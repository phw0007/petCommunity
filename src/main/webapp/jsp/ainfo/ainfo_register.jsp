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
<c:import url="/header" />
<div class="member">
	<div class="member_item">
		<h3>업체정보 관리</h3>
		<ul>
			<li><a href="ainfo" >업체 목록</a></li>
			<li><a href="ainfo_register" style="font-weight: bold;">업체정보 등록</a></li>
			<li><a href="ainfo_delete">업체정보 삭제</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>업체정보 등록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ainfo">업체정보 관리</a></li>
				<li>></li>
				<li><a href="ainfo_register">업체정보 등록</a></li>
			</ul>
		</div>
		<div class="ainfo">
			<ul>
				<li><span>업체명</span><input type="text" class="info_name"></li>
				<li><span>주소</span><input type="text" class="info_address"></li>
				<li>
					<span>업종</span>
					<select name="select" class="ainfo_option">
						<option value="hospital">동물병원</option>
						<option value="store">반려용품</option>
						<option value="acco">펜션/숙소</option>
						<option value="cafe">카페</option>
						<option value="diner">식당</option>
					</select>
				</li>
				<li><span>홈페이지</span><input type="text" class="info_page"></li>
				<li><span>비고</span><input type="text" class="info_note"></li>
			</ul>
			<input type="button" value="등록" class="info_button" onclick="location.href='ainfo'"/>
		</div>
	</div>
</div>
</body>
</html>


























