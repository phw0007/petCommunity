package com.care.project.ashop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AShopController {
	@Autowired private AShopService service;
	@RequestMapping({"/ashop"})
	public String ashop(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.ashop(cp, select, search, model, requestUrl);
		if("/ashop".equals(requestUrl)) {
			return "ashop/ashop";
		}else {
			return "ashop/ashopDelete";
		}
	}
	
	@RequestMapping("ashopRegister")
	public String ashop_register() {
		return "ashop/ashopRegister";
	}
	
	@RequestMapping("ashopDelete")
	public String ashop_delete() {
		return "ashop/ashopDelete";
	}
	
	@RequestMapping("ashopOrder")
	public String ashop_order() {
		return "ashop/ashopOrder";
	}
	
	@RequestMapping("ashopOrderDel")
	public String ashop_order_del() {
		return "ashop/ashopOrderDel";
	}
	
	@RequestMapping("ashopInfo")
	public String ashop_info() {
		return "ashop/ashopInfo";
	}
	
	@RequestMapping("ashopUpdate")
	public String ashop_update() {
		return "ashop/ashopUpdate";
	}
	
	@RequestMapping("ashopOrderInfo")
	public String ashop_order_info() {
		return "ashop/ashopOrderInfo";
	}
	
	@RequestMapping("ashopOrderUpdate")
	public String ashop_order_update() {
		return "ashop/ashopOrderUpdate";
	}
	
	@ResponseBody
    @PostMapping(value = "uploadImage", produces = "text/plain; charset=utf-8")
    public String uploadImage(@RequestParam(value="imageFile", required = false) MultipartFile imageFile,
    							@RequestParam(value="fileName", required = false) String fileName, 
    							@RequestParam("selectedValues") String selectedValues) {
		service.uploadImage(selectedValues, imageFile, fileName);
        return "ashop";
    }
}
