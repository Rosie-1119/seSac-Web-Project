package com.fiveand.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fiveand.controller.Controller;
import com.fiveand.login.service.LoginService;
import com.fiveand.member.vo.MemberVO;

 
public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		     
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		
		System.out.println(id);
		System.out.println(pwd);
		
		
		LoginService service = new LoginService();
		MemberVO userVO = service.login(memberVO);
		
		String msg="";
		String url="";
		if(userVO == null) {
			msg = "아이디 또는 패스워드가 잘못입력되었습니다.";
			url = "/login.do";
		} else {
			
			switch(userVO.getType()) {
			case "S" :
				msg = "관리자님 환영합니다";
				break;
			case "U" :
				msg = userVO.getId() + "님 환영합니다";
				break;
		}
			url = "/";
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
		}
		
		return "redirect:" + url;
	}

	
	}
