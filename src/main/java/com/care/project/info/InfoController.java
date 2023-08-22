package com.care.project.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.project.info.InfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class InfoController {
	@Autowired private InfoService service;
	@Autowired private HttpSession session;
	
	@RequestMapping("info")
	public String info(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model) {
		service.xmlInsert();
		service.info(cp,select,search,model);
		return "mall/info";
	}
}
