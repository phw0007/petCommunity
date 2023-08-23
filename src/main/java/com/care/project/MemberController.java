package com.care.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.care.project.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	@Autowired
	private HttpSession session;

	@RequestMapping("index")
	public String index() {
		return "member/index";
	}


	@RequestMapping("header")
	public String header() {
		return "default/header";
	}

	@RequestMapping("main")
	public String main() {
		return "default/main";
	}

	@RequestMapping("footer")
	public String footer() {
		return "default/footer";
	}
	
	@RequestMapping("index2")
	public String index2() {
	    // 세션에서 아이디 정보를 가져와서 로그인 상태 확인
	    String id = (String) session.getAttribute("id");
	    if (id == null) {
	        return "redirect:login"; // 로그인되지 않은 상태라면 로그인 페이지로 리다이렉트
	    }
	    return "member/index2";
	}
	
	
	
	

	@GetMapping("login")
	public String login() {
	    // 로그인 상태를 확인하여 리다이렉트할 페이지를 결정합니다.
	    if (session.getAttribute("id") != null) {
	        return "redirect:index2"; // 이미 로그인한 경우 index2.jsp로 리다이렉트
	    } else {
	        return "member/login"; // 로그인하지 않은 경우 login.jsp로 이동
	    }
	}

	@PostMapping("mloginProc")
	public String mloginProc(MemberDTO member) {
		String result = service.loginProc(member);

		String id = (String)session.getAttribute("id");
//		if(id.endsWith("admin")) {
//			return "redirect:aindex";
//		}
		if(result.equals("로그인 성공")) {

			return "redirect:index2";
		}
		
		return "member/login";
	}



	@PostMapping("registerProc")
	public String registerProc(MemberDTO member, String confirm) {
		String result = service.registerProc(member, confirm);
		if (result.equals("회원 등록 완료")) {
			return "redirect:index";
		}
		return "member/register";
	}

	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "forward:login";
	}

	@RequestMapping("userInfo")
	public String userInfo(String id, @RequestParam(value = "currentPage", required = false) String cp, Model model) {

		if (session.getAttribute("id") == null) {
			return "redirect:login";
		}
		MemberDTO member = service.userInfo(id);
		if (member == null) {
			return "redirect:memberInfo?currentPage=" + cp;
		}
		model.addAttribute("member", member);
		return "member/userInfo";
	}
	
	@RequestMapping("basket")
	public String basket(String id, @RequestParam(value = "currentPage", required = false) String cp, Model model) {

		if (session.getAttribute("id") == null) {
			return "redirect:login";
		}
		MemberDTO member = service.userInfo(id);
		if (member == null) {
			return "redirect:memberInfo?currentPage=" + cp;
		}
		model.addAttribute("member", member);
		return "mall/basket";
	}

	@GetMapping("update")
	public String update() {
		String id = (String) session.getAttribute("id");
		if (id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/update";
	}




	@GetMapping("info")
	public String info() {
		return "mall/info";
	}


	@PostMapping("updateProc")
	public String updateProc(MemberDTO member, String confirm) {
		String id = (String) session.getAttribute("id");
		if (id == null || id.isEmpty()) {
			return "redirect:login";
		}
		member.setId(id);
		String result = service.updateProc(member, confirm);
		if (result.equals("회원 정보 수정 완료")) {
			return "forward:logout";
		}
		return "member/update";

	}
	

	@GetMapping("delete")
	public String delete() {
		String id = (String) session.getAttribute("id");
		if (id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/delete";
	}

	@PostMapping("deleteProc")
	public String deleteProc(String pw, String confirmPw, Model model) {
		String id = (String) session.getAttribute("id");
		if (id == null || id.isEmpty()) {
			return "redirect:login";
		}

		String result = service.deleteProc(id, pw, confirmPw);
		model.addAttribute("msg", result);
		if (result.equals("회원 정보 삭제 완료")) {
			return "forward:logout";
		}
		return "member/delete";
	}

	@ResponseBody
	@PostMapping(value = "uploadImage3", produces = "text/plain; charset=utf-8") // 추가
	public String uploadImage3(@RequestParam(value = "imageFile", required = false) MultipartFile emailFile,
			@RequestParam("fileName") String fileName) {
		System.out.println(fileName);
		service.uploadImage3(emailFile, fileName);
		return "index";
	}

	@GetMapping("photoAlbum")
	public String photoAlbum() {
		return "member/photoAlbum";
	}


	@ResponseBody
	@PostMapping(value = "mySendEmail", produces = "text/plain; charset=utf-8")
	public String sendEmail(@RequestBody(required = false) String email) {
		return service.sendEmail(email);
	}

	@ResponseBody
	@PostMapping(value = "mySendAuth", produces = "text/plain; charset=utf-8")
	public String sendAuth(@RequestBody(required = false) String auth) {
	    String authResult = service.sendAuth(auth); // 인증 결과를 받아옴

	    return authResult; // "인증 성공" 또는 "인증 실패" 반환
	}
	
	
	@GetMapping("email")
	public String email() {
		return "member/email";
	}
	
	@PostMapping("register")
	public String register(String email, Model model) {
		model.addAttribute("email",email);
	    return "member/register";
	}
	
	@PostMapping(value = "emailProc", produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String emailProc(@RequestBody(required = false) String email) {
        // 여기서 인증 코드를 확인하고 처리하는 로직을 구현하세요.
        // 예를 들어, 인증 코드가 일치하는 경우에 "인증 성공"을 반환하고, 그렇지 않은 경우 "인증 실패"를 반환합니다.
        String authenticationResult = service.checkAuthenticationCode(email);
        
        return authenticationResult; // "인증 성공" 또는 "인증 실패"를 반환
    }
	

}
