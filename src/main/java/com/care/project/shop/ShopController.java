package com.care.project.shop;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@Autowired
	private HttpServletRequest request; // 필드로 HttpServletRequest를 주입받습니다.

	@RequestMapping("/addToCart")
	@ResponseBody
	public String addToCart(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity) {
	    // 세션에서 장바구니 정보를 가져옵니다. 세션이 없다면 생성합니다.
	    HttpSession session = request.getSession(true);
	    List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");


	    // 카트가 비어있는 경우 새로 생성합니다.
	    if (cart == null) {
	        cart = new ArrayList<>();
	    }

	    // 선택한 상품 정보를 데이터베이스 등에서 가져옵니다.
	    ShopDTO product = shopService.getProductDetails(productId);

	    // 카트에 상품 정보와 수량을 추가합니다.
	    cart.add(new CartItemDTO(product, quantity));

	    // 장바구니 정보를 세션에 저장합니다.
	    session.setAttribute("cart", cart);

	    return "success"; // 또는 "error"
	}
	
	@RequestMapping("/cart")
	public String viewCart(Model model) {
	    // 세션에서 장바구니 정보를 가져옵니다.
	    HttpSession session = request.getSession(false);
	    List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new ArrayList<>();
	    }

	    // 장바구니 내용을 뷰에 전달합니다.
	    model.addAttribute("cartItems", cart);

	    return "mall/cart"; // 장바구니 뷰를 반환합니다.
	}

	 @GetMapping("cart")
	    public String cart() {
	        if (session.getAttribute("id") == null) {
	            return "redirect:login";
	        }
	        return "mall/cart";
	    }
	
	
	
}