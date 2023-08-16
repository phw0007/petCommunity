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
			    	<tr>
			    		<td>1</td>
			    		<td>애견사료</td>
			    		<td>아투</td>
			    		<td>성견용 사료</td>
			    		<td>43,000</td>
			    		<td>10</td>
			    		<td><input type="checkbox" ></td>
			    	</tr>
			</table>
		</div>
		<div class="memberSearch">
			<a href=""><</a><a href="">1</a><a href="">></a>
			<div class="selectSearch">
				<form action="memberSelect">
					<select name="select" class="selectOption">
						<option value="">전체</option>
						<option value="id">상품분류</option>
						<option value="name">판매업체</option>
						<option value="address">상품명</option>
					</select>
					<input type="text" name="search" class="searchOption"/>
					<input type="submit" value="검색" class="submitOption"/>
					<input type="button" value="삭제" class="deleteOption" onclick="location.href='delete'"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>