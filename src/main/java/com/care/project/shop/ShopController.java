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

	@RequestMapping({"/shopping", "/food", "/snack", "/cloths", "/medi", "/pad", "/living"})
	public String shopping(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String category = "";
		String page = "";
		if("/shopping".equals(requestUrl)) {
			page = "shopping";
			category = "";
		}else if("/food".equals(requestUrl)) {
			page = "food";
			category = "사료";
		}else if("/snack".equals(requestUrl)) {
			page = "snack";
			category = "간식";
		}else if("/cloths".equals(requestUrl)) {
			page = "cloths";
			category = "의류";
		}else if("/medi".equals(requestUrl)) {
			page = "medi";
			category = "약품";
		}else if("/pad".equals(requestUrl)) {
			page = "pad";
			category = "배변패드";
		}else {
			page = "living";
			category = "생활용품";
		}
		model.addAttribute(page,"border-bottom: 3px solid #FFEDA1;");
		service.shop(cp, select, search, model, category, page);
		return "mall/shopping";
	}
	
	@RequestMapping("shopLink")
	public String shopLink() {
		return "mall/shopLink";
	}
	
}
