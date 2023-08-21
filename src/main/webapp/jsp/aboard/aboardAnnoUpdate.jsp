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
<c:import url="/aheader" />
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
			<form class="annoUpdate" action="aboardAnnoUpdateProc">
				<ul>
					<li><span>제목</span><input type="text" id="title" name="title" value="${title }" style="font-size: 22px; font-family: 'Poor Story';"></li>
					<li><span>작성일</span>${writeDate}</li>
					<li><span>작성자</span><input type="text" value="${id }" id="id" name="id" style="font-size: 22px; font-family: 'Poor Story';" readonly="readonly"></li>
					<li style="float: none;"><span style="float: left;">내용</span>
						<div class="AnnoContent">
							<textarea name="text" id="text">${content }</textarea>
						</div>
					</li>
					<li>
						<input type="submit" value="수정완료" class="selectEnd" style="float: right; margin-right:60px;"/>
						<input type="hidden" name="no" id="no" value="${no}">
					</li>
				</ul>
			</form>
		</div>
	</div>
</div>
</body>
</html>