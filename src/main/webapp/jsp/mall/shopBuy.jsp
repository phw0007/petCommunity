<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<c:import url = "/header"/>
<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/shopBuy.css">
<meta charset="UTF-8">
</head>
<body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script>
<script>
function execDaumPostcode() {
	new daum.Postcode({
        oncomplete: function(data) {
			if(data.userSelectedType === 'R'){
				document.getElementById('address').value= data.roadAddress;
			}else{
				document.getElementById('address').value= data.jibunAddress;
			}
			document.getElementById('postcode').value= data.zonecode;
        }
    }).open();
}

function radioCheck() {
    let memoTextRadio = document.getElementById('memoTextRadio');
    let memoTextBox = document.getElementById('memoTextBox');
    let memoSelectRadio = document.getElementById('memoSelectRadio');
    let memoSelect = document.getElementById('memoSelect');

    if (memoTextRadio.checked) {
        memoTextBox.disabled = false;
        memoSelect.disabled = true;
    } else if (memoSelectRadio.checked) {
        memoTextBox.disabled = true;
        memoSelect.disabled = false;
    } else {
        memoTextBox.value = '';
        memoTextBox.disabled = true;
        memoSelect.disabled = true;
    }
}

function addBuy() {
 	var name = document.getElementById("name").value;
 	var mobile = document.getElementById("mobile").value;
 	var postcode = document.getElementById("postcode").value;
	var address = document.getElementById("address").value;
 	var detailAddress = document.getElementById("detailAddress").value;
 	var memoTextRadio = document.getElementById('memoTextRadio');
 	var memoTextBox = document.getElementById('memoTextBox').value;
 	var memoSelect = document.getElementById('memoSelect').value;
 	var cardRadio = document.getElementById('card');
 	var cacaoRadio = document.getElementById('cacaoPay');
 	var randomNum = Math.floor(Math.random() * (100000000 - 1000000000)) + 1000000000;
 	
 	var shippingMemo;
    if (memoTextRadio.checked) {
    	shippingMemo = memoTextBox;
    } else {
    	shippingMemo = memoSelect;
    }
    
 	var payType = "";
    if (cardRadio.checked) {
    	payType = "신용카드";
    } else if(cacaoRadio.checked){
    	payType = "카카오페이";
    }
    if(name == ""){
    	alert('수령인명은 필수 입력 항목입니다.');
    }else if(mobile == ""){
    	alert('전화번호는 필수 입력 항목입니다.');
    }else if(postcode == ""){
		alert('우편번호는 필수 입력 항목입니다.');
 	}else if(address == ""){
 		alert('주소는 필수 입력 항목입니다.');
 	}else if(detailAddress == ""){
 		alert('상세주소는 필수 입력 항목입니다.');
 	}else if(payType == "") {
 		alert('결제방법은 필수 선택 항목입니다.');
 	}
 	else{
		let orderUser = ['${user.id}','${user.userName}','${user.mobile}','${user.address}',payType,randomNum];
		let shippingUser = [name,mobile,postcode,address,detailAddress,shippingMemo];
		let orderProduct = ['${product.category}','${product.company}','${product.product}','${productAllPay}','${num}'];
		
		url="callback";
	    const form = document.createElement('form'); // form 태그 생성
	    form.setAttribute('method', 'post'); // 전송 방식 결정 (get or post)
	    form.setAttribute('action', url); // 전송할 url 지정
	    
	    const userData = document.createElement('input'); // input 태그 생성
	    userData.setAttribute('type', 'hidden'); // type = hidden
	    userData.setAttribute('name', 'orderUser'); // 데이터의 key
	    userData.setAttribute('value', orderUser); // 데이터의 value
	
	   	const shippingData = document.createElement('input'); // input 태그 생성
	   	shippingData.setAttribute('type', 'hidden'); // type = hidden
	   	shippingData.setAttribute('name', 'shippingUser'); // 데이터의 key
	   	shippingData.setAttribute('value', shippingUser); // 데이터의 value
	   	
	   	const productData = document.createElement('input'); // input 태그 생성
	   	productData.setAttribute('type', 'hidden'); // type = hidden
	   	productData.setAttribute('name', 'orderProduct'); // 데이터의 key
	   	productData.setAttribute('value', orderProduct); // 데이터의 value
	   	
	    form.appendChild(userData);
	    form.appendChild(shippingData);
	    form.appendChild(productData);
	    document.body.appendChild(form);
	    form.submit();    
	}
}


