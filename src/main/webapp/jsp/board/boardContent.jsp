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
	result = confirm('삭제하시겠습니까?');
	if (result == true){
		location.href='boardDeleteProc?no=${board.no}';
	}
}
function commentDelete(writeDate,commentId){
	let selectedValues = ['${board.no}',commentId,'${board.category}','${cp}',writeDate];
	url="commentDelete"
	commentDeleteProc(url,selectedValues,commentId);
}
function commentDeleteProc(url, selectedValues, commentId) {
    alert('${sessionScope.id}');
    if (commentId === null || commentId !== '${sessionScope.id}') {
        alert('작성자만 삭제할 수 있습니다.');
    } 
    if(commentId ==='${sessionScope.id}') {
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
}


	function checkCommentLength(textarea) {
		const maxLength = 100;
		if (textarea.value.length > maxLength) {
			alert('댓글은 100자 이내로 입력해주세요.');
			textarea.value = textarea.value.substring(0, maxLength);
		}
	}

	/* 좋아요 */
	function clickLike() {
		let selectedValues = ['${board.no}', '${board.id}','${board.category}','${cp}'];
		url = "clickLike";
		clickLikeButton(url,selectedValues);
	}
	function clickLikeButton(url,selectedValues){
		if('${sessionScope.id}'=== null){
		alert('로그인 후 이용해주세요.');
		}
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
	 var errorMessage = "${errorMessage}";
     if (errorMessage) {
         alert(errorMessage);
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

    </c:otherwise>
</c:choose>
	   </div>

		<div class="likeB"><button class="likes" type="button" onclick="clickLike()"><img src="/image/made.png" alt="하트" style="width:70px; height:70px; ">추천수:<span>${board.likes}</span></button></div>
	 
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
		<textarea rows="5" cols = "100" name = "commentContent" oninput="checkCommentLength(this)"  placeholder="댓글을 입력해주세요.(100자 이내)"></textarea>
		<button type="submit" style="background:#fcd11e;font-family: 'Poor Story', cursive;border:none; 
		width:50px;  height:25px;">등록</button>
		</form>

			<c:choose>
				<c:when test="${empty comments }">
				등록된 댓글이 없습니다.
				</c:when>
				<c:otherwise>
					<c:forEach var="comment" items="${comments}">
						<ul>
							<li><span>${comment.id}</span><b>${comment.writeDate}</b></li>
							<li>${comment.commentContent}
							 <input type="button" value="X" onclick="commentDelete('${comment.writeDate}','${comment.id}')"/>
							  <!--   <form action="commentDelete" method="post">
							  
								<button type="button" onclick="commentDelete('${comment.writeDate}')">삭제</button>
							  </form>-->
						</ul>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
 
	</div>


<c:import url = "/footer"/>
</body>
</html>