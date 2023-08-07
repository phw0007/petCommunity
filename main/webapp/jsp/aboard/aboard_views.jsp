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
<c:import url="/header" />
	<div class="member">
	<div class="member_item">
		<h3>커뮤니티 관리</h3>
		<ul>
			<li><a href="aboard" style="font-weight: bold;">게시글 목록</a></li>
			<li><a href="aboard_delete">게시글 삭제</a></li>
			<li><a href="aboard_anno">공지사항 관리</a></li>
			<li><a href="aboard_anno_del">공지사항 삭제</a></li>
		</ul>			
	</div>
	<div class="member_main">
		<div class="member_title">
			<p>게시글 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="aboard">커뮤니티 관리</a></li>
				<li>></li>
				<li><a href="aboard">게시글 목록</a></li>
			</ul>
		</div>
		<div class="member_views">
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
										<li><span>작성일</span>${comment.writeDate }<a href="">X</a></li>
									</ul>
									<p><span>댓글내용</span><textarea readonly="readonly">${comment.commentContent }</textarea></p>
								</div>
							</c:forEach>
						</li>
					</c:otherwise>
				</c:choose>
				<li>
					<input type="button" value="확인" class="select_end" onclick="location.href='aboard'"
					style="margin-left:100px"/>
					<input type="button" value="삭제" class="aboard_delete" onclick="location.href=''"/>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>