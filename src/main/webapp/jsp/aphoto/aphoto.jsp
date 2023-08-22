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
	<div class="memberItem">
		<h3>반려앨범 관리</h3>
		<ul>
			<li><a href="aphoto" style="font-weight: bold;">게시글 목록</a></li>
			<li><a href="aphotoDelete">게시글 삭제</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>게시글 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="aphoto">반려앨범 관리</a></li>
				<li>></li>
				<li><a href="aphoto">게시글 목록</a></li>
			</ul>
		</div>
		<div class="memberInfo">
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
			    	<c:forEach var="photo" items="${photos}">
						<tr onclick="location.href='aphotoViews?id=${photo.id}&category=${photo.category}&no=${photo.no}&currentPage=${currentPage}'">
							<td>${no=no+1}</td>
							<td>${photo.category }</td>
							<td>${photo.title }</td>
							<td>${photo.id }</td>
							<td>${photo.likes }</td>
							<td>${photo.hits }</td>
							<td>${photo.writeDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="memberSearch">
			<div> ${result}	</div>
			<div class="selectSearch">
				<form action="aboard">
					<select name="select" class="selectOption">
						<c:choose>
							<c:when test="${select == 'category'}">
								<option value="">전체</option>
								<option value="category" selected="selected">게시판명</option>
								<option value="title">제목</option>
								<option value="id">작성자</option>
							</c:when>
							<c:when test="${select == 'title'}">
								<option value="">전체</option>
								<option value="category">게시판명</option>
								<option value="title" selected="selected">제목</option>
								<option value="id">작성자</option>
							</c:when>
							<c:when test="${select == 'id'}">
								<option value="">전체</option>
								<option value="category">게시판명</option>
								<option value="title">제목</option>
								<option value="id" selected="selected">작성자</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
								<option value="category">게시판명</option>
								<option value="title">제목</option>
								<option value="id">작성자</option>
							</c:otherwise>
						</c:choose>
					</select>
					<input type="text" name="search" class="searchOption" value="${search}"/>
					<input type="submit" value="검색" class="submitOption"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>