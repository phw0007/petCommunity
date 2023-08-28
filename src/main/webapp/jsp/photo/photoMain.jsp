<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <c:import url="/header" />
  
  	<link rel="stylesheet" href="${contextRoot}css/home.css">
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
	<div class="potoMain">
		<h3>공지사항</h3>
		
		<ul class="animalCategory">
			<li><a href="home">강아지</a></li>
			<li> ㅣ </li>
			<li><a href="home">고양이</a></li>
			<li> ㅣ </li>
			<li><a href="home">파충류</a></li>
			<li> ㅣ </li>
			<li><a href="home">조류</a></li>
			<li> ㅣ </li>
			<li><a href="home">수중생물</a></li>
			<li> ㅣ </li>
			<li><a href="home">소동물</a></li>
			<li> ㅣ </li>
			<li><a href="home">기타동물</a></li>
			
		</ul>
		<br>
		
		<ul class="contentWeb">
		<c:forEach var="photo" items="${photos}" >
			<li>

				<div class="liweb" onclick="location.href='photoContent?no=${photo.no}'">
					<div class="lititle">${photo.id} &nbsp;&nbsp; ${photo.writeDate}</div>
					<div class="liimg"><img alt="/image/${photo.fileName}" src=/image/${photo.fileName} width="210" height="220" ></div>
					<div class="licont">${photo.title}</div>

					<div class="liicon">
						<p class="see"><span class="material-symbols-outlined">visibility</span>&nbsp;</p>
						<p class="favorite"><span class="material-symbols-outlined">favorite</span>&nbsp;</p>
						<p class="comment"><span class="material-symbols-outlined">comment</span>&nbsp;</p>
					</div>
				</div>
				</c:forEach>
			</li>
			
		</ul>
		<div style="text-align: center;">${result}</div>
		<br><br><br><br>
		<div class=	"photoFt">
			<div class="boardshBg">
				<form action="boardsh" id="boardsh">
					<select name="select" style="width: 70px; height: 30px;">
						<option value="">제목</option>
						<option value="id">작성자</option>
					</select>
					<input type="text" name="search" style="width: 400px; height: 30px; "/>
					<input type="submit" value="검색" style="width: 70px; height: 30px;"/>
				</form>
			</div>
			<button id="goWrite" onclick="location.href='photoWrite'">글쓰기</button>
		</div>
		
		
	</div>
	


	
</body>
</html>
<c:import url="/footer" />

