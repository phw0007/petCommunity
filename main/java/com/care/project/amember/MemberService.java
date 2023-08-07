package com.care.project.amember;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.project.common.PageService;

import jakarta.servlet.http.HttpSession;

@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	@Autowired private HttpSession session;
	public void amember(String cp, String select, String search, Model model, String requestUrl) {
		if(select == null){
			select = "";
		}
		
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
			
		if(search == null) {
			search = "";
		}
		requestUrl = requestUrl.substring(1);
		int pageBlock = 3;
		int end = pageBlock * currentPage;
		
		int begin = end - pageBlock + 1;
		int no = 0;
		ArrayList<MemberDTO> members = memberMapper.memberData(begin, end, select, search);
		int totalCount = memberMapper.count(select, search);
		String url = requestUrl+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*3;
		model.addAttribute("members", members);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
	}

	public MemberDTO amemberInfo(String id) {	
		return memberMapper.amemberInfo(id);
	}

	public void amemberDelete(String selectedValues) {
		String[] checkData = selectedValues.split(",");
		System.out.println(selectedValues);
		for(String name:checkData) {
			memberMapper.memberDelete(name);
		}
	}

	public void passwordUpdata(String id, String newPassword) {
		memberMapper.passwordUpdata(id, newPassword);
	}
	
	public void amemberEmail(Model model, String selectedValues) {
		String amemberEmail = selectedValues;
		model.addAttribute("amemberEmail", amemberEmail);
	}
	
	@Autowired private MailService mailService;
	public String sendEmail(String email, String emailTitle, String emailContent, MultipartFile emailFile) {
		if(email == null || email.isEmpty())
			return "이메일을 정확하게 입력해 주세요.";

		String msg = mailService.sendMail(email, emailTitle, emailContent, emailFile);
		return msg;
	}

}




