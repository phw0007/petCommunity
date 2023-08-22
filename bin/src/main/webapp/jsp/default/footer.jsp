<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <style type = "text/css">
   .footer{width:1200px; margin:0 auto;}
    .footer ul li{display:inline; list-style:none; font-color: black;}
    .footer ul li a{text-decoration: none; color:black; }
</style>
<c:url var = "context" value= "/"/>
 <hr>
<div class="footer" align="center">
   <img src="/image/logo2.png" alt="logo" width="100"; height="100";>
   <ul>
      <li><a href="${context }Company">회사소개</a></li>
      <li>|</li>
      <li><a href="${context }Privacy">개인정보처리방침</a></li>
      <li>|</li>
      <li><a href="${context }Protection">청소년보호정책</a></li>
      <li>|</li>
      <li><a href="${context }Terms">이용약관</a></li>
   </ul>
   <p>이메일무단수집거부 문의 : DDobongjagyu@naver.com Copyrightⓒ 2023 Creature all rights reserved</p>
</div>