			<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>
			<!DOCTYPE html>
			<html lang="en">
			<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!-- The above 3 meta  *must* come first in the head; any other head content must come *after* these tags -->
			
			<title>로그인창</title> 
			<script>
			// 아이디, 패스워드 값 입력하기
			
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
											<button type="submit" class="primary-btn order-submit" id="btnLogin"
												align="center">로그인</button>
									</form>
			
			
								</div>
							</div>
						</div>
					</div>
				</div>
	
		</section>
		
	 <section class="login-write">
            <div class="button-login" align ="center" >
                <a id="kakao-login-btn" >
    <img src="//k.kakaocdn.net/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="20%" height ="50px" />
    </a>
            </div>
            
        </section>
        

<script>logInOut()</script>      
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type='text/javascript'>
Kakao.init('23d3236e95d78f95d78a5ca69eb39dc6');
$("#kakao-login-btn").on("click", function(){
    //1. 로그인 시도
    Kakao.Auth.login({
        success: function(authObj) {
          //console.log(JSON.stringify(authObj));
          //console.log(Kakao.Auth.getAccessToken());
          //2. 로그인 성공시, API를 호출합니다.
          Kakao.API.request({
            url: '/v2/user/me',
            success: function(res) {
              //console.log(JSON.stringify(res));
              console.log(res);
              var id = res.id;
			  scope : 'account_email';
			alert('로그인성공');
              //var email = res.kakao_account.email;
			  //var name = res.properties.nickname;
			  location.href="http://localhost:9999/fiveand-web-project/jsp/member/kakaocallback.jsp";
		
              
        }
          })
          console.log(authObj);
          var token = authObj.access_token;
        },
        fail: function(err) {
          alert(JSON.stringify(err));
        }
      });
        
})
</script>
		








			<footer id="footer">
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
