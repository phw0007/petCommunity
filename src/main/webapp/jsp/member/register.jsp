
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<link rel="stylesheet" href="${contextRoot}css/register.css" type="text/css">
<script src="${contextRoot}dbQuiz.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
            if(data.userSelectedType === 'R'){
               document.getElementById('address').value= data.roadAddress;
            }else{
               document.getElementById('address').value= data.jibunAddress;
            }
            document.getElementById('postcode').value= data.zonecode;
              /*  
                console.log(data.userSelectedType)
               console.log(data.roadAddress)
               console.log(data.jibunAddress)
               console.log(data.zonecode)
               */
            }
        }).open();
    }

    </script>
<div class="register" align="center">

   <h3 id="msg"></h3>
   <h1>회원가입</h1>
   <h4>주인정보</h4>
   <table ><tr><td>
   <form action="registerProc" method="post" id="f">
      <input type="text" name="id" id="id" placeholder="아이디" style="width: 308px; height: 30px;"><br>
      <input type="password" name="pw" id="pw" placeholder="비밀번호" style="width: 308px; height: 30px;"><br>
      <input type="password" name="confirm" id="confirm"
      onchange="pwCheck()" placeholder="비밀번호 확인" style="width: 308px; height: 30px;">
      <label id="label" ></label><br>
      <input type="text" name="userName" id="userName" placeholder="이름" style="width: 308px; height: 30px;"><br>
      <input type="text" id="postcode" name="postcode" placeholder="우편번호">
      <input type="button" onclick="execDaumPostcode()" value="검색" style="width: 100px; height: 30px; border: 1px solid #000000; font-family: 'Poor Story', cursive;"><br>
      <input type="text" id="address" name="address"><br>
      <input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소" style="width: 308px; height: 30px;"><br>
      <input type="text" name="mobile"  placeholder="전화번호" style="width: 308px; height: 30px;"><br>
      <input type="text" id="email" name="email" placeholder="이메일" value="${email}" style="margin-top:50px;">
      <h4 align="center">강아지 정보</h4>
      <input type="text" name="petName" id="petName" placeholder="이름" style="width: 308px; height: 30px;"><br>
      <select id="category" name="petCategory" size="1" style="width: 308px; height: 30px;">
      <option value="선택">선택</option>
         <option value="강아지">강아지</option>
         <option value="고양이">고양이</option>
         <option value="파충류">파충류</option>
         <option value="조류">조류</option>
         <option value="수중생물">수중생물</option>
         <option value="소동물">소동물</option>
         <option value="기타동물">기타동물</option>
        </select> <br>
        <h5>프로필 사진</h5><input type="file" id="fileImg" name="petFile" onchange="fileURL()" style="background: none; font-family: 'Poor Story', cursive;" accept="image/*"/><br>
      <input type="submit" value="회원가입" onclick="allCheck()" style="width: 150px; height: 30px; font-family: 'Poor Story', cursive; border: 1px solid #000000; cursor: pointer;">
      <input type="button" value="취소" onclick="location.href='login'" style="width: 150px; height: 30px; font-family: 'Poor Story', cursive; border: 1px solid #000000; cursor: pointer;"><br>
   </form>
   </td></tr></table>
   
</div>

<c:import url="/footer" />

