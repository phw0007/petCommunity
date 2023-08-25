package com.care.project.shop;

import java.text.DecimalFormat;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShopController {
	@Autowired private ShopService service;
	@Autowired private HttpSession session;
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
	
	@RequestMapping("shopLink")
	public String shopLink() {
		return "mall/shopLink";
	}
	
	@RequestMapping("/shopIn")
	public String shopIn(@RequestParam("productId") int productId, Model model) {
	    // productId로 선택한 상품의 상세 정보를 가져옵니다.
	    ShopDTO product = service.getProductDetails(productId);
	    
	    // 상품 정보를 모델에 추가합니다.
	    model.addAttribute("product", product);
	    
	    return "mall/shopIn"; // 상세 페이지 JSP 파일의 이름을 반환합니다.
	}
	
	@RequestMapping("shopBuy")
	public String shopBuy(String productPrice, String productId, String quantity, Model model) {
		String id = (String)session.getAttribute("id");
		if (id == null || id.isEmpty()) {
			return "redirect:login";
		}
		service.getProduct(productPrice, productId, quantity, id, model);
		return "mall/shopBuy";
	}
	
//	@RequestMapping(value="callback", produces = "application/text; charset=utf8")
//	public void callback(@RequestParam(required = false) String imp_uid) {
//	
//	}
//	@RequestMapping("callback")
//	public void callback(@RequestBody Map<String, Object> model) {
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.add("Content-Type", "application/json; charset=UTF-8");
//		JSONObject responseObj = new JSONObject();
//	}
	@RequestMapping("addToCart")
	public String addCart(String selectedValues, Model model) {
		String[] checkData = selectedValues.split(",");
		System.out.println(checkData[0]);//개당상품가격
		System.out.println(checkData[1]);//상품번호
		System.out.println(checkData[2]);//상품구매갯수
		int pay = Integer.parseInt(checkData[0]);
		int num = Integer.parseInt(checkData[2]);
		int total = pay*num;
		System.out.println(total);//상품총가격
		return "mall/addToCart";
	}
	
	@RequestMapping("callback")
	public String callback(String orderUser, String shippingUser,String orderProduct) {
		service.orderData(orderUser, shippingUser, orderProduct);
		return "redirect:shopping";
	}
	
	@RequestMapping("orderCancel")
	public void orderCancel() {
		service.orderCancel();
	}
}
