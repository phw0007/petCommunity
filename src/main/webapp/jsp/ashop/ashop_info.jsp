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
<c:import url="/aheader" />
<div class="member">
	<div class="member_item">
		<h3>쇼핑몰 관리</h3>
		<ul>
			<li><a href="ashop" style="font-weight: bold;">상품 목록</a></li>
			<li><a href="ashop_register">상품 등록</a></li>
			<li><a href="ashop_delete">등록상품 삭제</a></li>
			<li><a href="ashop_order">주문 목록</a></li>
			<li><a href="ashop_order_del">주문 취소</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>상품 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashop">상품 목록</a></li>
			</ul>
		</div>
		<div class="member_info">
			<div class="ashop_left">
				<p><img src="/image/pet.jpg" alt="pet" width=180px height=240px/></p>
				<ul>
					<li><span>상품 이름</span>성견용 사료</li>
					<li><span>상품 분류</span>애견 사료</li>
					<li><span>판매 업체</span>아투</li>
					<li><span>상품 가격</span>43,000</li>
					<li><span>재고</span>10</li>
				</ul>
			</div>
			<div class="ashop_right">
				<p>상품 상제정보</p>
				<p><textarea class="text_info" readonly="readonly">안녕하세요</textarea></p>
			</div>
			<input type="button" value="확인" class="ashop_select" onclick="location.href='ashop'"/>
			<input type="button" value="수정" class="ashop_update" onclick="location.href='ashop_update'"/>
		</div>
	</div>
</div>
</body>
</html>