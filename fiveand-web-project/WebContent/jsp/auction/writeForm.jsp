<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	function doWrite() {

		let f = document.inputForm

		if (f.productName.value == '') {
			alert('상품명을 입력하세요')
			f.productName.focus()
			return false
		}
		if (f.writer.value == '') {
			alert('작성자를 입력하세요')
			f.writer.focus()
			return false
		}
		if (f.hopePrice.value == '') {
			alert('가격을 입력하세요')
			f.hopePrice.focus()
			return false
		}
		if (f.content.value == '') {
			modal('내용을 입력하세요')
			f.content.focus()
			return false
		}
		return true
	}

	document.getElementById('nowDate').value = new Date().toISOString()
			.substring(0, 10);
	;
</script>
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
	<form action="${ pageContext.request.contextPath }/auction/write.do"
		method="post" name="inputForm" enctype="multipart/form-data">
		<div align="center">
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">

						<!-- Product details -->

						<div class="product-details">
							<h2 class="product-name">
								상품명 : <input type="text" name="pdName"><br>
							</h2>
							<h4>
								작성자 : <input type="text" name="id"><br>
							</h4>
							<div>
								<h3 class="product-price">
									￦<input type="text" name="hopePrice" width="10px">
									<del class="product-old-price">원</del>
								</h3>
							</div>
							<hr>

							<div class="product-options">
								<p>
									한 줄 소개 : <input type="text" width="100px" name="pdSimpleInfo"><br>
								</p>
								<p>
									마감일 : <input type="date" id='nowDate'>
								</p>
								<p>
									상품 소개 :
									<textarea rows="10" cols="20" name="pdInfo">
							</textarea>
								</p>
								사진 : <input type="file" name="attachfile1"> <input
									type="file" name="attachfile2"> <input type="file"
									name="attachfile3"> <input type="file"
									name="attachfile4"> <input type="file"
									name="attachfile5">
								<div class="add-to-cart">

									<button class="add-to-cart-btn" onclick="return doWrite()">
										<i class="fa fa-shopping-cart"></i>add to cart
									</button>
								</div>

								<ul class="product-btns">
									<li><a href="#"><i class="fa fa-heart-o"></i> add to
											wishlist</a></li>
									<li><a href="#"><i class="fa fa-exchange"></i> add to
											compare</a></li>
								</ul>

								<ul class="product-links">
									<li>Category:</li>
									<li><a href="#">Headphones</a></li>
									<li><a href="#">Accessories</a></li>
								</ul>

								<ul class="product-links">
									<li>Share:</li>
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
									<li><a href="#"><i class="fa fa-envelope"></i></a></li>
								</ul>

							</div>
						</div>
					</div>
	</form>

	</div>
	<!-- /Product details -->

	<!-- Product tab -->
	<div class="col-md-12">
		<div id="product-tab">
			<!-- product tab nav -->
			<ul class="tab-nav">
				<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
				<li><a data-toggle="tab" href="#tab2">Details</a></li>
				<li><a data-toggle="tab" href="#tab3">Reviews (3)</a></li>
			</ul>
			<!-- /product tab nav -->

			<!-- product tab content -->
			<div class="tab-content">
				<!-- tab1  -->
				<div id="tab1" class="tab-pane fade in active">
					<div class="row">
						<div class="col-md-12">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Ut enim ad minim veniam, quis nostrud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
								aute irure dolor in reprehenderit in voluptate velit esse cillum
								dolore eu fugiat nulla pariatur. Excepteur sint occaecat
								cupidatat non proident, sunt in culpa qui officia deserunt
								mollit anim id est laborum.</p>
						</div>
					</div>
				</div>
				<!-- /tab1  -->

				<!-- tab2  -->
				<div id="tab2" class="tab-pane fade in">
					<div class="row">
						<div class="col-md-12">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Ut enim ad minim veniam, quis nostrud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
								aute irure dolor in reprehenderit in voluptate velit esse cillum
								dolore eu fugiat nulla pariatur. Excepteur sint occaecat
								cupidatat non proident, sunt in culpa qui officia deserunt
								mollit anim id est laborum.</p>
						</div>
					</div>
				</div>
				<!-- /tab2  -->

				<!-- tab3  -->
				<div id="tab3" class="tab-pane fade in">
					<div class="row">
						<!-- Rating -->
						<div class="col-md-3">
							<div id="rating">
								<div class="rating-avg">
									<span>4.5</span>
									<div class="rating-stars">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star-o"></i>
									</div>
								</div>
								<ul class="rating">
									<li>
										<div class="rating-stars">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
										<div class="rating-progress">
											<div style="width: 80%;"></div>
										</div> <span class="sum">3</span>
									</li>
									<li>
										<div class="rating-stars">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star-o"></i>
										</div>
										<div class="rating-progress">
											<div style="width: 60%;"></div>
										</div> <span class="sum">2</span>
									</li>
									<li>
										<div class="rating-stars">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i
												class="fa fa-star-o"></i>
										</div>
										<div class="rating-progress">
											<div></div>
										</div> <span class="sum">0</span>
									</li>
									<li>
										<div class="rating-stars">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
												class="fa fa-star-o"></i>
										</div>
										<div class="rating-progress">
											<div></div>
										</div> <span class="sum">0</span>
									</li>
									<li>
										<div class="rating-stars">
											<i class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i
												class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
												class="fa fa-star-o"></i>
										</div>
										<div class="rating-progress">
											<div></div>
										</div> <span class="sum">0</span>
									</li>
								</ul>
							</div>
						</div>
						<!-- /Rating -->

						<!-- Reviews -->
						<div class="col-md-6">
							<div id="reviews">
								<ul class="reviews">
									<li>
										<div class="review-heading">
											<h5 class="name">John</h5>
											<p class="date">27 DEC 2018, 8:0 PM</p>
											<div class="review-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star-o empty"></i>
											</div>
										</div>
										<div class="review-body">
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing
												elit, sed do eiusmod tempor incididunt ut labore et dolore
												magna aliqua</p>
										</div>
									</li>
									<li>
										<div class="review-heading">
											<h5 class="name">John</h5>
											<p class="date">27 DEC 2018, 8:0 PM</p>
											<div class="review-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star-o empty"></i>
											</div>
										</div>
										<div class="review-body">
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing
												elit, sed do eiusmod tempor incididunt ut labore et dolore
												magna aliqua</p>
										</div>
									</li>
									<li>
										<div class="review-heading">
											<h5 class="name">John</h5>
											<p class="date">27 DEC 2018, 8:0 PM</p>
											<div class="review-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star-o empty"></i>
											</div>
										</div>
										<div class="review-body">
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing
												elit, sed do eiusmod tempor incididunt ut labore et dolore
												magna aliqua</p>
										</div>
									</li>
								</ul>
								<ul class="reviews-pagination">
									<li class="active">1</li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
								</ul>
							</div>
						</div>
						<!-- /Reviews -->

						<!-- Review Form -->
						<div class="col-md-3">
							<div id="review-form">
								<form class="review-form">
									<input class="input" type="text" placeholder="Your Name">
									<input class="input" type="email" placeholder="Your Email">
									<textarea class="input" placeholder="Your Review"></textarea>
									<div class="input-rating">
										<span>Your Rating: </span>
										<div class="stars">
											<input id="star5" name="rating" value="5" type="radio"><label
												for="star5"></label> <input id="star4" name="rating"
												value="4" type="radio"><label for="star4"></label> <input
												id="star3" name="rating" value="3" type="radio"><label
												for="star3"></label> <input id="star2" name="rating"
												value="2" type="radio"><label for="star2"></label> <input
												id="star1" name="rating" value="1" type="radio"><label
												for="star1"></label>
										</div>
									</div>
									<button class="primary-btn">Submit</button>
								</form>
							</div>
						</div>
						<!-- /Review Form -->
					</div>
				</div>
				<!-- /tab3  -->
			</div>
			<!-- /product tab content  -->
		</div>
	</div>
	<!-- /product tab -->
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
      <jsp:include page="/jsp/include/footer.jsp" />
   </footer>
   <!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>
