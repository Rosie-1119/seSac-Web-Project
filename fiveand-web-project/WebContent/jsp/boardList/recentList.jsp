<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>최근 경매</title>

 		<!-- Google font -->
 		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

 		<!-- Bootstrap -->
 		<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css"/>

 		<!-- Slick -->
 		<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/slick.css"/>
 		<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/slick-theme.css"/>

 		<!-- nouislider -->
 		<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/nouislider.min.css"/>

 		<!-- Font Awesome Icon -->
 		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/font-awesome.min.css">

 		<!-- Custom stlylesheet -->
 		<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css"/>



    </head>
	<body>
		<!-- HEADER -->
		<header>
			<jsp:include page="/jsp/include/topMenu.jsp" />
		</header>
		<!-- /HEADER -->


		<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<ul class="breadcrumb-tree">
							<li><a href="#">Home</a></li>
							<li class="active">Recent List</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->



		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- STORE -->
					<div id="store" class="col-md-9">
					
						<!-- store top filter -->
						<div class="store-filter clearfix">
							<div class="store-sort">
								<label>
									Sort By:
									<select class="input-select">
										<option value="0">Popular</option>
										<option value="1">Position</option>
									</select>
								</label>

								<label>
									Show:
									<select class="input-select">
										<option value="0">20</option>
										<option value="1">50</option>
									</select>
								</label>
							</div>
							<ul class="store-grid">
								<li class="active"><i class="fa fa-th"></i></li>
								<li><a href="#"><i class="fa fa-th-list"></i></a></li>
							</ul>
						</div>
						<!-- /store top filter -->

						<!-- store products -->
						<div class="row">
						
						
							<!-- product -->
							<c:forEach var="i" begin="0" end="9">
							<div class="col-md-4 col-xs-6">
							
								<div class="product">
									<div class="product-img">
										<%-- 이미지 링크하기 --%>
										<img src="${ pageContext.request.contextPath }/img/product01.png" alt="">
										<div class="product-label">
											<%-- 마감일까지의 차이 등록 --%>
											<span class="sale">마감 ${ recentList[i].dueDate }</span>
											<%-- 등록일 기준 오늘 등록한 제품 NEW 
											<span class="new">NEW</span>--%>
											
										</div>
									</div>
									<div class="product-body">
										<p class="product-category">${ recentList[i].cName }</p>
										<h3 class="product-name"><a href="#">${ recentList[i].pdName }</a></h3>
										<h4 class="product-price">시작가 ${ recentList[i].startPrice }</h4>
										
										<div class="product-btns">
											<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to My Heart</span></button>
											<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
										</div>
									</div>
									<div class="add-to-cart"><a href="${ pageContext.request.contextPath }/auction/viewcnt.do?no=${ recentList[i].pdNo }">
										<button class="add-to-cart-btn"><i class="fa fa-hand-o-up"></i>경매 참여</button></a>
									</div>
									
								</div>
								<c:if test="${ (i+1) mod 3 eq 0 }">
										<div class="clearfix visible-lg visible-md"></div>
									</c:if>
						
							</div>
							</c:forEach>
							<!-- /product -->

							
						</div>
						<!-- /store products -->
						



						
						<!-- 페이징 기능 -->
						<div class="store-filter clearfix">
							<span class="store-qty">Showing 20-100 products</span>
							<ul class="store-pagination">
								<li class="active">1</li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
							</ul>
						</div>
						<!-- /store bottom filter -->
					</div>
					<!-- /STORE -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->









		<!-- FOOTER -->
		<footer id="footer">
			<jsp:include page="/jsp/include/footer.jsp" />
		</footer>
		<!-- /FOOTER -->

		<!-- jQuery Plugins -->
		<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/slick.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/nouislider.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/jquery.zoom.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/main.js"></script>

	</body>
</html>
