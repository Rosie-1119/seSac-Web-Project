package com.fiveand.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.mypage.service.MyPageService;

public class DeleteMyInfoController implements Controller {

	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");	
		String pwd = request.getParameter("pwd");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		
		MyPageService service = new MyPageService();
		service.updateMyInfo(member);
	
		return "redirect:/myInfo.do?id="+id;
	
}
}