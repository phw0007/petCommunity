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
  
  function addCart(pay,inventory) {
      var productPrice = pay;
      var productId = document.getElementById("productId").value;
      var quantity = document.getElementById("quantity").value;
     let selectedValues = [inventory,productPrice,productId,quantity];
     url="addCart";
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
      <input type="number" id="quantity" name="quantity" value="1" min="1" max="${product.inventory }" oninput="updatePrice()"><br>
      <button type="button" onclick="addCart(${product.pay},${product.inventory })" style="margin-top: 30px; background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer;">장바구니에 추가</button>
      <button type="submit" style="background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer; margin-top: 20px;">구매하기</button>
    </form>
  </div>
</div>

<c:import url="/footer"/>
</body>
</html>