package com.fiveand.signup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.signup.service.IdCheckService;

public class IdCheckController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberVO memberVo = new MemberVO();
		
		IdCheckService service = new IdCheckService();
		service.checkId(memberVo);
		
		return null;
	}

}
