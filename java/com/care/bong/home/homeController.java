package com.care.bong.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

	@RequestMapping("header")
	public String header(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "main/header";
	}
	
	@RequestMapping("home")
	public String home(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "main/home";
	}
	
	@RequestMapping("footer")
	public String footer(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "main/footer";
	}
	
	@RequestMapping("photo")
	public String poto(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "photo/photoMain";
	}
	
	@RequestMapping("photoWrite")
	public String potoWrite(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "photo/photoWrite";
		
		
	}
	

}







