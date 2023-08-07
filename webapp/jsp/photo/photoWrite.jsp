<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/dbQuiz.js"></script>
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
	<div class="boardWrite">
		<h1>글쓰기</h1>
		<form action = "photoWriteProc" method = "post" enctype="multipart/form-data">
		<select id="category" name="category" size="1" style="width:250px; height:30px;">
			<option value="">카테고리</option>
			<option value="자유게시판">자유게시판</option>
			<option value="Q&A">Q&A</option>
			<option value="강아지">강아지</option>
			<option value="고양이">고양이</option>
			<option value="파충류">파충류</option>
			<option value="조류">조류</option>
			<option value="수중생물">수중생물</option>
			<option value="소동물">소동물</option>
			<option value="기타동물">기타동물</option>
		</select><br><br>
		<input type="text" name="title" placeholder="제목을 입력해주세요." id="title" style="width: 400px; height: 30px;"><br><br>
	    <textarea rows="20" cols="130" name="content" placeholder="내용을 입력해주세요."></textarea><br><br>
        파일첨부   <input type = "file" multiple="multiple" value = "파일 선택" name = "upfile"><br><br>
       
         <div class="button">
			<input type = "submit" value = "글 등록하기" style="font-size:15px; width:100px; height:30px;background:#fcd11e;  font-family: 'Poor Story'">
			<input type = "button" value = "목록"style="font-size:15px; width:100px; height:30px;background:#fcd11e;  font-family: 'Poor Story'" onclick="location.href = 'boardForm'">
			</div>
		</form>
	</div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

</body>
</html>
<c:import url="/footer" />