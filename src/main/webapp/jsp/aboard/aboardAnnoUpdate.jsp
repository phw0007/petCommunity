<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/aboard.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<c:import url="/header" />
	<div class="member">
	<div class="memberItem">
		<h3>커뮤니티 관리</h3>
		<ul>
			<li><a href="aboard" >게시글 목록</a></li>
			<li><a href="aboardDelete">게시글 삭제</a></li>
			<li><a href="aboardAnno" style="font-weight: bold;">공지사항 관리</a></li>
			<li><a href="aboardAnnoDel">공지사항 삭제</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>공지사항 관리</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="aboard">커뮤니티 관리</a></li>
				<li>></li>
				<li><a href="aboard">공지사항 관리</a></li>
			</ul>
		</div>
		<div class="memberViews">
			<ul>
				<li><span>제목</span><input type="text" value="안녕하세요" style="font-size: 22px; font-family: 'Poor Story';"></li>
				<li><span>작성일</span>2023-07-31</li>
				<li><span>작성자</span><input type="text" value="관리자" style="font-size: 22px; font-family: 'Poor Story';"></li>
				<li><span>내용</span><textarea style="font-size: 22px; font-family: 'Poor Story';"></textarea></li>
				<li>
					<input type="button" value="수정완료" class="selectEnd" onclick="location.href='aboardAnno'"
					style="float: right; margin-right:50px;"/>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>