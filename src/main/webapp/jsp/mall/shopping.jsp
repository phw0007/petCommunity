<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/mall.css" rel="stylesheet" type="text/css">
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

<div class="shopping" align="center">
 <h1>쇼핑몰</h1>
  <ul>
  	<li><a href="shopping" style="${shopping}">전체</a></li>
    <li>ㅣ</li>
    <li><a href="food" style="${food}">사료</a></li>
    <li>ㅣ</li>
    <li><a href="snack">간식</a></li>
    <li>ㅣ</li>
    <li><a href="cloths">의류</a></li>
    <li>ㅣ</li>
    <li><a href="medi">약품</a></li>
    <li>ㅣ</li>
    <li><a href="pad">배변패드</a></li>
    <li>ㅣ</li>
    <li><a href="living">생활용품</a></li>
  </ul>
  
  <div class="shoppingList">
    <ul> 
		<c:forEach var="shop" items="${shops}">
			<li onclick="location.href='#'">
				<p><img src="${shop.imageFile}" alt="pet" width=200px height=260px/></p>
				<span style="font-weight: bold;">${shop.company}</span>
				<span>${shop.product}</span>
				<span>${shop.shopPay}</span>
			</li>
		</c:forEach>
    </ul>
  </div>
 <div> ${result} </div>
  <div class="serch">
	<form action="shopping">
		<select name="select" class="selectOption" style="width:100px; font-family:'Poor Story'; margin-left: -150px;">
		<c:choose>
			<c:when test="${select == 'company'}">
				<option value="" >전체</option>
				<option value="company" selected="selected">회사명</option>
				<option value="product">상품명</option>
				<option value="pay">가격</option>
			</c:when>
			<c:when test="${select == 'product'}">
				<option value="" >전체</option>
				<option value="company">회사명</option>
				<option value="product" selected="selected">상품명</option>
				<option value="pay">가격</option>
			</c:when>
			<c:when test="${select == 'pay'}">
				<option value="" >전체</option>
				<option value="company">회사명</option>
				<option value="product">상품명</option>
				<option value="pay" selected="selected">가격</option>
			</c:when>
			<c:otherwise>
				<option value="">전체</option>
				<option value="company">회사명</option>
				<option value="product">상품명</option>
				<option value="pay">가격</option>
			</c:otherwise>
		</c:choose>
		</select> 
		<input type="text" name="search" value="${search}" class="searchOption" style="width:500px; "> 
		<input type="submit" value="검색" class="submitOption" style="width:100px; font-family:'Poor Story';background:#FFEDA1;">
	</form>
	</div>
</div>

<c:import url = "/footer"/>
</body>
</html>
