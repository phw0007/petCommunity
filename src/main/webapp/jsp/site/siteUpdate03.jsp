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
	<div class="memberItem">
		<h3>사이트 관리</h3>
		<ul>
			<li><a href="site">회사소개</a></li>
			<li><a href="site02" >개인정보 처리 방침</a></li>
			<li><a href="site03" style="font-weight: bold;">이용약관</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>회사소개</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="site">사이트 관리</a></li>
				<li>></li>
				<li><a href="site03">이용약관</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<form action="siteUpdateProc3" method="post">
				<p><textarea class="siteInfo01" name="content" style="border:1px solid #000;">${siteInfo}</textarea></p>
				<p><input type="button" value="취소" class="siteUpdateBtn" onclick="history.back()" style="margin-left:20px; margin-right:20px;"/></p>
				<p><input type="submit" value="수정완료" class="siteUpdateBtn"/></p>
			</form>
		</div>
	</div>
</div>
</body>
</html>