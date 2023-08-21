<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/board.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardModify</title>
</head>
<body>
 <div class="boardModify">
  <form action = "boardModifyProc" method = "post">
	<input type = "hidden" name = "no" value = "${board.no }">
     <div class="modifyContent">
	<h1>글 수정</h1>
	 <ul>
	   <li>제목<span><input style="width:500px; height:25px;" type="text" name="title" value="${board.title }" /></span></li>
	   <li>작성자<span> ${board.id }</span></li>
	   <li>작성일<span> ${board.writeDate }</span><span>조회수</span><span>${borad.hits}</span></li>
	   <li><textarea rows="10" cols="30" style="width:800px; font-size:15px;" name="content">${board.content }</textarea> </li>
	 </ul>
	  <div class="modifyB">
			<button class="Mlist" type="button" onclick="location.href='boardForm'">목록</button>
			<input class="modi" type="submit" value="수정">
			<button class="back" type="button" onclick="history.back()">이전</button> 
		</div>
	</div>
</form>
</div>
<c:import url = "/footer"/>
</body>
</html>