<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<link rel="stylesheet" href="/css/login.css" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>

<div class=login align="center">
    <p><img src="/image/logo.png" alt="logo"></p>
	<h1>로그인</h1>
	<table ><tr><td>
	<form action="loginProc" method="post" id="f">
		<input type="text" name="id" placeholder="아이디" id="id" style="width: 200px; height: 30px; padding-left:10px; font-family: 'Poor Story', cursive;"><br>
		<input type="password" name="pw" placeholder="비밀번호" id="pw" style="width: 200px; height: 30px; padding-left:10px; font-family: 'Poor Story', cursive;"><br>
		<input type="button" value="회원가입" onclick="location.href='register.jsp'" style="width: 80px; height: 30px; font-family: 'Poor Story', cursive;">
		<input type="button" value="취소" onclick="location.href='index.jsp'" style="width: 80px; height: 30px; margin-left: 35px; font-family: 'Poor Story', cursive;"><br>
		<input type="button" value="로그인" onclick="loginCheck()" style="width:100px; height: 30px; margin-left:50px; font-family: 'Poor Story', cursive;">
	</form>
	</td></tr>
	<!-- 
		# 카카오 이미지 URL #
		https://developers.kakao.com/tool/demo/login/login?method=dynamic
		
		# 인가 코드 요청 #
		https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-code-request
	 -->
	<tr><td>
		<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&
		client_id=af3185dbf0396a5bf08b67e29a79b429&
		redirect_uri=http://localhost:8086/dbQuiz/kakaoLogin">
			<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" />
		</a>
	</td></tr>
	</table>
</div>

<c:import url="/footer" />










