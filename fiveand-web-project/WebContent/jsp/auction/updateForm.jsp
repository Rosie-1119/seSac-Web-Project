<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>경매 수정하기</title>

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

</head>
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

.updateForm {
	width: 800px;
	align-content: center;
	align-items: center;
	text-align: center;
}

.container_f {
	align-content: center;
	align-items: center;
	padding-right: 15px;
	padding-left: 15px;
	margin-right: 30%;
	margin-left: 30%;
}

table {
	border-top: 1px solid #E4E7ED;
    border-collapse: collapse;
}

th, td {
	height: 40px;
	align-content: left;
	align-items: left;
	text-align: left;
	vertical-align: middle;
	border-bottom: 1px solid #E4E7ED;
}

th {
	font-size: 15pt;
}
</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- datepicker 한국어로 -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<script>
	$(function() {

		//오늘 날짜를 출력
		$("#today").text(new Date().toLocaleDateString());

		//datepicker 한국어로 사용하기 위한 언어설정
		$.datepicker.setDefaults($.datepicker.regional['ko']);

		// 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
		// 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가

		//시작일.
		/* $('#fromDate').datepicker({
		   showOn : "both", // 달력을 표시할 타이밍 (both: focus or button)
		   buttonImage : "images/calendar.gif", // 버튼 이미지
		   buttonImageOnly : true, // 버튼 이미지만 표시할지 여부
		   buttonText : "날짜선택", // 버튼의 대체 텍스트
		   dateFormat : "yy-mm-dd", // 날짜의 형식
		   changeMonth : true, // 월을 이동하기 위한 선택상자 표시여부
		   //minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이전 날짜 선택 불가)
		   onClose : function(selectedDate) {
		      // 시작일(fromDate) datepicker가 닫힐때
		      // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
		      $("#toDate").datepicker("option", "minDate", selectedDate);
		   }
		}); */

		//종료일
		$('#dueDate')
				.datepicker(
						{
							showOn : "both",
							buttonImage : "${pageContext.request.contextPath}/img/calendar.png",
							buttonImageOnly : true,
							dateFormat : "yy-mm-dd",
							changeMonth : true,
							minDate : 1,
							maxDate : 20, // 오늘 이전 날짜 선택 불가
							onClose : function(selectedDate) {
								// 종료일(toDate) datepicker가 닫힐때
								// 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
								$('#today').datepicker("option", "maxDate",
										selectedDate);
							}
						})
	})
</script>
<body>
	<!-- HEADER -->
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<!-- /HEADER -->


	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container_f">
			<!-- row -->
			<div class="row">
				<!-- 경매 등록 폼 -->
				<form
					action="${ pageContext.request.contextPath }/auction/update.do"
					class="updateForm" method="post">
					<input type="hidden" name="id" value="${ product.id }"> <input
						type="hidden" name="pdNo" value="${ product.pdNo }">
					<div class="product-details">
						<div class="section-title">
							<h3 class="title">경매 수정하기</h3>
						</div>
						<table width="800px;">
							<tr>
								<th>작 성 자</th>
								<td>&nbsp;<strong>${ userVO.id }</strong></td>
							</tr>
							<tr>
								<th>상 품 명</th>
								<td>&nbsp;<input type="text" name="pdName"
									style="width: 100%; height: 30px; margin-bottom: 20px;"
									placeholder="상품명을 입력해주세요" required></td>
							</tr>
							<tr>
								<th>희 망 가</th>
								<td>￦&nbsp;<strong>${ product.hopePrice }&nbsp;</strong>원
								</td>
							</tr>
							<tr>
								<th>시 작 가</th>
								<td>￦&nbsp;<strong>${ product.startPrice }&nbsp;</strong>원
								</td>
							</tr>
							<tr>
								<th>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
								<td>&nbsp;<input type="text" name="pdSimpleInfo"
									style="width: 100%; height: 30px; margin-bottom: 20px;"
									placeholder="상품 한 줄 소개를 입력해주세요" required></td>
							</tr>
							<tr>
								<th>상세설명</th>
								<td>&nbsp;<textarea
										style="width: 100%; margin-bottom: 20px;" rows="10"
										name="pdInfo"></textarea></td>
							</tr>
							<tr>
								<th>카테고리</th>
								<td>&nbsp;<select name="cNo">
										<option value="1">디지털기기</option>
										<option value="2">생활가전</option>
										<option value="3">가구/인테리어</option>
										<option value="4">의류/잡화</option>
										<option value="5">뷰티/미용</option>
										<option value="6">도서/음반</option>
										<option value="7">기타</option>
								</select></td>
							</tr>
							<tr>
								<th>마 감 일</th>
								<td><label for="dueDate">${ product.dueDate }</label></td>
							</tr>

						</table>
						<br>
						<br>
						<br>
						<div class="add-to-cart">
							<button class="add-to-cart-btn">
								<i class="fa fa-hand-o-up"></i>수정하기
							</button>
						</div>
					</div>
				</form>
				<!-- /경매 등록 폼 -->
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
