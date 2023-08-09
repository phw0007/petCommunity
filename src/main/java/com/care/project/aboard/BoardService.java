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
		int pageBlock = 3; 
		int end = pageBlock * currentPage; 
		
		int begin = end - pageBlock + 1; 
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

	public void aboardInfo(String id, String category, int no, Model model, String cp) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		no = (currentPage-1)*3;
		BoardDTO board = boardMapper.aboardInfo(id, category, no);
		ArrayList<BoardDTO> comments = boardMapper.aboardComment(id, category, no);
		model.addAttribute("comments", comments);
		model.addAttribute("board", board);
		model.addAttribute("cp", cp);
	}
	
	public void aboardDelete(String selectedValues) {
		String[] checkData = selectedValues.split(",");
		for(int i = 3; i <= checkData.length; i+=3) {
			int no = Integer.parseInt(checkData[i-3]);
			String id = checkData[i-2];
			String category = checkData[i-1];
			System.out.println(no);
			System.out.println(id);
			System.out.println(category);
			boardMapper.aboardDelete(id, category, no);
			boardMapper.aboardCommentDelete(id, category, no);
			boardMapper.aboardNoUpdate(no);
			boardMapper.aboardCommentNoUpdate(no);
		}
	}
}




