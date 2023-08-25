<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<link rel="stylesheet" href="/css/userInfo.css" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>




<div class="userInfo">
	<h1>마이 페이지 </h1>
	    <div class="petInfo">
	        <a><img src="${member.petFile}" width="140px" height="180px"></a>
	        <div class="petInfo2">
	        <h5>반려동물 정보</h5>
	        <p>이름  <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1; margin-top: 20px;">${member.petName}</span></p>
	        <p>종류  <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1; margin-top: 20px;">${member.petCategory}</span></p>
	        </div>
	    </div>
	    <div class="ownerInfo">
	        <h5>주인 정보</h5>
	        <ul class="ownerLeft">
	            <li>이름 &nbsp; &nbsp; &nbsp; <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.userName }</span></li>
	            <li>전화번호 <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.mobile }</span></li>
	            <li>가입일자 <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${member.registerDay }</span></li>
	        </ul>
	        <ul class="ownerRight">
	            <li>주소 &nbsp; &nbsp; <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${member.address }</span></li>
	            <li>아이디 <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.id }</span></li>
	            <li>이메일 <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.email }</span></li>
	        </ul>
	    </div>
	    <div class="infoButton" align="center">
	        <button type="button" onclick="location.href='update'" style="cursor: pointer;">회원 수정</button>
	        <button type="button" onclick="location.href='delete'" style="cursor: pointer;">회원 탈퇴</button>
	    </div>
	    <hr>

	
	
	<div class="basket" align="center">
	<input type="button" value="더보기 >" onclick="location.href='cart?id=${sessionScope.id }'" style="background: none; vertical-align: right; border: none; cursor: pointer; font-size: 15px; float:right;"><br>
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
	<hr>
	
	
	
	<div class="out" align="center">
	<ul>
	    <li><a href="${context }logout">로그아웃</a></li>
	</ul>
	
	</div>
	    
	   
	    
	
</div>	

<c:import url="/footer"/>






















