<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../default/header.jsp" %>

<div align="center">
	<h1>회원 수정</h1>
	<table >
	<tr><td>${msg }</td></tr>
	<tr><td>
	<form action="updateService" method="post" id="f">
		<input type="text" value="${id }" id="id"> (*필수 항목) <br>
		<input type="password" name="pw" placeholder="비밀번호" id="pw"><br>
		<input type="password" name="confirm" placeholder="비밀번호 확인 " id="confirm"
		onchange="pwCheck()">
		<label id="label" ></label><br>
		<input type="text" name="userName" id="userName" value="${userName }" ><br>
		<input type="text" name="address" value="${address  }"><br>
		<input type="text" name="mobile" value="${mobile }"><br>
		<input type="button" value="회원수정" onclick="allCheck()">
		<input type="button" value="취소" onclick="location.href='index'"><br>
	</form>
	</td></tr></table>
</div>

<%@ include file="../default/footer.jsp" %>



