
photo
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url = "/header"/>
 	<link rel="stylesheet" href="css/home.css">
 	 <link href="css/reset.css" rel="stylesheet" type="text/css">
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
	<div class="photoContent">
		<h1>${photo.category} </h1>
		<p><span>제목</span>${photo.title} </p> 
		<p><span>작성자</span>${photo.id}</p>
		<p><span>작성일</span>${photo.writeDate}</p>
		
		<div class="seephoto">
			<img alt="/image/${photo.fileName}" src=/image/${photo.fileName} width="800" height="1000" style="margin-bottom: 30px; margin-left: 10px; ">
			
			<p class="poContent">${photo.content}</p>
			
			
		</div>
		<br>
		<br>
		<div class="btnbg"> <!--아이콘 버튼 클릭 -->
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
