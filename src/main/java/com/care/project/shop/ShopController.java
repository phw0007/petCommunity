package com.care.project.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopController {
	@Autowired private ShopService service;

	@RequestMapping({"/shopping", "/food"})
	public String shopping(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String category = "";
		String page = "";
		if("/shopping".equals(requestUrl)) {
			page = "shopping";
			category = "";
			model.addAttribute("shopping","border-bottom: 3px solid #FFEDA1;");
		}else if("/food".equals(requestUrl)) {
			page = "food";
			category = "사료";
			model.addAttribute("food","border-bottom: 3px solid #FFEDA1;");
		}
		service.shop(cp, select, search, model, category, page);
		return "mall/shopping";
	}
}
