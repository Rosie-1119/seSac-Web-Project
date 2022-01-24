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
		
		
		
		LoginService service = new LoginService();
		MemberVO userVO = service.login(memberVO);
		
		String url="";
		if(userVO == null) {
			url = "/login.do";
		} else {
			url = "";
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
		}
		
		
		return "redirect:" + url;
	}

	
}
