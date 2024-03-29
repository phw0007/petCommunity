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
public class AMemberController {
	@Autowired private AMemberService service;
	@Autowired private HttpSession session;
	
	@RequestMapping("aindex")
	public String aindex() {
		session.setAttribute("id", "admin");
		return "aindex/aindex";
	}

	@RequestMapping("aheader")
	public String header() {
		return "default/aheader";
	}
	
	@RequestMapping("amain")
	public String main(Model model) {
		service.amainMember(model);
		return "default/amain";
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
		AMemberDTO member = service.amemberInfo(id);
		int boardCount = service.userBoardCount(id);
		int commentCount = service.userCommentCount(id);
		int photoCount = service.userPhotoCount(id);
		
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("commentCount", commentCount);
		model.addAttribute("photoCount", photoCount);
		model.addAttribute("member", member);
		model.addAttribute("cp", cp);
		return "amember/amemberInfo";
	}	
	
	@PostMapping("memberDelete")
	public String memberDelete(String selectedValues) {
		service.amemberDelete(selectedValues);
		return "redirect:amemberDelete";
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
	
	@PostMapping("amemberSend")
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
