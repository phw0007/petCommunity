package com.care.project.aphoto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import com.care.project.aboard.ABoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class APhotoController {
	@Autowired private APhotoService service;
	@RequestMapping({"/aphoto","/aphotoDelete"})
	public String aphoto(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.aphoto(cp, select, search, model, requestUrl);
		if("/aphoto".equals(requestUrl)) {
			return "aphoto/aphoto";
		}else {
			return "aphoto/aphotoDelete";
		}
	}
	
	@RequestMapping("aphotoViews")
	public String aphotoViews(String id, String category, int no, Model model,
			@RequestParam(value="currentPage", required = false)String cp) {
		service.aphotoInfo(id, category, no, model, cp);	
		return "aphoto/aphotoViews";
	}

	@RequestMapping({"/photoDeleteCheckBoxes", "/photoDeleteButton"})
	public String boardDelete(String selectedValues, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.photoDeleteCheckBoxes(selectedValues);
		if("/photoDeleteCheckBoxes".equals(requestUrl)) {
			return "redirect:aphotoDelete";
		}else {
			return "redirect:aphoto";
		}
	}
	
	@RequestMapping("/photoDeleteComment")
	public String photoDeleteComment(String selectedValues) {
		String url = service.photoDeleteComment(selectedValues);
		return "forward:aphotoViews?"+url;
	}
}
