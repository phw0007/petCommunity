<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/board.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>
<div class="boardForm">

	<h1>커뮤니티종류 ex)강아지,고양이,자유 ${board.category}</h1>
	<div class="boardCategory">
		<ul>
			<li><a href="location.href=''">자유게시판</a></li>
			<li><a href="location.href=''">Q&A</a></li>
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
				<th width="30">No.</th>
				<th width="500">제목</th>
				<th width="100">작성자</th>
				<th width="80">작성일</th>
				<th width="70">추천수</th>
				<th width="70">조회수</th>	
			</tr>
			<c:forEach var="board" items="${boards}">
				<tr>
					<td id="no">${board.no }</td>
					<td onclick="location.href='boardContent?num=${board.no}'">${board.title }</td>
					<td>${board.id }</td>
					<td>${board.writeDate }</td>
					<td>${board.hits }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=4>${result }</td>
			</tr>
		</table>
	<form>
		<button class="writeB" type="button"
			onclick="location.href='boardWrite'">글쓰기</button>
	</form>
	</div>

</div>


<c:import url = "/footer"/>
