<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header" />
<div align="center">
	<form action="boardWriteService" method='post' enctype="multipart/form-data">
		<table>
			<caption>
				<font size="5"><b>게시글 등록</b></font>
			</caption>
			<tr>
				<th width="100px">제목</th>
				<td><input style="width: 100%;" type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea style="width: 100%;" rows="10" cols="30" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td><input type="file" name="upfile"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글쓰기"> 
					<input type="button" value="목록"	 onclick="location.href='boardForm'">
				</td>
			</tr>
		</table>
	</form>
</div>
<c:import url="/footer" />
	<!-- 
		boardWrite.jsp 와 boardWriteService.jsp는 로그인한 사용자만 접근 가능
		
		boardWriteService.jsp로 데이터 전달
		제목과 내용을 전달하면
		no : 테이블에서 no 컬럼 중 제일 큰 번호를 얻어와 더하기 1
			SELECT max(no)+1 FROM session_board;
			SELECT no FROM session_board ORDER BY no DESC;
		
		title, content : 전달받은 데이터
		id : 로그인한 사용자 id
		wirteDate : 현재 날짜(2023-06-23)를 Date, SimpleDateFormat 클래스로 구함
		hits : 게시글 등록이기에 처음에는 0을 갖음
		fileName : 미완성이기에 '' 빈문자열로 저장
	 -->






