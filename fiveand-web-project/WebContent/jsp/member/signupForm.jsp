<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>회원가입</title>

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
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	$(function() {
		$('#id').on('keyup', idCheck);
	})
	
	function idCheck() {
		var id = $('#id').val();
		var sendData = {'id':id}
		$.ajax({
			url: 'idCheck',
			data: sendData,
			success: function(result) {
				if(result == 'fail') {
					$('#idCheck').css('color', 'red')
					$('#idcheck').html("사용할 수 없는 ID입니다.")
	                flag=false;
				} else {
	                $('#idcheck').html("사용할 수 있는 ID입니다.")
	                flag=true;
				}
			}
		})
	}

</script>
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
					<h3 class="breadcrumb-header">회원가입</h3>
					<ul class="breadcrumb-tree">
						<li><a href="#">Home</a></li>
						<li class="active">SignUp</li>
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
				<div class="col-md-7">
					<!-- 회원가입 폼 -->
					<form name="SignupForm" method="post"
						action="${ pageContext.request.contextPath }/signupProcess.do"
						onsubmit="return checkForm()">
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Fiveand 회원가입</h3>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="id"
									placeholder="사용하실 ID를 입력해 주세요." required>
									<span id="idCheck"></span>
							</div>
							<div class="form-group">
								<input class="input" type="password" name="password"
									placeholder="패스워드를 입력해 주세요." required>
							</div>
							<div class="form-group">
								<input class="input" type="password" name="passwordCheck"
									placeholder="패스워드를 다시 입력해 주세요." required>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="name"
									placeholder="이름을 입력해 주세요." required>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="phone"
									placeholder="휴대폰 번호 '-'표 없이 입력해 주세요." required>
							</div>
							<div class="form-group">
								<input class="input" type="email" name="email"
									placeholder="이메일을 입력해 주세요." required>
							</div>
							<div class="form-group">
								<button type="submit" class="primary-btn order-submit"
									align="center">가입하기</button>
							</div>
						</div>
					</form>
					<!-- /회원가입 폼 -->

					<!-- blank  -->
					<div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</div>
					<!-- /blank  -->

				</div>

			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

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
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>