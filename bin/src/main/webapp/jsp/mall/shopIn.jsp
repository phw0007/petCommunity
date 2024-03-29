<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/shopIn.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url="/header"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<script type="text/javascript">
  function updatePrice() {
    var productPriceSpan = document.getElementById("productPrice");
    var pricePerUnit = parseFloat(productPriceSpan.getAttribute("data-price"));
    var quantity = parseInt(document.getElementById("quantity").value);
    var totalPrice = pricePerUnit * quantity;
    productPriceSpan.textContent = totalPrice.toFixed(0);
  }

  function addToCartAndRedirect() {
    var form = document.getElementById("addToCartForm");
    var quantity = form.querySelector("#quantity").value;

    // AJAX를 통해 서버로 요청을 보내고, 응답을 받아 리디렉션합니다.
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "addToCart", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
          // 요청 성공 시 리디렉션합니다.
          location.href = "cart"; // "cart.jsp" 페이지로 이동합니다.
        } else {
          // 요청 실패 시 처리 (예: 오류 메시지 표시 등)
        }
      }
    };

    // 요청 전송
    xhr.send("productId=" + encodeURIComponent(form.querySelector("[name=productId]").value) +
      "&quantity=" + encodeURIComponent(quantity));
  }
  
  function addToCart(productPrice, productId, quantity) {
       var xhr = new XMLHttpRequest();
       xhr.open("POST", "addToCart", true);
       xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
       xhr.onreadystatechange = function () {
           if (xhr.readyState === XMLHttpRequest.DONE) {
               if (xhr.status === 200) {
                   var result = xhr.responseText;
                   if (result === "success") {
                       var confirmMessage = "장바구니에 추가되었습니다. 장바구니화면으로 이동할까요?";
                       if (confirm(confirmMessage)) {
                           location.href = "cart";
                       } else {
                           // 취소 누를 경우 아무 동작 없음
                       }
                   } else if (result === "not_logged_in") {
                       alert("로그인 후 이용해주세요.");
                       location.href = "login"; // 로그인 페이지로 이동
                   } else {
                       alert("장바구니 추가에 실패하였습니다.");
                   }
               } else {
                   alert("장바구니 추가에 실패하였습니다.");
               }
           }
       };

       xhr.send("productId=" + encodeURIComponent(productId) +
                "&quantity=" + encodeURIComponent(quantity));
   }

  function addCart(pay) {
	 	var productPrice = pay;
	 	var productId = document.getElementById("productId").value;
	 	var quantity = document.getElementById("quantity").value;
		let selectedValues = [productPrice, productId, quantity];
		url="addToCart";
	    const form = document.createElement('form'); // form 태그 생성
	    form.setAttribute('method', 'post'); // 전송 방식 결정 (get or post)
	    form.setAttribute('action', url); // 전송할 url 지정
	    
	    const data = document.createElement('input'); // input 태그 생성
	    data.setAttribute('type', 'hidden'); // type = hidden
	    data.setAttribute('name', 'selectedValues'); // 데이터의 key
	   	data.setAttribute('value', selectedValues); // 데이터의 value (여기서는 data1)

	    form.appendChild(data);
	    document.body.appendChild(form);
	    form.submit();   
	}
</script>

<div class="product-details">
  <div class="shopInLeft">
    <img src="${product.imageFile}" alt="pet" style="border: 1px solid #000000; width:300px; height:400px;"/>
  </div>
  <div class="shopInRight">
    <h2>${product.company}</h2>
    <h3>${product.product}</h3>
    <form action="shopBuy" method="post" id="addToCartForm">
    	<p>가격: <span id="productPrice" data-price="${product.pay}">${product.pay}</span>원</p>
    	<input type="hidden" id="productId" name="productId" value="${product.no}">
    	<input type="hidden" name="productPrice"value="${product.pay}">
		<label for="quantity">수량:</label>
		<input type="number" id="quantity" name="quantity" value="1" min="1" oninput="updatePrice()"><br>
		<button type="button" onclick="addCart(${product.pay})" style="margin-top: 30px; background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer;">장바구니에 추가</button>
      <button type="submit" style="background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer;">구매하기</button>
    </form>
  </div>
</div>

<c:import url="/footer"/>
</body>
</html>