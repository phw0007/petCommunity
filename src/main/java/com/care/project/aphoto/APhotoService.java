package com.care.project.aphoto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.project.aboard.ABoardDTO;
import com.care.project.common.PageService;

@Service
public class APhotoService {
	@Autowired private APhotoMapper photoMapper;
	public void aphoto(String cp, String select, String search, Model model, String requestUrl) {
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
		ArrayList<APhotoDTO> photos = photoMapper.photoData(begin, end, select, search);
		int totalCount = photoMapper.count(select, search);
		String url = requestUrl+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*14;
		model.addAttribute("photos", photos);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
		
	}
	public void aphotoInfo(String id, String category, int no, Model model, String cp) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		
		photoMapper.aphotoHit(id, category, no);
		APhotoDTO photo = photoMapper.aphotoInfo(id, category, no);
		ArrayList<APhotoDTO> comments = photoMapper.aphotoComment(id, category, no);
		
		model.addAttribute("comments", comments);
		model.addAttribute("photo", photo);
		model.addAttribute("cp", cp);
	}
	public void photoDeleteCheckBoxes(String selectedValues) {
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
			photoMapper.aphotoDelete(id, category, no);
			photoMapper.aphotoCommentDelete(id, category, no);
			photoMapper.aphotoNoUpdate(no);
			photoMapper.aphotoCommentNoUpdate(no);
			sub++;
		}
	}
	public String photoDeleteComment(String selectedValues) {
		String[] checkData = selectedValues.split(",");
		int no = Integer.parseInt(checkData[0]);
		String id = checkData[1];
		String category = checkData[2];
		String cp = checkData[3];
		String writeDate = checkData[4];
		photoMapper.commentDeleteButton(id, category, no, writeDate);
		return "id="+id+"&category="+category+"&no="+no+"&currentPage="+cp;
	}

}




