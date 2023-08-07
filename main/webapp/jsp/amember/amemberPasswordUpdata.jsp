<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/amember.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<c:import url="/header" />
<div class="member">
	<div class="memberItem">
		<h3>회원 관리</h3>
		<ul>
			<li><a href="amember" style="font-weight: bold;">회원 목록</a></li>
			<li><a href="amemberDelete">회원 삭제</a></li>
			<li><a href="amemberMail">메일 발송 설정</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>회원목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="amember">회원 관리</a></li>
				<li>></li>
				<li><a href="amember">회원 목록</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<form action="passwordUpdata">
				<p><span>유저명 : </span><input type="text" name="id" value="${id}" class="idOption" readonly="readonly"/></p>
				<p><span>새 비밀번호 : </span><input type="text" name="newPassword" class="passwordOption"/></p>
				<input type="submit" value="확인" class="selectEnd"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>