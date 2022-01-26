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

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

//번호에 해당하는 답글 -> 등록 페이지 뜨이게 하기 -> ㄴ 답글 형태
$(document).ready(function(){
	$(document).on('click', '.replyBtn', function() {
		
		let bNo = $(this).attr('id')
		alert(bNo)
		$('#qnaReplyForm').css('display', 'block');
		$('.list').css('display', 'none');
		$('#goWriteForm').css('display', 'none')
		//display 답글 등록 qnaForm
		
		
		//bNo 게시글 DB에 insert
		$.ajax({
			
		})
		
		
	})
})

$(document).ready(function() {
	// QnA 탭 클릭 시
	
	
	$('#qnaList').click(function() {
		
		$.ajax({
			type: "post",
			url: "${ pageContext.request.contextPath }/qna/list.do",
			data: {
				no: ${param.no}
			},
			datatype: "json",
			success: function(data) {
				$('.list').children('tbody').empty()
				let list = JSON.parse(data)
				list.forEach(function(data) {
					//console.log(data)
					let tag = '<tr>';
					
					tag += '<td>';
					tag += data.bNo
					tag += '</td>';
					tag += '<td>';
					tag += data.title
					tag += '</td>';
					tag += '<td>';
					tag += data.content
					tag += '</td>';
					tag += '<td>';
					tag += data.id
					tag += '</td>';
					tag += '</td>';
					tag += '<td>';
					tag += data.regDate
					tag += '</td>';
					tag += '</td>';
					tag += '<td>';
					tag += '<button id="' + data.bNo + '"  class="replyBtn">';
					tag += '답글 달기';
					tag += '</button>';
					
					tag += '</tr>';
					//$('.list').children().eq(0).append(tag)
					$('.list').children('tbody').append(tag);
					//<button id="goWriteForm">문의하기</button>
				}) 
			}
		})
		
		

	
	})
})


$(document).ready(function() {
	// 문의
	$('#goWriteForm').click(function() {
		
		$('.list').css('display', 'none');
		$('#qnaWriteForm').css('display', 'block');
		$('#qnaDetailForm').css('display', 'none');
		$(this).css('display', 'none')
		})
		})
		
		
$(document).ready(function() {
	// 문의글 등록할 때!!
	$('#writeBtn').click(function() {
		$('.list').css('display', 'block');
		$('#qnaWriteForm').css('display', 'none');
		$(this).css('display', 'block')
		
		
		var title = $('#title').val().trim();
		var id = '${ userVO.id }';
		var content = $('#content').val().trim();

		/*console.log(title);
		
		var formData = new FormData();
		formData.append("title",title);
		formData.append("id",id);
		formData.append("content",content);
		console.log(formData);*/
		
		$.ajax({
			type: "post",
			url: "${ pageContext.request.contextPath }/qna/write.do",
			data : {
				title: title,
				id: id,
				content: content,
				no: ${ param.no }
			},
			success: function(){
				alert('게시글 등록이 완료 되었습니다.')
				
				location.href = "${ pageContext.request.contextPath }/auction/detail.do?no=${param.no}";
			}, error: function(){
				alert('게시글 등록 실패')
			}
		})
		})
		})


		
	function doAction(boardNo) {
		<c:choose>
		<c:when test="${ not empty userVO }">
		location.href = "${ pageContext.request.contextPath }/detail/detail.do?no="
				+ boardNo
		</c:when>
		<c:otherwise>
		if (confirm('로그인 서비스가 필요합니다\n로그인 페이지로 이동하시겠습니다?')) {
			location.href = '${ pageContext.request.contextPath }/member/login.do'
		}
		</c:otherwise>
		</c:choose>
	}
	
	
	
