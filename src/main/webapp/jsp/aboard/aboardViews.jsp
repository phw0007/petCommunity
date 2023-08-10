<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/aboard.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<script>
function getDeleteBoardButton() {
	let selectedValues = ['${board.no}','${board.id}','${board.category}'];
	url="boardDeleteButton";
	getDeleteBoard(url, selectedValues);
}

function getDeleteBoardComment() {
	let selectedValues = ['${board.no}','${board.id}','${board.category}','${cp}'];
	url="boardDeleteComment";
	getDeleteBoard(url, selectedValues);
}

function getDeleteBoard(url, selectedValues) {
	if (window.confirm("정말로 삭제하시겠습니까?")) {
	    const form = document.createElement('form'); // form 태그 생성
	    form.setAttribute('method', 'post'); // 전송 방식 결정 (get or post)
	    form.setAttribute('action', url); // 전송할 url 지정
	    
	    const data = document.createElement('input'); // input 태그 생성
	    data.setAttribute('type', 'hidden'); // type = hidden
	    data.setAttribute('name', 'selectedValues'); // 데이터의 key
	   	data.setAttribute('value', selectedValues); // 데이터의 value (여기서는 data1)
	
	    form.appendChild(data);
		
	    document.body.appendChild(form);
	
	    form.submit();      
	}
}
</script>
<c:import url="/header" />
	<div class="member">
	<div class="memberItem">
		<h3>커뮤니티 관리</h3>
		<ul>
			<li><a href="aboard" style="font-weight: bold;">게시글 목록</a></li>
			<li><a href="aboardDelete">게시글 삭제</a></li>
			<li><a href="aboardAnno">공지사항 관리</a></li>
			<li><a href="aboardAnnoDel">공지사항 삭제</a></li>
		</ul>			
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>게시글 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="aboard">커뮤니티 관리</a></li>
				<li>></li>
				<li><a href="aboard">게시글 목록</a></li>
			</ul>
		</div>
		<div class="memberViews">
			<ul>
				<li><span>제목</span>${board.title }</li>
				<li><span>작성일</span>${board.writeDate }</li>
				<li><span>작성자</span>${board.id }</li>
				<li><span>조회수</span>${board.hits }</li>
				<li><span>추천수</span>${board.likes }</li>
				<li><span>내용</span>
					<div class="content">
						<img src=${board.fileName } alt="pet" width=140px height=200px/><br>
						${board.content }
					</div>
				</li>
				<c:choose>
					<c:when test="${empty comments }">
					</c:when>
					<c:otherwise>
						<li>
							<c:forEach var="comment" items="${comments}">
								<div class="comment">
									<ul>
										<li><span>작성자</span>${comment.commentId }</li>
										<li><span>작성일</span>${comment.writeDate }<input type="button" value="X" onclick="getDeleteBoardComment()"/></li>
									</ul>
									<p><span>댓글내용</span><textarea readonly="readonly">${comment.commentContent }</textarea></p>
								</div>
							</c:forEach>
						</li>
					</c:otherwise>
				</c:choose>
				<li>
					<input type="button" value="확인" class="selectEnd" onclick="location.href='aboard?currentPage=${cp}'"
					style="margin-left:20px; margin-right:40px;"/>
					<input type="button" value="삭제" class="aboardDelete" onclick="getDeleteBoardButton()"/>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>