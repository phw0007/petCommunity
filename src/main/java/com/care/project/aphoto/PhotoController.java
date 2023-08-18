package com.care.project.aphoto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhotoController {
	
	@RequestMapping("aphoto")
	public String aphoto() {
		return "aphoto/aphoto";
	}
	
	@RequestMapping("aphotoViews")
	public String aphotoViews() {
		return "aphoto/aphotoViews";
	}
	
	@RequestMapping("aphotoDelete")
	public String aphotoDelete() {
		return "aphoto/aphotoDelete";
	}
}
