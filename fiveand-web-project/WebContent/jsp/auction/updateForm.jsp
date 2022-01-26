<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<style>
/*datepicker에서 사용한 이미지 버튼 style적용*/
img.ui-datepicker-trigger {
	margin-left: 5px;
	vertical-align: middle;
	cursor: pointer;
	width: 30px;
}

#pdInfo {
	width : 70%;
	height: 400px;
	resize: none;
}
</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- datepicker 한국어로 -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Electro - HTML Ecommerce Template</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/slick.css" />
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<body>
	<!-- HEADER -->
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
						<li><a href="#">All Categories</a></li>
						<li><a href="#">Accessories</a></li>
						<li><a href="#">Headphones</a></li>
						<li class="active">Product name goes here</li>
					</ul>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /BREADCRUMB -->

	<!-- SECTION -->
	<form action="${ pageContext.request.contextPath }/auction/update.do"
		method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${ product.id }">
			<input type="hidden" name="pdNo" value="${ product.pdNo }">
		<div align="center">
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">

						<!-- Product details -->

						<div class="product-details">
							<h2 class="product-name">
								상품명 : <input type="text" class="input" name="pdName" placeholder="상품명을 입력해주세요"
									required><br>
							</h2>
							<h4>
								작성자 : ${ product.id }
							</h4>
							<div>
								<h4 class="product-price">
									희망가 : ￦ ${ product.hopePrice }
								</h4>
								<br>
								<h4 class="product-price">
									경매 시작가 : ￦${ product.startPrice }
								</h4>
							</div>
							<hr>

							<div class="product-options">
								<p>
									한 줄 소개 : <input type="text" width="100px" name="pdSimpleInfo"
										placeholder="상품 한 줄 소개를 입력해주세요" required><br>
								</p>
								<p>
									<label for="dueDate"> 경매 마감일 : ${ product.dueDate }</label>
								</p>

								<p>
									상품 소개<br>
									<textarea id="pdInfo" rows="10" cols="20" name="pdInfo" width="100px"></textarea>
								</p>
								<br>
								카테고리 :
									<select name="cNo">
										<option value="1">디지털기기</option>
										<option value="2">생활가전</option>
										<option value="3">가구/인테리어</option>
										<option value="4">의류/잡화</option>
										<option value="5">뷰티/미용</option>
										<option value="6">도서/음반</option>
										<option value="7">기타</option>
									</select>
								<hr>
								<div class="add-to-cart">
									<button class="add-to-cart-btn">
										<i class="fa fa-shopping-cart"></i>수정하기
									</button>
								</div>

							</div>

					</div>
					<!-- /Product details -->

			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- Section -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-12">
						<div class="section-title text-center">
							<h3 class="title">Related Products</h3>
						</div>
					</div>

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product01.png" alt="">
								<div class="product-label">
									<span class="sale">-30%</span>
								</div>
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name">
									<a href="#">product name goes here</a>
								</h3>
								<h4 class="product-price">
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
								<div class="product-rating"></div>
								<div class="product-btns">
									<button class="add-to-wishlist">
										<i class="fa fa-heart-o"></i><span class="tooltipp">add
											to wishlist</span>
									</button>
									<button class="add-to-compare">
										<i class="fa fa-exchange"></i><span class="tooltipp">add
											to compare</span>
									</button>
									<button class="quick-view">
										<i class="fa fa-eye"></i><span class="tooltipp">quick
											view</span>
									</button>
								</div>
							</div>
							<div class="add-to-cart">
								<button class="add-to-cart-btn">
									<i class="fa fa-shopping-cart"></i> add to cart
								</button>
							</div>
						</div>
					</div>
					<!-- /product -->

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product02.png" alt="">
								<div class="product-label">
									<span class="new">NEW</span>
								</div>
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name">
									<a href="#">product name goes here</a>
								</h3>
								<h4 class="product-price">
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="product-btns">
									<button class="add-to-wishlist">
										<i class="fa fa-heart-o"></i><span class="tooltipp">add
											to wishlist</span>
									</button>
									<button class="add-to-compare">
										<i class="fa fa-exchange"></i><span class="tooltipp">add
											to compare</span>
									</button>
									<button class="quick-view">
										<i class="fa fa-eye"></i><span class="tooltipp">quick
											view</span>
									</button>
								</div>
							</div>
							<div class="add-to-cart">
								<button class="add-to-cart-btn">
									<i class="fa fa-shopping-cart"></i> add to cart
								</button>

							</div>
						</div>
					</div>
					<!-- /product -->

					<div class="clearfix visible-sm visible-xs"></div>

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product03.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name">
									<a href="#">product name goes here</a>
								</h3>
								<h4 class="product-price">
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star-o"></i>
								</div>
								<div class="product-btns">
									<button class="add-to-wishlist">
										<i class="fa fa-heart-o"></i><span class="tooltipp">add
											to wishlist</span>
									</button>
									<button class="add-to-compare">
										<i class="fa fa-exchange"></i><span class="tooltipp">add
											to compare</span>
									</button>
									<button class="quick-view">
										<i class="fa fa-eye"></i><span class="tooltipp">quick
											view</span>
									</button>
								</div>
							</div>
							<div class="add-to-cart">
								<button class="add-to-cart-btn">
									<i class="fa fa-shopping-cart"></i> add to cart
								</button>
							</div>
						</div>
					</div>
					<!-- /product -->

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product04.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name">
									<a href="#">product name goes here</a>
								</h3>
								<h4 class="product-price">
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
								<div class="product-rating"></div>
								<div class="product-btns">
									<button class="add-to-wishlist">
										<i class="fa fa-heart-o"></i><span class="tooltipp">add
											to wishlist</span>
									</button>
									<button class="add-to-compare">
										<i class="fa fa-exchange"></i><span class="tooltipp">add
											to compare</span>
									</button>
									<button class="quick-view">
										<i class="fa fa-eye"></i><span class="tooltipp">quick
											view</span>
									</button>
								</div>
							</div>
							<div class="add-to-cart">
								<button class="add-to-cart-btn">
									<i class="fa fa-shopping-cart"></i> add to cart
								</button>
							</div>
						</div>
					</div>
					<!-- /product -->

				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /Section -->


		<!-- FOOTER -->
		<footer>
			<jsp:include page="${ pageContext.request.contextPath }/jsp/include/footer.jsp" />
		</footer>
		<!-- /FOOTER -->

		<!-- jQuery Plugins -->
		<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/slick.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/nouislider.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/main.js"></script>
</body>
</html>
