package com.care.project.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SiteController {
	@Autowired private SiteService service;
	
	@RequestMapping({"/site","/site02","/site03","/siteUpdate","/siteUpdate02","siteUpdate03"})
	public String site(HttpServletRequest request, Model model) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String category = "site1";
		if("/site".equals(requestUrl) || "/siteUpdate".equals(requestUrl)) {
			service.siteInfo(category, model);
			if("/site".equals(requestUrl)) {
				return "site/site";
			}else{
				return "site/siteUpdate";
			}
		}else if("/site02".equals(requestUrl) || "/siteUpdate02".equals(requestUrl)){
			category = "site2";
			service.siteInfo(category, model);
			if("/site02".equals(requestUrl)) {
				return "site/site02";
			}else{
				return "site/siteUpdate02";
			}
		}else {
			category = "site3";
			service.siteInfo(category, model);
			if("/site03".equals(requestUrl)) {
				return "site/site03";
			}else{
				return "site/siteUpdate03";
			}
		}
	}
	
	@RequestMapping({"/siteUpdateProc1","/siteUpdateProc2","/siteUpdateProc3"})
	public String siteUpdate(String content, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		System.out.println(content);
		String category = "site1";
		if("/siteUpdateProc1".equals(requestUrl)) {
			service.siteUpdate(content, category);
			return "redirect:site";
		}else if("/siteUpdateProc2".equals(requestUrl)) {
			category = "site2";
			service.siteUpdate(content, category);
			return "redirect:site02";
		}else {	
			category = "site3";
			service.siteUpdate(content, category);
			return "redirect:site03";
		}
	}
}
