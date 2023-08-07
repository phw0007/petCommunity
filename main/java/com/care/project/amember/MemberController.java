package com.care.project.amember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired private MemberService service;
	@Autowired private HttpSession session;
	
	@RequestMapping("aindex")
	public String aindex() {
		return "aindex/aindex";
	}

	@RequestMapping("header")
	public String header() {
		return "default/header";
	}
	
	@RequestMapping("main")
	public String main() {
		return "default/main";
	}
	
	@RequestMapping({ "/amember", "/amemberDelete", "/amemberMail" })
	public String amember(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		service.amember(cp, select, search, model, requestUrl);
		if("/amember".equals(requestUrl)) {
			return "amember/amember";
		}else if("/amemberDelete".equals(requestUrl)){
			return "amember/amemberDelete";
		}else {
			return "amember/amemberMail";
		}
	}
	
	@RequestMapping("amemberInfo")
	public String amember_info(String id, Model model,
			@RequestParam(value="currentPage", required = false)String cp) {
		MemberDTO member = service.amemberInfo(id);		
		model.addAttribute("member", member);
		model.addAttribute("cp", cp);
		return "amember/amemberInfo";
	}	
	
	@RequestMapping("memberDelete")
	public String memberDelete(String selectedValues, String url) {
		service.amemberDelete(selectedValues);
		return "redirect:"+url;
	}
	
	@RequestMapping("passwordUpdata")
	public String password_updata(String id, String newPassword) {
		service.passwordUpdata(id, newPassword);
		return "redirect:amember";
	}
	
	@RequestMapping("amemberPasswordUpdata")
	public String amemberPasswordUpdata(Model model, String id) {
		model.addAttribute("id", id);
		return "amember/amemberPasswordUpdata";
	}
	
	@RequestMapping("amemberSend")
	public String amemberSend(Model model, String selectedValues) {
		service.amemberEmail(model, selectedValues);
		return "amember/amemberSend";
	}
	
	@ResponseBody
    @PostMapping(value = "sendEmail", produces = "text/plain; charset=utf-8")
    public String sendEmail(@RequestParam("userEmail") String userEmail, 
    		@RequestParam("emailTitle") String emailTitle,
    		@RequestParam(value="emailContent", required = false) String emailContent,
    		@RequestParam(value="emailFile", required = false) MultipartFile emailFile) {
					
			service.sendEmail(userEmail, emailTitle, emailContent, emailFile);
        return "amemberMail";
    }
}
