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
<script>
	function getInfoDelete() {
		if (window.confirm("정말로 삭제하시겠습니까?")) {
			location.href="memberDelete?selectedValues=${member.id}&url=amember";
		} 
	}
</script>
<c:import url="/header" />
<div class="member">
	<div class="memberItem">
		<h3>회원 관리</h3>
		<ul>
			<li><a href="amember" style="font-weight: bold;">회원 목록</a></li>
			<li><a href="amemberDelete">회원 삭제</a></li>
			<li><a href="amemberMail">메일 발송 설정</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>회원목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="amember">회원 관리</a></li>
				<li>></li>
				<li><a href="amember">회원 목록</a></li>
			</ul>
		</div>
		
		<div class="mainInfo">
			<div class="userInfo">
				<p>사용자 정보</p>
				<ul>
					<li><span>이름</span>${member.userName }</li>
					<li><span>아이디</span>${member.id }</li>
					<li><span>가입일</span>${member.registerDay }</li>
					<li><span>이메일</span>${member.email }</li>
					<li><span>주소</span>${member.address }</li>
					<li><span>전화번호</span>${member.mobile }</li>
				</ul>
			</div>
			<div class="userBoard">
				<p>게시물 정보</p>
				<ul>
					<li><span>커뮤니티</span>1</li>
					<li><span>반려앨범</span>1</li>
					<li><span>댓글</span>1</li>
				</ul>
			</div>
			<div class="userPet">
				<p>반려동물 정보</p>
				<ul>
					<li><img src=${member.petFile } alt="pet" width=140px height=200px/></li>
					<li><span>이름</span>${member.petName }</li>
					<li><span>종류</span>${member.petCategory }</li>
				</ul>
			</div>
		</div>
		<div class="memberButton">
			<input type="button" value="비밀번호 변경" class="userPassword" onclick="location.href='amemberPasswordUpdata?id=${member.id }'"/>
			<input type="button" value="삭제" class="userDelete" onclick="getInfoDelete()"/>
			<input type="button" value="확인" class="selectEnd" onclick="location.href='amember?currentPage=${cp }'"/>
		</div>
	</div>
</div>
</body>
</html>