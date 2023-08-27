package com.care.project.ashop;

import java.awt.Window;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;


import com.care.project.common.PageService;
import com.care.project.shop.ShopDTO;
import com.care.project.shop.ShopMapper;

@Service
public class AShopService {
	@Autowired private AShopMapper ashopMapper;
	@Autowired private ShopMapper shopMapper;
	
	public String uploadImage(String selectedValues, MultipartFile imageFile, String fileName) {
		DecimalFormat forematter = new DecimalFormat("###,###");
		String[] checkData = selectedValues.split(",");
		String product = checkData[0];
		String category = checkData[1];
		String company = checkData[2];
		int pay = Integer.parseInt(checkData[3]);
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
		shopDto.setProduct(product);
		shopDto.setCompany(company);
		shopDto.setPay(pay);
		shopDto.setInventory(inventory);
		shopDto.setImageFile(fileName);
		shopDto.setInfo(info);
		AShopDTO check = ashopMapper.checkShop(shopDto);
		if(check == null) {
			ashopMapper.insertShop(shopDto);		
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
		DecimalFormat forematter = new DecimalFormat("###,###");
		requestUrl = requestUrl.substring(1);
		int pageBlock = 14; 
		int end = pageBlock * currentPage; 
		
		int begin = end - pageBlock + 1; 
		int no = 0;
		ArrayList<AShopDTO> shops = ashopMapper.shopData(begin, end, select, search);
		int totalCount = ashopMapper.count(select, search);
		String url = requestUrl+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*14;
		for(int i = 0; i < shops.size(); i++) {
			String pay = forematter.format(shops.get(i).getPay());
			shops.get(i).setShopPay(pay);
		}
		
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
		DecimalFormat forematter = new DecimalFormat("###,###");
		AShopDTO shop = ashopMapper.ashopInfo(name, category, company);
		String pay = forematter.format(shop.getPay());
		shop.setShopPay(pay);
		model.addAttribute("shop", shop);
		model.addAttribute("cp", cp);
	}
	
	public void ashopUpdate(String shopPay, String selectedValues, Model model) {
		String[] checkData = selectedValues.split(",");
		AShopDTO shop = new AShopDTO();
		shop.setNo(Integer.parseInt(checkData[0]));
		shop.setCategory(checkData[1]);
		shop.setProduct(checkData[2]);
		shop.setCompany(checkData[3]);
		shopPay = shopPay.replaceAll("[^\\w+]","");
		shop.setPay(Integer.parseInt(shopPay));
		shop.setInventory(Integer.parseInt(checkData[4]));
		shop.setImageFile(checkData[5]);
		shop.setInfo(checkData[6]);
		model.addAttribute("shop",shop);
	}
	
	public String updateShop(String selectedValues, MultipartFile imageFile, String fileName) {
		DecimalFormat forematter = new DecimalFormat("###,###");
		String[] checkData = selectedValues.split(",");
		String product = checkData[0];
		String category = checkData[1];
		String company = checkData[2];
		int pay = Integer.parseInt(checkData[3]);
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
		shopDto.setProduct(product);
		shopDto.setCompany(company);
		shopDto.setPay(pay);
		shopDto.setInventory(inventory);
		shopDto.setInfo(info);
		if(fileName != "") {
			shopDto.setImageFile(fileName);
			ashopMapper.updateShopImage(shopDto);
		}else {
			ashopMapper.updateShop(shopDto);
		}
		return "상품수정 완료되었습니다.";
	}
	
	public void shopDeleteCheckBoxes(String selectedValues) {
		String[] checkData = selectedValues.split(",");
		int sub = 0;
		for(int i = 3; i <= checkData.length; i+=3) {
			String product = checkData[i-3];
			String category = checkData[i-2];
			int no = Integer.parseInt(checkData[i-1]);
			no -= sub;
			ashopMapper.ashopDelete(product, category, no);
			ashopMapper.ashopNoUpdate(no);
			sub++;
		}
	}
	
	public void ashopOrder(String cp, String select, String search, Model model, String requestUrl) {
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
		ArrayList<AShopDTO> orders = ashopMapper.shopOrderData(begin, end, select, search);
		int totalCount = ashopMapper.orderCount(select, search);
		String url = requestUrl+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		no = (currentPage-1)*14;
		model.addAttribute("orders", orders);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
	}
	
	public void ashopOrderInfo(String selectedValues, Model model) {
		DecimalFormat forematter = new DecimalFormat("###,###");
		int no = Integer.parseInt(selectedValues);
		int listNo = 0;
		AShopDTO order = ashopMapper.ashopOrderInfo(no);
		ArrayList<AShopDTO> lists = ashopMapper.ashopOrderList(no);
		model.addAttribute("no",no);
		model.addAttribute("order",order);
		
		for(int i = 0; i < lists.size(); i++) {
			String pay = forematter.format(lists.get(i).getPay());
			lists.get(i).setShopPay(pay);
		}
		
		model.addAttribute("lists",lists);
		model.addAttribute("listNo",listNo);
	}
	
	public void orderDeleteCheckboxes(String selectedValues) {
		String[] checkData = selectedValues.split(",");
		int sub = 0;
		for(int i = 3; i <= checkData.length; i+=3) {
			int no = Integer.parseInt(checkData[i-1]);
			no -= sub;
			System.out.println("=======================================");
			System.out.println(selectedValues);
			System.out.println(no);
			ArrayList<AShopDTO> shopList = ashopMapper.ashopOrderList(no);
			for(int j = 0; j < shopList.size(); j++) {
				int shopNo = shopList.get(j).getProductId();
				int orderCount = shopList.get(j).getOrderCount();
				System.out.println("상품번호 : " + shopNo);
				System.out.println("구매갯수 : " + orderCount);
				ShopDTO shopData = shopMapper.getProductDetails(shopNo);
				int inventory = shopData.getInventory() + orderCount;
				shopMapper.updateInventory(shopNo, inventory);
			}
			ashopMapper.orderDelete(no);
			ashopMapper.orderNoUpdate(no);
			ashopMapper.orderListDelete(no);
			ashopMapper.orderListNoUpdate(no);
			sub++;
		}
	}
}