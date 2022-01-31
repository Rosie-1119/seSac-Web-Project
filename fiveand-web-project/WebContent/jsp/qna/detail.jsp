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
	src="${ pageContext.request.contextPath }/js/simple-modal.min.js">
</script>
<script>

function doAction(type) {
	switch(type) {
		case 'U':
			location.href="${ pageContext.request.contextPath }/qna/updateForm.do?bNo=${result.bNo}"
			break;
		case 'D':
			location.href="${ pageContext.request.contextPath }/qna/delete.do?bNo=${result.bNo}"
			break;
		case 'R':
			//location.href="reply.jsp?id=${ param.id }"
			$('#qnaReplyForm').css('display', 'block');
			break;
		case 'L':
			location.href="${ pageContext.request.contextPath }/auction/detail.do?no=${result.pdNo}"
			break;
	}
}

function doWrite(){
	let f = document.inputForm

	if(f.title.value == ''){
		alert('제목을 입력하세요')
		f.title.focus()
		return false
	}
	if(f.content.value == ''){
		alert('내용 입력하세요')
		f.content.focus()
		return false
	}
	else{
		alert('답글 등록이 완료되었습니다!')
	}

	return true
}

	
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
	<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">QnA Page</h3>
						<ul class="breadcrumb-tree">
							<li><a href="${ pageContext.request.contextPath }/auction/detail.do?no=${result.pdNo}">List</a></li>
							<li class="active">Current Page</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->
		
	<section>
		<div align = "left">
		
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
			<!-- request 영역에 등록되어 있는 product.id 를 어떻게 가져오는지? -->
			
		</c:if>
			<button onclick="doAction('L')">목록</button>
		</div>
		
		<!-- 댓글 기능 -->
		<div class="input-group" role="group" style="margin-top: 10px; width: 100%;">
			<textarea class="form-control" rows="3" id="commentContent"
				placeholder="댓글을 입력하세요." style="width: 70%;"></textarea>
			<div class="btn-group btn-group-sm" role="group">
			
				<c:if test="${userVO.id == null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기"
						disabled="disabled">
				</c:if>
				
				<c:if test="${userVO.id != null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기"
						id="commentWrite">
				</c:if>
				
				<input type="button" class="btn btn-default"
					value="댓글 읽기"
					onclick="getComment(1, event)" id="commentRead">
			</div>
		</div>

		<!-- Comment 태그 추가 -->
		<div class="input-group" role="group" style="margin-top: 10px; width: 100%;">
			<div id="showComment" style="text-align: center;"></div>
		</div>

		
		
		

		<div align="center" id="qnaReplyForm">
			<hr>
			<h2>답글 등록</h2>
			<hr>
			<br>
			<!-- submit이라는 타입을 가진 것을 눌렀을 때 실행되도록 하는 메소드 onsubmit -->
			<form action="${ pageContext.request.contextPath }/qna/reply.do"
				method="post" name="inputForm" onsubmit="return doWrite()">
				
				<input type="hidden" name="id" value="${ userVO.id }">
				<input type="hidden" name="pdNo" value="${ result.pdNo }">
				<input type="hidden" name="groupId" value="${ result.groupId }"> 
				<input type="hidden" name="depth" value="${ result.depth }"> 
				<input type="hidden" name="pos" value="${ result.pos }">
				

				<table border="1">
					<tr>
						<th width=23%>제목</th>
						<td>
							<input type="text" name="title" value="	&#8627;[Re]&nbsp;" required>
						</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td>${ userVO.id }
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="10" cols="60" placeholder="글을 적어 주세요." required></textarea></td>
					</tr>
				</table>
				<br> 
				<input type="submit" value="답글등록">
				<input type="button" value="취소" onclick="doAction('L')">
					
			</form>
		</div>
	</section>
	
	
	
	
	<script>
    jQuery(document).ready(function() {
        if(${userVO.id}== null}) {
            alert("게시판을 이용하시려면 로그인하셔야 합니다.");
            location.href="${ pageContext.request.contextPath }/login.do";
        }
    });
    
    // Perform an asynchronous HTTP (Ajax) request.
    // 비동기 통신 Ajax를 Setting한다.
    $.ajaxSetup({
        type:"POST",
        async:true,
        dataType:"json",
        error:function(xhr) {
            console.log("error html = " + xhr.statusText);
        }
    });
    
    $(function() {
        $("#commentWrite").on("click", function() {
            $.ajax({
                url:"${ pageContext.request.contextPath }/qna/commentWrite.do",
                data:{
                	id:"${userVO.id}",
                    comContent:$("#commentContent").val(),
                    bNo:"${result.bNo}"
                },
                beforeSend:function() {
                    console.log("시작");
                },
                complete:function() {
                    console.log("완료");
                },
                success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
                    if(data.result == 1) {            // 쿼리 정상 완료, executeUpdate 결과
                        console.log("comment가 정상적으로 입력되었습니다.");
                        $("#commentContent").val("");
                        showHtml(data.comments, 1);
                    }
                }
            })
        });
    });
 
    function showHtml(data, commPageNum) {
        let html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";
        $.each(data, function(index, item) {
            html += "<tr align='center'>";
            html += "<td>" + (index+1) + "</td>";
            html += "<td>" + item.id + "</td>";
            html += "<td align='left'>" + item.commentContent + "</td>";
            let presentDay = item.commentDate.substring(0, 10);
            html += "<td>" + presentDay + "</td>";
            html += "</tr>";
        });
        html += "</tbody></table>";
        commPageNum = parseInt(commPageNum);        // 정수로 변경
        // commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다.
        if("${article.commentCount}" > commPageNum * 10) {
            nextPageNum = commPageNum + 1;
            html +="<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>";
        }
        
        $("#showComment").html(html);
        $("#commentContent").val("");
        $("#commentContent").focus();
    }
    
    function getComment(commPageNum, event) {
        $.ajax({
            url:"${ pageContext.request.contextPath }/qna/commentRead.do",
            data:{
                commPageNum:commPageNum*10,
                articleNumber:"${result.bNo}"
            },
            beforeSend:function() {
                console.log("읽어오기 시작 전...");
            },
            complete:function() {
                console.log("읽어오기 완료 후...");
            },
            success:function(data) {
                console.log("comment를 정상적으로 조회하였습니다.");
                showHtml(data, commPageNum);
                
                let position = $("#showComment table tr:last").position();
                $('html, body').animate({scrollTop : position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간
            }
        })
    }
</script>

	
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