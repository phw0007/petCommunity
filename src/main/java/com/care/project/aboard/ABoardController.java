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
		}else {
			return "aboard/aboardDelete";
		}

	}

	@RequestMapping("aboardViews")
	public String aboard_views(String id, String category, int no, Model model,
			@RequestParam(value="currentPage", required = false)String cp) {
		service.aboardInfo(id, category, no, model, cp);	
		return "aboard/aboardViews";
	}	
	
	/*체크된 게시글 삭제*/
	@RequestMapping({"/boardDelete", "/boardAnnoDelete"})
	public String boardDelete(String selectedValues, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.boardDelete(selectedValues);
		if("/boardDelete".equals(requestUrl)) {
			return "redirect:aboardDelete";
		}else {
			return "redirect:aboardAnnoDel";
		}
	}
	
	/*삭제버튼 클릭시 삭제*/
	@RequestMapping({"/boardDeleteButton", "/boardAnnoDeleteButton"})
	public String boardDeleteButton(String selectedValues, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.boardDelete(selectedValues);
		if("/boardDeleteButton".equals(requestUrl)) {
			return "redirect:aboard";
		}else {
			return "redirect:aboardAnno";
		}
	}
	
	/*삭제버튼 클릭시 삭제*/
	@RequestMapping({"/boardDeleteComment", "/boardAnnoDeleteComment"})
	public String boardDeleteComment(String selectedValues, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String url = service.boardDeleteComment(selectedValues);
		if("/boardDeleteComment".equals(requestUrl)) {
			return "forward:aboardViews?"+url;
		}else {
			return "forward:aboardAnnoViews?"+url;
		}
	}
	
	@RequestMapping({"/aboardAnno", "/aboardAnnoDel"})
	public String aboardAnno(@RequestParam(value="currentPage", required = false)String cp,
		String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.aboardAnno(cp, select, search, model, request);
		if("/aboardAnno".equals(requestUrl)) {
			return "aboard/aboardAnno";
		}else {
			return "aboard/aboardAnnoDel";
		}
	}
	
	@RequestMapping("aboardAnnoViews")
	public String aboardAnnoViews(String id, String category, int no, Model model,
			@RequestParam(value="currentPage", required = false)String cp) {
		service.aboardInfo(id, category, no, model, cp); 
		return "aboard/aboardAnnoViews";
	}
	
	@RequestMapping("aboardAnnoUpdate")
	public String aboardAnnoUpdate(String selectedValues, Model model) {
		service.aboardAnnoUpdate(selectedValues, model);
		return "aboard/aboardAnnoUpdate";
	}
	
	@RequestMapping("aboardAnnoUpdateProc")
	public String aboardAnnoUpdateProc(String no, String id, String title, String text) {
		service.aboardAnnoUpdate(no, id, title, text);
		return "redirect:aboardAnno";
	}
	
	@RequestMapping("aboardAnnoRegister")
	public String aboardAnnoRegister() {
		return "aboard/aboardAnnoRegister";
	}
	
	@RequestMapping("aboardAnnoRegisterProc")
	public String aboardAnnoRegisterProc(String id, String title, String text) {
		service.aboardAnnoRegister(id, title, text);
		return "redirect:aboardAnno";
	}
	
}
