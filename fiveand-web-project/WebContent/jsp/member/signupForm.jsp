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
	/* ID중복 체크 */
	$(document).ready(function() {
		$('#id').on('keyup', idCheck)
	})
	
		flag = false;
	function idCheck() {
		var id = $('#id').val()
		var sendData = {'id':id}
		
		$.ajax({
			url: '${pageContext.request.contextPath}/idCheck.do',
			data: sendData,
			type: 'post',
			success: function(result) {
				result = result.trim()
				data = result
				if(result == '1') {
					$('#idCheck').css('color', 'red'),
					$('#idCheck').html('* 사용할 수 없는 ID입니다.'),
					$('#signBtn').attr('type', 'button')
					flag = false;
				} else {
					$('#idCheck').css('color', '#8d99ae'),
	                $('#idCheck').html('* 사용할 수 있는 ID입니다.')
	                $('#signBtn').attr('type', 'submit')
	                flag = true;
				}
			}
		})
	}
	
	
	$(document).ready(function() {
		$('#pwd, #pwd2').on('keyup', pwdCheck)
	})
	
		flag2 = false;
	function pwdCheck() {
		let pass1 = $('#pwd').val();
		let pass2 = $('#pwd2').val();
		
		if(pass1 != "" || pass2 != "") {
			if(pass1 == pass2) {
				$('#pwdCheck').css('color', '#8d99ae'),
				$('#pwdCheck').html('* 패스워드가 일치합니다.')
				$('#signBtn').attr('type', 'submit')
				flag2 = true;
			} else {
				$('#pwdCheck').css('color', 'red'),
				$('#pwdCheck').html('* 패스워드가 일치하지 않습니다.')
				$('#signBtn').attr('type', 'button')
				flag2 = false;
			}
		}
	}

	$(document).ready(function() {
		if(flag == true && flag2 == true) {
			alert("sggrsdghrrh")
			e.cancelBubble = true
		} else {
			e.cancelBubble = true
		}
	})

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
						action="${ pageContext.request.contextPath }/signupProcess.do">
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Fiveand 회원가입</h3>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="id" id="id"
									placeholder="사용하실 ID를 입력해 주세요." required>
									<span id="idCheck"> </span>
							</div>
							<div class="form-group">
								<input class="input" type="password" name="pwd" id="pwd"
									placeholder="패스워드를 입력해 주세요." required>
							</div>
							<div class="form-group">
								<input class="input" type="password" name="pwdCheck" id="pwd2"
									placeholder="패스워드를 다시 입력해 주세요." required>
									<span id="pwdCheck"> </span>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="name"
									placeholder="이름을 입력해 주세요." required>
							</div>
							<div class="form-group">
								<input class="input" type="tel" name="phone"
									placeholder="휴대폰 번호 '-'표 없이 입력해 주세요." required>
							</div>
							<div class="form-group">
								<input class="input" type="email" name="email"
									placeholder="이메일을 입력해 주세요." required>
							</div>
							<div class="form-group">
								<button type="submit" class="primary-btn order-submit" id="signBtn"
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