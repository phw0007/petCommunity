package com.care.project.shop;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.project.MemberMapper;
import com.care.project.ashop.AShopDTO;
import com.care.project.common.PageService;
import com.care.project.member.MemberDTO;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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

	public void orderData(String orderUser, String shippingUser, String orderProduct) {
		String[] orderUserData = orderUser.split(",");
		String[] orderProductData = orderProduct.split(",");
		String[] ordershippinData = shippingUser.split(",");
		
		String id = orderUserData[0];
		String userName = orderUserData[1];
		String mobile = orderUserData[2];
		String address = orderUserData[3];
		String payType = orderUserData[4];
		String orderNumber = (id+"-"+orderUserData[5]);
		String impUid = (orderUserData[6]);
		String payCheck = "확인";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String writeDate = sdf.format(new Date());
	    
		String shippinName = "";
		String shippinAddress = "";
		String shippinMobile = "";
		String shippinMemo = "";
		
		String category = "";
		String company = "";
		String product = "";
		int pay = 0;
		int orderCount = 0;
		
		if(ordershippinData.length == 5) {
			shippinName = ordershippinData[0];//유저아이디
			shippinMobile = ordershippinData[1];//유저이름
			shippinAddress = ("("+ordershippinData[2]+")"+ordershippinData[3]+ordershippinData[4]);
		}
		
		if(ordershippinData.length == 6) {
			shippinName = ordershippinData[0];//유저이름
			shippinMobile = ordershippinData[1];//유저이름
			shippinAddress = ("("+ordershippinData[2]+")"+ordershippinData[3]+ordershippinData[4]);
			shippinMemo = ordershippinData[5];
		}
		
		if(orderProductData.length == 6){
			category = orderProductData[0];
			company = orderProductData[1];
			product = orderProductData[2];
			pay = Integer.parseInt(orderProductData[3]+orderProductData[4]);
			orderCount = Integer.parseInt(orderProductData[5]);
		}
		
		if(orderProductData.length == 7){
			category = orderProductData[0];
			company = orderProductData[1];
			product = orderProductData[2];
			pay = Integer.parseInt(orderProductData[3]+orderProductData[4]+orderProductData[5]);
			orderCount = Integer.parseInt(orderProductData[6]);
		}
		
		System.out.println("================주문자================");
		System.out.println("주문자 ID :"+id);
		System.out.println("주문자 이름 :"+userName);
		System.out.println("주문자 전화번호 :"+mobile);
		System.out.println("주문자 주소 :"+address);
		System.out.println("주문자 결재방법 :"+payType);
		System.out.println("주문자 결제상태 :"+payCheck);
		System.out.println("주문자 결재날짜 :"+writeDate);
		
		System.out.println("=================수령자===================");
		System.out.println("주문번호 :"+orderNumber);
		System.out.println("수령자 이름 :"+shippinName);
		System.out.println("수령자 전화번호 :"+shippinMobile);
		System.out.println("수령자 주소 :"+shippinAddress);
		System.out.println("수령자 메모 :"+shippinMemo);
		System.out.println("impUid :"+impUid);
		
		System.out.println("==================상품정보==================");
		System.out.println("상품분류 :"+category);
		System.out.println("판매자 :"+company);
		System.out.println("상품명 :"+product);
		System.out.println("상품가격 :"+pay);
		System.out.println("구매갯수 :"+orderCount);
		
		AShopDTO shopDto = new AShopDTO();
		shopDto.setId(id);
		shopDto.setUserName(userName);
		shopDto.setMobile(mobile);
		shopDto.setMobile(mobile);
		shopDto.setAddress(address);
		shopDto.setPayType(payType);
		shopDto.setPayCheck(payCheck);
		shopDto.setWriteDate(writeDate);
		shopDto.setShippinName(shippinName);
		shopDto.setShippinMobile(shippinMobile);
		shopDto.setShippinAddress(shippinAddress);
		shopDto.setShippinMemo(shippinMemo);
		shopDto.setCategory(category);
		shopDto.setCompany(company);
		shopDto.setProduct(product);
		shopDto.setPay(pay);
		shopDto.setOrderCount(orderCount);
		shopDto.setOrderNumber(orderNumber);
		shopDto.setImpUid(impUid);
		
		shopMapper.shopOrder(shopDto);
		AShopDTO shopOrderDto = shopMapper.shopOrderDate(writeDate);
		int no = shopOrderDto.getNo();
		shopDto.setNo(no);
		shopMapper.shippinData(shopDto);

	}
    
	public String getAccessToken() {
		String apiKey = "5740256785645581";
        String apiSecret = "CXm9Qe4HfB1x1C4HPUQWDtjjzyK7eVw1OcJEPE7RcoHEnUjiIMNFqXiKwXN8izN0y8j3KlVgLoJtNV3d";
        String apiUrl = "https://api.iamport.kr/users/getToken";
        String accessToken = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl);

        JSONObject requestParams = new JSONObject();
        requestParams.put("imp_key", apiKey);
        requestParams.put("imp_secret", apiSecret);
        
        try {
	        StringEntity entity = new StringEntity(requestParams.toString());
	        httpPost.setEntity(entity);
	        httpPost.setHeader("Content-Type", "application/json");
	
	        HttpResponse response = httpClient.execute(httpPost);
	
	        if (response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuilder responseContent = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                responseContent.append(line);
	            }
	            JSONObject responseData = new JSONObject(responseContent.toString());
	            accessToken = responseData.getJSONObject("response").getString("access_token");
	            System.out.println("토큰 값: " + accessToken);
	        } else {
	            System.out.println("요청 실패: " + response.getStatusLine().getStatusCode());
	        }
		} catch (Exception e) {
			
		}
        return accessToken;
    }

	public void getPayment(String id, String writeDate, String accessToken) {
		AShopDTO shopDto = shopMapper.getOrderData(id, writeDate);
        String impUid = shopDto.getImpUid().replace(" ", "_"); // 가져올 결제 거래의 아임포트 거래번호
        String orderNumber = shopDto.getOrderNumber(); // 가져올 결제 거래의 아임포트 거래번호
        int pay = shopDto.getPay(); // 가져올 결제 거래 가격
        String refundUrl = "https://api.iamport.kr/payments/cancel"; // 취소 요청 URL
        String cancelUrl = "https://api.iamport.kr/payments/cancel"; // 환불 요청 URL

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
	        // 환불 요청
	        JSONObject refundParams = new JSONObject();
	        refundParams.put("merchant_uid", orderNumber); // 환불할 결제 거래의 고유 ID
	        refundParams.put("amount", pay); // 환불할 금액
	        HttpPost refundPost = new HttpPost(refundUrl);
	        refundPost.setHeader("Authorization", accessToken);
	        refundPost.setEntity(new StringEntity(refundParams.toString(), "UTF-8"));
	        refundPost.setHeader("Content-Type", "application/json");
	        HttpResponse refundResponse = httpClient.execute(refundPost);
	        
	        // 취소 요청
	        JSONObject cancelParams = new JSONObject();
	        cancelParams.put("imp_uid", impUid); // 취소할 결제 거래의 고유 ID
	        HttpPost cancelPost = new HttpPost(cancelUrl);
	        cancelPost.setHeader("Authorization", accessToken);
	        cancelPost.setEntity(new StringEntity(cancelParams.toString(), "UTF-8"));
	        cancelPost.setHeader("Content-Type", "application/json");
	        HttpResponse cancelResponse = httpClient.execute(cancelPost);
	
	        // 처리 결과 확인
	        System.out.println("환불 성공: " + refundResponse.getStatusLine().getStatusCode());
	        System.out.println("취소 성공: " + cancelResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
			
		}
	}
}