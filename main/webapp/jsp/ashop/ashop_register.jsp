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
<c:import url="/header" />
<div class="member">
	<div class="member_item">
		<h3>쇼핑몰 관리</h3>
		<ul>
			<li><a href="ashop">상품 목록</a></li>
			<li><a href="ashop_register" style="font-weight: bold;">상품 등록</a></li>
			<li><a href="ashop_delete">등록상품 삭제</a></li>
			<li><a href="ashop_order">주문 목록</a></li>
			<li><a href="ashop_order_del">주문 취소</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>상품 등록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashop_register">상품 등록</a></li>
			</ul>
		</div>
		<div class="member_info">
			<div class="ashop_left">
				<p><img id="img" src="/image/pet.jpg" alt="petImage" width=180px height=240px/></p>
				<ul>
					<li><span>상품 이름</span><input type="text" value="성견용 사료"></li>
					<li><span>상품 분류</span><input type="text" value="애견 사료"></li>
					<li><span>판매 업체</span><input type="text" value="아투"></li>
					<li><span>상품 가격</span><input type="text" value="43,000"></li>
					<li><span>재고</span><input type="text" value="10"></li>
				</ul>
				<p><input type="file" id="fileImg" class="ashopFile" onchange="fileURL()" accept="image/*"/></p>
			</div>
			<div class="ashop_right">
				<p>상품 상제정보</p>
				<p><textarea class="info_update">안녕하세요</textarea></p>
			</div>
			<input type="button" value="등록" class="ashop_select" onclick="uploadImage()"/>
		</div>
	</div>
</div>
</body>
</html>