package com.fiveand.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.admin.service.BlindListService;
import com.fiveand.controller.Controller;

public class RemoveController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int pdNo = Integer.parseInt(request.getParameter("no"));
		BlindListService service = new BlindListService();
		
		service.insertBlind(pdNo);
		return "redirect:/main.do";
	}

}
