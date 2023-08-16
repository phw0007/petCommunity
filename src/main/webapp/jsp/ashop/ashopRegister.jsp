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
			<li><a href="ashopRegister" style="font-weight: bold;">상품 등록</a></li>
			<li><a href="ashopDelete">등록상품 삭제</a></li>
			<li><a href="ashopOrder">주문 목록</a></li>
			<li><a href="ashopOrderDel">주문 취소</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>상품 등록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashopRegister">상품 등록</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<div class="ashopLeft">
				<p><img id="img" src="/image/pet.jpg" alt="petImage" width=180px height=240px/></p>
				<ul>
					<li><span>상품 이름</span><input type="text" id="name" value="성견용 사료"></li>
					<li><span>상품 분류</span>
						<select id="category" class="ashopOption">
							<option value="사료">사료</option>
							<option value="간식">간식</option>
							<option value="의류">의류</option>
							<option value="약품">약품</option>
							<option value="배변패드">배변패드</option>
							<option value="생활용품">생활용품</option>
						</select>
					</li>
					<li><span>판매 업체</span><input type="text" id="company" value="아투"></li>
					<li><span>상품 가격</span><input type="text" id="pay"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></li>
					<li><span>재고</span><input type="text" id="inventory" value="10"></li>
				</ul>
				<p><input type="file" id="fileImg" class="ashopFile" onchange="fileURL()" accept="image/*"/></p>
			</div>
			<div class="ashopRight">
				<p>상품 상제정보</p>
				<p><textarea class="infoUpdate" id="info">안녕하세요</textarea></p>
			</div>
			<input type="button" value="등록" class="ashopSelect" onclick="uploadImage()"/>
		</div>
	</div>
</div>
</body>
</html>