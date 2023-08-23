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
	
	
	 public String addToCart(int productId, int quantity) {
	        List<CartItemDTO> cart = getCartItems(); // 기존 장바구니 정보를 가져옴

	        // 선택한 상품 정보를 데이터베이스 등에서 가져옵니다. (가정)
	        ShopDTO product = getProductDetails(productId);

	        // 카트에 상품 정보와 수량을 추가합니다.
	        cart.add(new CartItemDTO(product, quantity));

	        // 장바구니 정보를 세션에 저장합니다.
	        session.setAttribute("cart", cart);

	        return "success"; // 또는 "error"
	    }

	    public List<CartItemDTO> getCartItems() {
	        // 세션에서 장바구니 정보를 가져옵니다.
	        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");

	        // 카트가 비어있는 경우 새로 생성합니다.
	        if (cart == null) {
	            cart = new ArrayList<>();
	        }

	        return cart;
	    }
	
	


	
	
	

}