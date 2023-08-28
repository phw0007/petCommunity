<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${contextRoot}css/ainfo.css">
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
			<li><a href="ainfoDelete">업체정보 삭제</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>업체정보 수정</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ainfo">업체정보 관리</a></li>
				<li>></li>
				<li><a href="ainfo">업체 목록</a></li>
			</ul>
		</div>
		<div class="ainfo">
			<form action="ainfoUpdateProc" method="post">
				<ul>
					<li><span>번호</span><input type="text" name="no" class="infoName" value="${info.no}" readonly="readonly"></li>
					<li><span>업체명</span><input type="text" name="name" class="infoName" value="${info.name}" ></li>
					<li><span>주소</span><input type="text" name="address" class="infoAddress" value="${info.address}"></li>
					<li>
						<span>업종</span>
						<select name="category" class="ainfoOption">
							<c:choose>
								<c:when test="${info.category == '동물병원'}">
									<option value="동물병원" selected="selected">동물병원</option>
									<option value="동물약국">동물약국</option>
									<option value="학교체육시설">학교체육시설</option>
									<option value="수영장">수영장</option>
									<option value="축구장">축구장</option>
								</c:when>
								<c:when test="${info.category == '동물약국'}">
									<option value="동물병원">동물병원</option>
									<option value="동물약국" selected="selected">동물약국</option>
									<option value="학교체육시설">학교체육시설</option>
									<option value="수영장">수영장</option>
									<option value="축구장">축구장</option>
								</c:when>
								<c:when test="${info.category == '학교체육시설'}">
									<option value="동물병원">동물병원</option>
									<option value="동물약국">동물약국</option>
									<option value="학교체육시설" selected="selected">학교체육시설</option>
									<option value="수영장">수영장</option>
									<option value="축구장">축구장</option>
								</c:when>
								<c:when test="${info.category == '수영장'}">
									<option value="동물병원">동물병원</option>
									<option value="동물약국">동물약국</option>
									<option value="학교체육시설">학교체육시설</option>
									<option value="수영장" selected="selected">수영장</option>
									<option value="축구장">축구장</option>
								</c:when>
								<c:otherwise>
									<option value="동물병원">동물병원</option>
									<option value="동물약국">동물약국</option>
									<option value="학교체육시설">학교체육시설</option>
									<option value="수영장">수영장</option>
									<option value="축구장" selected="selected">축구장</option>
								</c:otherwise>
							</c:choose>
						</select>
					</li>
					<li><span>홈페이지</span><input type="text" name="homePage" class="infoPage" value="${info.homePage}"></li>
					<li><span>전화번호</span><input type="text" name="mobile" class="infoNote" value="${info.mobile}"></li>
				</ul>
				<input type="submit" value="수정" class="infoButton"/>
				<input type="button" value="취소" class="infoButton" onclick="history.back()"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>