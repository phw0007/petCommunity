package com.care.dbQuiz.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {

	@Autowired private MemberService service;
	@Autowired private HttpSession session;
	
	@RequestMapping("index")
	public String index() {
		return "member/index";
	}
	
	@RequestMapping("main")
	public String main() {
		return "default/main";
	}
	
	@RequestMapping("header")
	public String header() {
		return "default/header";
	}
	
	@RequestMapping("footer")
	public String footer() {
		return "default/footer";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "redirect:index";
	}
	
	@PostMapping("login")
	public String login(String id, String pw) {
		boolean result = service.login(id, pw);
		if(result) {
			//로그인 성공
			return "redirect:index";
		}
		//로그인 실패
		return "member/login";
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("register")
	public String register(MemberDTO memberDto, String confirm, HttpServletRequest sr) {
		String result = service.register(memberDto, confirm);
		if(result.equals("회원가입 되었습니다.")) {
			sr.setAttribute("msg", result);
			sr.setAttribute("url", "index");
			return "member/message";
		}else {
			sr.setAttribute("msg", result);
			sr.setAttribute("url", "register");
			return "member/message";
		}
	}
	
	@RequestMapping("memberInfo")
	public String list(Model model, String search, String select,
		@RequestParam(value="currentPage", required = false)String cp) {
		service.memberInfo(cp, select, search, model);
		return "member/memberInfo";
	}
	
	@RequestMapping("userInfo")
	public String userInfo(String id, Model model, @RequestParam(value="currentPage", required = false)String cp) {
		String sessionId = (String)session.getAttribute("id");
		if(sessionId == null || sessionId.isEmpty()) {
			return "member/login";
		}
		if(sessionId.equals(id) == false && sessionId.equals("admin") == false) {
			return "redirect:memberInfo?currentPage="+cp; 
			//주소 링크의 값을 memberInfo로 변경
			//member/memberInfo로 하게되면 주소의 값이 변경이 되지 않기때문에 사용
		}
		service.userInfo(sessionId, model);
		return "member/userInfo";
	}
	
	@GetMapping("update")
	public String update() {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/update";
	}
	
	@PostMapping("updateService")
	public String updateService(MemberDTO member, String confirm, HttpServletRequest sr) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		member.setId(id);
		String result = service.update(member,confirm);
		if(result.equals("회원정보 수정 되었습니다.")) {
			sr.setAttribute("msg", result);
			sr.setAttribute("url", "index");
			session.invalidate();
			return "member/message";
		}
		sr.setAttribute("msg", result);
		sr.setAttribute("url", "update");
		return "member/message";
	}
	
	@GetMapping("delete")
	public String delete() {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/delete";
	}
	
	@PostMapping("deleteService")
	public String deleteService(String pw, String confirmPw) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		String result = service.delete(id, pw, confirmPw);
		if(result.equals("회원정보가 삭제 되었습니다.")) {
			session.invalidate();
			return "redirect:index";
		}
		return "member/delete";
	}
	
	@ResponseBody
	@PostMapping(value="sendEmail", produces = "text/plain; charset=utf-8")
	public String sendEmail(@RequestBody(required = false) String email) {
		return service.sendEmail(email);
	}
	

	@ResponseBody
	@PostMapping(value="sendAuth", produces = "text/plain; charset=utf-8")
	public String sendAuth(@RequestBody(required = false) String auth) {
		System.out.println("sendAuth()");
		return service.sendAuth(auth);
	}

	@Autowired private kakaoService kakao;
	@GetMapping("kakaoLogin")
	public String kakaoLogin(String code) {
		System.out.println("code : " + code);
		kakao.getAccessToken(code);
		kakao.getUserInfo();
		return "redirect:index";
	}
	@GetMapping("kakaoLogout")
	public String kakaoLogout() {
		kakao.unLink();
		return "redirect:index";
	}
}
