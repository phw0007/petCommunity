package com.care.project.home;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.project.ainfo.AInfoDTO;
import com.care.project.ainfo.AInfoMapper;
import com.care.project.ashop.AShopDTO;
import com.care.project.board.BoardDTO;
import com.care.project.common.PageService;
import com.care.project.shop.ShopDTO;
import com.care.project.shop.ShopMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class photoService {

	@Autowired private photoMapper photoMapper;
	@Autowired private AInfoMapper infoMapper;
	@Autowired private ShopMapper shopMapper;
	@Autowired private HttpSession session;
	
	public String photoWriteProc(MultipartHttpServletRequest multi){
		
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "로그인";
		}
		
		photoDTO photo = new photoDTO();
		photo.setId(id);
		
		photo.setCategory(multi.getParameter("category"));
		photo.setTitle(multi.getParameter("title"));
		photo.setContent(multi.getParameter("content"));
		SimpleDateFormat sdfDate  = new SimpleDateFormat("yyyy-MM-dd");
		photo.setWriteDate(sdfDate .format(new Date()));
		
		photo.setFileName("");
		
		  List<MultipartFile> files = multi.getFiles("upfile"); // 여러 개의 파일 가져오기
		    List<String> savedFileNames = new ArrayList<>(); // 저장된 파일명들을 담을 리스트

		    for (MultipartFile file : files) {
		        String fileName = file.getOriginalFilename();
		        if (file.getSize() != 0) {
		            // 파일의 중복을 해결하기 위해 시간의 데이터를 파일이름으로 구성함.
		            SimpleDateFormat sdfFile  = new SimpleDateFormat("yyyyMMddHHmmss-");
		            Calendar cal = Calendar.getInstance();
		            fileName = sdfFile .format(cal.getTime()) + fileName;

		            String fileLocation = "C:/JAVAS/boot_workspace/petCommunity/src/main/webapp/image/";
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
		    photo.setFileName(String.join(",", savedFileNames));
		    System.out.println(photo.getFileName());
		
		photoMapper.photoWriteProc(photo);
		return "photo";

	}
	
	
	public photoDTO photoContent(String n, String cp) {
		int no = 0;
		try {
			no = Integer.parseInt(n);
		} catch (Exception e) {
			return null;
		}
		
		photoDTO photo = photoMapper.photoContent(no);
		if(photo == null)
			return null;
		
		return photo;
	}


	private void incHit(int no) {
		photoMapper.incHit(no);
		
	} 
	  
	public List<photoDTO> getAllPhotos() {
	    return photoMapper.getAllPhotos(); // 예시: 모든 사진 데이터를 가져오는 메서드 호출
	}
	
	public List<photoDTO> getHomePhotos(){
		return photoMapper.homePhoto();
	}
	
	public List<BoardDTO> mainhomeboard(){
		int begin = 1;
		int end = 22;
		return photoMapper.mainhomeboard(begin,end);
	}
	
	public void photo(String cp, String select, String search, Model model) {
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
		int pageBlock = 8; 
		int end = pageBlock * currentPage; 
		
		int begin = end - pageBlock + 1; 
		int no = 0;
		ArrayList<photoDTO> photos = photoMapper.photoData(begin, end, select, search);
		int totalCount = photoMapper.count(select, search);
		String url = "photoMain?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*6;
		model.addAttribute("photos", photos);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
		
		
	}


	public ArrayList<AInfoDTO> getInfo() {
		int begin = 1;
		int end = 19;
		return infoMapper.getInfo(begin, end);
	}


	public ArrayList<AShopDTO> getShop() {
		DecimalFormat forematter = new DecimalFormat("###,###");
		int begin = 1;
		int end = 5;
		ArrayList<AShopDTO> shops = shopMapper.getShop(begin, end);
		for(int i = 0; i < shops.size(); i++) {
			String pay = forematter.format(shops.get(i).getPay());
			shops.get(i).setShopPay(pay);
		}
		return shops;
	}

}
