package com.fiveand.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.mypage.service.MyPageService;


public class MyInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MyPageService service = new MyPageService();
		List<MemberVO> list = service.selectMyInfo();
		
		request.setAttribute("list", list);
		
		return "/jsp/member/myPageForm.jsp";
	}
}
