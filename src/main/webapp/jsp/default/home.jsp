<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <c:import url="/header" />
  
  
  	<link rel="stylesheet" href="/css/home.css">
    <link href="css/reset.css" rel="stylesheet" type="text/css">
  <style type="text/css">
</style>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<div class="mainlogo"><a href="${context }home" id="logo"><img src="/image/logo2.png" alt="logo" width="300" height="300" ></a></div>


		 <div class="web">
 					<div class="top">
			 			<div class="tl">
						 	<p>공지사항<a href="${context }home">더보기 > </a></p>
						 	<br>
						 	<div class="tlc">
							 	<p>커뮤니티 인기글 	 <a href="${context }freeboardForm">더보기 > </a></p>
							 		<ul class="boardHit">
									<c:forEach var="mboard" items ="${mboards}" >
									       <li onclick="location.href='boardContent?no=${mboard.no}&category=${mboard.category}'">
									       ${mboard.no} &nbsp; ${mboard.title}&nbsp; ${mboard.id} &nbsp; ${mboard.writeDate} </li>
									    </c:forEach>
							 		</ul>
					 		</div>
			 			 <br> <br>
						 	<div class="tlp">
						 	 	<p>반려앨범<a href="${context }photoMain">더보기 > </a></p>
						 		<ul class="potHit">
    <c:forEach var="mphoto" items="${mphotos}" varStatus="loop">
        <li>
            <div class="mliweb" onclick="location.href='photoContent?no=${mphoto.no}'">
                <div class="mliimg"><img alt="/image/${mphoto.fileName}" src="/image/${mphoto.fileName}" width="160" height="200"></div>
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
							 	<a href="${context }info">더보기 > </a></p>
							 	<ul class="infoList">
							 			<li> 자유게시판같은 형식으로 카테고리, 이름만   </li>
							 		</ul>
							 </div>
 					</div>
 				<br>
				 		 <div class="shop">
							 	<p>쇼핑몰<a href="${context }shopping">더보기 > </a></p>
							 	<ul class="shopList">
							 			<li class="sh">
											<a href="${context }home">
												<div class="simgbox">
							 						<img src="/image/logo2.png" alt="logo" width="50" height="50" >
							 					</div>	
							 					<div class="stxtbox">
							 						<p>상품이름</p>
							 						<p>가격</p>
							 					</div>
							 				</a>
							 			</li>
							 		</ul>
						</div>
					 </div>
		 
 
 
</body>
</html>
<c:import url="/footer" />