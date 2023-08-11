<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/ainfo.css">
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
		<h3>업체정보 관리</h3>
		<ul>
			<li><a href="ainfo" >업체 목록</a></li>
			<li><a href="ainfo_register">업체정보 등록</a></li>
			<li><a href="ainfo_delete" style="font-weight: bold;">업체정보 삭제</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>업체정보 삭제</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ainfo">업체정보 관리</a></li>
				<li>></li>
				<li><a href="ainfo_delete">업체정보 삭제</a></li>
			</ul>
		</div>
		<div class="member_info">
			<table>
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>업체 분류</th>
			    		<th>업체 이름</th>
			    		<th>업체 이메일</th>
			    		<th>주소</th>
			    		<th>전화번호</th>
			    		<th>선택</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<tr>
			    		<td>1</td>
			    		<td>동물병원</td>
			    		<td>동물병원</td>
			    		<td>1234@naver.com</td>
			    		<td>서울특별시</td>
			    		<td>010-1234-1234</td>
			    		<td><input type="checkbox" ></td>
			    	</tr>
			</table>
		</div>
		<div class="member_search">
			<a href=""><</a><a href="">1</a><a href="">></a>
			<div class="select_search">
				<form action="memberSelect">
					<select name="select" class="select_option">
						<option value="">전체</option>
						<option value="id">업체 분류</option>
						<option value="name">업체 이름</option>
						<option value="address">주소</option>
						<option value="mobile">전화번호</option>
					</select>
					<input type="text" name="search" class="search_option"/>
					<input type="submit" value="검색" class="submit_option"/>
					<input type="button" value="삭제" class="delete_option" onclick="location.href='delete'"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>


























