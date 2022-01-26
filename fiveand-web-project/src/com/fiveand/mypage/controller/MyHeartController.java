package com.fiveand.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.mypage.service.MyPageService;

public class MyHeartController implements Controller{
	
	///전체수정해야함
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MyPageService service = new MyPageService();
		List<MemberVO> list = service.selectMyInfo();
		
		request.setAttribute("list", list);
		
		return "/jsp/member/myPageForm.jsp";
	}
}
	