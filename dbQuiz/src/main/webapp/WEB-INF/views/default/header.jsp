<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
	a {text-decoration: none; color:black;}
	ul {padding: 20px;}
	ul li {display: inline; padding: 15px;}
	.main_div{height: 150px; padding-top : 80px;}
</style>    

<script src="/dbQuiz/resources/dbQuiz.js"></script>
<!-- resources 안에 이미지 파일  등을 넣어서 활용 -->

<div align="center">
	<h1>CARE</h1>
</div>

<div align="right">
	<hr>
	<ul>
		<li><a href="${context }index">HOME</a></li>
		<li><a href="${context }register">Register</a></li>
		<li><a href="${context }login">Login</a></li>
		<li><a href="${context }memberInfo">MemberInfo</a></li>
		<li><a href="${context }logout">Logout</a></li>
		<li><a href="${context }boardForm">Board</a></li>
	</ul>
	<hr>
</div>