<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/cart.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url="/header"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
</head>
<body>
<script type="text/javascript">
  function updatePrice(productId) {
    var productPriceSpan = document.getElementById("productPrice_" + productId);
    var pricePerUnit = parseFloat(productPriceSpan.getAttribute("data-price"));
    var quantity = parseInt(document.getElementById("quantity_" + productId).value);
    var totalPrice = pricePerUnit * quantity;
    productPriceSpan.textContent = totalPrice.toFixed(0);
    updateTotalPrice();
  }
  
  function updateTotalPrice() {
    var total = 0;
    var checkboxes = document.getElementsByName("selectedItems");
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            var productId = checkboxes[i].value;
            var itemTotalSpan = document.getElementById("productPrice_" + productId);
            total += parseFloat(itemTotalSpan.textContent);
        }
    }
    var totalSpan = document.getElementById("totalPrice");
    totalSpan.textContent = total.toFixed(0);
  }
</script>
<div class="cartIn" align="center">
    <h1>장바구니</h1>
    <form action="removeSelectedItems" method="post">
        <table>
            <tr>
                <th></th>
                <th>상품</th>
                <th>회사명</th>
                <th>상품명</th>
                <th>가격</th>
                <th>수량</th>
                <th>총 가격</th>
            </tr>
            <c:forEach var="item" items="${cartItems}">
            <tr>
                <td><input type="checkbox" name="selectedItems" value="${item.productId}" onchange="updateTotalPrice()"></td>
                <td><img src="${item.imageFile}" alt="pet" style="width:100px; height:100px;"/></td>
                <td>${item.company}</td>
                <td>${item.product}</td>
                <td>${item.pay}원</td>
                <td><label for="quantity_${item.productId}">수량:</label>
                    <input type="number" id="quantity_${item.productId}" name="quantity" value="1" min="1" max="" oninput="updatePrice(${item.productId})"><br></td>
                <td><span id="productPrice_${item.productId}" data-price="${item.pay}" data-total="${item.total}">${item.total}</span>원</td>
            </tr>
        </c:forEach>
    </table>
    
    <button type="submit" style="background-color: #FFEDA1; border:none; width:150px; height:30px; font-family: 'Poor Story', cursive; cursor: pointer; margin-top: 20px; margin-left: 1450px;">삭제</button>
     <div class="totalCoin">총 주문 금액: <span id="totalPrice">0</span>원</div>
</form>
    
    <form action="checkout" method="post" align="center">
        <button type="submit" style="background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer; margin-top: 50px;">구매하기</button>
    </form>
</div>
<c:import url="/footer"/>
</body>
</html>