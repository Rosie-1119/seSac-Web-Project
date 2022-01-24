package com.fiveand.auction.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.service.MainBoardListService;
import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;

public class MainBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MainBoardListService service = new MainBoardListService();
		Object[] arr = service.selectRecentList();
		
		List<ProductVO> RecentList = (ProductVO)arr[0];
		List<ProductFileVO> RecentFileList = (ProductFileVO)arr[1];
		
		
		request.setAttribute("RecentList", RecentList);
		request.setAttribute("RecentFileList", RecentFileList);
		
		return "/";
	}

}
