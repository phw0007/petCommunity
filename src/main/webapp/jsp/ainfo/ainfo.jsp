<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/ainfo.css">
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
		<h3>업체정보 관리</h3>
		<ul>
			<li><a href="ainfo" style="font-weight: bold;">업체 목록</a></li>
			<li><a href="ainfoRegister">업체정보 등록</a></li>
			<li><a href="ainfoDelete">업체정보 삭제</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>업체 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ainfo">업체정보 관리</a></li>
				<li>></li>
				<li><a href="ainfo">업체 목록</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<table>
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>업체 분류</th>
			    		<th>업체 이름</th>
			    		<th>업체 이메일</th>
			    		<th>주소</th>
			    		<th>전화번호</th>
			    	</tr>
			    </thead>
			    <tbody>
				<c:forEach var="info" items="${infos}">
					<tr onclick="location.href=''">
						<td>${no=no+1}</td>
						<td>${info.category }</td>
						<td>${info.name }</td>
						<td>${info.email }</td>
						<td>${info.address }</td>
						<td>${info.mobile }</td>
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
								<option value="name">업체 이름</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'name'}">
								<option value="">전체</option>
								<option value="category">게시판명</option>
								<option value="name" selected="selected">업체 이름</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'address'}">
								<option value="">전체</option>
								<option value="category">게시판명</option>
								<option value="name">업체 이름</option>
								<option value="address" selected="selected">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'mobile'}">
								<option value="">전체</option>
								<option value="category">게시판명</option>
								<option value="name">업체 이름</option>
								<option value="address">주소</option>
								<option value="mobile" selected="selected">전화번호</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
								<option value="category">게시판명</option>
								<option value="name">업체 이름</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
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