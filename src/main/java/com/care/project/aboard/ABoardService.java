package com.care.project.aboard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.project.common.PageService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ABoardService {
	@Autowired private ABoardMapper boardMapper;
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
		ArrayList<ABoardDTO> boards = boardMapper.boardData(begin, end, select, search);
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
		
		boardMapper.aboardHit(id, category, no);
		ABoardDTO board = boardMapper.aboardInfo(id, category, no);
		ArrayList<ABoardDTO> comments = boardMapper.aboardComment(id, category, no);
		
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
			System.out.println(no);
			System.out.println(id);
			System.out.println(category);
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

	public void aboardAnno(String cp, String select, String search, Model model, HttpServletRequest request) {
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
		
		int pageBlock = 14; 
		int end = pageBlock * currentPage; 
		
		int begin = end - pageBlock + 1; 
		int no = 0;
		ArrayList<ABoardDTO> boards = boardMapper.boardAnnoData(begin, end, select, search);
		int totalCount = boardMapper.annoCount(select, search);
		String url = "aboardAnno?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*14;
		model.addAttribute("boards", boards);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
	}


	public void aboardAnnoRegister(String id, String title, String content) {
		ABoardDTO aboardDto = new ABoardDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String writeDate = sdf.format(new Date());
	    aboardDto.setId(id);
	    aboardDto.setTitle(title);
	    aboardDto.setContent(content);
	    aboardDto.setCategory("공지사항");
	    aboardDto.setFileName("");
	    aboardDto.setWriteDate(writeDate);
	    boardMapper.aboardAnnoRegister(aboardDto);
	}

	public void aboardAnnoUpdate(String selectedValues, Model model) {
		String[] checkData = selectedValues.split(",");
		String id = checkData[0];
		String title = checkData[1];
		String writeDate = checkData[2];
		String content = checkData[3];
		String no = checkData[4];
		model.addAttribute("no", no);
		model.addAttribute("id", id);
		model.addAttribute("title", title);
		model.addAttribute("writeDate", writeDate);
		model.addAttribute("content", content);
	}

	public void aboardAnnoUpdate(String no, String id, String title, String content) {
		ABoardDTO aboardDto = new ABoardDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String writeDate = sdf.format(new Date());
	    int noData = Integer.parseInt(no);
	    aboardDto.setNo(noData);
	    aboardDto.setId(id);
	    aboardDto.setTitle(title);
	    aboardDto.setContent(content);
	    aboardDto.setCategory("공지사항");
	    aboardDto.setFileName("");
	    aboardDto.setWriteDate(writeDate);
	    boardMapper.aboardAnnoUpdate(aboardDto);
	}
}