</script>
</head>
<body>
	<!-- HEADER -->
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>


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
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- Product main img -->
				<div class="col-md-5 col-md-push-2">
					<div id="product-main-img">
						<div class="product-preview">
							<img src="./img/product01.png" alt="">
						</div>

						<div class="product-preview">
							<img src="./img/product03.png" alt="">
						</div>

						<div class="product-preview">
							<img src="./img/product06.png" alt="">
						</div>

						<div class="product-preview">
							<img src="./img/product08.png" alt="">
						</div>
					</div>
				</div>
				<!-- /Product main img -->

				<!-- Product thumb imgs -->
				<div class="col-md-2  col-md-pull-5">
					<div id="product-imgs">
						<div class="product-preview">
							<img src="./img/product01.png" alt="">
						</div>

						<div class="product-preview">
							<img src="./img/product03.png" alt="">
						</div>

						<div class="product-preview">
							<img src="./img/product06.png" alt="">
						</div>

						<div class="product-preview">
							<img src="./img/product08.png" alt="">
						</div>
					</div>
				</div>
				<!-- /Product thumb imgs -->




				<!-- Product details -->
				<div class="col-md-5">
					<div class="product-details">
						<h2 class="product-name">${ product.pdName }</h2>
						<div>
							<div class="product-rating">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star-o"></i>
							</div>
							<a class="review-link" href="#">10 Review(s) | Add your
								review</a>
						</div>
						<div>
							<h3 class="product-price">
								$980.00
								<del class="product-old-price">$990.00</del>
							</h3>
							<!-- <span class="product-available">In Stock</span>  -->
						</div>
						<p>${ product.pdSimpleInfo }</p>

						<!-- <div class="product-options">
								<label>
									Size
									<select class="input-select">
										<option value="0">X</option>
									</select>
								</label>
								<label>
									Color
									<select class="input-select">
										<option value="0">Red</option>
									</select>
								</label>
								
							</div>  -->

						<div class="add-to-cart">
							<div class="qty-label">
								제시가
								<div class="input-number">
									<input type="number"> <span class="qty-up">+</span> <span
										class="qty-down">-</span>
								</div>
							</div>
							<button class="add-to-cart-btn">
								<i class="fa fa-shopping-cart"></i>제시하기
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
				<!-- /Product details -->




				<!-- Product tab -->
				<div class="col-md-12">
					<div id="product-tab">
						<!-- product tab nav -->
						<ul class="tab-nav">
							<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>

							<li id="qnaList"><a data-toggle="tab" href="#tab3">QnA</a></li>
						</ul>
						<!-- /product tab nav -->

						<!-- product tab content -->
						<div class="tab-content">
							<!-- tab1  -->
							<div id="tab1" class="tab-pane fade in active">
								<div class="row">
									<div class="col-md-12">
										<p>상품 상세설명 링크</p>
									</div>
								</div>
							</div>
							<!-- /tab1  -->



							<!-- tab3  -->
							<div id="tab3" class="tab-pane fade in">

								<section>
									<div align="center">
										<br>
										<table border="1" class="list" width="60%">
											<thead>
												<tr>
													<th width="5%">번호</th>
													<th>제목</th>
													<th>내용</th>
													<th width="10%">글쓴이</th>
													<th width="15%">등록일</th>
													<th width="12%">답글</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${ list }" var="board">
													<tr>
														<td style="text-align: center;">${ board.no }</td>

														<td><a href="javascript:doAction(${ board.no })">

																<c:out value="${ board.title }" />
														</a></td>

														<td style="text-align: center;">${ board.writer }</td>
														<td style="text-align: center;">${ board.regDate }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<br>
										<c:if test="${ not empty userVO }">
											<button id="goWriteForm">문의하기</button>
											<!-- <button>새글등록</button> -->
										</c:if>





										<!-- 작성폼 -->
										<div align="center" id="qnaWriteForm">
											<hr>
											<h2>QnA 문의글 등록</h2>
											<hr>
											<br>
											<!-- submit이라는 타입을 가진 것을 눌렀을 때 실행되도록 하는 메소드 onsubmit -->
											<table border="1">
												<tr>
													<th width=23%>제목</th>
													<td>
														<!-- notnull일때 무조건 써야할 때! required --> <input type="text"
														name="title" id="title" required>
													</td>
												</tr>
												<tr>
													<th>글쓴이</th>
													<td>${ userVO.id }<!-- <input type="text" name="writer" required> -->
													</td>
												</tr>
												<tr>
													<th>내용</th>
													<td><textarea name="content" rows="7" cols="60" id="content" required></textarea></td>
												</tr>
											</table>
											<br>
											<button type="button" id="writeBtn">새글등록</button>
										</div>

										<div align="center" id="qnaReplyForm">
											<hr>
											<h2>QnA 답글 등록</h2>
											<hr>
											<br>
											<!-- submit이라는 타입을 가진 것을 눌렀을 때 실행되도록 하는 메소드 onsubmit -->
											<form
												action="${ pageContext.request.contextPath }/qna/write.do"
												method="post" name="inputForm" onsubmit="return doWrite()">
												<input type="hidden" name="writer" value="${ userVO.id }">
												<table border="1">
													<tr>
														<th width=23%>제목</th>
														<td>
															<!-- notnull일때 무조건 써야할 때! required --> <input type="text"
															name="title" required>
														</td>
													</tr>
													<tr>
														<th>글쓴이</th>
														<td>${ userVO.id }<!-- <input type="text" name="writer" required> -->
														</td>
													</tr>
													<tr>
														<th>내용</th>
														<td><textarea name="content" rows="7" cols="60" required></textarea></td>
													</tr>
												</table>
												<br> <input type="submit" value="답글등록">
											</form>
										</div>



										<!-- 디테일폼 -->
										<div align="center" id="qnaDetailForm">
											<hr>
											<h2>게시판 상세</h2>
											<hr>
											<br>
											<table border="1">
												<tr>
													<th width="25%">번호</th>
													<td>${ board.no }</td>
												</tr>
												<tr>
													<th width="25%" style="padding-top: 15px">제목</th>
													<td><input type="text" name="title"
														value="${ board.title }" class="title"></td>
												</tr>
												<tr>
													<th width="25%">작성자</th>
													<td><input type="text" name="id" value="${ board.id }"
														class="id"></td>
												</tr>
												<tr>
													<th width="25%">내용</th>
													<td><textarea name="content" rows="7" cols="60" id="content" value="${ param.content }"></textarea></td>
												</tr>
												<tr>
													<th width="25%">등록일</th>
													<td><input type="text" name="regDate"
														value="${ board.regDate }" class="regDate"></td>
												</tr>
											</table>
											<br>
											<c:if test="${ board.id eq userVO.id }">
												<button onclick="doAction('U')">수정</button>
												<button onclick="doAction('D')">삭제</button>
											</c:if>
											<button onclick="doAction('C')">답글</button>
											<button onclick="doAction('L')">목록</button>
										</div>


									</div>
								</section>

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







	<!-- FOOTER -->
	<footer id="footer">
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/slick.min.js"></script>
	<script src="${ pageContext.request.contextPath }js/nouislider.min.js"></script>
	<script src="${ pageContext.request.contextPath }js/main.js"></script>
</body>
</html>

