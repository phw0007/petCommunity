package com.care.project.aboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.project.amember.MemberDTO;
import com.care.project.amember.MemberMapper;
import com.care.project.common.PageService;

import jakarta.servlet.http.HttpSession;

@Service
public class BoardService {
	@Autowired private BoardMapper boardMapper;
	@Autowired private HttpSession session;
	public void aboard(String cp, String select, String search, Model model, String requestUrl) {
		if(select == null){
			select = "";
		}
		
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
			
		if(search == null) {
			search = "";
		}
		requestUrl = requestUrl.substring(1);
		int pageBlock = 3; // �븳 �럹�씠吏��뿉 蹂댁씪 �뜲�씠�꽣�쓽 �닔
		int end = pageBlock * currentPage; // �뀒�씠釉붿뿉�꽌 媛��졇�삱 留덉�留� �뻾踰덊샇
		
		int begin = end - pageBlock + 1; // �뀒�씠釉붿뿉�꽌 媛��졇�삱 �떆�옉 �뻾踰덊샇
		int no = 0;
		ArrayList<BoardDTO> boards = boardMapper.boardData(begin, end, select, search);
		int totalCount = boardMapper.count(select, search);
		String url = requestUrl+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*3;
		model.addAttribute("boards", boards);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
	}

	public void aboardInfo(String id, String boardName, int no, Model model, String cp) {
		BoardDTO board = boardMapper.aboardInfo(id, boardName, no);
		ArrayList<BoardDTO> comments = boardMapper.aboardComment(id, boardName, no);
		model.addAttribute("comments", comments);
		model.addAttribute("board", board);
		model.addAttribute("cp", cp);
	}
	
	public void aboardComment(String id, String boardName, int no, Model model, String cp) {
		ArrayList<BoardDTO> comments = boardMapper.aboardComment(id, boardName, no);
		model.addAttribute("comments", comments);
		model.addAttribute("cp", cp);
	}

}




