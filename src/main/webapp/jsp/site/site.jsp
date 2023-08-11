<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/asite.css">
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
		<h3>사이트 관리</h3>
		<ul>
			<li><a href="site" style="font-weight: bold;">회사소개</a></li>
			<li><a href="site02">개인정보 처리 방침</a></li>
			<li><a href="site03">이용약관</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>회사소개</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="site">사이트 관리</a></li>
				<li>></li>
				<li><a href="site">회사소개</a></li>
			</ul>
		</div>
		<div class="member_info">
			<p><textarea class="site_info01" readonly="readonly">안녕하세요</textarea></p>
			<p><input type="button" value="수정" class="site_update_btn" onclick="location.href='site_update'"/></p>
		</div>
	</div>
</div>
</body>
</html>