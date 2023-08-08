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
	<div class="member_item">
		<h3>커뮤니티 관리</h3>
		<ul>
			<li><a href="aboard" style="font-weight: bold;">게시글 목록</a></li>
			<li><a href="aboard_delete">게시글 삭제</a></li>
			<li><a href="aboard_anno">공지사항 관리</a></li>
			<li><a href="aboard_anno_del">공지사항 삭제</a></li>
		</ul>
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>게시글 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="aboard">커뮤니티 관리</a></li>
				<li>></li>
				<li><a href="aboard">게시글 목록</a></li>
			</ul>
		</div>
		<div class="member_info">
		<c:choose>
			<c:when test="${empty boards }">
				<h1> 등록된 데이터가 존재하지 않습니다. </h1>
			</c:when>
			<c:otherwise>
				<table>
					<thead>
				    	<tr>
				    		<th>번호</th>
				    		<th>게시판 명</th>
				    		<th>게시글 제목</th>
				    		<th>작성자</th>
				    		<th>추천수</th>
				    		<th>조회수</th>
				    		<th>작성일</th>
				    	</tr>
				    </thead>
				    <tbody>
						<c:forEach var="board" items="${boards}">
							<tr onclick="location.href='aboard_views?id=${board.id}&boardName=${board.boardName}&no=${no+1}&currentPage=${currentPage }'">
								<td>${no=no+1}</td>
								<td>${board.boardName }</td>
								<td>${board.title }</td>
								<td>${board.id }</td>
								<td>${board.hits }</td>
								<td>${board.likes }</td>
								<td>${board.writeDate }</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="member_search">
			<div> ${result}	</div>
			<div class="select_search">
				<form action="aboard">
					<select name="select" class="select_option">
						<c:choose>
							<c:when test="${select == 'boardName'}">
								<option value="">전체</option>
								<option value="boardName" selected="selected">게시판명</option>
								<option value="title">제목</option>
								<option value="id">작성자</option>
							</c:when>
							<c:when test="${select == 'title'}">
								<option value="">전체</option>
								<option value="boardName">게시판명</option>
								<option value="title" selected="selected">제목</option>
								<option value="id">작성자</option>
							</c:when>
							<c:when test="${select == 'id'}">
								<option value="">전체</option>
								<option value="boardName">게시판명</option>
								<option value="title">제목</option>
								<option value="id" selected="selected">작성자</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
								<option value="boardName">게시판명</option>
								<option value="title">제목</option>
								<option value="id">작성자</option>
							</c:otherwise>
						</c:choose>
					</select>
					<input type="text" name="search" class="search_option" value="${search}"/>
					<input type="submit" value="검색" class="submit_option"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>