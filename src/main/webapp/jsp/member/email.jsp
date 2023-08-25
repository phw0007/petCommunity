<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<link rel="stylesheet" href="/css/email.css" type="text/css">
<script src="/dbQuiz.js"></script>
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
    
    var xhr;
    function sendEmail(){
       xhr = new XMLHttpRequest();
       xhr.open('post', 'mySendEmail')
       xhr.send(document.getElementById('email').value)
       xhr.onreadystatechange = resProc
    }
    function resProc(){
       if(xhr.readyState === 4 && xhr.status === 200){
          document.getElementById('msg').innerHTML = xhr.responseText;
       }
    }
    
    function sendAuth(){
       if(xhr == null){
          document.getElementById('msg').innerHTML = '이메일 주소를 전송 후 이용하세요.'
          return;
       }
       xhr.open('post', 'mySendAuth');
       xhr.send(document.getElementById('auth').value);
       xhr.onreadystatechange = sendAuthProc
    }
    function sendAuthProc(){
       if(xhr.readyState === 4 && xhr.status === 200){
          document.getElementById('msg').innerHTML = xhr.responseText;
       }
       if(xhr.responseText === '인증 성공'){
          document.getElementById('auth').style='display:none';
          document.getElementById('authBtn').style='display:none';
          document.getElementById('email').style='display:none';
          document.getElementById('emailBtn').style='display:none';
       }else if (xhr.responseText === '인증 실패') {
           alert('인증 실패');
           // 인증 실패 시 추가 처리 가능
       }
    }
    
    function next() {
        if(xhr == null){
             document.getElementById('msg').innerHTML = '이메일 주소를 전송 후 이용하세요.'
             return;
          }
          xhr.open('post', 'mySendAuth');
          xhr.send(document.getElementById('auth').value);
          xhr.onreadystatechange = verifyAuthCode
     }

     function verifyAuthCode() {
        if(xhr.responseText === '인증 성공'){
           var f = document.getElementById('f');
            f.submit();
          }
     }

    
    
    

</script>
<div class="email" align="center">
   <form action="register" method="post" id="f">
      <h3>회원가입</h3>
      <h4>이메일 인증</h4>
      <input type="text" id="email" name="email" placeholder="이메일" style="margin-top:50px;">
      <input type="button" id="emailBtn" onclick="sendEmail()" value="전송" style="width: 100px; height: 30px; border: 1px solid #000000; font-family: 'Poor Story', cursive; cursor: pointer;"><br>
      <input type="text" id="auth" placeholder="인증번호">
      <input type="button" id="authBtn" onclick="sendAuth()" value="인증번호 확인" style="width: 100px; height: 30px; border: 1px solid #000000; font-family: 'Poor Story', cursive; cursor: pointer;"><br>
      <h5 id="msg"></h5>
      <input type="button" value="다음" onclick="next()" style="width: 150px; height: 30px; font-family: 'Poor Story', cursive; border: 1px solid #000000; cursor: pointer; margin-top: 30px;">

     
   </form>

   
</div>

<c:import url="/footer" />


