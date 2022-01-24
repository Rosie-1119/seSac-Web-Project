<%@page import="com.fiveand.member.vo.MemberVO"%>
<%@page import="com.fiveand.login.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("pwd");
	
	MemberVO memberVO = new MemberVO();
	memberVO.setId(id);
	memberVO.setPwd(password);
	
	LoginDAO dao = new LoginDAO();

	MemberVO userVO = dao.login(memberVO);
	
	String msg = "";
	String url = "";
	if(userVO == null ) {
		msg = "아이디 또는 패스워드가 잘못입력되었습니다.";
		url = "loginForm.jsp";
	} else {
		
		switch(userVO.getType()) {
		case "S" :
			msg = "관리자님 환영합니다";
			break;
		case "U" :
			msg = userVO.getId() + "님 환영합니다";
			break;
		}
		
		msg = "로그인을 성공했습니다.";
		url = "/index";
		
		// 세션등록
		session.setAttribute("userVO", userVO);
	}

	pageContext.setAttribute("msg", msg);
	pageContext.setAttribute("url", url);
%>

<script>
	modal('${ msg }')
	location.href = '${ url }'
</script>