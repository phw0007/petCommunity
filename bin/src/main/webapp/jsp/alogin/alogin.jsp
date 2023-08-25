<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/alogin.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<c:import url="/aheader"/>
<div class="member">
	<ul>
		<li><img src="/image/logo.png" alt="logo" width=300px height=300px/></li>
		<li>admin</li>
		<li><a href="aloginOut">로그아웃</a></li>
	</ul>
</div>
</body>
</html>