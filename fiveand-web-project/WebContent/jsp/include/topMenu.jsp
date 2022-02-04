<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- !!폼 만들 때 index.html에 있는 링크 복붙해 놓고 TopMenu/footer 넣기!! -->


		<!-- HEADER -->
		
		<!-- TOP HEADER -->
		<div id="top-header">
			<div class="container">
		
				<ul class="header-links pull-right">
					<span>
					<c:if test="${ not empty userVO.id }">
		   				[${ userVO.id }님으로 로그인 중]&emsp;
					</c:if>
					</span>
					
					<!-- 회원가입 버튼 -->
		
				<c:choose>
				<c:when test="${ empty userVO.id }">
      
			<li><a href="${ pageContext.request.contextPath }/signup.do"><i
					class="fa fa-arrow-right"></i> Join</a></li>
			<!-- 로그인 버튼 -->
			<li><a href="${ pageContext.request.contextPath }/login.do"><i
					class="fa fa-user-o" id="btnLogin"></i> Login</a></li>
								   </c:when>
						<c:otherwise>
			<!-- 로그아웃 버튼 -->
			<li><a href="${ pageContext.request.contextPath }/logout.do"><i
					class="fa fa-user-o" id="btnLogout"></i> Logout</a></li>
			 <li><a href="${ pageContext.request.contextPath }/myPage.do"><i
					class="fa fa-user-o"></i> 마이페이지</a></li>
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
							<div class="header-ctn" style="width: 280px;">
							
								
								<div>
								<c:if test="${ empty userVO.id }">
									<a onclick="alert('로그인이 필요합니다.')" id="suggList" href="${ pageContext.request.contextPath }/login.do">
										<i class="fa fa-heart-o"></i>
										<span>참여한 경매</span>
									</a>
								</c:if>
								
								
								<c:if test="${ not empty userVO.id }">
									<a id="suggList" href="${ pageContext.request.contextPath }/mySuggList.do?id=${userVO.id}" >
										<i class="fa fa-heart-o"></i>
										<span>참여한 경매</span>
									</a>
								</c:if>
								
								</div>

								<!-- Auction : 경매 등록하기 -->
								<div class="dropdown">
								<c:if test="${ empty userVO.id }">
		   							<a onclick="alert('로그인이 필요합니다.')" id="auctionReg" href="${ pageContext.request.contextPath }/login.do">
										<i class="fa fa-handshake-o"></i>
										<span>경매 등록</span>
									</a>
								</c:if>
								<c:if test="${ not empty userVO.id }">
									<a id="auctionReg" href="${ pageContext.request.contextPath }/auction/writeForm.do">
										<i class="fa fa-handshake-o"></i>
										<span>경매 등록</span>
									</a>
								</c:if>
								
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
						<li class="active"><a href="${ pageContext.request.contextPath }/main.do">Home</a></li>
						
						<!--여기 수정하기!!!!!!-->
						<li><a href="javascript:digital();">디지털기기</a></li>
						<li><a href="javascript:living();">생활가전</a></li>
						<li><a href="javascript:interior();">가구/인테리어</a></li>
						<li><a href="javascript:clothes();">의류/잡화</a></li>
						<li><a href="javascript:beauty();">뷰티/미용</a></li>
						<li><a href="javascript:book();">도서/음반</a></li>
						<li><a href="javascript:etc();">기타</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->