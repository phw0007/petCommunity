
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<link rel="stylesheet" href="/css/delete.css" type="text/css">
<c:import url="/header" />


<div class="delete" align="center">
<h1>회원 탈퇴</h1>
<table>
	<tr><td>${msg }</td></tr>
	<tr><td>
	<form action="deleteProc" method="post">
		<input type="text" value="${sessionScope.id }" readonly="readonly" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"> <br>
		<input type="password" placeholder="비밀번호" name="pw" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"><br>
		<input type="password" placeholder="비밀번호 확인" name="confirmPw" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px; cursor: pointer;"><br>
		<input type="submit" value="회원 탈퇴" style="margin-left: 50px; margin-top: 30px; background-color: #FFEDA1; width:100px; height:30px; border: 1px solid #000000; cursor: pointer;"> 
		<input type="button" value="취소" onclick="location.href='index'" style="background-color: #FFEDA1; width:100px; height:30px; border: 1px solid #000000; cursor: pointer;">
	</form>
	</td></tr>
</table>
</div>

<c:import url="/footer" />








