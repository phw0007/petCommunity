
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="contextRoot" value="/"/>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<link rel="stylesheet" href="${contextRoot}css/header.css" type="text/css">
<c:url var="context" value="/"/>
<div id="header">
<div align="center" class="inner">

	<ul>  					 <!-- 이미지 파일 경로가 다르신분은 수정해서 써주세요 -->
		<li><a href="${context }home"><img src="${contextRoot}image/logo.png" alt="logo" ></a></li>
		<li><a href="${context }freeboardForm">커뮤니티</a></li>
		<li><a href="${context }shopping">쇼핑몰</a></li>
		<li><a href="${context }photoMain">반려앨범</a></li>
		<li><a href="${context }info?category=동물병원">업체정보</a></li>
		<li><a href="${context }login">로그인</a></li>
		
	</ul>
</div>

