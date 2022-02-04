<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<!-- jquery 적용 스크립트 -->
<script
	src="${ pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"
	integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E="
	crossorigin="anonymous"></script>

<!-- 모달창 관련 -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/simple-modal.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/simple-modal-default.min.css">
<script
	src="${ pageContext.request.contextPath }/js/simple-modal.min.js"></script>

<style>
p.textBtn {
	text-align: right;
}
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script>

/* + 버튼 누르면 금액 추가 */
$(document).ready(
		function(){
			$('span.qty-up').click(function() {
				let upPrice = Number($("#suggest").val()) + 1000
				$("#suggest").val(upPrice)
			})
		})
		
/* - 버튼 누르면 금액 감소 */
$(document).ready(
		function(){
			$('span.qty-down').click(function() {
				let downPrice = Number($("#suggest").val()) - 1000
				$("#suggest").val(downPrice)
			})
		}
)

/* 삭제하기 눌렀을 때 */
$(document).ready(
		function(){
			$('p#deleteProduct').click(function() {
				let conf = confirm('정말 삭제하시겠습니까?')
				if (conf) {
					location.href = "${ pageContext.request.contextPath }/remove.do?no=${product.pdNo}&id=${product.id}"
				}
			})
		}
)

/* 수정하기 눌렀을 때 */
$(document).ready(
		function(){
			$('p#modifyProduct').click(function() {
				location.href = "${ pageContext.request.contextPath }/auction/updateForm.do?no=${product.pdNo}"
			})
		}
)

/* 마음 찍기 - ajax로 구현 */
$(document).ready(function(){
	$('#heart-btns').click(function(e){
		
		// 로그인을 안했을 경우
		if ( ${ empty userVO } ) {
			alert('로그인을 해주시기 바랍니다.')
		}
		// 마음 추가 안되어있을 경우
		else if($('#heart-btns').children('ul').attr('id') == 'add-heart' ) {
			$.ajax({
				url: '${ pageContext.request.contextPath }/addHeart.do',
				type: 'POST',
				data: {
					id: '${userVO.id}',
					pdNo: '${product.pdNo}'
				},
				success : function(result){
					if(result.trim() > '0') {
						$('#heart-btns').children('ul').attr('id', 'cancle-heart')
						$('#heart-btn').html('<i id="heart-icon" class="fa fa-heart"></i> cancle to Heart')
						$('#heart-cnt').html(result.trim())
						alert('마음함에 추가되었습니다.')
					}
					else {
						alert('마음을 찍을 수 없습니다.')
					}
				}, error: function(){
					alert('ajax 연결 실패')
				}
			})
		}
		else {
			$.ajax({
				url: '${ pageContext.request.contextPath }/cancleHeart.do',
				type: 'POST',
				data: {
					id: '${userVO.id}',
					pdNo: '${product.pdNo}'
				},
				success : function(result){
					if(result.trim() >= '0') {
						$('#heart-btns').children('ul').attr('id', 'add-heart')
						$('#heart-btn').html('<i id="heart-icon" class="fa fa-heart-o"></i> add to Heart')
						$('#heart-cnt').html(result.trim())
						alert('마음함에서 삭제했습니다.')
					}
					else {
						alert('이미 마음이 없습니다.')
					}
				}, error: function(){
					alert('ajax 연결 실패')
				}
			})
		}
	})
})

/* 경매 마감까지 남은 시간 */
function remindTime() {
	var today = new Date(); // 현재 시간
	var dday = new Date('${ product.dueDate }');
	if (today < dday) {
		var gap = dday.getTime() - today.getTime();
		var day = Math.ceil(gap / (1000*60*60*24));
		var hour = Math.ceil((gap % (1000*60*60*24)) / (1000*60*60));
		var min = Math.ceil((gap % (1000*60*60)) / (1000*60));
		var sec = Math.ceil((gap % (1000*60)) / 1000);
		
		$("h6.time-title").html("경매 마감 D-"+day+" "+hour+":"+min+":"+sec)
	}
	else {
		$("h6.time-title").html("경매 마감")
		$("h2.product-name").html("<del>${product.pdName}</del>")		
	}
}

let timers = setInterval(remindTime, 1000);

/* 제시하기 조건 통과 후 실행되는 메소드 */
function doAction(){
	location.href = "${ pageContext.request.contextPath }/suggest.do?no=${product.pdNo}"
}

/* 제시하기 버튼 누를 때 조건 확인 */
function checkSuggest() {	
	if(${ empty userVO }){
		alert('로그인을 해주세요')
		return false
	}
	if(new Date() >= new Date('${ product.dueDate }')) {
		alert('이미 마감된 경매입니다')
		return false
	}
	
	if(${ empty suggestList[0].sugPrice }) {
		if ($("#suggest").val() <= ${product.startPrice}) {
			alert('시작가보다 높게 입력해주세요')
			return false
		}
	}
	<c:if test="${ not empty suggestList[0].sugPrice }">
	else {
		if($("#suggest").val() <= ${ suggestList[0].sugPrice }) {
			alert('최고 경매가보다 높게 입력해주세요')
			return false
		}
	}
	</c:if>
	alert('성공적으로 제시되었습니다')
	
	return true
}


/* 페이지 이동 시 interval 실행 - 뒤로가기로 돌아와도 멈춰있어요 */
$(window).on("beforeunload", function(){
	clearInterval(timers)
})
</script>


