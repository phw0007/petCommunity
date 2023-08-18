package com.care.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


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
	
	@RequestMapping("index2")
	public String index2() {
		return "member/index2";
	}

	@RequestMapping("header")
	public String header() {
		return "default/header";
	}
	
	@RequestMapping("main")
	public String main() {
		return "default/main";
	}
	
	@RequestMapping("footer")
	public String footer() {
		return "default/footer";
	}
	
	
	
	/* http://localhost:8086/dbQuiz/login */
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("mloginProc")
	public String mloginProc(MemberDTO member) {
		String result = service.loginProc(member);
		if(result.equals("로그인 성공")) {
			return "redirect:index2";
		}
		return "member/login";
	}
	
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
	
	@GetMapping("update")
	public String update() {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/update";
	}
	@PostMapping("updateProc")
	public String updateProc(MemberDTO member, String confirm) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		member.setId(id);
		String result = service.updateProc(member, confirm);
		if(result.equals("회원 정보 수정 완료")) {
			return "forward:logout";
		}
		return "member/update";
	}
	
	
	@GetMapping("delete")
	public String delete() {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/delete";
	}
	
	@PostMapping("deleteProc")
	public String deleteProc(String pw, String confirmPw, Model model) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		
		String result = service.deleteProc(id, pw, confirmPw);
		model.addAttribute("msg", result);
		if(result.equals("회원 정보 삭제 완료")) {
			return "forward:logout";
		}
		return "member/delete";
	}
	
	   @ResponseBody
	    @PostMapping(value = "uploadImage3", produces = "text/plain; charset=utf-8") //추가
	    public String uploadImage3(@RequestParam(value="imageFile", required = false) MultipartFile emailFile,
	                         @RequestParam("fileName") String fileName) {
	         System.out.println(fileName);
	         service.uploadImage(emailFile, fileName);
	        return "index";
	    }
	   
	   @GetMapping("photoAlbum")
		public String photoAlbum() {
			return "member/photoAlbum";
		}
        
	   @GetMapping("shopping")
		public String shopping() {
			return "mall/shopping";
		}
	   
	   
	

	
	
	
	
	
	
	
	
	
	
}

