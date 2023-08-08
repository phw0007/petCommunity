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
			return "aboard/aboard_delete";
		}
	}
	//게시판정보
	@RequestMapping("aboard_views")
	public String aboard_views(String id, String boardName, int no, Model model,
			@RequestParam(value="currentPage", required = false)String cp) {
		service.aboardInfo(id, boardName, no, model, cp);	
		return "aboard/aboard_views";
	}	
	
	@RequestMapping("aboard_delete")
	public String aboard_delete() {
		return "aboard/aboard_delete";
	}
	
	@RequestMapping("aboard_anno")
	public String aboard_anno() {
		return "aboard/aboard_anno";
	}
	
	@RequestMapping("aboard_anno_views")
	public String aboard_anno_views() {
		return "aboard/aboard_anno_views";
	}
	
	@RequestMapping("aboard_anno_del")
	public String aboard_anno_del() {
		return "aboard/aboard_anno_del";
	}
	
	@RequestMapping("aboard_anno_update")
	public String aboard_anno_update() {
		return "aboard/aboard_anno_update";
	}

}
