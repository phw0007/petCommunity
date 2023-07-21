<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function send() {
	var idValue = document.getElementById('id').value; // 이걸로 값을 가지고오는거임
	var pwValue = document.getElementById('pw').value;
	console.log('idValue : ' + idValue)
	console.log('pwValue : ' + pwValue)
	//자바스크립트 object 라는 자료형으로 여러 데이터를 하나로 묵음 콤마로 나누는방식을 가장 많이씀
	// 키 : 벨류 이런형식
	var reqData = {id : idValue, pw : pwValue} // 여기에 이름이 중요
	//console.log(reqData) // 이렇게하면 object 자료형만 뜸
	
	//JSON.stringify(reqData) :  자바스크립트 object을  제이슨 문자열 자료형으로 변환
	//네트워크로 데이터전달을 위해 변환
	//console.log('JSON.stringify(reqData) : ' + JSON.stringify(reqData))
	reqData  = JSON.stringify(reqData)
	xhr = new XMLHttpRequest();
	xhr.open('post', 'ex3');
	xhr.setRequestHeader('content-type', 'application/json');
	xhr.send(reqData);
	xhr.onreadystatechange = resProc;
	
/*	console.log(typeof 10)
	console.log(typeof 1.1)
	console.log(typeof '1.1')
	console.log(typeof "1.1")
	console.log(typeof reqData)
	*/
} 

var xhr;
function resProc(){
	if(xhr.readyState === 4 && xhr.status === 200){
		var resData = xhr.responseText;
		//console.log(resData) // 응답데이터의 자료형은 JSON String
		// JSON.parse(resData) : JSON 문자열 자료형을 자바스크립트 object 자료형으로 변환
		//console.log(JSON.parse(resData)) 
		
		resData = JSON.parse(resData)
		//console.log(resData.idPrint) 
		//console.log(resData.pwPrint) 
		document.getElementById('idPrint').innerHTML = resData.idPrint
		document.getElementById('pwPrint').innerHTML = resData.pwPrint
	}
}

//데이터는 하나여야한다 
</script>
	
</head>
<body>
	<input type='text' id="id"/><br>
	<span id="idPrint"></span><br>
	<input type="password" id="pw"/><br>
	<span id="pwPrint"></span><br>
	<button type="button" onclick="send()">로그인</button>
</body>
</html>



