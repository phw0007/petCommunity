<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo</title>
</head>
<body>
	<%@ include file="../default/header.jsp" %>

	<div align="center">
		<h1>개인 정보</h1>
		아이디 :  ${member.id }<br> 
		비밀번호 : ${member.pw }<br>
		이름 :  ${member.userName }<br>
		주소 : ${member.address }<br>
		전화번호 :  ${member.mobile }<br><br>
		<button type="button" onclick="location.href='update'">회원 수정</button>
		<button type="button" onclick="location.href='delete'">회원 삭제</button>
	</div>	
		<%@ include file="../default/footer.jsp" %>
</body>
</html>



















