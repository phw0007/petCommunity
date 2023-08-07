package com.care.project.ainfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

	@RequestMapping("ainfo")
	public String ainfo() {
		return "ainfo/ainfo";
	}
	
	@RequestMapping("ainfo_register")
	public String ainfo_register() {
		return "ainfo/ainfo_register";
	}
	
	@RequestMapping("ainfo_delete")
	public String ainfo_delete() {
		return "ainfo/ainfo_delete";
	}
	
	@RequestMapping("ainfo_data")
	public String ainfo_data() {
		return "ainfo/ainfo_data";
	}
	
}
