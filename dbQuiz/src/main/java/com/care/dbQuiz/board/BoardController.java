package com.care.dbQuiz.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {
	@Autowired private BoardService service;
	@Autowired private HttpSession session;
	
	@RequestMapping("boardForm")
	public String boardForm(Model model,
			@RequestParam(value = "currentPage", required = false)String cp) {
		service.boardForm(model, cp);
		return "board/boardForm";
	}
	
	@GetMapping("boardWrite")
	public String boardWrite() {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty())
			return "redirect:login";
		
		return "board/boardWrite";
	}
	
	@PostMapping("boardWriteService")
	public String boardWriteService(MultipartHttpServletRequest multi) {
		boolean result = service.boardWriteService(multi);
		if(result == false)
			return "redirect:boardWrite";
		
		return "redirect:boardForm";
	}
	
	@RequestMapping("boardContent")
	public String boardContent(Model model,
			@RequestParam(value = "no", required = false)String cp) {
		BoardDTO board = service.boardContent(model, cp);
		if(board == null)
			return "redirect:boardForm";
		
		board.setHits(board.getHits()+1);
		service.hits(board.getNo());
		return "board/boardContent";
	}
	
	@RequestMapping("boardDownload")
	public void boardDownload(@RequestParam(value = "no", required = false)String cp, 
			HttpServletResponse res) throws IOException {
		//throws IOException : 예외가 발생할 경우 해당 클래스에서 벗어난다.
		/*HttpServletRequest는 클라이언트가 서버에 보내는 요청정보를 처리하는 객체이고, 
		 *HttpServletResponse는 서버가 클라이언트로 보내는 응답정보를 처리하는 객체입니다.*/
		service.boardDownload(cp, res);
	}
	
	@GetMapping("boardModify")
	public String boardModify(Model model,
		@RequestParam(value = "no", required = false)String cp) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		
		BoardDTO board = service.boardContent(model, cp);
		if(board == null)
			return "redirect:boardForm";
		
		if(id.equals(board.getId()) == false)
			return "redirect:boardContent?no="+cp;
		
		return "board/boardModify";
	}
	
	@PostMapping("boardModifyService")
	public String boardModifyService(BoardDTO board) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		
		boolean result = service.boardModifyService(board);
		if(result == false)
			return "redirect:boardModify?no="+board.getNo();
		
		return "redirect:boardContent?no="+board.getNo();
	}
	
	@RequestMapping("boardDelete")
	public String boardDelete(@RequestParam(value = "no", required = false)String cp) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		boolean result = service.boardDelete(id, cp);
		if(result == false)
			return "redirect:boardContent?no="+cp;
		
		return "redirect:boardForm";
	}
}
