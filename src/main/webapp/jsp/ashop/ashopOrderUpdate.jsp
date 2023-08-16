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
	<div class="memberItem">
		<h3>쇼핑몰 관리</h3>
		<ul>
			<li><a href="ashop">상품 목록</a></li>
			<li><a href="ashopRegister">상품 등록</a></li>
			<li><a href="ashopDelete">등록상품 삭제</a></li>
			<li><a href="ashopOrder" style="font-weight: bold;">주문 목록</a></li>
			<li><a href="ashopOrderDel">주문 취소</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>주문 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashopOrder">주문 목록</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<div class="infoTop">
				<table>
					<thead>
				    	<tr>
				    		<th>주문자명</th>
				    		<th>주소</th>
				    		<th>전화번호</th>
				    		<th>결재방식</th>
				    		<th>결재상태</th>
				    	</tr>
				    </thead>
				    <tbody>
				    	<tr>
				    		<td>관리자</td>
				    		<td><input type="text" value="서울특별시"></td>
				    		<td>010-1234-1234</td>
				    		<td>신용카드</td>
				    		<td>결재확인</td>
				    	</tr>
				</table>
			</div>
			<div class="infoBottom">
				<p>구매 항목</p>
				<table>
					<thead>
				    	<tr>
				    		<th>번호</th>
				    		<th>상품분류</th>
				    		<th>판매업체</th>
				    		<th>상품이름</th>
				    		<th>상품가격</th>
				    		<th>주문개수</th>
				    	</tr>
				    </thead>
				    <tbody>
				    	<tr>
				    		<td>1</td>
				    		<td>애견사료</td>
				    		<td>아투</td>
				    		<td>성견용 사료</td>
				    		<td>43,000</td>
				    		<td><input type="text" value="1"></td>
				    	</tr>
				</table>
			</div>
			<input type="button" value="수정완료" class="ashopUpdate" onclick="location.href=''"/>
		</div>
	</div>
</div>
</body>
</html>