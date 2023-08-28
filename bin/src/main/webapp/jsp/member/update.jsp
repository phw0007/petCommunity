<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
 <style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<link rel="stylesheet" href="${contextRoot}css/update.css" type="text/css">
<script src="${contextRoot}dbQuiz.js"></script>
<div class="update" align="center">
	<h1>회원 수정</h1>
	<table ><tr><td>
	<form action="updateProc" method="post" id="f">
		<input type="text" value="${sessionScope.id }" id="id" placeholder="아이디" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"> <br>
		<input type="password" name="pw" id="pw" placeholder="비밀번호" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"><br>
		<input type="password" name="confirm"  id="confirm"
		onchange="pwCheck()" placeholder="비밀번호 확인" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;">
		<label id="label" ></label><br>
		<input type="text" name="userName" id="userName" value="${sessionScope.userName }" placeholder="이름" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"><br>
		<input type="text" name="address" value="${sessionScope.address }" placeholder="주소" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"><br>
		<input type="text" name="mobile" value="${sessionScope.mobile }" placeholder="전화번호" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"><br>
		<input type="text" name="petName" id="petName" placeholder="강아지 이름" value="${sessionScope.petName}" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px;"><br>
		<select id="category" name="petCategory" size="1" value="${sessionScope.petCategory }" style="width: 308px; height: 30px; font-family: 'Poor Story', cursive; background-color: #FFEDA1; border:none; margin-bottom: 20px; cursor: pointer;">
		<option value="선택">선택</option>
         <option value="강아지">강아지</option>
         <option value="고양이">고양이</option>
         <option value="파충류">파충류</option>
         <option value="조류">조류</option>
         <option value="수중생물">수중생물</option>
         <option value="소동물">소동물</option>
         <option value="기타동물">기타동물</option>
		</select><br>
		
		
		<input type="button" value="수정" onclick="allCheck()" style="margin-left: 50px; margin-top: 30px; background-color: #FFEDA1; width:100px; height:30px; border: 1px solid #000000; cursor: pointer;">
		<input type="button" value="취소" onclick="location.href='index2'" style="background-color: #FFEDA1; width:100px; height:30px; border: 1px solid #000000; cursor: pointer;"><br>
	</form>
	</td></tr></table>
</div>

<c:import url="/footer" />



