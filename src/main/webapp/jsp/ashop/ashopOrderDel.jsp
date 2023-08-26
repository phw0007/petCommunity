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
function orderCancelCheckboxes() {
	   let checkboxes = document.getElementsByClassName('member-checkbox');
	   let selectedValues = [];

	   if (window.confirm("정말로 삭제하시겠습니까?")) {
	      for (let i = 0; i < checkboxes.length; i++) {
	         if (checkboxes[i].checked) {
	            selectedValues.push(checkboxes[i].value);
	         }
	      }
	      if (selectedValues[0] == null || selectedValues[0] == "") {
	         window.confirm("삭제할 회원을 선택해주세요.")
	      } else {
	         const url = "orderCancelCheckboxes";
	         getCheckBoxesData(url, selectedValues);
	      }
	   }
	}

	function getCheckBoxesData(url, selectedValues) {
	   const data = document.createElement('input');
	   data.setAttribute('type', 'hidden');
	   data.setAttribute('name', 'selectedValues'); // 데이터의 key
	   data.setAttribute('value', selectedValues); // 데이터의 value

	   const form = document.createElement('form');
	   form.setAttribute('method', 'post'); // 전송 방식 결정 (get or post)
	   form.setAttribute('action', url); // 전송할 url 지정  
	   form.appendChild(data);
	   document.body.appendChild(form);
	   form.submit();
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
			<li><a href="ashopOrder">주문 목록</a></li>
			<li><a href="ashopOrderDel" style="font-weight: bold;">주문 취소</a></li>
		</ul>
	</div>
	<div class="memberMain">
		<div class="memberTitle">
			<p>주문 취소</p>
			<ul>
				<li><a href="aindex">홈</a></li>
				<li>></li>
				<li><a href="ashop">쇼핑몰 관리</a></li>
				<li>></li>
				<li><a href="ashopOrderDel">주문 취소</a></li>
			</ul>
		</div>
		<div class="memberInfo">
			<table>
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>아이디</th>
			    		<th>사용자명</th>
			    		<th>주소</th>
			    		<th>전화번호</th>
			    		<th>주문날짜</th>
			    		<th>선택</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="order" items="${orders}">
						<tr>
							<td>${no=no+1}</td>
							<td>${order.id}</td>
							<td>${order.userName}</td>
							<td>${order.address}</td>
							<td>${order.mobile}</td>
							<td>${order.writeDate}</td>
							<td><input type="checkbox" class="member-checkbox" value="${order.id},${order.writeDate},${order.no}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="memberSearch">
			<div> ${result}	</div>
			<div class="selectSearch">
				<form action="ashopOrder">
					<select name="select" class="selectOption">
						<c:choose>
							<c:when test="${select == 'id'}">
								<option value="">전체</option>
								<option value="id" selected="selected">아이디</option>
								<option value="userName">사용자명</option>
								<option value="writeDate">주문날짜</option>
							</c:when>
							<c:when test="${select == 'userName'}">
								<option value="">전체</option>
								<option value="id">아이디</option>
								<option value="userName" selected="selected">사용자명</option>
								<option value="writeDate">주문날짜</option>
							</c:when>
							<c:when test="${select == 'writeDate'}">
								<option value="">전체</option>
								<option value="id">아이디</option>
								<option value="userName">사용자명</option>
								<option value="writeDate" selected="selected">주문날짜</option>
							</c:when>
							<c:otherwise>
								<option value="">전체</option>
								<option value="id">아이디</option>
								<option value="userName">사용자명</option>
								<option value="writeDate">주문날짜</option>
							</c:otherwise>
						</c:choose>
					</select>
					<input type="text" name="search" class="searchOption" value="${search}"/>
					<input type="submit" value="검색" class="submitOption"/>
					<input type="button" value="주문취소" class="deleteOption" onclick="orderCancelCheckboxes()"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>