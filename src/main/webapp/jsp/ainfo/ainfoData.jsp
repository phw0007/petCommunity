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
	<div class="memberItem">
		<h3>업체정보 관리</h3>
		<ul>
			<li><a href="ainfo" style="font-weight: bold;">업체 목록</a></li>
			<li><a href="ainfoDelete">업체정보 삭제</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>업체 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ainfo">업체정보 관리</a></li>
				<li>></li>
				<li><a href="ainfo">업체 목록</a></li>
			</ul>
		</div>
		<div class="ainfo">
			<ul>
				<li><span>업체명</span>동물병원</li>
				<li><span>주소</span>서울특별시</li>
				<li><span>업종</span>동물병원</li>
				<li><span>홈페이지</span>동물병원@naver.com</li>
				<li><span>비고</span>비고</li>
			</ul>
			<input type="button" value="확인" class="infoButton" onclick="location.href='ainfo'"/>
		</div>
	</div>
</div>
</body>
</html>


























