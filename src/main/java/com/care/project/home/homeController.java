package com.care.project.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import jakarta.servlet.http.HttpSession;

@Controller
public class homeController {

	@Autowired private photoService service;
	@Autowired private HttpSession session;
	
	
	
	@RequestMapping("home")
	public String home(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "default/home";
	}
	
	
	
	@RequestMapping("photo")
	public String photo(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "photo/photoMain";
	}
	
	@RequestMapping("photoWrite")
	public String photoWrite(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "photo/photoWrite";
		
		
	}
	
	@PostMapping("photoWriteProc")
	public String photoWriteProc(Model model, MultipartHttpServletRequest multi) {
		String msg = service.photoWriteProc(multi);
		if(msg.equals("로그인"))
			return "redirect:login";
		
		if(msg.equals("게시글 작성 완료"))
			return "redirect:photoMain";
		
		model.addAttribute("msg", msg);
		return "redirect:photo";
	}
	
	
	@RequestMapping("potoContent")
	public String photoContent(
			@RequestParam(value="no", required = false)String n, Model model) {
		photoDTO photo = service.photoContent(n);
		if(photo == null) {
			System.out.println("boardContent 게시글 번호 : " + n);
			return "redirect:photo";
		}
		model.addAttribute("photo", photo);
		return "photo/photoContent";
		
		
	}
	

}







