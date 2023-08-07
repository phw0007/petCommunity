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
	        <a>사진 ${member.petFile}</a>
	        <div class="petInfo2">
	        <h5>반려동물 정보</h5>
	        <p>이름  <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.petName}</span></p>
	        <p>종류  <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.petCategory}</span></p>
	        </div>
	    </div>
	    <div class="ownerInfo">
	        <h5>주인 정보</h5>
	        <ul class="ownerLeft">
	            <li>이름 &nbsp; &nbsp; &nbsp; <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.userName }</span></li>
	            <li>전화번호 <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.mobile }</span></li>
	        </ul>
	        <ul class="ownerRight">
	            <li>주소 &nbsp; <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.address }</span></li>
	            <li>아이디 <span style="display:inline-block; width:150px; height:20px; background-color: #FFEDA1;">${member.id }</span></li>
	        </ul>
	    </div>
	    <div class="infoButton" align="center">
	        <button type="button" onclick="location.href='update'" style="cursor: pointer;">회원 수정</button>
	        <button type="button" onclick="location.href='delete'" style="cursor: pointer;">회원 탈퇴</button>
	    </div>
	    <hr>

	
	
	
	
	
	<div class="album">
	<input type="file" id="fileImg" class="ashopFile" onchange="fileURL()" accept="image/*"/>
	<img id="img" src="/image/logo.png" alt="petImage" width=180px height=240px/>
	<input type="button" value="등록" class="ashop_select" onclick="uploadImage()"/>
	
	</div>
	
	<div class="basket">
	</div>
	    
	   
	    
	
</div>	

<c:import url="/footer"/>



















