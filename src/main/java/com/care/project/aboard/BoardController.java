package com.care.project.aboard;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired private BoardService service;
	@Autowired private HttpSession session;
	
	@RequestMapping({"/aboard", "/aboardDelete"})
	public String aboard(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.aboard(cp, select, search, model, requestUrl);
		if("/aboard".equals(requestUrl)) {
			return "aboard/aboard";
		}else if("/aboardDelete".equals(requestUrl)){
			return "aboard/aboardDelete";
		}else {
			return "aboard/aboardAnnoDel";
		}
	}

	@RequestMapping("aboardViews")
	public String aboard_views(String id, String category, int no, Model model,
			@RequestParam(value="currentPage", required = false)String cp) {
		service.aboardInfo(id, category, no, model, cp);	
		return "aboard/aboardViews";
	}	
	
	@PostMapping("boardDelete")
	public String memberDelete(String selectedValues) {
		service.aboardDelete(selectedValues);
		return "redirect:aboardDelete";
	}
	
	@RequestMapping("aboardAnno")
	public String aboard_anno() {
		return "aboard/aboardAnno";
	}
	
	@RequestMapping("aboardAnnoViews")
	public String aboard_anno_views() {
		return "aboard/aboardAnnoViews";
	}
	
	@RequestMapping("aboardAnnoDel")
	public String aboard_anno_del() {
		return "aboard/aboardAnnoDel";
	}
	
	@RequestMapping("aboardAnnoUpdate")
	public String aboard_anno_update() {
		return "aboard/aboardAnnoUpdate";
	}

}
