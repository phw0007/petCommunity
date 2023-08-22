package com.care.project.alogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired private HttpSession session;
	
	@RequestMapping("alogin")
	public String alogin() {
		return "alogin/alogin";
	}
	
	@RequestMapping("aloginOut")
	public String aloginOut() {
		session.invalidate();
		return "redirect:index";
	}
	
	
}
