<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/aphoto.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<c:import url="/aheader" />
<div class="member">
	<div class="member_item">
		<h3>반려앨범 관리</h3>
		<ul>
			<li><a href="aphoto" style="font-weight: bold;">게시글 목록</a></li>
			<li><a href="aphoto_delete">게시글 삭제</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>게시글 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="aphoto">반려앨범 관리</a></li>
				<li>></li>
				<li><a href="aphoto">게시글 목록</a></li>
			</ul>
		</div>
		<div class="member_info">
			<table>
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>분류</th>
			    		<th>게시글 제목</th>
			    		<th>작성자</th>
			    		<th>추천수</th>
			    		<th>조회수</th>
			    		<th>작성일</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<tr onclick="location.href='aphoto_views'">
			    		<td>1</td>
			    		<td>강아지</td>
			    		<td>안녕하세요</td>
			    		<td>관리자</td>
			    		<td>0</td>
			    		<td>0</td>
			    		<td>2023-07-26</td>
			    	</tr>
			</table>
		</div>
		<div class="member_search">
			<a href=""><</a><a href="">1</a><a href="">></a>
			<div class="select_search">
				<form action="memberSelect">
					<select name="select" class="select_option">
						<option value="">전체</option>
						<option value="id">아이디</option>
						<option value="name">사용자명</option>
						<option value="address">주소</option>
						<option value="mobile">전화번호</option>
					</select>
					<input type="text" name="search" class="search_option"/>
					<input type="submit" value="검색" class="submit_option"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>