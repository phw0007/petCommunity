package com.care.project.shop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.project.ashop.AShopDTO;
import com.care.project.common.PageService;
import com.care.project.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Service
public class ShopService {
	@Autowired private ShopMapper shopMapper;
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
			System.out.println(pay);
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

	public ShopDTO getProductById(int productId) {
		
		return shopMapper.getProductDetails(productId);
	}
	
	
	public void addToCart(int productId, int quantity, int total) {
	    // productId를 사용하여 상품 정보 가져오기
	    ShopDTO product = shopMapper.getProductDetails(productId);
	    String id = (String) session.getAttribute("id");
	    // CartDTO 객체를 생성하여 관련 데이터 설정
	    CartDTO cartItem = new CartDTO();
	    cartItem.setId(id);
	    cartItem.setProduct(product.getProduct());
	    cartItem.setCompany(product.getCompany());
	    cartItem.setPay(product.getPay());
	    cartItem.setImageFile(product.getImageFile());
	    cartItem.setProductId(productId);
	    cartItem.setQuantity(quantity);
	    cartItem.setTotal(total);

	    // 매퍼를 사용하여 장바구니 항목을 데이터베이스에 저장
	    shopMapper.addToCart(cartItem);
	}
	 public List<CartDTO> getCartItems(String id) {
	        return shopMapper.getCartItems(id);
	    }
	
	

}