package com.care.project.home;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpSession;

@Service
public class photoService {

	@Autowired private photoMapper photoMapper;
	@Autowired private HttpSession session;
	
	public String photoWriteProc(MultipartHttpServletRequest multi){
			
		
		photoDTO photo = new photoDTO();
	//	photo.setId(multi.getParameter("id")); 
		photo.setCategory(multi.getParameter("category"));
		photo.setTitle(multi.getParameter("title"));
		photo.setContent(multi.getParameter("content"));
		SimpleDateFormat sdfDate  = new SimpleDateFormat("yyyy-MM-dd");
		photo.setWrite_date(sdfDate .format(new Date()));
		photo.setFile_name("");
		
		  List<MultipartFile> files = multi.getFiles("upfile"); // 여러 개의 파일 가져오기
		    List<String> savedFileNames = new ArrayList<>(); // 저장된 파일명들을 담을 리스트

		    for (MultipartFile file : files) {
		        String fileName = file.getOriginalFilename();
		        if (file.getSize() != 0) {
		            // 파일의 중복을 해결하기 위해 시간의 데이터를 파일이름으로 구성함.
		            SimpleDateFormat sdfFile  = new SimpleDateFormat("yyyyMMddHHmmss-");
		            Calendar cal = Calendar.getInstance();
		            fileName = sdfFile .format(cal.getTime()) + fileName;

		            String fileLocation = "C:/JAVAS/boot_workspace/project/src/main/resources/static/img/";
		            File save = new File(fileLocation + fileName);

		            try {
		                // 서버가 저장한 업로드 파일은 임시 저장 경로에 있는데 개발자가 원하는 경로로 이동
		                file.transferTo(save);
		                savedFileNames.add(fileName); // 저장된 파일명을 리스트에 추가
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    // 저장된 파일명들을 photo 객체에 설정 (여러 개의 파일명을 쉼표로 구분하여 하나의 문자열로 저장)
		    photo.setFile_name(String.join(",", savedFileNames));

		
		photoMapper.photoWriteProc(photo);
		return "photo";

	}
	
	
	public photoDTO photoContent(String n) {
		int no = 0;
		try {
			no = Integer.parseInt(n);
		} catch (Exception e) {
			return null;
		}
		
		photoDTO photo = photoMapper.photoContent(no);
		if(photo == null)
			return null;
		photo.setHits(photo.getHits()+1);
		incHit(photo.getNo());
		
		System.out.println("board.getFileName() : " + photo.getFile_name());
		System.out.println("board.getFileName() : " + photo.getFile_name().isEmpty());
		if(photo.getFile_name() != null && photo.getFile_name().isEmpty() == false) {
			String fn = photo.getFile_name();
			String[] fileName = fn.split("-", 2);
			photo.setFile_name(fileName[1]);
		}
		return photo;
	}


	private void incHit(int no) {
		photoMapper.incHit(no);
		
	}
	  
	 
	   
	 
	
}
