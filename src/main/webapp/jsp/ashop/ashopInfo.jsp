
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/ashop.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<script>
function ashopUpdateButton() {
	let selectedValues = ['${shop.no}','${shop.category}','${shop.product}','${shop.company}',
		'${shop.inventory}','${shop.imageFile}','${shop.info}'];
	url="ashopUpdate?shopPay=${shop.shopPay}";
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

function deleteShopButton() {
	let selectedValues = ['${shop.product}','${shop.category}','${shop.no}'];
	url="deleteShopButton";
	getDeleteShop(url, selectedValues);
}

function getDeleteShop(url, selectedValues) {
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
		<h3>쇼핑몰 관리</h3>
		<ul>
			<li><a href="ashop" style="font-weight: bold;">상품 목록</a></li>
			<li><a href="ashopRegister">상품 등록</a></li>
			<li><a href="ashopDelete">등록상품 삭제</a></li>
			<li><a href="ashopOrder">주문 목록</a></li>
			<li><a href="ashopOrderDel">주문 취소</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>상품 목록</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashop">상품 목록</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<div class="ashopLeft">
				<c:choose>
					<c:when test="${shop.imageFile == '' || shop.imageFile == null}">
						<p><img src="/image/pet.jpg" alt="pet" width=180px height=240px/></p>	
					</c:when>
					<c:otherwise>
						<p><img src="${shop.imageFile}" alt="pet" width=180px height=240px/></p>
					</c:otherwise>
				</c:choose>
				<ul>
					<li><span>상품 이름</span>${shop.product}</li>
					<li><span>상품 분류</span>${shop.category }</li>
					<li><span>판매 업체</span>${shop.company }</li>
					<li><span>상품 가격</span>${shop.shopPay }</li>
					<li><span>재고</span>${shop.inventory }</li>
				</ul>
			</div>
			<div class="ashopRight">
				<p>상품 상제정보</p>
				<p><textarea class="textInfo" readonly="readonly">${shop.info}</textarea></p>
			</div>
			<input type="button" value="확인" class="ashopSelect" onclick="location.href='ashop?currentPage=${cp}'"/>
			<input type="button" value="수정" class="ashopUpdate" onclick="ashopUpdateButton()"/>
			<input type="button" value="삭제" class="ashopUpdate" onclick="deleteShopButton()"/>
		</div>
	</div>
</div>
</body>

</html>