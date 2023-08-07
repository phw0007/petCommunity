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
<title>boardContent</title>
<script>
	function deleteCheck(){
		result = confirm('진짜로 삭제할거임? 진짜??');
		if (result == true){
			location.href='boardDeleteProc?num=${board.no}';
		}
	}
</script>
</head>
<body>

	<div class="boardContent">
	<h1>선택한 카테고리 (코드 예: board.category)</h1>
	 <ul>
	   <li>제목<span>제목들어갈 곳 ${board.title} </span></li>
	   <li>작성자<span>작성자 들어갈 곳 ${board.id }</span></li>
	   <li>작성일<span>작성일 들어갈 곳 ${board.writeDate }</span>조회수<span>조회수 들어갈 곳${borad.hits}</span></li>
	   <li>내용들어갈 곳${board.content} </li>
	   <li><button type="button" style="border:none; background:none;vertical-align:middle; width:70px; height:70px;cursor:pointer;"><img src="/image/made.png" alt="하트" style="width:70px; height:70px; ">추천수:</button></li>
	 </ul>
	  <div class="contentB">
			<button class="Clist" type="button" onclick="location.href='boardForm'">목록</button>
			<button class="Cmodify"type="button"
				onclick="location.href='boardModify?num=${board.no}'">수정</button>
			<button class="Cdelete" type="button" onclick="deleteCheck()">삭제</button>
		</div>
	  <div class="comment">
	  <h3>댓글</h3>
		<form action="commentProc" method="post"  >	
		<textarea rows="5" cols = "100" name = "comment" placeholder="댓글을 입력해주세요."></textarea>
		<button type="submit" style="background:#fcd11e;font-family: 'Poor Story', cursive; 
		width:50px;  height:25px;">등록</button>
		</form>	
       </div>
       
       <div class="commentView">
		<ul>
		  <li>댓글 들어갈 곳${comment.content } <span>작성자${comment.id}</span><b>날짜</b>
		     <button type="button" onclick="commentDelete()">삭제</button>
		  </li>
		</ul>
		</div>
	</div>


<c:import url = "/footer"/>
</body>
</html>
