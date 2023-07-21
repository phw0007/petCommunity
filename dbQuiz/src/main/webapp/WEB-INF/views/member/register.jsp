<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../default/header.jsp" %>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
            //검색된 기본 주소 타입: R(도로명), J(지번)
     		if(data.userSelectedType === 'R'){
     			document.getElementById('address').value=data.roadAddress;
     		}else{
     			document.getElementById('address').value=data.jibunAddress;
     		}
     			document.getElementById('postcode').value=data.zonecode;
            }
	        /*
	        	console.log(data.userSelectedType)
	        	console.log(data.roadAddress)
	        	console.log(data.jibunAddress)
	        	console.log(data.zonecode)
	        */
        }).open();
    }
    
    var xhr;
    function sendEmail(){
    	xhr = new XMLHttpRequest();
    	xhr.open('post', 'sendEmail')
    	xhr.send(document.getElementById('email').value)
    	xhr.onreadystatechange = resProc
    }
    
    function resProc(){
    	if(xhr.readyState === 4 && xhr.status === 200){
    		document.getElementById('msg').innerHTML = xhr.responseText;
    	}
    }
    function sendAuth(){
    	//msg의 값이 비어있다면 실행
    	//msg의 값은 sendEmail에서 반환되어 해당 클라이언트에 id 값에 대입된다.
    	if(xhr == null){
    		document.getElementById('msg').innerHTML = '이메일 주소를 전송 후 이용하세요.'
    		return;
    	}
    	xhr.open('post', 'sendAuth');
    	xhr.send(document.getElementById('auth').value);
    	xhr.onreadystatechange = sendAuthProc
    }
    function sendAuthProc(){
    	if(xhr.readyState === 4 && xhr.status === 200){
    		document.getElementById('msg').innerHTML = xhr.responseText;
    	}
    	//인증번호가 일치 했을경우 가입화면에서 인증 관련 입력란을 지움
    	if(xhr.responseText === '인증 성공'){
	    	document.getElementById('auth').style='display:none';
	    	document.getElementById('authBtn').style='display:none';
	    	document.getElementById('email').style='display:none';
	    	document.getElementById('emailBtn').style='display:none';
	    }
    }
    
</script>

<div align="center">
	<h3 id="msg"></h3>
	<h1>회원 등록</h1>
	<table ><tr><td>
	<form action="register" method="post" id="f">
		<input type="text" name="id" placeholder="아이디" id="id"> (*필수 항목) <br>
		<input type="password" name="pw" placeholder="비밀번호" id="pw"><br>
		<input type="password" name="confirm" placeholder="비밀번호 확인 " id="confirm"
		onchange="pwCheck()">
		<label id="label" ></label><br>
		<input type="text" name="userName" id="userName" placeholder="이름" ><br>
		
		<input type="text" id="postcode" nama="postcode" placeholder="우편번호">
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="address" name="address" placeholder="주소">
		<input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소"><br>
		
		<input type="text" name="mobile" placeholder="전화번호" ><br>
		
		<input type="text" id="email" placeholder="이메일">
		<input type="button" id="emailBtn" onclick="sendEmail()" value="이메일 주소 전송"><br>
		<input type="text" id="auth"  placeholder="인증번호">
		<input type="button" id="authBtn" onclick="sendAuth()" value="인증번호 전송"><br>
		
		<input type="button" value="회원가입" onclick="allCheck()">
		<input type="button" value="취소" onclick="location.href='index'"><br>
	</form>
	</td></tr></table>
</div>

<%@ include file="../default/footer.jsp" %>

<!-- 
-단방향 : 평문 ->암호문(암호문), 복호화(x)
-양방향 : -> 암호문(암호화), 암호문 -> 평문(복호화) 예)주소등 재사용이 가능한 것들
 -->

