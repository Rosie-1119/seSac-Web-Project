<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 상세페이지</title>
<script>
	function doAction(type) {
		
		switch(type) {
		case 'U':
			location.href="updateForm.jsp?no=${ param.no }"
			break;
		case 'D':
			location.href=""
			break;
		case 'C':
			location.href="reply.jsp?id=${ param.id }"
			break;
		case 'L':
			location.href="detail/detail.jsp"
			break;
		}
	}
</script>
</head>
<body>
	<section>
		<div align = "center">
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
														<th width="25%">제목</th>
														<td><input type="text" name="title" value="${ board.title }" class="title"></td>
													</tr>
													<tr>
														<th width="25%">작성자</th>
														<td><input type="text" name="id" value="${ board.id }" class="id"></td>
													</tr>
													<tr>
														<th width="25%">내용</th>
														<td><textarea name="content" rows="7" cols="60" id="content" value="${ param.content }">
														</textarea></td>
													</tr>
													<tr>
														<th width="25%">등록일</th>
														<td><input type="text" name="regDate" value="${ board.regDate }" class="regDate"></td>
													</tr>
												</table>
		<br>
		<c:if test="${ board.id eq userVO.id }">
		<button onclick="doAction('U')">수정</button>
		<button onclick="doAction('D')">삭제</button>
		<button onclick="doAction('C')">답글</button>
		<button onclick="doAction('L')">목록</button>
		</c:if>
	</div>
	</section>
</body>
</html>