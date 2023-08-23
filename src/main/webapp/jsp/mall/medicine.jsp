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
    <li><a href="info?category=동물병원">동물병원</a></li>
    <li><a href="medicine?category=동물약국">동물약국</a></li>
    <li><a href="school?category=학교체육시설">학교체육시설</a></li>
    <li><a href="pool?category=수영장">수영장</a></li>
    <li><a href="soccer?category=축구장">축구장</a></li>
  </ul>
  
  <div class="infoList">
    <ul>
      <li>
      <table class="infoT">
      <c:forEach var="useInfo" items="${info }">  
        <tr>
          <th width="150" height="30" style="background-color:#ffeda1">업체이름</th>
          <td width="300">${useInfo.name }</td>
          <th width="150" style="background-color:#ffeda1">홈페이지</th>
          <td width="300"><a href="${useInfo.homePage }" target="_blanck">홈페이지</a></td>
        </tr>
         <tr></tr>
         <tr></tr>
        <tr>
         <th width="150"height="30" style="background-color:#ffeda1">업체주소</th>
          <td>${useInfo.address }</td>
          <th style="background-color:#ffeda1">연락처</th>
          <td>${useInfo.mobile }</td>
      
        </tr>
       </c:forEach>
      </table>
      <div class="infoButton">
        <a href="${useInfo.homePage }" target="_blanck">홈페이지</a>
           <a href="https://www.instagram.com/myoyeon_catclinic/" target="_blanck">위치보기</a>
      </div>
      </li>
    </ul>
    
  </div>
<div class="result">${result }</div>
  <div class="serch">
	<form action="InfoSearch">
			<select name="select" class="selectOption" style="width:100px; height:30px;font-family:'Poor Story';">
						<c:choose>
							<c:when test="${select == 'name'}">
								<option value="">전체</option>
						
								<option value="name" selected="selected">업체 이름</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'address'}">
								<option value="">전체</option>
								
								<option value="name">업체 이름</option>
								<option value="address" selected="selected">주소</option>
								<option value="mobile">전화번호</option>
							</c:when>
							<c:when test="${select == 'mobile'}">
								<option value="">전체</option>
								
								<option value="name">업체 이름</option>
								<option value="address">주소</option>
								<option value="mobile" selected="selected">전화번호</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
							
								<option value="name">업체 이름</option>
								<option value="address">주소</option>
								<option value="mobile">전화번호</option>
							</c:otherwise>
						</c:choose>
					</select>
					<input type="text" name="search" class="searchOption" value="${search}" style="width:500px; height:30px;"/>
					<input type="submit" value="검색" class="submitOption" style="width:100px; height:30px; font-family:'Poor Story';background:#fcd11e;"/>
	</form>
	</div>
</div>

<c:import url = "/footer"/>
