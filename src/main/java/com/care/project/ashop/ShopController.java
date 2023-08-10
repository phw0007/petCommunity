package com.care.project.ashop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ShopController {
	@Autowired private ShopService service;
	@RequestMapping("ashop")
	public String ashop() {
		return "ashop/ashop";
	}
	
	@RequestMapping("ashop_register")
	public String ashop_register() {
		return "ashop/ashop_register";
	}
	
	@RequestMapping("ashop_delete")
	public String ashop_delete() {
		return "ashop/ashop_delete";
	}
	
	@RequestMapping("ashop_order")
	public String ashop_order() {
		return "ashop/ashop_order";
	}
	
	@RequestMapping("ashop_order_del")
	public String ashop_order_del() {
		return "ashop/ashop_order_del";
	}
	
	@RequestMapping("ashop_info")
	public String ashop_info() {
		return "ashop/ashop_info";
	}
	
	@RequestMapping("ashop_update")
	public String ashop_update() {
		return "ashop/ashop_update";
	}
	
	@RequestMapping("ashop_order_info")
	public String ashop_order_info() {
		return "ashop/ashop_order_info";
	}
	
	@RequestMapping("ashop_order_update")
	public String ashop_order_update() {
		return "ashop/ashop_order_update";
	}
	
	@ResponseBody
    @PostMapping(value = "uploadImage", produces = "text/plain; charset=utf-8")
    public String uploadImage(@RequestParam(value="imageFile", required = false) MultipartFile emailFile,
    							@RequestParam("fileName") String fileName) {
			System.out.println(fileName);
			service.uploadImage(emailFile, fileName);
        return "amemberMail";
    }
}
