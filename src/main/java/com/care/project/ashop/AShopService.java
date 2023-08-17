package com.care.project.ashop;

import java.awt.Window;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.project.aboard.ABoardDTO;
import com.care.project.aboard.ABoardMapper;
import com.care.project.common.PageService;

@Service
public class AShopService {
	@Autowired private AShopMapper shopMapper;
	public String uploadImage(String selectedValues, MultipartFile imageFile, String fileName) {
		DecimalFormat forematter = new DecimalFormat("###,###");
		String[] checkData = selectedValues.split(",");
		String name = checkData[0];
		String category = checkData[1];
		String company = checkData[2];
		int payData = Integer.parseInt(checkData[3]);
		String pay = forematter.format(payData);
		int inventory = Integer.parseInt(checkData[4]);
		String info = checkData[5];
		if(imageFile != null) {
			if(imageFile.getSize() != 0) {
				String fileLocation = "C:\\Users\\hi\\git\\petCommunity\\src\\main\\webapp\\image\\"+fileName;
				File save = new File(fileLocation);
				try {
					imageFile.transferTo(save);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(fileName == null) {
			fileName = "";
		}else {
			fileName = "/image/"+fileName;
		}
		AShopDTO shopDto = new AShopDTO();
		shopDto.setCategory(category);
		shopDto.setName(name);
		shopDto.setCompany(company);
		shopDto.setPay(pay);
		shopDto.setInventory(inventory);
		shopDto.setImageFile(fileName);
		shopDto.setInfo(info);
		AShopDTO check = shopMapper.checkShop(shopDto);
		if(check == null) {
			shopMapper.insertShop(shopDto);		
		}else {
			return "이미 존재하는 상품입니다.";
		}
		return "상품등록 완료되었습니다.";
	}
	public void ashop(String cp, String select, String search, Model model, String requestUrl) {
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
		ArrayList<AShopDTO> shops = shopMapper.shopData(begin, end, select, search);
		int totalCount = shopMapper.count(select, search);
		String url = requestUrl+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*14;
		model.addAttribute("shops", shops);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
		
	}
	
	public void ashopInfo(String name, String category, String company, String cp, Model model) {
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			currentPage = 1;
		}
		AShopDTO shop = shopMapper.ashopInfo(name, category, company);

		model.addAttribute("shop", shop);
		model.addAttribute("cp", cp);
	}
	
	public void ashopUpdate(String pay, String selectedValues, Model model) {
		String[] checkData = selectedValues.split(",");
		AShopDTO shop = new AShopDTO();
		shop.setNo(Integer.parseInt(checkData[0]));
		shop.setCategory(checkData[1]);
		shop.setName(checkData[2]);
		shop.setCompany(checkData[3]);
		shop.setPay(pay);
		shop.setInventory(Integer.parseInt(checkData[4]));
		shop.setImageFile(checkData[5]);
		shop.setInfo(checkData[6]);
		model.addAttribute("shop",shop);
	}
	public String updateShop(String selectedValues, MultipartFile imageFile, String fileName) {
		DecimalFormat forematter = new DecimalFormat("###,###");
		String[] checkData = selectedValues.split(",");
		String name = checkData[0];
		String category = checkData[1];
		String company = checkData[2];
		int payData = Integer.parseInt(checkData[3]);
		String pay = forematter.format(payData);
		int inventory = Integer.parseInt(checkData[4]);
		String info = checkData[5];
		if(imageFile != null) {
			if(imageFile.getSize() != 0) {
				String fileLocation = "C:\\Users\\hi\\git\\petCommunity\\src\\main\\webapp\\image\\"+fileName;
				File save = new File(fileLocation);
				try {
					imageFile.transferTo(save);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(fileName == null) {
			fileName = "";
		}else {
			fileName = "/image/"+fileName;
		}
		AShopDTO shopDto = new AShopDTO();
		shopDto.setCategory(category);
		shopDto.setName(name);
		shopDto.setCompany(company);
		shopDto.setPay(pay);
		shopDto.setInventory(inventory);
		shopDto.setInfo(info);
		if(fileName != "") {
			shopDto.setImageFile(fileName);
			shopMapper.updateShopImage(shopDto);
		}else {
			shopMapper.updateShop(shopDto);
		}
		return "상품수정 완료되었습니다.";
	}
}