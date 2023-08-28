<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/reset.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="${contextRoot}css/aindex.css" type="text/css">
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
				<li>${member.id}<span>${member.registerDay}</span></li>
			</c:forEach>
		</ul>
	</div>
	<div class="main_rigth">
		<div class="board">
			<p>커뮤니티 관리<a href="aboard"><span style="width:70px; float: right;">더보기 ></span></a></p>
			<ul>
				<c:forEach var="board" items="${boards}" >
					<li><span>${board.category}</span><span style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 360px;">${board.title}</span>
					<span style="float: right; text-align: right;">${board.writeDate}</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="info">
			<p>업체정보 관리<a href="ainfo"><span style="width:70px; float: right;">더보기 ></span></a></p>
			<ul>
				<c:forEach var="info" items="${infos}">
					<li><span>${info.category}</span><span style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 360px;">${info.name}</span>
					<span style="float: right; text-align: right;">${info.mobile}</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="shop">
			<p>쇼핑몰 관리<a href="ashop"><span style="width:70px; float: right;">더보기 ></span></a></p>
			<ul>
				<c:forEach var="shop" items="${shops}">
					<li><span>${shop.category}</span><span style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 360px;">${shop.product}</span>
					<span style="float: right; text-align: right;">${shop.pay}</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="photo">
			<p>반려앨범 관리<a href="aphoto"><span style="width:70px; float: right;">더보기 ></span></a></p>
			<ul>
				<c:forEach var="photo" items="${photos}">
					<li><span>${photo.category }</span><span style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 360px;">${photo.title}</span>
					<span style="float: right; text-align: right;">${photo.writeDate}</span></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div> 
</body>
</html>