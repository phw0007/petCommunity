<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <c:import url="/header" />
  	<link rel="stylesheet" href="${contextRoot}css/home.css">
    <link href="css/reset.css" rel="stylesheet" type="text/css"> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<div class="mainlogo"><a href="${context }home" id="logo"><img src="${contextRoot}image/logo.png" alt="logo" width="300px" height="300px" ></a></div>
<div class="web">
 	<div class="top">
		<div class="tl">
			<p>공지사항<a href="${context }home">더보기 > </a></p><br>
				<div class="tlc">
					<p>커뮤니티<a href="${context }freeboardForm">더보기 > </a></p>
					<table class="boardHit">
						<thead>
						    <tr>
						    	<th>번호</th>
						    	<th>제목</th>
						    	<th>작성자</th>
						    	<th>작성날짜</th>
						    </tr>
						</thead>
						<tbody>
							<c:forEach var="mboard" items="${mboards}">
								<tr>
									<td>${no=no+1}</td>
									<td>${mboard.title}</td>
									<td>${mboard.id}</td>
									<td>${mboard.writeDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>	
				</div>
			 <br><br>
		<div class="tlp">
			<p>반려앨범<a href="${context }photoMain">더보기 > </a></p>
		<ul class="potHit">
			<c:forEach var="mphoto" items="${mphotos}" varStatus="loop">
		        <li>
		            <div class="mliweb" onclick="location.href='photoContent?no=${mphoto.no}'">
		                <div class="mliimg"><img alt="${mphoto.fileName}" src="${contextRoot}image/${mphoto.fileName}" width="160" height="200"></div>
		                <div class="mlicont">${mphoto.title}</div>
		                <div class="mliicon">
		                    <p class="mpotoid">${mphoto.id}</p>
		                    <p class="msee"><span class="material-symbols-outlined">visibility</span>&nbsp;0</p>
		                    <p class="mfavorite"><span class="material-symbols-outlined">favorite</span>&nbsp;0</p>
		                </div>
		            </div>
		        </li>
    		</c:forEach>
		</ul>
</div>
	</div>
		<div class="tr">
			<p>업체정보
			<a href="info?category=동물병원">더보기 > </a></p>
			<table class="infoList">
				<thead>
			    	<tr>
			    		<th>번호</th>
			    		<th>업체분류</th>
			    		<th>업체명</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="info" items="${infos}">
						<tr>
							<td>${infoNo=infoNo+1}</td>
							<td>${info.category}</td>
							<td>${info.name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
 	</div>
 	<br>
	<div class="shop">
		<p>쇼핑몰<a href="${context }shopping">더보기 > </a></p>
		<div class="shoppingList">
			<ul> 
				<c:forEach var="shop" items="${shops}">
					<li onclick="location.href='#'">
					    <a href="shopIn?productId=${shop.no}">
						<p><img src="${contextRoot}image/${shop.imageFile}" alt="pet" width=160px height=180px/></p>
						<span style="font-weight: bold;">${shop.company}</span>
						<span>${shop.product}</span>
						<span>${shop.shopPay}</span>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
</body>
</html>

<c:import url="/footer" />