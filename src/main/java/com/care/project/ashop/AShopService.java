package com.care.project.ashop;

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
	public void uploadImage(String selectedValues, MultipartFile imageFile, String fileName) {
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
				String fileLocation = "C:\\javas\\boot_workspace\\project\\src\\main\\webapp\\image\\"+fileName;
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
		}
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
}