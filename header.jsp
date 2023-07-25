<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="css/reset.css" rel="stylesheet" type="text/css">

<style type="text/css">
 	
	a {text-decoration: none; color:black; font-weight:800; font-size:28px; }
	ul { background-color:#FCD11E; height:100px; line-height:90px; padding-left:380px; }
	ul li {float:left; margin-left:30px;  margin-right:30px; width:130px; height:100px; }
	
	
</style>    





<c:url var="context" value="/"/>

<div align="center" >

	<ul>  					 <!-- 이미지 파일 경로가 다르신분은 수정해서 써주세요 -->
	<li><a href="${context }home"><img src="img/logo.png" alt="logo" width="100" height="100" ></a></li>
		<li><a href="${context }index">커뮤니티</a></li>
		<li><a href="${context }shop">쇼핑몰</a></li>
		<li><a href="${context }photo">반려앨범</a></li>
		<li><a href="${context }info">업채정보</a></li>
		<li><a href="${context }login">로그인</a></li>
	</ul>

</div>








