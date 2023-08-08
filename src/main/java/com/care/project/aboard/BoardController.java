package com.care.project.aboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import com.care.project.amember.MemberDTO;
import com.care.project.amember.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired private BoardService service;
	@Autowired private HttpSession session;
	
	@RequestMapping({ "/aboard"})
	public String aboard(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.aboard(cp, select, search, model, requestUrl);
		if("/aboard".equals(requestUrl)) {
			return "aboard/aboard";
		}else {
			return "aboard/aboardDelete";
		}
	}

	@RequestMapping("aboardViews")
	public String aboard_views(String id, String boardName, int no, Model model,
			@RequestParam(value="currentPage", required = false)String cp) {
		service.aboardInfo(id, boardName, no, model, cp);	
		return "aboard/aboardViews";
	}	
	
	@RequestMapping("aboardDelete")
	public String aboard_delete() {
		return "aboard/aboardDelete";
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
