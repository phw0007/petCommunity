<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<link rel="stylesheet" href="/css/userInfo.css" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>


<div class="userInfo" align="center">
   <h1>마이 페이지 </h1>
       <div class="petInfo">
           <a>사진 ${member.petFile}</a>
           <h5>반려동물 정보</h5>
           <p>이름  <span>${member.petName}</span></p>
           <p>종류  <span>${member.petCategory}</span></p>
       </div>
       <div class="ownerInfo">
           <h5>주인 정보</h5>
           <ul class="ownerLeft">
               <li>이름 <span>${member.userName }</span></li>
               <li>전화번호 <span>${member.mobile }</span></li>
           </ul>
           <ul class="ownerRight">
               <li>주소 <span>${member.address }</span></li>
               <li>아이디 <span>${member.id }</span></li>
           </ul>
       </div>
       <div class="infoButton">
           <button type="button" onclick="location.href='update'">회원 수정</button>
           <button type="button" onclick="location.href='delete'">회원 탈퇴</button>
       </div>

   
   
   
   
   
   <div class="album">
   </div>
   
   <div class="basket">
   </div>
       
      
       
   
</div>   

<c:import url="/footer"/>


















