<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${contextRoot}css/amember.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<script src="${contextRoot}dbQuiz.js"></script>
<c:import url="/aheader" />
	<div class="member">
	<div class="memberItem">
		<h3>회원 관리</h3>
		<ul>
			<li><a href="amember">회원 목록</a></li>
			<li><a href="amemberDelete">회원 삭제</a></li>
			<li><a href="amemberMail"style="font-weight: bold;">메일 발송 설정</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>메일 발송 설정</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="amember">회원 관리</a></li>
				<li>></li>
				<li><a href="amemberMail">메일 발송 설정</a></li>
			</ul>
		</div>
		<div class="memberSend">
			<ul>
				<li><span>받는사람</span>
				<input type="text" class="emailUser" id="userEmail" value="${amemberEmail}"></li>
				<li><span>제목</span>
				<input type="text" id="emailTitle" class="emailTitle"></li>
				<li><span>파일첨부</span><input type="file" id="emailFile" class="emailFile" onchange="fileTitle()">
				<p><textarea id="fileTextarea"></textarea></p></li>
				<li><span>내용</span>
				<p><textarea id="emailContent"></textarea></p></li>
				<li><input type="button" value="전송" class="submitSend" onclick="sendEmail()"/></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>