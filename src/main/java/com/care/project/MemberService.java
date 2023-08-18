package com.care.project;





import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.project.member.MemberDTO;

import jakarta.servlet.http.HttpSession;


@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	@Autowired private HttpSession session;
	
	
	public String loginProc(MemberDTO member) {
		if(member.getId() == null || member.getId().isEmpty()) {
			return "아이디를 입력하세요.";
		}
		
		if(member.getPw() == null || member.getPw().isEmpty()) {
			return "비밀번호를 입력하세요.";
		}
		
		MemberDTO result = memberMapper.mloginProc(member.getId());
		if(result != null) {
			BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
			
			if(bpe.matches(member.getPw(), result.getPw())) {
				session.setAttribute("id", result.getId());
				session.setAttribute("userName", result.getUserName());
				session.setAttribute("address", result.getAddress());
				session.setAttribute("mobile", result.getMobile());
				return "로그인 성공";
			}
		}
		
		return "아이디/비밀번호를 확인 후 다시 시도하세요.";
	}
	
	public String registerProc(MemberDTO member, String confirm) {
		if(member.getId() == null || member.getId().isEmpty()) {
			return "아이디를 입력하세요.";
		}
		
		if(member.getPw() == null || member.getPw().isEmpty()) {
			return "비밀번호를 입력하세요.";
		}
		
		if(member.getPw().equals(confirm) == false) {
			return "두 비밀번호를 일치하여 입력하세요.";
		}
		
		if(member.getUserName() == null || member.getUserName().isEmpty()) {
			return "이름을 입력하세요.";
		}
		/*
		System.out.println("암호화된 비밀번호 : " + cryptPassword);
		System.out.println("암호화된 비밀번호 길이 : " + cryptPassword.length());
		System.out.println("평문 비밀번호 : " + member.getPw());
		
		 암호화된 비밀번호 : $2a$10$.EOushkIDT8Gnb33i6NOSuS32ymKWipIvLCKeVlwGR20UWJYRYWEm
		 암호화된 비밀번호 길이 : 60
		 평문 비밀번호 : 1111
		 ALTER TABLE session_quiz MODIFY pw varchar2(60);
		 */
		member.setPetFile("/image/"+member.getPetFile());
		MemberDTO result = memberMapper.mloginProc(member.getId());
		if(result == null) {
			BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
			String cryptPassword = bpe.encode(member.getPw());
			member.setPw(cryptPassword);
			memberMapper.registerProc(member);
			return "회원 등록 완료";
		}
		
		return "이미 가입된 아이디 입니다.";
	}

	public MemberDTO userInfo(String id) {
		if(id == null || id.isEmpty()) {
			return null;
		}
		
		String sessionId = (String)session.getAttribute("id");
		if(sessionId.equals(id) == false && sessionId.equals("admin") == false)
			return null;
		
//		MemberDTO result = memberMapper.loginProc(id);
		return memberMapper.mloginProc(id);
	}

	public String updateProc(MemberDTO member, String confirm) {
		if(member.getPw() == null || member.getPw().isEmpty()) {
			return "비밀번호를 입력하세요.";
		}
		
		if(member.getPw().equals(confirm) == false) {
			return "두 비밀번호를 일치하여 입력하세요.";
		}
		
		if(member.getUserName() == null || member.getUserName().isEmpty()) {
			return "이름을 입력하세요.";
		}
		
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		String cryptPassword = bpe.encode(member.getPw());
		member.setPw(cryptPassword);
		
		int result = memberMapper.updateProc(member);
		if(result == 1)
			return "회원 정보 수정 완료";
		return "회원 정보 수정 실패";
	}

	public String deleteProc(String id, String pw, String confirmPw) {
		if(pw == null || pw.isEmpty()) {
			return "비밀번호를 입력하세요.";
		}
		
		if(pw.equals(confirmPw) == false) {
			return "두 비밀번호를 일치하여 입력하세요.";
		}
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		MemberDTO member = memberMapper.mloginProc(id);
		if(member != null && bpe.matches(pw, member.getPw())) {
			memberMapper.delete(id);
			return "회원 정보 삭제 완료";
		}
		return "비밀번호를 확인 후 다시 시도하세요.";
	}
	
	   public void uploadImage(MultipartFile imageFile, String fileName) { //변경
		      if(imageFile.isEmpty()) {
		         return;
		      }
		      if(imageFile.getSize() != 0) {
		         String fileLocation = "C:\\javas\\boot_workspace\\project\\src\\main\\webapp\\image\\"+fileName;
		         File save = new File(fileLocation);
		         try {
		            imageFile.transferTo(save);
		         } catch (Exception e) {
		            e.printStackTrace();
		         }
		      }
		   }


	






	
	
	
	
	
	
 
	
	
}




