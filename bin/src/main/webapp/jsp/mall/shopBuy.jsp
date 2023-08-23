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
var IMP = window.IMP;
IMP.init("imp07740386");

function requestPay() {
  IMP.request_pay(
    {
      pg: "html5_inicis.INIBillTst",
      pay_method: "card", // 생략가
      merchant_uid: "order_no_0002", // 상점에서 생성한 고유 주문번호
      name: "주문명:결제테스트",
      amount: 1004,
      buyer_email: "test@portone.io",
      buyer_name: "구매자이름",
      buyer_tel: "010-1234-5678",
      buyer_addr: "서울특별시 강남구 삼성동",
      buyer_postcode: "123-456",
    },
    function (rsp) {
		rsp => {
			if (rsp.success) {   
    		// axios로 HTTP 요청
    			axios({
    				url: "https://api.iamport.kr",
    			    method: "post",
    			    headers: { "Content-Type": "application/json" },
    			    data: {
    			    	imp_uid: rsp.imp_uid,
    			        merchant_uid: rsp.merchant_uid
    			    }
    			}).then((data) => {
    			    // 서버 결제 API 성공시 로직
			})
			} else {
				alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
			}
    	}
    }
  );
  async requestPayResponse => {
	    const { success, error_msg } = requestPayResponse;
	    if (!success) {
	      alert(`결제에 실패하였습니다. 에러 내용: ${error_msg}`);
	      return;
	    }
	    // 이전 단계에서 구현한 결제정보 사후 검증 API 호출
	    const res = await axios({
	      url: "/payments/complete",
	      method: "post",
	      headers: { "Content-Type": "application/json" }, 
	      data: { imp_uid: "...", merchant_uid: "..." },
	    });
	    switch (res.status) {

	    }
	  }
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
					<td>1</td>
					<td><img src="/image/pet.jpg" alt="pet" width=100px height=100px/></i></td>
					<td>강아지사료</td>
					<td>사료업체</td>
					<td>1</td>
					<td>3,000</td>
					<td>40,000</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="shopAddress">
		<div class="shopAddressLeft">
		<p>배송지정보</p>
			<ul>
				<li><span>수령인</span>
					<input type="text" id="name" name="name" value="홍길동">
				</li>
				<li><span>연락처</span>
					<input type="text" id="mobile" name="mobile" placeholder="-없이 숫자만 입력" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
				</li>
				<li><span>배송지 주소</span><br>
					<input type="text" id="postcode" name="postcode" placeholder="우편번호">
					<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="address" name="address" placeholder="주소"><br>
					<input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소">
				</li>
				
				<li>
				    <div>요청사항</div>
				    <div>
				        <span>
				            <input type="radio" name="memoGroup" id="memoSelectRadio" value="memoSelect" onclick="radioCheck()" checked="checked">요청사항 선택
				        </span>
				        <select name="select" id="memoSelect">
				            <option value="memo1">배송 전에 미리 연락 바랍니다.</option>
				            <option value="memo2">부재시 경비실에 맡겨 주세요.</option>
				            <option value="memo3">부재시 전화 주시거나 문자 남겨 주세요.</option>
				            <option value="memo4">부재시 문앞에 놓고 가주세요.</option>
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
				<li>홍길동</li>
				<li>010-1234-5678</li>
				<li>adimn@naver.com</li>
			</ul>
		</div>
	</div>
	
	<div class="payment">
		<div class="paymentLift">
			<p>결제수단</p>
			<ul>
				<li><input type="radio" id="card" name="card" value="card">신용카드</li>
				<li>
					<div><input type="radio" id="cacaoPay" name="cacaoPay" value="cacaoPay"></div>
					<div><img src="https://developers.kakao.com/tool/resource/static/img/button/pay/payment_icon_yellow_small.png" /></div>
				</li>
			</ul>
		</div>
		<div class="paymentRight">
			<p>결제상세</p>
			<ul>
				<li><span>상품금액</span>30,500</li>
				<li><span>배송비용</span>3,000</li>
				<li><span>주문금액</span>33,500</li>
				<li><input type="button" value="결제하기"></li>
			</ul>
		</div>
	</div>
</div>

<c:import url = "/footer"/>
</body>
</html>