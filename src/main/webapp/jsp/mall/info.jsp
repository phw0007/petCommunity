<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/mall.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>

<div class="info">
  <ul>
    <li><a href="hospital">동물병원</a></li>
    <li><a href="goods">반려용품</a></li>
    <li><a href="goods">펜션/숙소</a></li>
    <li><a href="cafe">카페</a></li>
    <li><a href="restaurant">식당</a></li>
  </ul>
  
  <div class="infoList">
    <ul>
      <li>
      <table class="infoT">
        <tr>
          <th width="150" height="30">업체이름</th>
          <td width="300">{업체이름}</td>
          <th width="150">비고</th>
          <td width="300">{비고}</td>
        </tr>
         <tr></tr>
         <tr></tr>
        <tr>
         <th width="150"height="30">업체주소</th>
          <td>{업체이름}</td>
          <th>연락처</th>
          <td>{연락처}</td>
        </tr>
      </table>
      <div class="infoButton">
        <a href="#" target="_blanck">홈페이지</a>
           <a href="https://www.instagram.com/myoyeon_catclinic/" target="_blanck">위치보기</a>
      </div>
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