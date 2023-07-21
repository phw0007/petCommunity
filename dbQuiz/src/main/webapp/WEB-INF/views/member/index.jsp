<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<!-- http://localhost:8085/jsp_exam/session_quiz/index.jsp -->
	<c:import url="/header" /> <!-- 서버에 요청 forword가 나감  -->
	<c:import url="/main" /><!-- "/"를 안 넣으면  PageNotFound - No mapping for GET 발생-->
	<c:import url="/footer" />
</body>
</html>