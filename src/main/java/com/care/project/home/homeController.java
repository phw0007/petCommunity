package com.care.project.home;

import java.awt.Image;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import jakarta.servlet.http.HttpSession;

@Controller
public class homeController {

	@Autowired private photoService service;
	@Autowired private HttpSession session;
	
	
	
	@RequestMapping("home")
	public String home(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "default/home";
	}
	
	
	 @Autowired
	    private photoMapper imageMapper; // 실제 매퍼 인터페이스를 구현한 클래스의 빈을 주입

//	    @RequestMapping("photo")
//	    public String photo(Model model2) {
//	        List<Image> images = imageMapper.getAllImages(); // 이미지 리스트를 매퍼를 통해 가져옴
//	        model2.addAttribute("images", images); // JSP로 이미지 리스트를 전달
//	        System.out.println();
//	        return "photo/photoMain"; // 이미지 리스트를 보여줄 JSP 파일의 이름
//	    }
	
	
	
	@RequestMapping("photo")
	public String photo(
			Model model, Model model2) {
		List<photoDTO> photos = service.getAllPhotos();
	    model.addAttribute("photos", photos);
		
	    List<Image> images = imageMapper.getAllImages(); // 이미지 리스트를 매퍼를 통해 가져옴
        model2.addAttribute("images", images); // JSP로 이미지 리스트를 전달
	   
        
        
        
		return "photo/photoMain";
	}
	
	@RequestMapping("photoWrite")
	public String photoWrite(
			@RequestParam(value="currentPage", required = false)String cp,
			Model model) {
		System.out.println("호출되는거야?");
		
		return "photo/photoWrite";
		
		
	}
	
	@PostMapping("photoWriteProc")
	public String photoWriteProc(Model model, MultipartHttpServletRequest multi) {
		String msg = service.photoWriteProc(multi);
		if(msg.equals("로그인"))
			return "redirect:login";
		
		if(msg.equals("게시글 작성 완료"))
			return "redirect:photoMain";
		
		model.addAttribute("msg", msg);
		return "redirect:photo";
	}
	
	
	@RequestMapping("potoContent")
	public String photoContent(
			@RequestParam(value="no", required = false)String n, Model model) {
		photoDTO photo = service.photoContent(n);
		if(photo == null) {
			System.out.println("boardContent 게시글 번호 : " + n);
			return "redirect:photo";
		}
		model.addAttribute("photo", photo);
		return "photo/photoContent";
		
		
	}
	

}







