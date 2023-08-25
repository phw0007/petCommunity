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
    <div class="cartIn" align="center">
    <h1>장바구니</h1>
    
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
            <td><input type="checkbox" name="selectedItems" value="${item.productId}"></td>
            <td><img src="${item.imageFile}" alt="pet" style="width:100px; height:100px;"/></td>
            <td>${item.company}</td>
            <td>${item.product}</td>
            <td>${item.pay}원</td>
            <td>${item.quantity}개</td>
            <td>${item.total}원</td>
        </tr>
    </c:forEach>
    </table>
    </div>
    
    <form action="checkout" method="post" align="center">
        <button type="submit" style="background-color: #FFEDA1; border:none; width:400px; height:40px; font-family: 'Poor Story', cursive; cursor: pointer; margin-top: 50px;">구매하기</button>
    </form>
    
    <c:import url="/footer"/>
</body>
</html>