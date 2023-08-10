package com.care.project.board;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired private BoardService service;
	@Autowired private HttpSession session;
	
	@RequestMapping("boardForm")
	public String boardForm(@RequestParam(value="currentPage", required=false)String cp, Model model) {
		//service.boardForm(cp, model);
		return "board/boardForm";
	}
	
	@GetMapping("freeboardForm")
	public String freeboardForm(@RequestParam(value="currentPage", required=false)String cp, Model model) {
		service.freeboardForm(cp, model);
		return "board/freeboardForm";
	}
	
	
	@GetMapping("boardWrite")
	public String boardWrite() {
	String id = (String)session.getAttribute("id");
	if(id == null || id.isEmpty()) {
	return "redirect:login";
	}
	return "board/boardWrite";
	}
	
	@PostMapping("boardWriteProc")
	public String boardWriteProc(Model model, MultipartHttpServletRequest multi) {
		String msg = service.boardWriteProc(multi);
		if(msg.equals("로그인")) {
			return "redirect:login";
		}
		if(msg.equals("게시글 작성 완료")) {
			return "redirect:boardForm"; //forward 해도 됨. 목적은 둘 다 boardForm으로 매핑 찾아가서 메서드 실행하려는 것이기 때문
		}
		model.addAttribute("msg", msg);
		return "board/boardWrite";
	}
	
	@RequestMapping("boardContent")
	public String boardContent(
			@RequestParam(value="no", required = false)String n, Model model) {
		BoardDTO board = service.boardContent(n);
		System.out.println(n);
		if(board == null) {
			System.out.println("boardContent 게시글 번호 : " + n);
			return "redirect:freeboardForm";
		}
		model.addAttribute("board", board);
		return "board/boardContent";
	}
	
	
	@RequestMapping("boardDownload")
	public void boardDownload(
			@RequestParam(value="no", required = false)String n, 
			HttpServletResponse res) throws IOException{
		
		service.boardDownload(n, res);
		
//		boolean result = service.boardDownload(n, res);
//		if(result == false)
//			return "redirect:boardForm";
//	
//		return "forward:boardContent"; 
	}
	
	@GetMapping("boardModify")
	public String boardModify(
			@RequestParam(value="no", required = false)String n,
			Model model) {
		
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		
		BoardDTO board = service.boardModify(n);
		if(board == null)
			return "redirect:boardForm";
		
		if(id.equals(board.getId()) == false)
			return "redirect:boardContent?no="+n;
	
		model.addAttribute("board", board);
		return "board/boardModify";
	}
	
	@PostMapping("boardModifyProc")
	public String boardModifyProc(BoardDTO board) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		
		String result = service.boardModifyProc(board);
		if(result.equals("게시글 수정 완료")) {
			return "redirect:boardContent?num="+board.getNo();
		}
		return "board/freeboardForm"; // 실패했을 때 게시글 수정하는 자리로 간다고 하면, board/boardModify가 될 수 없음(보드에 들어갈 내용이 없으니까. redirect로 가야 함)
	}
	
	@RequestMapping("boardDeleteProc")
	public String boardDeleteProc(@RequestParam(value="no", required = false)String n) {
		String msg = service.boardDeleteProc(n);
		if(msg.equals("로그인"))
			return "redirect:login";
		
		if(msg.equals("작성자만 삭제 할 수 있습니다.")) {
			System.out.println("게시글 번호 : " + n);
			return "forward:boardContent";
		}
		
		return "redirect:freeboardForm";
	}
	
	@PostMapping("boardLikeProc")
	public String boardLikeProc(@RequestParam(value="no", required = false)String n) {
		
		return "redirect:boardContent";
	}
	
	   @ResponseBody
	    @PostMapping(value = "uploadImage", produces = "text/plain; charset=utf-8")
	    public String uploadImage(@RequestParam(value="imageFile", required = false) MultipartFile emailFile,
	                         @RequestParam("fileName") String fileName) {
	         System.out.println(fileName);
	         service.uploadImage(emailFile, fileName);
	        return "redirect:boardContent";
	    }
}