</head>
<body>
	<!-- HEADER -->
	<c:choose>
		<c:when test="${ userVO.type eq 'A' }">
			<header>
				<jsp:include page="/jsp/include/topMenuAdmin.jsp" />
			</header>	
	</c:when>
		<c:otherwise>
		<header>
			<jsp:include page="/jsp/include/topMenu.jsp" />
		</header>
	</c:otherwise>
	</c:choose>
	<!-- /HEADER -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- Product main img -->
				<div class="col-md-5 col-md-push-2">
					<div id="product-main-img">
						<c:forEach items="${ fileList }" var="file">
							<div class="product-preview">
								<img
									src="${ pageContext.request.contextPath }/upload/${ file.fileSaveName }"
									alt="">
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- /Product main img -->

				<!-- Product thumb imgs -->
				<div class="col-md-2  col-md-pull-5">
					<div id="product-imgs">
						<c:forEach items="${ fileList }" var="file">
							<div class="product-preview">
								<img
									src="${ pageContext.request.contextPath }/upload/${ file.fileSaveName }"
									alt="">
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- /Product thumb imgs -->

				<!-- Product details -->
				<div class="col-md-5">
					<div class="product-details">
						<h6 class="product-price time-title"></h6>
						<div class="count"></div>
						<h2 class="product-name">${ product.pdName }</h2>
						<h5>판매자 ${ product.id }</h5>
						<div>
							<h3 class="product-price">${ product.startPrice }&#8361
								<del class="product-old-price">${ product.hopePrice }&#8361</del>
							</h3>
							<!-- <span class="product-available">In Stock</span>  -->
						</div>
						<p>${ product.pdSimpleInfo }</p>
						<hr>


						<c:if test="${ userVO.id ne product.id }">
							<div class="add-to-cart">
								<form action="${ pageContext.request.contextPath }/suggest.do"
									method="post" name="inputSuggest"
									onsubmit="return checkSuggest()">
									<input type="hidden" name="id" value="${ userVO.id }">
									<input type="hidden" name="pdNo" value="${ product.pdNo }">
									<div class="qty-label">
										제시가
										<div class="input-number">
											<c:choose>
												<c:when test="${ empty suggestList }">
													<input id="suggest" type="number" name="sugPrice"
														value="${ product.startPrice }">
												</c:when>
												<c:otherwise>
													<input id="suggest" type="number" name="sugPrice"
														value="${ suggestList[0].sugPrice }">
												</c:otherwise>
											</c:choose>
											<span class="qty-up">+</span> <span class="qty-down">-</span>
										</div>
									</div>
									<button type="submit" class="add-to-cart-btn">
										<i class="fa fa-hand-o-up"></i>제시하기
									</button>
								</form>
							</div>
						</c:if>

						<!-- suggest 모달창 -->
						<div class="modal" data-modal>
							<div class="modal-content">
								<button role="button" class="close-icon"
									data-modal="close-modal">X</button>
								<div class="modal-body">
									<br>
									<p id="suggestFailMsg">내용입니다</p>
									<br>
								</div>
								<div class="modal-footer">
									<button role="button" class="close-button"
										data-modal="close-modal">취소</button>
									<button role="button">확인</button>
								</div>
							</div>
						</div>
						
						<!-- 마음 찍기 버튼 -->
						<c:choose>
						<c:when test="${ userVO.id eq product.id }">
						</c:when>
						<c:when test="${isHeart eq true}">
							<div id="heart-btns">
							<ul class="product-btns" id="cancle-heart">
								<li id="heart-btn"><i id="heart-icon" class="fa fa-heart"></i> cancle to Heart</li>
							</ul>
							</div>
						</c:when>
						<c:otherwise>
							<div id="heart-btns">
							<ul class="product-btns" id="add-heart">
								<li id="heart-btn"><i id="heart-icon" class="fa fa-heart-o"></i> add to Heart</li>
							</ul>
							</div>
						</c:otherwise>
						</c:choose>
						
						<ul class="product-links">
							<li><i id="heart-icon" class="fa fa-heart"></i></li>
							<li id="heart-cnt">${ product.likeCnt }</li>
							<li>Category :</li>
							<li><a href="#">${ product.cName }</a></li>
							<!-- <li><a href="#">Accessories</a></li>  -->
						</ul>
						<hr>
						<div>
							<p>경매 진행 현황 (TOP 3)</p>
							<hr>
							<c:forEach items="${ suggestList }" var="suggest">
								<h4>${ suggest.sugPrice }&#8361</h4>
								<h6>${ suggest.id }(${ suggest.sugDate })</h6>
								<hr>
							</c:forEach>

						</div>
					</div>
					<c:if test="${ userVO.type eq 'A' }">
						<div class="deletebtn">
							<p class="textBtn" id="deleteProduct">삭제하기</p>
						</div>
					</c:if>
					<c:if test="${ userVO.id eq product.id }">
						<p class="textBtn" id="modifyProduct">수정하기</p>
					</c:if>

<button id="btn-kakaopay" class="btn btn-primary">카카오페이</button>
				</div>
				
				
				<!-- /Product details -->




				<!-- Product tab -->
				<div class="col-md-12">
					<div id="product-tab">
						<!-- product tab nav -->
						<ul class="tab-nav">
							<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
							<li><a href="${ pageContext.request.contextPath }/qna/list.do?no=${ product.pdNo }">QnA</a></li>
						</ul>
						<!-- /product tab nav -->

						<!-- product tab content -->
						<div class="tab-content">
							<!-- tab1  -->
							<div id="tab1" class="tab-pane fade in active">
								<div class="row">
									<div class="col-md-12">
										<p>${ product.pdInfo }</p>
									</div>
								</div>
							</div>
							<!-- /tab1  -->
							
							



							
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
	<footer id="footer">
		<jsp:include page="/jsp/include/footer.jsp" />
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

