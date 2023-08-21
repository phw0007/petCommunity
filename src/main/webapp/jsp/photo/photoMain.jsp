<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <c:import url="/header" />
  
  	<link rel="stylesheet" href="/css/home.css">
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
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
			<li><a href="${context }home">강아지</a></li>
			<li> ㅣ </li>
			<li><a href="${context }home">고양이</a></li>
			<li> ㅣ </li>
			<li><a href="${context }home">파충류</a></li>
			<li> ㅣ </li>
			<li><a href="${context }home">조류</a></li>
			<li> ㅣ </li>
			<li><a href="${context }home">수중생물</a></li>
			<li> ㅣ </li>
			<li><a href="${context }home">소동물</a></li>
			<li> ㅣ </li>
			<li><a href="${context }home">기타동물</a></li>
			
		</ul>
		<br>
		
		<%
    int itemsPerPage = 6; // 페이지당 아이템 수
    int currentPage = 2;   // 현재 페이지 번호
    if (request.getParameter("page") != null) {
        currentPage = Integer.parseInt(request.getParameter("page"));
    }
    
    int startIndex = (currentPage - 1) * itemsPerPage; // 가져올 아이템의 시작 인덱스
%>

		<ul class="contentWeb">
    <c:forEach var="photo" items="${photos}" begin="${startIndex + 1}" end="${startIndex + itemsPerPage}" varStatus="loop">
    <c:if test="${loop.index > startIndex + itemsPerPage}">
        <c:break />
    </c:if>
        <li>
            <div class="liweb">
                <div class="lititle">${photo.write_date}</div>
                <div class="liimg"><a href="#"><img alt="photoImg/${photo.file_name}" width="210" height="220" src="photoImg/${photo.file_name}"></a></div>
                
                <div class="licont"><a href="#">${photo.title}</a></div>
                <div class="liicon">
                    <p class="see"><span class="material-symbols-outlined">visibility</span>&nbsp;${hits}</p>
                    <p class="favorite"><span class="material-symbols-outlined">favorite</span>&nbsp;${likes}</p>
                    <p class="comment"><span class="material-symbols-outlined">comment</span>&nbsp;${0}</p>
                </div>
            </div>
        </li>
        
    </c:forEach>
</ul>

		
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
	
<!-- <div> ${result}	</div> -->	

	
	

</body>
</html>
<c:import url="/footer" />