package com.care.project.shop;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.project.MemberMapper;
import com.care.project.ashop.AShopDTO;
import com.care.project.common.PageService;
import com.care.project.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Service
public class ShopService {
	@Autowired private ShopMapper shopMapper;
	@Autowired private MemberMapper memberMapper;
	@Autowired private HttpSession session;
	public void shop(String cp, String select, String search, Model model, String category, String page) {
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
		int pageBlock = 8; 
		int end = pageBlock * currentPage; 

		int begin = end - pageBlock + 1; 
		int no = 0;
		ArrayList<ShopDTO> shops = shopMapper.shopData(begin, end, select, search, category);
		int totalCount = shopMapper.count(select, search, category);
		String url = page+"?select="+select+"&search="+search+"&currentPage=";
		String result = PageService.printPage(url, currentPage, totalCount, pageBlock);
		for(int i = 0; i < shops.size(); i++) {
			String pay = forematter.format(shops.get(i).getPay());
			shops.get(i).setShopPay(pay);
		}
		no = (currentPage-1)*14;
		model.addAttribute("shops", shops);
		model.addAttribute("result", result);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		model.addAttribute("select", select);
		model.addAttribute("search", search);
	}

	public ShopDTO getProductDetails(int productId) {
	    return shopMapper.getProductDetails(productId);
	}

	public void getProduct(String productPrice, String productId, String quantity, String id, Model model) {
		DecimalFormat forematter = new DecimalFormat("###,###");
		int pay = Integer.parseInt(productPrice);
		int num = Integer.parseInt(quantity);
		int no = Integer.parseInt(productId);
		int delivery = 3000;
		int number = 0;
		int total = pay*num;
		int totalPay = total+delivery;
		String productPay = forematter.format(total);
		String productAllPay = forematter.format(total);
		String shippingFee= forematter.format(delivery);
		String shippingPay= forematter.format(totalPay);
		System.out.println(productId);
		System.out.println(quantity);
		System.out.println(total);
		System.out.println(id);
		ShopDTO product = shopMapper.getProductDetails(no);
		MemberDTO user = memberMapper.mloginProc(id);
		model.addAttribute("product", product);
		model.addAttribute("user", user);
		model.addAttribute("num", num);
		model.addAttribute("totalPay", totalPay);
		model.addAttribute("productPay", productPay);
		model.addAttribute("shippingPay", shippingPay);
		model.addAttribute("shippingFee", shippingFee);
		model.addAttribute("productAllPay", productAllPay);
		model.addAttribute("number", number);
	}


}