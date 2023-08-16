package com.care.project.ashop;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AShopController {
	@Autowired private AShopService service;
	@RequestMapping("ashop")
	public String ashop() {
		return "ashop/ashop";
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
        return "amemberMail";
    }
}
