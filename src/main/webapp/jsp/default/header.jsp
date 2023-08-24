<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<link rel="stylesheet" href="/css/header.css" type="text/css">
<style type = "text/css">
#header{height:100px;}
.inner{font-family: 'Poor Story', cursive;height:80px;}
.inner ul li a{padding:10px 50px 25px 50px;}

.inner ul li:first-child a:hover{border-bottom:0;}
.main_div{height:150px; padding-top:80px;}
</style>

<c:url var="context" value="/"/>
<div id="header">
<div align="center" class="inner">

	<ul>  					 <!-- 이미지 파일 경로가 다르신분은 수정해서 써주세요 -->
	<li><a href="${context }home"><img src="/image/logo2.png" alt="logo" width="100" height="100" ></a></li>
		<li><a href="${context }freeboardForm">커뮤니티</a></li>
		<li><a href="${context }shopping">쇼핑몰</a></li>
		<li><a href="${context }photo">반려앨범</a></li>
		<li><a href="${context }info?category=동물병원">업체정보</a></li>
		<li><a href="${context }login">로그인</a></li>
	</ul>
</div>
</div>