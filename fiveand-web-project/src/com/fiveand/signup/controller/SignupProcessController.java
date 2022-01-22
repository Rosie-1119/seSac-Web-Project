package com.fiveand.signup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.signup.service.SignupService;

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
		MemberVO memberVo = new MemberVO();
		memberVo.setId(id);
		memberVo.setPwd(pwd);
		memberVo.setName(name);
		memberVo.setPhone(phone);
		memberVo.setEmail(email);
		
		//service 호출
		SignupService service = new SignupService();
		service.addMember(memberVo);
		/*
		MemberVO userVO = service.addMember(memberVo);
		
		String url = "";
		if(userVO == null) {
			//회원가입 실패
			url = "/signup.do";
		} else {
			//회원가입 성공
			url = "/";
		}
		return "redirect:" + url;  // redirect:/fiveand-web-project/signup.do
		*/
		return "redirect:/";  //회원가입 완료 시 메인 페이지로 돌아감
	}

}
