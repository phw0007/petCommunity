package com.care.project.ainfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import com.care.project.aboard.ABoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AInfoController {
	@Autowired private AInfoService service;
	@Autowired private HttpSession session;
	
	@RequestMapping({"/ainfo"})
	public String ainfo(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.ainfo(cp, select, search, model, requestUrl);
		if("/aboard".equals(requestUrl)) {
			return "ainfo/ainfo";
		}else {
			return "ainfo/ainfoDelete";
		}
	}
	
	@RequestMapping("ainfoRegister")
	public String ainfoRegister() {
		return "ainfo/ainfoRegister";
	}
	
	@RequestMapping("ainfoDelete")
	public String ainfoDelete() {
		return "ainfo/ainfoDelete";
	}
	
	@RequestMapping("ainfoData")
	public String ainfoData() {
		return "ainfo/ainfoData";
	}
	
}
