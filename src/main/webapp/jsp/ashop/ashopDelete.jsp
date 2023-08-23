<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/ashop.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<script src="/dbQuiz.js"></script>
<c:import url="/aheader" />
<div class="member">
	<div class="memberItem">
		<h3>쇼핑몰 관리</h3>
		<ul>
			<li><a href="ashop">상품 목록</a></li>
			<li><a href="ashopRegister">상품 등록</a></li>
			<li><a href="ashopDelete" style="font-weight: bold;">등록상품 삭제</a></li>
			<li><a href="ashopOrder">주문 목록</a></li>
			<li><a href="ashopOrderDel">주문 취소</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>등록상품 삭제</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashopDelete">등록상품 삭제</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<table>
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>상품분류</th>
			    		<th>판매업체</th>
			    		<th>상품명</th>
			    		<th>상품가격</th>
			    		<th>재고</th>
			    		<th>선택</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="shop" items="${shops}">
						<tr>
							<td>${no=no+1}</td>
							<td>${shop.category }</td>
							<td>${shop.company }</td>
							<td>${shop.product }</td>
							<td>${shop.shopPay }</td>
							<td>${shop.inventory }</td>
							<td><input type="checkbox" class="member-checkbox" value="${shop.product},${shop.category},${shop.no}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="memberSearch">
			<div> ${result}	</div>
			<div class="selectSearch">
				<form action="ashopDelete">
					<select name="select" class="selectOption">
						<c:choose>
							<c:when test="${select == 'category'}">
								<option value="">전체</option>
								<option value="category" selected="selected">상품분류</option>
								<option value="company">판매업체</option>
								<option value="product">상품명</option>
							</c:when>
							<c:when test="${select == 'company'}">
								<option value="">전체</option>
								<option value="category">상품분류</option>
								<option value="company" selected="selected">판매업체</option>
								<option value="product">상품명</option>
							</c:when>
							<c:when test="${select == 'product'}">
								<option value="">전체</option>
								<option value="category">상품분류</option>
								<option value="company">판매업체</option>
								<option value="product" selected="selected">상품명</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
								<option value="category">상품분류</option>
								<option value="company">판매업체</option>
								<option value="product">상품명</option>
							</c:otherwise>
						</c:choose>
					</select>
					<input type="text" name="search" class="searchOption" value="${search}"/>
					<input type="submit" value="검색" class="submitOption"/>
					<input type="button" value="삭제" class="deleteOption" onclick="getShopDeleteCheckBoxes()"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>