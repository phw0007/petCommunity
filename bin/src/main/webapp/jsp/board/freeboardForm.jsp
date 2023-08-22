<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/board.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>
<div class="boardForm">

	<h1>자유게시판</h1>
	<div class="boardCategory">
		<ul>
			<li><a href="location.href=''">공지사항</a></li>
			<li><a href="location.href='freeboardForm'">자유게시판</a></li>
			<li><a href="location.href='qnaoardForm'">Q&A</a></li>
			<li><a href="location.href=''">강아지</a></li>
			<li><a href="location.href=''">고양이</a></li>
			<li><a href="location.href=''">파충류</a></li>
			<li><a href="location.href=''">조류</a></li>
			<li><a href="location.href=''">수중생물</a></li>
			<li><a href="location.href=''">소동물</a></li>
			<li><a href="location.href=''">기타동물</a></li>
		</ul>
	</div>

	<div class="boardFormT">

		<table class="formTable">
			<tr>
				<th width="50">No.</th>
				<th width="400">제목</th>
				<th width="100">작성자</th>
				<th width="150">작성일</th>
				<th width="50">추천수</th>
				<th width="50">조회수</th>	
			</tr>
			<c:forEach var="freeboard" items="${freeboards}" varStatus="status">
		
				<tr>
					<td>${totalCount - ((currentPage-1) * 10 + status.index)}</td>
					<td onclick="location.href='boardContent?no=${freeboard.no}&category=${freeboard.category}&cp=${currentPage }'">${freeboard.title }</td>
					<td>${freeboard.id }</td>
					<td>${freeboard.writeDate }</td>
					<td>${freeboard.likes }</td>
					<td>${freeboard.hits }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="result">${result }</div>
		 <div class="searchBoard">
	   <form action="boardSearch">
		<!--  <select name="select" style="width:100px; height:30px;font-family:'Poor Story';">
			<option value="" >전체</option>
			<option value="id">아이디</option>
			<option value="title">제목</option>
		</select> <input type="text" name=search style="width:500px; height:30px;"> 
		<input type="submit" value="검색" style="width:100px; height:30px; font-family:'Poor Story';background:#fcd11e;">-->
					<select name="select" class="search">
						<c:choose>
							<c:when test="${select == 'title'}">
								<option value="">전체</option>
								<option value="title" selected="selected">제목</option>
								<option value="id">작성자</option>
							</c:when>
							<c:when test="${select == 'id'}">
								<option value="">전체</option>
								<option value="title">제목</option>
								<option value="id" selected="selected">작성자</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
								<option value="title">제목</option>
								<option value="id">작성자</option>
							</c:otherwise>
						</c:choose>
					</select>
					<input type="text" name="search" style="width:500px; height:30px;" value="${search}"> 
		<input type="submit" value="검색" style="width:100px; height:30px; font-family:'Poor Story';background:#fcd11e;">
	</form>
	</div>
	<form>
		<button class="writeB" type="button"
			onclick="location.href='boardWrite'">글쓰기</button>
	</form>
	
	</div>
	

</div>


<c:import url = "/footer"/>