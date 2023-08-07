package com.care.project.aphoto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhotoController {
	
	@RequestMapping("aphoto")
	public String aphoto() {
		return "aphoto/aphoto";
	}
	
	@RequestMapping("aphoto_views")
	public String aphoto_views() {
		return "aphoto/aphoto_views";
	}
	
	@RequestMapping("aphoto_delete")
	public String aphoto_delete() {
		return "aphoto/aphoto_delete";
	}
}
