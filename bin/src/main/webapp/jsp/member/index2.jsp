<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="dbQuiz.js"></script>
<link rel="stylesheet" href="${contextRoot}css/index2.css" type="text/css">
<style>
 @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index2</title>
</head>
<body>
	
	<c:import url="/header"/>
	<div class=index2 align="center">
	    <p><img src="/image/logo.png" alt="logo" style="width: 200px; height: 200px; margin-top: 100px;"></p>
	    사용자 아이디 : ${sessionScope.id }<br>
	    <form action="loginAfter">
	    <input type="button" value="마이페이지" onclick="location.href='userInfo?id=${sessionScope.id }'"><br>
	    <input type="button" value="사진첩" onclick="location.href='index2'"><br>
	    <input type="button" value="장바구니" onclick="location.href='index2'"><br>
	    
	    </form>
		<ul>
		<li><a href="${context }logout">로그아웃</a></li>
		</ul>
	</div>
	<c:import url="/footer"/>
</body>
</html>







