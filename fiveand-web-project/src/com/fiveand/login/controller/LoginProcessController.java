package com.fiveand.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fiveand.controller.Controller;
import com.fiveand.login.service.LoginService;
import com.fiveand.login.vo.LoginVO;

 
public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		     
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		
		LoginVO loginVO = new LoginVO();
		
		loginVO.setId(id);
		loginVO.setPassword(password);
		
		
		LoginService service = new LoginService();
		LoginVO userVO = service.login(loginVO);
		
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
