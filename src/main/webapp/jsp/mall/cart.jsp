<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
</head>
<body>
    <h1>장바구니</h1>
    
    <table>
        <tr>
            <th>상품</th>
            <th>가격</th>
            <th>수량</th>
        </tr>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>${item.product.product}</td>
                <td>${item.product.pay}원</td>
                <td>${item.quantity}</td>
            </tr>
        </c:forEach>
    </table>
    
    <form action="checkout" method="post">
        <button type="submit">주문하기</button>
    </form>
    
    <c:import url="/footer"/>
</body>
</html>