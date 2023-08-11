package com.care.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.project.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired private MemberService service;
	@Autowired private HttpSession session;

	@RequestMapping("index")
	public String index() {
		return "member/index";
	}

//	@RequestMapping("header")
//	public String header() {
//		return "default/header";
//	}
//	
//	@RequestMapping("main")
//	public String main() {
//		return "default/main";
//	}
	
	@RequestMapping("footer")
	public String footer() {
		return "default/footer";
	}
	
	/* http://localhost:8086/dbQuiz/login */
//	@GetMapping("login")
//	public String login() {
//		return "member/login";
//	}
//	
//	@PostMapping("loginProc")
//	public String loginProc(MemberDTO member) {
//		String result = service.loginProc(member);
//		if(result.equals("로그인 성공")) {
//			return "member/index2";
//		}
//		return "member/login";
//	}
	
	/* http://localhost:8086/dbQuiz/register */
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("registerProc")
	public String registerProc(MemberDTO member, String confirm) {
		String result = service.registerProc(member, confirm);
		if(result.equals("회원 등록 완료")) {
			return "redirect:index";
		}
		return "member/register";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "forward:index";
	}
	
	@RequestMapping("userInfo")
	public String userInfo(String id, 
			@RequestParam(value="currentPage", required = false)String cp, 
			Model model) {
		
		if(session.getAttribute("id") == null ) {
			return "redirect:login";
		}
		MemberDTO member = service.userInfo(id);
		if(member == null) {
			return "redirect:memberInfo?currentPage="+cp;
		}
		model.addAttribute("member", member);
		return "member/userInfo";
	}
	
	@GetMapping("bag")
	public String bag() {
		return "member/bag";
	}
	@GetMapping("info")
	public String info() {
		return "mall/info";
	}
	@GetMapping("shopping")
	public String shopping() {
		return "mall/shopping";
	}
}
	
	
	
	
	
	
	
	
	
