<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${contextRoot}css/aphoto.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<script>
function getDeleteBoardButton() {
	let selectedValues = ['${photo.no}','${photo.id}','${photo.category}'];
	url="photoDeleteButton";
	getDeleteBoard(url, selectedValues);
}

function getDeleteBoardComment(writeDate) {
	let selectedValues = ['${photo.no}','${photo.id}','${photo.category}','${cp}',writeDate];
	url="photoDeleteComment";
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
<c:import url="/aheader" />
	<div class="member">
	<div class="memberItem">
		<h3>반려앨범 관리</h3>
		<ul>
			<li><a href="aphoto" style="font-weight: bold;">게시글 목록</a></li>
			<li><a href="aphotoDelete">게시글 삭제</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>게시글 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="aphoto">반려앨범 관리</a></li>
				<li>></li>
				<li><a href="aphoto">게시글 목록</a></li>
			</ul>
		</div>
		<div class="memberViews">
			<ul>
				<li><span>제목</span>${photo.title }</li>
				<li><span>작성일</span>${photo.writeDate }</li>
				<li><span>작성자</span>${photo.id }</li>
				<li><span>조회수</span>${photo.hits }</li>
				<li><span>추천수</span>${photo.likes }</li>
				<li><span>내용</span>
					<div class="content">
						<c:if test="${photo.fileName != null}">
							<img src=${photo.fileName } alt="pet" width=140px height=200px/><br>
						</c:if>
						${photo.content }
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
										<li><span>작성일</span>${comment.writeDate }<input type="button" value="X" onclick="getDeleteBoardComment('${comment.writeDate}')"/></li>
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