<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%

	session.setAttribute("id", "1234");
	response.sendRedirect("http://localhost:9999/fiveand-web-project/main.jsp");
	%>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>

</body>
</html>