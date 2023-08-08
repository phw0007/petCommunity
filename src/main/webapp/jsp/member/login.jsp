<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<link rel="stylesheet" href="/css/login.css" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<script src="/dbQuiz.js"></script>
<div class=login align="center">
    <p><img src="/image/logo.png" alt="logo"></p>
	<h1>로그인</h1>
	<table ><tr><td> 
	<form action="loginProc" method="post" id="f">
		<input type="text" name="id" placeholder="아이디" id="id" style="width: 200px; height: 30px; padding-left:10px; font-family: 'Poor Story', cursive;"><br>
		<input type="password" name="pw" placeholder="비밀번호" id="pw" style="width: 200px; height: 30px; padding-left:10px; font-family: 'Poor Story', cursive;"><br>
		<input type="button" value="회원가입" onclick="location.href='register'" style="width: 80px; height: 30px; font-family: 'Poor Story', cursive;  cursor: pointer;">
		<input type="button" value="취소" onclick="location.href='index'" style="width: 80px; height: 30px; margin-left: 35px; font-family: 'Poor Story', cursive;  cursor: pointer;"><br>
		<input type="submit" value="로그인" onclick="loginCheck()" style="width:100px; height: 30px; margin-left:50px; font-family: 'Poor Story', cursive;  cursor: pointer;">
	</form>
	</table>
</div>

<c:import url="/footer" />











