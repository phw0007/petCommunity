<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(){
		//ajaz 요청을 초기화
		//서버로 요청만
	//	var xhr = new XMLHttpRequest();
	//	xhr.open('post', 'ex1a')
	//	xhr.send();
		
	/*	var xhr = new XMLHttpRequest();
		xhr.open('post', 'ex1b')
		var sendData = 'ex1.jsp에서 전달한 데이터';
		xhr.send('ex1.jsp에서 전달한 데이터'); //둘다 똑같음 변수로 만들어서 넣든 문자열로 넣든
		xhr.send(sendData);*/
		
		//함수이름만 넣어주면 함수를 호출해준다 그런거를 콜백이라부른다
		xhr = new XMLHttpRequest();
		xhr.open('post', 'ex1c');
		var sendData = 'ex1.jsp에서 전달한 데이터';
		xhr.send(sendData);
			// 요청의 상태 변화를 추적합니다
		 	xhr.onreadystatechange = resProc;
		}
		var xhr;
		function resProc(){
			if(xhr.readyState !== 4) return;
			// readyState 4: 완료
		
			if(xhr.status === 200) {
		    // status 200: 성공
		    //메소드를 잘못적으면 405 요청이 문제면 404 
				console.log(xhr.responseText); // '반환된 텍스트'
				var print = document.getElementById('print');
				print.innerHTML = xhr.responseText
			} else {
				console.log('에러: ' + xhr.status); // 요청 도중 에러 발생
			}
		}
	
	
</script>
</head>
<body>
<!-- send가 없어도 실행함 문자열로 인식해서 하지만 버튼이 동작하면 오류가 나는데 이클립스 콘솔로는 볼수없고 웹브라우저 게발자 모드콘솔에 에러가 뜸 이유는 이클립스에서는 문자열취급으로 넘겨버렸지만 
웹브라우저는 자바 스크립트코드로 실행해버려서  -->

<!-- 동기통신 비동기통신  요청해서 응답을 모두다 받으면 동기통신 요청url로 데이터끼리만 주고받는 방식은 비동기통신 예) 화면 전체가 바뀌는게 아니라 html은 유지하고 데이터만 -->
	
	<div id="print">출력 데이터</div>
	<button type="button" onclick="send()">데이터 가져오기</button>
</body>
</html>