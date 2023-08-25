package com.care.project.shop;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.care.project.member.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShopController {
	@Autowired private ShopService service;
	 @Autowired
	    private ShopService shopService;
	 @Autowired
		private HttpSession session;
	

	@RequestMapping({"/shopping", "/food", "/snack", "/cloths", "/medi", "/pad", "/living"})
	public String shopping(@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model, HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String category = "";
		String page = "";
		if("/shopping".equals(requestUrl)) {
			page = "shopping";
			category = "";
		}else if("/food".equals(requestUrl)) {
			page = "food";
			category = "사료";
		}else if("/snack".equals(requestUrl)) {
			page = "snack";
			category = "간식";
		}else if("/cloths".equals(requestUrl)) {
			page = "cloths";
			category = "의류";
		}else if("/medi".equals(requestUrl)) {
			page = "medi";
			category = "약품";
		}else if("/pad".equals(requestUrl)) {
			page = "pad";
			category = "배변패드";
		}else {
			page = "living";
			category = "생활용품";
		}
		model.addAttribute(page,"border-bottom: 3px solid #FFEDA1;");
		service.shop(cp, select, search, model, category, page);
		return "mall/shopping";
	}
	
	
	@RequestMapping("/shopIn")
	public String shopIn(@RequestParam("productId") int productId, Model model) {
	    // productId로 선택한 상품의 상세 정보를 가져옵니다.
	    ShopDTO product = service.getProductDetails(productId);
	    
	    // 상품 정보를 모델에 추가합니다.
	    model.addAttribute("product", product);
	    
	    return "mall/shopIn"; // 상세 페이지 JSP 파일의 이름을 반환합니다.
	}
	
	
	
	
	  @GetMapping("cart")
	    public String cart(Model model) {
	        String id = (String) session.getAttribute("id");
	        if (id == null) {
	            return "redirect:login"; // 로그인되지 않은 경우 로그인 페이지로 이동
	        }

	        List<CartDTO> cartItems = shopService.getCartItems(id);
	        model.addAttribute("cartItems", cartItems);

	        return "mall/cart";
	    }
	 
	 
	 @RequestMapping("addCart")
	 public String addCart(String selectedValues, Model model) {
	     String id = (String) session.getAttribute("id");
	     if (id == null) {
	            return "redirect:login"; // 로그인되지 않은 경우 로그인 페이지로 이동
	        }
	     String[] checkData = selectedValues.split(",");
	     int inventory = Integer.parseInt(checkData[0]);     // 상품 구매 갯수
	     int productPrice = Integer.parseInt(checkData[1]); // 개당 상품 가격
	     int productId = Integer.parseInt(checkData[2]);   // 상품 번호
	     int quantity = Integer.parseInt(checkData[3]);     // 상품 구매 갯수
	     int total = productPrice * quantity; // 상품 총 가격 계산
	     
	     // productId를 사용하여 상품 정보를 가져와서 모델에 추가
	     ShopDTO product = service.getProductDetails(productId);
	     model.addAttribute("product", product);
	     product.getProduct();
	     
	     
	     // 나머지 필요한 정보도 모델에 추가
	     model.addAttribute("productPrice", productPrice);
	     model.addAttribute("productId", productId);
	     model.addAttribute("quantity", quantity);
	     model.addAttribute("inventory", inventory);
	     model.addAttribute("total", total);
	     
	     shopService.addToCart(productId, quantity, total);
	     
	     
	     
	  // 기존 코드에 추가: 장바구니 정보 가져와서 모델에 추가
	        
	        List<CartDTO> cartItems = shopService.getCartItems(id);
	        model.addAttribute("cartItems", cartItems);
	     
	     return "mall/cart"; // 결과 페이지로 이동
	 }
	 
	 
	 @PostMapping("removeSelectedItems")
	    public String removeSelectedItems(@RequestParam("selectedItems") int[] selectedItems) {
	        String id = (String) session.getAttribute("id");
	        shopService.removeSelectedItems(id, selectedItems);

	        return "redirect:cart"; // 카트 페이지로 리다이렉트
	    }
	 

	 
	 
	 
	 
	
}