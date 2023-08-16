<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<link rel="stylesheet" href="/css/login.css" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<script src="/dbQuiz.js"></script>
<div class="bag" >
	<h1>장바구니</h1>
	<ul>
	 <li>
	     <div class="bagPhoto">사진 들어갈 곳</div>
	     <div class="bagInfo">
	       <ul>
	         <li>상품명: 코드 들어갈 곳  </li>
	         <li>갯수: 
	           <input type="button" value="<" onclick="down()">
                {코드 들어갈 곳 }
	           <input type="button" value=">" onclick="up()">
	         </li>
	         <li>금액: {금액들어갈 코드}원</li>
	       </ul>
	     </div>
	     <input type = "button" value="삭제" onclick="allCheck()"
	     style="width:100px; height:30px;background:#ffeda1; font-family:'Poor Story'; border:0; font-size:20px;">
	 </li>
	</ul>
	<div class="order">
	 <span>총 금액 : {코드 들어갈 곳 } 원</span>
	  <input type="button" value="주문하기" onclick="order()"
	  style="width:100px; height:30px;background:#ffeda1; font-family:'Poor Story'; border:0; font-size:20px;">
	</div>
</div>

<c:import url="/footer" />










