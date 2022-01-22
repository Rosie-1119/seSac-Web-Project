package com.fiveand.signup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.signup.service.SignupService;
import com.fiveand.signup.vo.SignupVO;

public class SignupProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		//입력받은 데이터 추출
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		//VO에 저장
		SignupVO signup = new SignupVO();
		signup.setId(id);
		signup.setPwd(pwd);
		signup.setName(name);
		signup.setPhone(phone);
		signup.setEmail(email);
		
		//service 호출
		SignupService service = new SignupService();
		service.addMember(signup);
		
		return null;
	}

}
