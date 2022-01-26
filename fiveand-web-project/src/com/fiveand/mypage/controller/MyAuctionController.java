package com.fiveand.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fiveand.mypage.service.MyPageService;
import com.fiveand.controller.Controller;

public class MyAuctionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		MyPageService service = new MyPageService();
		//MemberVO member = service.selectMyAuction(id);
		
	//	request.setAttribute("member", member);
		
		return "/jsp/member/myPageForm.jsp";
	}
}
