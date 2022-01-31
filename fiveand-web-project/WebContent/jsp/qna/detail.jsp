<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>문의글 상세 페이지</title>

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
	
<script>
$(document).ready(function(){
	
	function doAction(type) {
		switch(type) {
			case 'U':
				location.href="qnaUpdateForm.jsp?no=${ param.no }"
				break;
			case 'D':
				location.href="qnaDeleteForm.jsp?no=${ param.no }"
				break;
			case 'R':
				//location.href="reply.jsp?id=${ param.id }"
				$('#qnaReplyForm').css('display', 'block');
				break;
			case 'L':
				location.href="${pageContext.request.contextPath}/auction/detail.do?no="+${product.pdNo}
				break;
		}
	}
	
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
	<section>
		<div align = "center">
		<hr>
		<h2>QnA</h2>
		<hr>
		<br>
			<table border="1">
				<tr>
					<th width="25%">번호</th>
					<td>${ result.bNo }</td>
				</tr>
				<tr>
					<th width="25%">제목</th>
					<td>${ result.title }</td>
				</tr>
				<tr>
					<th width="25%">작성자</th>
					<td>${ result.id }</td>
				</tr>
				<tr>
					<th width="25%">등록일</th>
					<td>${ result.regDate }</td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>${ result.content }</td>
				</tr>
			</table>
			<br>
			
		<c:if test="${ result.id eq userVO.id }">
			<button onclick="doAction('U')">수정</button>
			<button onclick="doAction('D')">삭제</button>
			<button onclick="doAction('R')">답글</button>
			
		</c:if>
			<button onclick="doAction('L')">목록</button>
	</div>

		<div align="center" id="qnaReplyForm">
			<hr>
			<h2>QnA 답글 등록</h2>
			<hr>
			<br>
			<!-- submit이라는 타입을 가진 것을 눌렀을 때 실행되도록 하는 메소드 onsubmit -->
			<form action="${ pageContext.request.contextPath }/qna/write.do"
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
	</section>
	
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