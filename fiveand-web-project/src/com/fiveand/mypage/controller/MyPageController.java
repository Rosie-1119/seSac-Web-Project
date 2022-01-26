package com.fiveand.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageController {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		return "/jsp/member/myPageForm.jsp";
	}
}
