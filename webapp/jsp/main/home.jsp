<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <c:import url="/header" />
  
  
  	<link rel="stylesheet" href="css/home.css">
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
<div class="mainlogo"><a href="${context }home" id="logo"><img src="img/logo.png" alt="logo" width="300" height="300" ></a></div>


		 <div class="web">
 					<div class="top">
			 			<div class="tl">
						 	<p>공지사항</p>
						 	<br>
						 	<div class="tlc">
							 	<p>커뮤니티 인기글 	 <a href="${context }home">더보기 > </a></p>
							 		<ul class="boardHit">
							 			<li>1번</li>
							 			<li>2번</li>
							 			<li>3번</li>
							 			<li>4번</li>
							 			<li>5번</li>
							 			<li>6번</li>
							 			<li>7번</li>
							 			
							 		</ul>
					 		</div>
			 			 <br> <br>
						 	<div class="tlp">
						 	 	<p>반려앨범<a href="${context }photo">더보기 > </a></p>
						 		<ul class="potHit">
						 			<li></li>
						 		</ul>
						 	</div>
			 	
						 </div>
	 
			 
							 <div class="tr">
							 	<p>업체정보
							 	<a href="${context }home">더보기 > </a></p>
							 	<ul class="infoList">
							 			<li></li>
							 		</ul>
							 </div>
 					</div>
 				<br>
				 		 <div class="shop">
							 	<p>업체정보<a href="${context }home">더보기 > </a></p>
							 	<ul class="shopList">
							 			<li class="sh">
											<a href="${context }home">
												<div class="simgbox">
							 						<img src="img/logo.png" alt="logo" width="50" height="50" >
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