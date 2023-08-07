<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url = "/header"/>
 	<link rel="stylesheet" href="css/home.css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardWrite</title>
</head>
<body>
	<div class="boardContent">
		<h1>카테고리</h1>
		<p><span>제목</span>제목1</p>
		<p><span>작성자</span>작성자1</p>
		<p><span>작성일</span>2023-008-01</p>
		
		<div class="seeboard">
			사진
			
			글
			
			
		</div>
		<br>
		<br>
		<div class="btnbg">
			<ul>
				<li></li>
			</ul>
		</div>
		<br>
		
		<br>
		<form action = "boardWriteProc" method = "post" enctype="multipart/form-data" style="margin-left: 150px">
		<div style="display: flex; align-items: center;">
	    <textarea rows="5" cols="130" name="content" placeholder="내용을 입력해주세요."></textarea>
         <div class="button">
			<input type = "submit" value = "댓글 등록하기" style="font-size:15px;
			 width:130px; height:50px;background:#fcd11e;  font-family: 'Poor Story'">
			</div>
			</div>
		</form>
		<br>
		<br>
		
	</div>


</body>
</html>
<c:import url="/footer" />