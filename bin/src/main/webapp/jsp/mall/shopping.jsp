<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/mall.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="shopping" align="center">
 <h1>쇼핑몰</h1>
  <ul>
    <li><a href="food">사료</a></li>
    <li>ㅣ</li>
    <li><a href="snack">간식</a></li>
    <li>ㅣ</li>
    <li><a href="cloths">의류</a></li>
    <li>ㅣ</li>
    <li><a href="medi">약</a></li>
    <li>ㅣ</li>
    <li><a href="pad">배변패드</a></li>
    <li>ㅣ</li>
    <li><a href="living">리빙</a></li>
  
  </ul>
  
  <div class="shoppingList">
    <ul>
      <li>
        <a href="#">
          <b>이미지 들어갈 곳</b><br>
           <span>상품이름 : </span><br>
           <span>가격 : </span>
        </a>
      </li>
     <li>
        <a href="#">
          <b>이미지 들어갈 곳</b><br>
           <span>상품이름 : </span><br>
           <span>가격 : </span>
        </a>
      </li> 
    </ul>
  </div>
  ${result }
  <div class="serch">
	<form action="Info">
		<select name="select" style="width:100px; height:30px;font-family:'Poor Story';">
			<option value="" >전체</option>
			<option value="id">아이디</option>
			<option value="title">제목</option>
		</select> <input type="text" name=search style="width:500px; height:30px;"> 
		<input type="submit" value="검색" style="width:100px; height:30px; font-family:'Poor Story';background:#fcd11e;">
	</form>
	</div>
</div>

<c:import url = "/footer"/>
</body>
</html>
s