<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url = "/header"/>
<link href="${contextRoot}css/board.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<script src="${contextRoot}dbQuiz.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardWrite</title>
<script>

function checkContentLength(textarea) {
	const maxLength = 600;
	if (textarea.value.length > maxLength) {
		alert('내용은 600자 이내로 입력해주세요.');
		textarea.value = textarea.value.substring(0, maxLength);
	}
}
</script>
</head>
<body>
	<div class="boardWrite">
		<h1>글쓰기</h1>
		<form action = "boardWriteProc" method = "post" enctype="multipart/form-data">
		<select id="category" name="category" size="1" style="width:250px; height:30px;">
			<option value="">카테고리</option>
			<option value="자유게시판">자유게시판</option>
			<option value="QnA">Q&A</option>
			<option value="강아지">강아지</option>
			<option value="고양이">고양이</option>
			<option value="파충류">파충류</option>
			<option value="조류">조류</option>
			<option value="수중생물">수중생물</option>
			<option value="소동물">소동물</option>
			<option value="기타동물">기타동물</option>
		</select><br><br>
		<input type="text" name="title" placeholder="제목을 입력해주세요." id="title" style="width: 800px; height: 30px;"><br><br>
	    <textarea class="contentWrite" rows="20" cols="130" oninput="checkContentLength(this)"  name="content" placeholder="내용을 입력해주세요(600자이내)."></textarea><br><br>
	      파일 첨부 :
          
     
        <input type="file" id="fileImg" class="ashopFile" name="upfile" onchange="fileURL()" accept="image/*"/>
       <br><br>
       <!--  <input type="button" value="등록" class="ashop_select" onclick="uploadImage2()"/>-->
         <div class="button">
			<input class="write" type = "submit" value = "글 등록하기">
			<input class="list" type = "button" value = "목록" onclick="location.href = 'freeboardForm'">
			</div>
		</form>
	</div>

<c:import url = "/footer"/>
</body>

</html>



