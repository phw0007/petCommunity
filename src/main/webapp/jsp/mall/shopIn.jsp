<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/shopIn.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
var IMP = window.IMP;
IMP.init("imp07740386");

function requestPay() {
  IMP.request_pay(
    {
      pg: "html5_inicis.INIBillTst",
      pay_method: "card",
      merchant_uid: "6210-0383-0332-3318",
      name: "당근 10kg",
      amount: 1004,
      buyer_email: "Iamport@chai.finance",
      buyer_name: "포트원 기술지원팀",
      buyer_tel: "010-1234-5678",
      buyer_addr: "서울특별시 강남구 삼성동",
      buyer_postcode: "123-456",
    },
    function (rsp) {
      // callback
      //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
    }
  );
}
</script>

   <div class="product-details">
       
        <div class="shopInLeft">
            <img src="${product.imageFile}" alt="pet"  style="border: 1px solid #000000; width:300px; height:400px;"/>
        </div>
        
        <div class="shopInRight">
            <h2>${product.company}</h2>
            <h3>${product.product}</h3>
            <p>가격: ${product.pay}</p>
            
        <!-- 수량 선택 필드와 장바구니 추가 버튼 -->
        <form action="addToCart" method="post" >
            <input type="hidden" name="productId" value="${product.no}">
            <label for="quantity" >수량:</label>
            <input type="number" id="quantity" name="quantity" value="1" min="1" ><br>
            <button type="submit" style="margin-top: 30px; background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer;">장바구니에 추가</button>
        </form>
        <form action="addToBuy" method="post">
            <button type="submit" style="background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer;"></button>
            <button type="button" onclick="requestPay()" style="background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer;">구매하기</button>
        </form>
        </div>
    </div>

<c:import url = "/footer"/>
</body>
</html>