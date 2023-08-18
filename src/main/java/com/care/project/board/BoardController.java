package com.care.project.board;

import java.io.IOException;
import java.util.ArrayList;

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
	
	@RequestMapping("freeboardForm")
	public String freeboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.freeboardForm(cp, model);
		return "board/freeboardForm";
	}
	@RequestMapping("qnaboardForm")
	public String qnaboardForm(@RequestParam(value="currentPage", required=false)String cp,Model model) {
		service.freeboardForm(cp, model);
		return "board/qnaboardForm";
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
			return "redirect:freeboardForm"; //forward 해도 됨. 목적은 둘 다 boardForm으로 매핑 찾아가서 메서드 실행하려는 것이기 때문
		}
		model.addAttribute("msg", msg);
		return "board/boardWrite";
	}
	
	   @RequestMapping("boardContent")
	   public String boardContent(
	         @RequestParam(value="no", required = false)String n,
	         @RequestParam(value="category")String c,
	         @RequestParam(value="cp", required=false)String cp,
	         Model model) {
	      BoardDTO board = service.boardContent(n,cp);
	      BoardDTO boards = new BoardDTO();
	      ArrayList<BoardDTO> comments = service.boardComments(c,n);
	      System.out.println(n);
	      System.out.println("페이지"+cp);
	      if(board == null) {
	         System.out.println("boardContent 게시글 번호 : " + n);
	         return "redirect:freeboardForm";
	      }
	      model.addAttribute("board", board);
	      model.addAttribute("comments", comments);
	      model.addAttribute("cp",cp);
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
	@PostMapping(value = "uploadImage2", produces = "text/plain; charset=utf-8")
	public String uploadImage(@RequestParam(value = "imageFile", required = false) MultipartFile emailFile,
			@RequestParam("fileName") String fileName) {
		System.out.println(fileName);
		service.uploadImage(emailFile, fileName);
		return "redirect:boardContent";
	}
	
	@PostMapping("freecommentProc")
	public String freecommentProc(@RequestParam(value="no", required = false)String n,
		    @RequestParam(value = "category", required = false) String category,
			BoardDTO board, Model model) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		System.out.println(board.getCategory());
		String result = service.freecommtentProc(board);

		if(result.equals("댓글 작성 완료")) {
			return "forward:boardContent?no="+n; //forward 해도 됨. 목적은 둘 다 boardForm으로 매핑 찾아가서 메서드 실행하려는 것이기 때문
		}
	   
		return "board/boardContent";
	}
	
	@PostMapping("commentDelete")
	public String commentDelete(String selectedValues) {
		
		String url= service.commentDeleteProc(selectedValues);
		System.out.println(url);
      return "forward:boardContent?"+url;
      
	}
	
	   @PostMapping("clickLike")
	   public String clickLikeButton(String selectedValues, Model model) {
		   
		   System.out.println(selectedValues);
	      String url = service.boardLikeButton(selectedValues);
	      if(url.equals("로그인이 필요합니다.")) {
	    	  model.addAttribute("errorMessage", "로그인이 필요한 작업입니다."); // 에러 메시지 모델에 추가
	    	  return "redirect:freeboardForm";
	      }
	      System.out.println(url);
	      return "forward:boardContent?"+url;
	   }
	  
	@RequestMapping("boardSearch")
	public String boardSearch(@RequestParam(value="currentPage", required=false)String cp, 
			String select, String search, Model model) {
		System.out.println("알려쥬" + select);
		System.out.println("이것동"+search);
		service.boardSearch(cp, select, search, model);
		return "board/freeboardForm";
	}
}