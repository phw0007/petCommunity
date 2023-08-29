<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/mall.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
    .infoT {
    
      border: 1px solid black; /* 테두리 두께 및 색상 설정 */
   }
</style>
<c:import url = "/header"/>

<div class="info">
 <ul>
    <li><a href="info?category=동물병원">동물병원</a></li>
    <li><a href="medicine?category=동물약국">동물약국</a></li>
    <li><a href="school?category=학교체육시설">학교체육시설</a></li>
    <li><a href="pool?category=수영장">수영장</a></li>
    <li><a href="soccer?category=축구장" class="on">축구장</a></li>
  </ul>
  
  <div class="infoList">
      <table class="infoT" > 
      <c:forEach var="useInfo" items="${info }">  
        <tr>
          <th width="100" height="10" style="background-color:#ffeda1">업체이름</th>
          <td width="370">${useInfo.name }</td>
          <th width="100" style="background-color:#ffeda1">홈페이지</th>
           <c:choose>
    <c:when test="${empty useInfo.homePage or useInfo.homePage eq '-'}">
        <td width="370">-</td>
    </c:when>
    <c:otherwise>
        <td width="370"><a href="${useInfo.homePage}" target="_blank">홈페이지</a></td>
    </c:otherwise>
</c:choose>
        </tr>
        <tr  style="border-bottom:1px solid #e6e6e6; padding-bottom:15px;">
         <th width="100"height="30" style="background-color:#ffeda1">업체주소</th>
          <td width="370">${useInfo.address }</td>
          <th style="background-color:#ffeda1">연락처</th>
          <td width="370">${useInfo.mobile }</td>
        </tr>
             <tr>
           <td colspan="4" style="border-top:1px solid #e6e6e6; padding-top:5px; padding-bottom:10px;"></td>
       </tr>
       </c:forEach>
      </table>
  </div>
<div class="result">${result }</div>
  <div class="serch">
	<form action="info">
			<select name="select" class="selectOption" >
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
					<input type="hidden" name="category" value="축구장">
					<input type="text" name="search" class="searchOption" value="${search}" />
					<input type="submit" value="검색" class="submitOption" />
	</form>
	</div>
</div>

<c:import url = "/footer"/>
