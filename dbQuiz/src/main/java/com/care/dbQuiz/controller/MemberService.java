package com.care.dbQuiz.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.core.RecordCreator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.dbQuiz.common.PageService;
import com.care.dbQuiz.javaMail.MailService;
import com.care.dbQuiz.repository.MemberMapper;

@Service
public class MemberService {
	
	@Autowired private MemberMapper memberMapper;
	@Autowired private HttpSession session;
	
	public boolean login(String id, String pw) {
		MemberDTO memberDto = memberMapper.login(id);
		if(memberDto != null) {
			BCryptPasswordEncoder bpe =  new BCryptPasswordEncoder();
		if(bpe.matches(pw, memberDto.getPw())) {//암호화된 비밀번호 검증(입력한 비밀번호, DB에 저장된 암호화된 비밀번호)
			session.setAttribute("id", memberDto.getId());
			session.setAttribute("userName", memberDto.getUserName());
			session.setAttribute("address", memberDto.getAddress());
			session.setAttribute("mobile", memberDto.getMobile());
			return true;
			}
		}
		return false;
	}

	public String register(MemberDTO memberDto, String confirm) {
		if(confirm.equals(memberDto.getPw()) == false) {
			return "같은 비밀번호를 입력해주세요.";
		}
		BCryptPasswordEncoder bpe =  new BCryptPasswordEncoder();
		String cryptPassword=  bpe.encode(memberDto.getPw());
		memberDto.setPw(cryptPassword);
		
		System.out.println("암호화된 비밀번호 : " +cryptPassword);
		System.out.println("암호화된 비밀번호의 길이 : "+cryptPassword.length());
		System.out.println("평문 비밀번호 : " + memberDto.getPw());
		/*
		암호화된 비밀번호 : $2a$10$/NIdqe058EJN1Fr949cK0uI4n7C43ugsjIqTETeciXwu.lq3eWo/e
		암호화된 비밀번호의 길이 : 60
		평문 비밀번호 : 1234
		*/
		MemberDTO check = memberMapper.login(memberDto.getId());
		if(check == null) {
			memberMapper.register(memberDto);
			return "회원가입 되었습니다.";
		}else {
			return "이미 가입된 아이디 입니다.";
		}
	}
	
	public void memberInfo(@RequestParam("currentPage")String cp, String select, String search, Model model) {
		if(select == null){
			select = "";
		}
		
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		int pageBlock = 4; // 한 페이지에 보일 데이터의 수 
		int end = pageBlock * currentPage; // 테이블에서 가져올 마지막 행번호
		int begin = end - pageBlock + 1; // 테이블에서 가져올 시작 행번호
		
		ArrayList<MemberDTO> members = memberMapper.list(begin, end, select, search);
		int totalCount = memberMapper.count(select, search);
		String url = "memberInfo?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		
		model.addAttribute("members", members);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
	}
	
	public void userInfo(String id, Model model) {
		MemberDTO memberDto = memberMapper.login(id);
		model.addAttribute("member", memberDto);
	}

	public String update(MemberDTO member, String confirmPw) {
		
		if(confirmPw.equals(member.getPw()) == false) {
			return "같은 비밀번호를 입력해주세요.";
		}
		BCryptPasswordEncoder bpe =  new BCryptPasswordEncoder();
		String cryptPassword=  bpe.encode(member.getPw());
		member.setPw(cryptPassword);
		memberMapper.update(member);
		return "회원정보 수정 되었습니다.";

	}

	public String delete(String id, String pw, String confirm) {
		if(pw.equals(confirm) == false) {
			return "같은 비밀번호를 입력해주세요.";
		}
		MemberDTO check = memberMapper.login(id);
		if(check != null) {
			BCryptPasswordEncoder bpe =  new BCryptPasswordEncoder();
		if(bpe.matches(pw, check.getPw())) {//암호화된 비밀번호 검증(입력한 비밀번호, DB에 저장된 암호화된 비밀번호)
			memberMapper.delete(id);
			return "회원정보가 삭제 되었습니다.";
			}
		}
		return "비밀번호가 틀렸습니다.";
	}

	@Autowired private MailService mailService;
	public String sendEmail(String email) {
		//이메일을 입력하지 않았거나 빈 문자열일 경우 실행
		if(email == null || email.isEmpty())
			return "이메일을 확인 후 다시 입력하세요.";
		Random r = new Random();
		// 1,000,000 
		// 100 000 , 001234
	
		content = String.format("%06d", r.nextInt(1000000));//0~1000000 사이의 랜덤한 숫자 생성
		System.out.println("인증번호 : " + content);
		String msg = mailService.sendMail(email, "인증번호가 도착했습니다", content);
		//이메일 전송이 성공했을경우 실행
		if(msg.equals("입력한 이메일에서 인증번호를 확인하세요.") == false) {
			content = "";
		}
		return msg;
	}
	//content : sendEmail에서 생성한 랜덤 숫자
	private String content;
	
	public String sendAuth(String auth) {
		if(auth == null || auth.isEmpty())
			return "인증번호를 입력 후 다시 시도하세요.";
		
		if(content == null || content.isEmpty())
			return "인증번호를 입력 후 다시 시도하세요.";
		
		if(auth.equals(content)) {
			return "인증 성공";
		}
		
		return "인증 실패";
	}
}
