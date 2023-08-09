<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/board.css" rel="stylesheet" type="text/css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardContent</title>
<script>
function deleteCheck(){
	result = confirm('진짜로 삭제할거임? 진짜??');
	if (result == true){
		location.href='boardDeleteProc?no=${board.no}';
	}
}


</script>

</head>
<body>

	<div class="boardContent">
	<h1>${board.category}</h1>
	 <ul>
	   <li>제목<span>${board.title} </span></li>
	   <li>작성자<span> ${board.id }</span></li>
	   <li>작성일<span> ${board.writeDate }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;조회수<span> ${board.hits}</span></li>
	   </ul>
	   <div class="content">
	   ${board.content} <br><br>
	<c:choose>
    <c:when test="${board.fileName == '파일 없음'}">
        <!-- 파일이 없을 때는 아무것도 출력하지 않음 -->
    </c:when>
    <c:otherwise>
        <img id="img" src="/image/${board.fileName}" alt="petImage" />
        ${board.fileName}
    </c:otherwise>
</c:choose>
	   </div>
	   <div class="likeB"><button class="likes" type="button" ><img src="/image/made.png" alt="하트" style="width:70px; height:70px; ">추천수:<span>${board.likes}</span></button></div>
	 
	  <div class="contentB">
			<button class="Clist" type="button" onclick="location.href='freeboardForm'">목록</button>
			<button class="Cmodify"type="button"
				onclick="location.href='boardModify?no=${board.no}'">수정</button>
			<button class="Cdelete" type="button" onclick="deleteCheck()">삭제</button>
		</div>
	  <div class="comment">
	  <h3>댓글</h3>
		<form action="freecommentProc" method="post"  >	
		<input type = "hidden" name = "no" value = "${board.no }">
		<input type = "hidden" name = "category" value = "${board.category }">
		<textarea rows="5" cols = "100" name = "commentContent" placeholder="댓글을 입력해주세요."></textarea>
		<button type="submit" style="background:#fcd11e;font-family: 'Poor Story', cursive; 
		width:50px;  height:25px;">등록</button>
		</form>	
       </div>
       
       <div class="commentView">
			<c:choose>
				<c:when test="${empty comments }">
				등록된 댓글이 없습니다.
				</c:when>
				<c:otherwise>
					<li>
					<c:forEach var="comment" items="${comments}">
							<div class="comment">
								<ul>
									<li><span>작성자</span>${comment.id }</li>
									<li><span>작성일</span>${comment.writeDate }<a href="">X</a></li>
								</ul>
								<p>
									<span>댓글내용</span>
									<textarea readonly="readonly">${comment.commentContent }</textarea>
								</p>
							</div>
						</c:forEach>
						</li>
				</c:otherwise>
			</c:choose>
	
		</div>
	</div>


<c:import url = "/footer"/>
</body>
</html>