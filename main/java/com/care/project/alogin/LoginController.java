package com.care.project.alogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("alogin")
	public String alogin() {
		return "alogin/alogin";
	}
	
}
