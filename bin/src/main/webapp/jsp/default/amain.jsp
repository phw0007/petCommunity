<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<link href="css/reset.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="/css/aindex.css" type="text/css">
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
	</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<div class="main">  
	<div class="main_left">
		<p>회원관리<a href="amember"><span>더보기 ></span></a></p>
		<ul>
			<c:forEach var="member" items="${members}">
				<li>${member.id }<span>${member.registerDay }</span></li>
			</c:forEach>
		</ul>
	</div>
	<div class="main_rigth">
		<div class="board">
			<p>커뮤니티 관리<a href="aboard"><span>더보기 ></span></a></p>
			<ul>
				<li>커뮤니티명&nbsp&nbsp게시글제목<span>작성날짜</span></li>
			</ul>
		</div>
		<div class="info">
			<p>업체정보 관리<a href="ainfo"><span>더보기 ></span></a></p>
			<ul>
				<li>업체 분류&nbsp&nbsp업체명<span>연락처</span></li>
			</ul>
		</div>
		<div class="shop">
			<p>쇼핑몰 관리<a href="ashop"><span>더보기 ></span></a></p>
			<ul>
				<li>제품분류&nbsp&nbsp제품명<span>등록일</span></li>
			</ul>
		</div>
		<div class="photo">
			<p>반려앨범 관리<a href="aphoto"><span>더보기 ></span></a></p>
			<ul>
				<li>작성자&nbsp&nbsp게시글제목<span>작성날짜</span></li>
			</ul>
		</div>
	</div>
</div> 
</body>
</html>