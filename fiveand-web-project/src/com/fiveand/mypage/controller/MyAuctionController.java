package com.fiveand.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.member.vo.MemberVO;
import com.fiveand.mypage.service.MyPageService;
import com.fiveand.controller.Controller;

public class MyAuctionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MyPageService service = new MyPageService();
		List<MemberVO> list = service.selectMyAuction();
		
		request.setAttribute("list", list);
		
		return "/jsp/member/myPageForm.jsp";
	}
}
