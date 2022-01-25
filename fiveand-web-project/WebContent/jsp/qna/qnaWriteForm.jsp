<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<div align="center">
			<hr>
			<h2>QnA 문의글 등록</h2>
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
						<td>${ userVO.id } <!-- <input type="text" name="writer" required> -->
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="7" cols="60" required>
					</textarea></td>
					</tr>
				</table>
				<br> <input type="submit" value="새글등록">
			</form>
		</div>
	</section>
</body>
</html>