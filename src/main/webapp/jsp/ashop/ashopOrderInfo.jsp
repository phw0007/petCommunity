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
function orderDeleteButton(no) {
	let selectedValues = no;
	url="orderDeleteButton";
	getDeleteShop(url, selectedValues);
}

function getDeleteShop(url, selectedValues) {
	if (window.confirm("정말로 취소하시겠습니까?")) {
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
			<li><a href="ashop">상품 목록</a></li>
			<li><a href="ashopRegister">상품 등록</a></li>
			<li><a href="ashopDelete">등록상품 삭제</a></li>
			<li><a href="ashopOrder" style="font-weight: bold;">주문 목록</a></li>
			<li><a href="ashopOrderDel">주문 취소</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>주문 상세정보</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashopOrder">주문 목록</a></li>
				<li>></li>
				<li>주문 상세정보</li>
			</ul>
		</div>
		<div class="memberInfo">
			<div class="infoTop">
				<p>주문자 정보</p>
				<table>
					<thead>
				    	<tr>
				    		<th>아이디</th>
				    		<th>주문자명</th>
				    		<th style="width: 700px;">주소</th>
				    		<th style="width: 200px;">전화번호</th>
				    		<th>결재방식</th>
				    		<th>결재상태</th>
				    		<th>주문날짜</th>
				    	</tr>
				    </thead>
				    <tbody>
				    	<tr>
				    		<td>${order.id}</td>
				    		<td>${order.userName}</td>
				    		<td>${order.address}</td>
				    		<td>${order.mobile}</td>
				    		<td>${order.payType}</td>
				    		<td>${order.payCheck}</td>
				    		<td>${order.writeDate}</td>
				    	</tr>
				    </tbody>
				</table>
			</div>
			
			<div class="infoCenter">
				<p>배송지 정보</p>
				<table>
					<thead>
				    	<tr>
				    		<th style="width: 150px;">수령인</th>
				    		<th style="width: 800px;">주소</th>
				    		<th style="width: 200px;">전화번호</th>
				    		<th style="width: 700px;">요청사항</th>
				    	</tr>
				    </thead>
				    <tbody>
				    	<tr>
				    		<td>${order.shippinName}</td>
				    		<td>${order.shippinAddress}</td>
				    		<td>${order.shippinMobile}</td>
				    		<td>${order.shippinMemo}</td>
				    	</tr>
				    </tbody>
				</table>
			</div>		
				
			<div class="infoBottom">
				<p>구매 항목</p>
				<table>
					<thead>
				    	<tr>
				    		<th>번호</th>
				    		<th>상품분류</th>
				    		<th>판매업체</th>
				    		<th>상품이름</th>
				    		<th>상품가격</th>
				    		<th>주문개수</th>
				    	</tr>
				    </thead>
				    <tbody>
				    <c:forEach var="list" items="${lists}">
				    	<tr>
				    		<td>${listNo=listNo+1}</td>
				    		<td>${list.category}</td>
				    		<td>${list.company}</td>
				    		<td>${list.product}</td>
				    		<td>${list.shopPay}</td>
				    		<td>${list.orderCount}</td>
				    	</tr>
				    </c:forEach>
				</table>
			</div>
			<input type="button" value="삭제" class="ashopUpdate" onclick="orderDeleteButton(${order.no})"/>
			<input type="button" value="확인" class="ashopSelect" onclick="history.back()"/>
		</div>
	</div>
</div>
</body>
</html>