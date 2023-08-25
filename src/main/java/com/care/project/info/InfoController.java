package com.care.project.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import com.care.project.info.InfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class InfoController {
	@Autowired private InfoService service;
	@Autowired private HttpSession session;
	
	@RequestMapping("info")
	public String info(@RequestParam(value="currentPage", required = false)String cp,
			@RequestParam(value="category", required = false)String category,
			String select, String search, Model model) {
		System.out.println(category);
		String jsp="info";
		service.xmlInsert();
		service.info(cp,select,search,model,category,jsp);
		return "mall/info";
	}
	@RequestMapping("medicine")
	public String medicine(@RequestParam(value="currentPage", required = false)String cp,
			@RequestParam(value="category", required = false)String category,
			String select, String search, Model model) {
		System.out.println(category);
		service.xmlInsert();
		String jsp="medicine";
		service.info(cp,select,search,model,category,jsp);
		return "mall/medicine";
	}
	@RequestMapping("school")
	public String school(@RequestParam(value="currentPage", required = false)String cp,
			@RequestParam(value="category", required = false)String category,
			String select, String search, Model model) {
		System.out.println(category);
		String url="school";
		service.xmlInsert();
		String jsp="school";
		service.info(cp,select,search,model,category,jsp);
		return "mall/school";
	}
	@RequestMapping("pool")
	public String pool(@RequestParam(value="currentPage", required = false)String cp,
			@RequestParam(value="category", required = false)String category,
			String select, String search, Model model) {
		System.out.println(category);
		service.xmlInsert();
		String jsp="pool";
		service.info(cp,select,search,model,category,jsp);
		return "mall/pool";
	}
	@RequestMapping("soccer")
	public String soccer(@RequestParam(value="currentPage", required = false)String cp,
			@RequestParam(value="category", required = false)String category,
			String select, String search, Model model) {
		System.out.println(category);
		service.xmlInsert();
		String jsp="soccer";
		service.info(cp,select,search,model,category,jsp);
		return "mall/soccer";
	}

	
//	@RequestMapping({"/info", "/medi"})
//	public String medi(@RequestParam(value="currentPage", required = false)String cp,
//			@RequestParam(value="category", required = false)String category,
//			HttpServletRequest request,
//			String select, String search, Model model) {
//		System.out.println(category);
//		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//		service.xmlInsert();
//		if("/info".equals(requestUrl)) {
//			service.info(cp, select, search, model, category,requestUrl);
//		return "mall/info";
//		}
//		return "mall/medi";
//}
}
	