var IMP = window.IMP;
IMP.init("imp07740386");

function requestPay() {
	let mobile = document.getElementById('mobile');
	let postcode = document.getElementById('postcode');
	let address = document.getElementById('address');
	let detailAddress = document.getElementById('detailAddress');
 	var cardRadio = document.getElementById('card');
 	var cacaoRadio = document.getElementById('cacaoPay');
	var currentDate = new Date();
	var randomNum = Math.floor(Math.random() * (100000000 - 1000000000)) + 1000000000;
	
	var payType = "";
	if (cardRadio.checked) {
		payType = "kcp.A52CY";
	} else if(cacaoRadio.checked){
		payType = "kakaopay.TC0ONETIME";
	}
	IMP.request_pay({
		pg: payType,
		pay_method: "card", // 생략가
		merchant_uid: randomNum, // 상점에서 생성한 고유 주문번호
		name: "결제테스트",
		amount: '${totalPay}',                         // 숫자 타입
		buyer_email: '${user.email }',
		buyer_name: '${user.userName }',
		buyer_tel: mobile.value,
		buyer_addr: address.value + detailAddress.value,
		buyer_postcode: postcode.value,
    },
    function (rsp) {
		if (rsp.success) {// 결제성공시 로직
		 	var name = document.getElementById("name").value;
		 	var mobile = document.getElementById("mobile").value;
		 	var postcode = document.getElementById("postcode").value;
			var address = document.getElementById("address").value;
		 	var detailAddress = document.getElementById("detailAddress").value;
		 	var memoTextRadio = document.getElementById('memoTextRadio');
		 	var memoTextBox = document.getElementById('memoTextBox').value;
		 	var memoSelect = document.getElementById('memoSelect').value;
		 	var cardRadio = document.getElementById('card');
		 	var cacaoRadio = document.getElementById('cacaoPay');
		 	
		 	var shippingMemo;
		    if (memoTextRadio.checked) {
		    	shippingMemo = memoTextBox;
		    } else {
		    	shippingMemo = memoSelect;
		    }
		    
		 	var payType = "";
		    if (cardRadio.checked) {
		    	payType = "신용카드";
		    } else if(cacaoRadio.checked){
		    	payType = "카카오페이";
		    }
		    if(name == ""){
		    	alert('수령인명은 필수 입력 항목입니다.');
		    }else if(mobile == ""){
		    	alert('전화번호는 필수 입력 항목입니다.');
		    }else if(postcode == ""){
				alert('우편번호는 필수 입력 항목입니다.');
		 	}else if(address == ""){
		 		alert('주소는 필수 입력 항목입니다.');
		 	}else if(detailAddress == ""){
		 		alert('상세주소는 필수 입력 항목입니다.');
		 	}else if(payType == "") {
		 		alert('결제방법은 필수 선택 항목입니다.');
		 	}
		 	else{
				let orderUser = ['${user.id}','${user.userName}','${user.mobile}','${user.address}',payType,randomNum];
				let shippingUser = [name,mobile,postcode,address,detailAddress,shippingMemo];
				let orderProduct = ['${product.category}','${product.company}','${product.product}','${productAllPay}','${num}'];
				
				url="callback";
			    const form = document.createElement('form'); // form 태그 생성
			    form.setAttribute('method', 'post'); // 전송 방식 결정 (get or post)
			    form.setAttribute('action', url); // 전송할 url 지정
			    
			    const userData = document.createElement('input'); // input 태그 생성
			    userData.setAttribute('type', 'hidden'); // type = hidden
			    userData.setAttribute('name', 'orderUser'); // 데이터의 key
			    userData.setAttribute('value', orderUser); // 데이터의 value
			
			   	const shippingData = document.createElement('input'); // input 태그 생성
			   	shippingData.setAttribute('type', 'hidden'); // type = hidden
			   	shippingData.setAttribute('name', 'shippingUser'); // 데이터의 key
			   	shippingData.setAttribute('value', shippingUser); // 데이터의 value
			   	
			   	const productData = document.createElement('input'); // input 태그 생성
			   	productData.setAttribute('type', 'hidden'); // type = hidden
			   	productData.setAttribute('name', 'orderProduct'); // 데이터의 key
			   	productData.setAttribute('value', orderProduct); // 데이터의 value
			   	
			    form.appendChild(userData);
			    form.appendChild(shippingData);
			    form.appendChild(productData);
			    document.body.appendChild(form);
			    form.submit();    
			}
			
        } else {// 결제 실패시
			alert("결재 실패");         
        }
	});
}
</script>
<div class="shopping">
<h1>주문/결재</h1>
	<div class="shopProduct">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>판매자</th>
					<th>수량</th>
					<th>배송비</th>
					<th>상품금액</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${number=number+1}</td>
					<td><img src="${product.imageFile}" alt="pet" width=100px height=100px/></i></td>
					<td>${product.product}</td>
					<td>${product.company}</td>
					<td>${num}</td>
					<td>${shippingFee}</td>
					<td>${productAllPay}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="shopAddress">
		<div class="shopAddressLeft">
		<p>배송지정보</p>
			<ul>
				<li><span>수령인</span>
					<input type="text" id="name" name="name" placeholder="홍길동">
				</li>
				<li><span>연락처</span>
					<input type="text" id="mobile" name="mobile" placeholder="-없이 숫자만 입력" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
				</li>
				<li><span>배송지 주소</span><br>
					<input type="text" id="postcode" name="postcode" placeholder="우편번호" readonly="readonly">
					<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="address" name="address" placeholder="주소" readonly="readonly"><br>
					<input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소">
				</li>
				
				<li>
				    <div>요청사항</div>
				    <div>
				        <span>
				            <input type="radio" name="memoGroup" id="memoSelectRadio" value="memoSelect" onclick="radioCheck()" checked="checked">요청사항 선택
				        </span>
				        <select name="select" id="memoSelect">
				            <option value="배송 전에 미리 연락 바랍니다.">배송 전에 미리 연락 바랍니다.</option>
				            <option value="부재시 경비실에 맡겨 주세요.">부재시 경비실에 맡겨 주세요.</option>
				            <option value="부재시 전화 주시거나 문자 남겨 주세요.">부재시 전화 주시거나 문자 남겨 주세요.</option>
				            <option value="부재시 문앞에 놓고 가주세요.">부재시 문앞에 놓고 가주세요.</option>
				        </select>
				    </div>
				    <div>
				        <span>
				            <input type="radio" name="memoGroup" id="memoTextRadio" value="memoText" onclick="radioCheck()">직접입력
				        </span>
				        <input type="text" id="memoTextBox" placeholder="요청사항을 직접 입력합니다." disabled>
				    </div>
				</li>
			</ul>
		</div>
		
		<div class="shopAddressRight">
		<p>주문자 정보</p>
			<ul>
				<li>${user.userName }</li>
				<li>${user.mobile }</li>
				<li>${user.email }</li>
			</ul>
		</div>
	</div>
	
	<div class="payment">
		<div class="paymentLift">
			<p>결제수단</p>
			<ul>
				<li><input type="radio" id="card" name="payGroup" value="신용카드">신용카드</li>
				<li>
					<div><input type="radio" id="cacaoPay" name="payGroup" value="카카오페이"></div>
					<div><img src="https://developers.kakao.com/tool/resource/static/img/button/pay/payment_icon_yellow_small.png" /></div>
				</li>
			</ul>
		</div>
		<div class="paymentRight">
			<p>결제상세</p>
			<ul>
				<li><span>상품금액</span>${productPay }</li>
				<li><span>배송비용</span>${shippingFee }</li>
				<li><span>주문금액</span>${shippingPay }</li>
				<li><input type="button" value="결제하기" onclick="addBuy()"></li>
			</ul>
		</div>
	</div>
</div>

<c:import url = "/footer"/>
</body>
</html>