package com.care.project.ainfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.care.project.aboard.ABoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AInfoController {
	@Autowired private AInfoService service;
	@Autowired private HttpSession session;
	
	@RequestMapping({"/ainfo", "/ainfoDelete"})
	public String ainfo(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.xmlInsert();
		service.ainfo(cp, select, search, model, requestUrl);
		if("/ainfo".equals(requestUrl)) {
			return "ainfo/ainfo";
		}else {
			return "ainfo/ainfoDelete";
		}
	}
	
	@RequestMapping("ainfoUpdate")
	public String ainfoUpdate(@RequestParam(value="currentPage", required = false)String cp, AInfoDTO info, Model model) {
		String name = info.getName();
		String category = info.getCategory();
		String address = info.getAddress();
		service.ainfoData(cp, name, category, address, model);
		return "ainfo/ainfoUpdate";
	}
	
	@PostMapping("ainfoUpdateProc")
	public String ainfoUpdateProc(AInfoDTO info) {
		service.ainfoUpdateProc(info);
		return "redirect:ainfo";
	}
	
	@RequestMapping({"/infoDelete", "/infoDeleteButton"})
	public String ainfoDelete(String selectedValues, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.infoDelete(selectedValues);
		if("/infoDelete".equals(requestUrl)) {
			return "redirect:ainfoDelete";
		}else {
			return "redirect:ainfo";
		}
	}
	
	@RequestMapping("ainfoData")
	public String ainfoData(@RequestParam(value="currentPage", required = false)String cp, 
			String name, String category,String address, Model model) {
			service.ainfoData(cp, name, category, address, model);
		return "ainfo/ainfoData";
	}
	
}
