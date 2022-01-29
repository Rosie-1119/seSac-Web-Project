package com.fiveand.auction.heart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;

public class CancleHeartController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("result", true);
		return "/jsp/auction/heartResult.jsp";
	}

}
