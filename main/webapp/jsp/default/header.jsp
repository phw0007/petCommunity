<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<link rel="stylesheet" href="/css/header.css" type="text/css">
<style type = "text/css">
#header{height:100px;}
.inner{font-family: 'Poor Story', cursive;}
.inner ul li a{padding:10px 50px 10px 50px;}
.inner ul li a:hover{color:black; border-bottom:3px solid black;}
.inner ul li:first-child a:hover{border-bottom:0;}
</style>


<c:url var="context" value="/"/>
<div id="header">
<div align="center" class="inner">

   <ul>                  <!-- 이미지 파일 경로가 다르신분은 수정해서 써주세요 -->
   <li><a href="${context }home"><img src="/image/logo.png" alt="logo" width="100" height="100" ></a></li>
      <li><a href="${context }index">커뮤니티</a></li>
      <li><a href="${context }shop">쇼핑몰</a></li>
      <li><a href="${context }photo">반려앨범</a></li>
      <li><a href="${context }info">업체정보</a></li>
      <li><a href="${context }login">로그인</a></li>
   </ul>
</div>
</div>

