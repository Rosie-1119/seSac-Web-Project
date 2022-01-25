			<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>
			<!DOCTYPE html>
			<html lang="en">
			<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!-- The above 3 meta  *must* come first in the head; any other head content must come *after* these tags -->
			
			<title>loginForm</title>
			<script>
						function isNull(obj, msg) {
							if (obj.value == '') {
								alert(msg)
								obj.focus()
								return true
							}
							return false
						}
						
						function checkForm() {
							let f = document.loginForm;
							if(isNull(f.id, '아이디를 입력하세요'))
								return false
							if(isNull(f.password, '패스워드를 입력하세요'))
								return false
							return true
						}	
			</script>
		
		
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
								<h3 class="breadcrumb-header">로그인</h3>
							</div>
						</div>
						<!-- /row -->
					</div>
					<!-- /container -->
				</div>
				<!-- /BREADCRUMB -->
			<body>
				<a href="javascript:kakaoLogin();"><img src="./kakao_login.png"
					alt="카카오계정 로그인" style="height: 100px;" /></a>
			
				<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
				<script>
			        window.Kakao.init('ebdcff68f6f76a623abdabb849ea24a4');
			
			        function kakaoLogin() {
			            window.Kakao.Auth.login({
			                scope: 'profile, account_email, gender, age_range, birthday', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
			                success: function(response) {
			                    console.log(response) // 로그인 성공하면 받아오는 데이터
			                    window.Kakao.API.request({ // 사용자 정보 가져오기 
			                        url: '/v2/user/me',
			                        success: (res) => {
			                            const kakao_account = res.kakao_account;
			                            console.log(kakao_account)
			                        }
			                    });
			                    window.location.href='/' //리다이렉트 되는 코드
			                },
			                fail: function(error) {
			                    console.log(error);
			                }
			            });
			        }
			    </script>
			</body>
			
			
			
			
			
			<section>
			
			
				<div align="center" class="section">
					<!-- container -->
					<div class="container">
						<!-- row -->
						<div class="row">
							<div class="col-md-7">
								<!-- Billing Details -->
								<div class="billing-details">
			
									<br>
									<form name="loginForm" method="post"
										action="${ pageContext.request.contextPath }/loginProcess.do"
										onsubmit="return checkForm()">
			
										<div class="form-group">
											<input class="input" type="text" name="id"
												placeholder="아이디를 입력해 주세요.">
										</div>
			
			
										<div class="form-group">
											<input class="input" type="password" name="pwd"
												placeholder="패스워드를 입력해 주세요.">
										</div>
										<div class="form-group">
											<button type="submit" class="primary-btn order-submit"
												align="center">로그인</button>
									</form>
			
			
								</div>
							</div>
						</div>
					</div>
				</div>
	
			</section>

			<footer>
				<jsp:include page="/jsp/include/footer.jsp" />
			</footer>
		
			<!-- jQuery Plugins -->
			<script src="js/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/slick.min.js"></script>
			<script src="js/nouislider.min.js"></script>
			<script src="js/jquery.zoom.min.js"></script>
			<script src="js/main.js"></script>
			
			</body>
			</html>
