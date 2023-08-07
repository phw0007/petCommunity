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
<c:import url="/header" />
<div class="member">
	<div class="member_item">
		<h3>쇼핑몰 관리</h3>
		<ul>
			<li><a href="ashop">상품 목록</a></li>
			<li><a href="ashop_register">상품 등록</a></li>
			<li><a href="ashop_delete">등록상품 삭제</a></li>
			<li><a href="ashop_order" style="font-weight: bold;">주문 목록</a></li>
			<li><a href="ashop_order_del">주문 취소</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>주문 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashop_order">주문 목록</a></li>
			</ul>
		</div>
		<div class="member_info">
			<table>
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>구매회원</th>
			    		<th>상품이름</th>
			    		<th>주소</th>
			    		<th>전화번호</th>
			    		<th>상품 가격</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<tr onclick="location.href='ashop_order_info'">
			    		<td>1</td>
			    		<td>관리자</td>
			    		<td>성견용 사료</td>
			    		<td>서울특별시</td>
			    		<td>010-1234-1234</td>
			    		<td>43,000</td>
			    	</tr>
			</table>
		</div>
		<div class="member_search">
			<a href=""><</a><a href="">1</a><a href="">></a>
			<div class="select_search">
				<form action="memberSelect">
					<select name="select" class="select_option">
						<option value="">전체</option>
						<option value="id">구매회원</option>
						<option value="name">상품이름</option>
						<option value="address">주소</option>
					</select>
					<input type="text" name="search" class="search_option"/>
					<input type="submit" value="검색" class="submit_option"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>