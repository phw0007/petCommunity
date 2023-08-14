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
public class ABoardController {
	@Autowired private ABoardService service;
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
	
	/*체크된 게시글 삭제*/
	@PostMapping("boardDelete")
	public String boardDelete(String selectedValues) {
		service.boardDelete(selectedValues);
		return "redirect:aboardDelete";
	}
	
	/*삭제버튼 클릭시 삭제*/
	@PostMapping("boardDeleteButton")
	public String boardDeleteButton(String selectedValues) {
		service.boardDelete(selectedValues);
		return "redirect:aboard";
	}
	
	/*삭제버튼 클릭시 삭제*/
	@PostMapping("boardDeleteComment")
	public String boardDeleteComment(String selectedValues) {
		String url = service.boardDeleteComment(selectedValues);
		return "forward:aboardViews?"+url;
	}
	
	@RequestMapping("aboardAnno")
	public String aboardAnno() {
		return "aboard/aboardAnno";
	}
	
	@RequestMapping("aboardAnnoViews")
	public String aboardAnnoViews() {
		return "aboard/aboardAnnoViews";
	}
	
	@RequestMapping("aboardAnnoDel")
	public String aboardAnnoDel() {
		return "aboard/aboardAnnoDel";
	}
	
	@RequestMapping("aboardAnnoUpdate")
	public String aboardAnnoUpdate() {
		return "aboard/aboardAnnoUpdate";
	}

}
