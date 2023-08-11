package com.care.project.aboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
		int pageBlock = 14; 
		int end = pageBlock * currentPage; 
		
		int begin = end - pageBlock + 1; 
		int no = 0;
		ArrayList<BoardDTO> boards = boardMapper.boardData(begin, end, select, search);
		int totalCount = boardMapper.count(select, search);
		String url = requestUrl+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*14;
		model.addAttribute("boards", boards);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
	}

	public void aboardInfo(String id, String category, int no, Model model, String cp) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		BoardDTO board = boardMapper.aboardInfo(id, category, no);
		ArrayList<BoardDTO> comments = boardMapper.aboardComment(id, category, no);
		model.addAttribute("comments", comments);
		model.addAttribute("board", board);
		model.addAttribute("cp", cp);
	}
	
	public void boardDelete(String selectedValues) {
		String[] checkData = selectedValues.split(",");
		int sub = 0;
		for(int i = 3; i <= checkData.length; i+=3) {
			int no = Integer.parseInt(checkData[i-3]);
			no -= sub;
			String id = checkData[i-2];
			String category = checkData[i-1];
			boardMapper.aboardDelete(id, category, no);
			boardMapper.aboardCommentDelete(id, category, no);
			boardMapper.aboardNoUpdate(no);
			boardMapper.aboardCommentNoUpdate(no);
			sub++;
		}
	}

	public String boardDeleteComment(String selectedValues) {
		String[] checkData = selectedValues.split(",");
		int no = Integer.parseInt(checkData[0]);
		String id = checkData[1];
		String category = checkData[2];
		String cp = checkData[3];
		String writeDate = checkData[4];
		boardMapper.commentDeleteButton(id, category, no, writeDate);
		return "id="+id+"&category="+category+"&no="+no+"&currentPage="+cp;
	}
}




