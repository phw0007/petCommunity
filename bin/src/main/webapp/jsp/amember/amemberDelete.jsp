<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/amember.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<script src="/dbQuiz.js"></script>
<c:import url="/aheader" />
<div class="member">
	<div class="memberItem">
		<h3>회원 관리</h3>
		<ul>
			<li><a href="amember">회원 목록</a></li>
			<li><a href="amemberDelete" style="font-weight: bold;">회원 삭제</a></li>
			<li><a href="amemberMail">메일 발송 설정</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>회원삭제</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="amember">회원 관리</a></li>
				<li>></li>
				<li><a href="amemberDelete">회원 삭제</a></li>
			</ul>
		</div>
		<div class="memberInfo">
		<c:choose>
			<c:when test="${empty members }">
				<h1> 등록된 데이터가 존재하지 않습니다. </h1>
			</c:when>
			<c:otherwise>
			<table>
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>아이디</th>
			    		<th>사용자명</th>
			    		<th>이메일</th>
			    		<th>주소</th>
			    		<th>전화번호</th>
			    		<th>가입일</th>
			    		<th>선택</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="member" items="${members}">
						<tr>
							<td>${no=no+1 }</td>
							<td>${member.id }</td>
							<td>${member.userName }</td>
							<td>${member.email }</td>
							<td>${member.address }</td>
							<td>${member.mobile }</td>
							<td>${member.registerDay }</td>
							<td><input type="checkbox" class="member-checkbox" value="${member.id }"></td>
						</tr>
					</c:forEach>
			</table>
			</c:otherwise>
		</c:choose>
		</div>
		<div class="memberSearch">
			<div> ${result}	</div>
			<div class="selectSearch">
				<form action="amemberDelete">
					<select name="select" class="selectOption">
						<c:choose>
							<c:when test="${select == 'id'}">
								<option value="">전체</option>
								<option value="id" selected="selected">아이디</option>
								<option value="name">사용자명</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'name'}">
								<option value="">전체</option>
								<option value="id">아이디</option>
								<option value="name" selected="selected">사용자명</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'address'}">
								<option value="">전체</option>
								<option value="id">아이디</option>
								<option value="name">사용자명</option>
								<option value="address" selected="selected">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'mobile'}">
								<option value="">전체</option>
								<option value="id">아이디</option>
								<option value="name">사용자명</option>
								<option value="address">주소</option>
								<option value="mobile" selected="selected">전화번호</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
								<option value="id">아이디</option>
								<option value="name">사용자명</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
							</c:otherwise>
						</c:choose>
					</select>
					<input type="text" name="search" class="searchOption" value="${search}"/>
					<input type="submit" value="검색" class="submitOption"/>
					<input type="button" value="삭제" class="deleteOption" onclick="getSelectedDeleteCheckboxes()"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>