<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- !!폼 만들 때 index.html에 있는 링크 복붙해 놓고 TopMenu/footer 넣기!! -->


		<!-- HEADER -->
		
		<!-- TOP HEADER -->
		<div id="top-header">
			<div class="container">
		
				<ul class="header-links pull-right">
		
					<c:if test="${ not empty userVO }">
		   							[${ userVO.id }님으로 로그인 중...]
							</c:if>
					<!-- 회원가입 버튼 -->
		
				<c:choose>
				<c:when test="${ empty userVO }">
      
			<li><a href="${ pageContext.request.contextPath }/signup.do"><i
					class="fa fa-arrow-right"></i> Join</a></li>
			<!-- 로그인 버튼 -->
			<li><a href="${ pageContext.request.contextPath }/login.do"><i
					class="fa fa-user-o"></i> Login</a></li>
								   </c:when>
						<c:otherwise>
			<!-- 로그아웃 버튼 -->
			<li><a href="${ pageContext.request.contextPath }/logout.do"><i
					class="fa fa-user-o"></i> Logout</a></li>
								     
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>

<header>
			<!-- /TOP HEADER -->
			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
					
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="${ pageContext.request.contextPath }/main.do" class="logo">
									<img src="${ pageContext.request.contextPath }/img/fiveand_Logo5.png" alt="fiveand_Logo" width="150" height="80">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form>
								
									<!-- 검색할 때 선택할 수 있는 카테고리 -->
									<select class="input-select">
										<option value="0">전체</option>
										<option value="1">디지털기기</option>
										<option value="2">생활가전</option>
										<option value="3">가구/인테리어</option>
										<option value="4">의류/잡화</option>
										<option value="5">뷰티/미용</option>
										<option value="6">도서/음반</option>
										<option value="7">기타</option>
									</select>
									<input class="input" placeholder="Search here">
									<button type="button" onclick="location.href='${ pageContext.request.contextPath }/search.do'"class="search-btn">Search</button>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->


						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
							
								<!-- Wishlist : 하트를 누른 경매물품 리스트 보기 -->
								<div>
									<a href="#">
										<i class="fa fa-heart-o"></i>
										<span>위시리스트</span>
										<!-- 몇 개 눌렀는지 나오게 하려면, 하트를 누른 경매 물품을 저장해둔 테이블이 존재해야함
											 셀렉트해서 갯수를 넣어주면 됨
										<div class="qty"></div> -->
									</a>
								</div>
								<!-- /Wishlist -->



								<!-- Auction : 경매 등록하기 -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"
									 href="${ pageContext.request.contextPath }/auction/writeForm.do">
										<i class="fa fa-handshake-o"></i>
										<span>경매 등록</span>
									</a>
									<!-- 현재 경매 등록한 현황 드롭다운으로 생성 가능(미정)
									<div class="cart-dropdown">
										<div class="cart-list">
											<div class="product-widget">
												<div class="product-img">
													<img src="./img/product01.png" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">product name goes here</a></h3>
													<h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
												</div>
												<button class="delete"><i class="fa fa-close"></i></button>
											</div>

											<div class="product-widget">
												<div class="product-img">
													<img src="./img/product02.png" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">product name goes here</a></h3>
													<h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
												</div>
												<button class="delete"><i class="fa fa-close"></i></button>
											</div>
										</div>
										<div class="cart-summary">
											<small>3 Item(s) selected</small>
											<h5>SUBTOTAL: $2940.00</h5>
										</div>
										<div class="cart-btns">
											<a href="#">View Cart</a>
											<a href="#">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div> -->
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<!-- 탑 네비게이션 바 => 카테고리별 분류  -->
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Categories</a></li>
						<li><a href="#">디지털 기기</a></li>
						<li><a href="#">생활가전</a></li>
						<li><a href="#">가구/인테리어</a></li>
						<li><a href="#">의류/잡화</a></li>
						<li><a href="#">뷰티/미용</a></li>
						<li><a href="#">도서/음반</a></li>
						<li><a href="#">기타</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->