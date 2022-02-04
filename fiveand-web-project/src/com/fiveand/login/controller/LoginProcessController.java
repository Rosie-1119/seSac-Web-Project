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
		
		System.out.println(id);
		System.out.println(pwd);
		
		
		LoginService service = new LoginService();
		MemberVO userVO = service.login(memberVO);
		System.out.println(userVO);
		
		String msg="";
		String url="";
		if(userVO == null) {
			msg = "아이디 또는 패스워드가 잘못입력되었습니다.";
			url = "/login.do";
		} else {
			
			switch(userVO.getType()) {
			case "A" :
				msg = "관리자님 환영합니다";
				break;
			case "U" :
				msg = userVO.getId() + "님 환영합니다";
				break;
			}
			if (userVO.getWarningCnt() >= 1) {
				msg = "5회 경고받은 계정입니다. 이용이 제한됩니다.";
				url = "/main.do";
				userVO = null;
			} else {
				url = "/main.do"; // "/"했을때는 로그아웃이 안떠서 수정했음ㅠ!
				HttpSession session = request.getSession();
				session.setAttribute("userVO", userVO);
				// 경매 성공했으나 결제 전인 건수 체크
				int winBidCnt = service.checkWinBid(userVO);
				session.setAttribute("winBidCnt", winBidCnt);
			}
		}
		System.out.println(msg);
		return "redirect:" + url;
	}

	
	}
