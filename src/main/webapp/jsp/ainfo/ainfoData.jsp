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
<script>
function getDeleteInfoButton() {
	let selectedValues = ['${info.no}'];
	url="infoDeleteButton";
	getDeleteInfo(url, selectedValues);
}

function getDeleteInfo(url, selectedValues) {
	if (window.confirm("정말로 삭제하시겠습니까?")) {
	    const form = document.createElement('form'); // form 태그 생성
	    form.setAttribute('method', 'post'); // 전송 방식 결정 (get or post)
	    form.setAttribute('action', url); // 전송할 url 지정
	    
	    const data = document.createElement('input'); // input 태그 생성
	    data.setAttribute('type', 'hidden'); // type = hidden
	    data.setAttribute('name', 'selectedValues'); // 데이터의 key
	   	data.setAttribute('value', selectedValues); // 데이터의 value (여기서는 data1)
	
	    form.appendChild(data);
		
	    document.body.appendChild(form);
	
	    form.submit();      
	}
}
</script>
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
			<p>업체 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ainfo">업체정보 관리</a></li>
				<li>></li>
				<li><a href="ainfo">업체 목록</a></li>
			</ul>
		</div>
		<div class="ainfo">
			<ul>
				<li><span>업체명</span>${info.name }</li>
				<li><span>주소</span>${info.address }</li>
				<li><span>업종</span>${info.category }</li>
				<li><span>홈페이지</span>${info.homePage }</li>
				<li><span>전화번호</span>${info.mobile }</li>
			</ul>
			<input type="button" value="확인" class="infoButton" onclick="location.href='ainfo?currentPage=${cp}'"/>
			<input type="button" value="수정" class="infoButton" style="margin-left:20px; margin-right:20px;" onclick="location.href='ainfoUpdate?name=${info.name}&category=${info.category}&address=${info.address}&homePage=${info.homePage}&mobile=${info.mobile}&currentPage=${currentPage}'"/>
			<input type="button" value="삭제" class="infoButton" onclick="getDeleteInfoButton()"/>
		</div>
	</div>
</div>
</body>
</html>