package com.fiveand.search.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;
import com.fiveand.search.service.SearchService;

public class SearchController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * request.setCharacterEncoding("utf-8");
		 */
		
		String findStr = request.getParameter("findStr");
		SearchService service = new SearchService();
		List<ProductVO> list = service.searchList(findStr);
		
		System.out.println(list);
		request.setAttribute("list", list);
		
		return "/jsp/search/search.jsp";
	}

}
