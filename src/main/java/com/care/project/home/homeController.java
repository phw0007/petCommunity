package com.care.project.home;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.project.board.BoardDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class homeController {

	@Autowired private photoService service;
	@Autowired private HttpSession session;
	
	
	
	@RequestMapping("home")
	public String home(Model model) {
			
		 List<photoDTO> mphotos = service.getHomePhotos(); 
	        model.addAttribute("mphotos", mphotos);
	  
	        List<BoardDTO> mboards = service.mainhomeboard();
//	        if (mboards == null) {
//	            System.out.println("mboards is null");
//	        } else {
//	            System.out.println("mboards in model: " + mboards);
//
//	            for (BoardDTO board : mboards) {
//	                System.out.println("Board ID: " + board.getId());
//	                System.out.println("Board Title: " + board.getTitle());
//	               System.out.println(board.getNo());
//	               System.out.println(board.getWriteDate());
//	            }
//	        }
	        model.addAttribute("mboards", mboards);
	 //     System.out.println(mboards);
	      //  System.out.println("mboards in model: " + model.getAttribute("mboards"));
		return "default/home";
	}
	
	
	 @Autowired
	    private photoMapper imageMapper; // 실제 매퍼 인터페이스를 구현한 클래스의 빈을 주입


	
	
	@RequestMapping("photoMain")
	public String photo(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model) {
		
		service.photo(cp,select, search, model);
		
		
   
		return "photo/photoMain";
	}
	 

//	List<photoDTO> photos = service.getAllPhotos();
//    model.addAttribute("photos", photos);

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
		return "redirect:photoMain";
	}
	
	
	@RequestMapping("photoContent")
	public String photoContent( @RequestParam(value="no", required = false)String n,
	        
	         @RequestParam(value="cp", required=false)String cp,
	         Model model, Model model2) {
	      photoDTO photo = service.photoContent(n,cp);
	      photoDTO photos = new photoDTO();
//	      System.out.println(n);
//	      System.out.println("페이지"+cp);
	      if(photo == null) {
	         System.out.println("boardContent 게시글 번호 : " + n);
	         return "redirect:photoMain";
	      }
	      List<photoDTO> aphotos = service.getAllPhotos();
		    model2.addAttribute("photos", aphotos);
		    
	      model.addAttribute("photo", photo);
	      model.addAttribute("cp",cp); {
		
		return "photo/photoContent";
	}
	}		
			

}