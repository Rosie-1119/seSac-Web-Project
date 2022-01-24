package com.fiveand.auction.board.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		Set<Object> listset = service.selectRecentList();
		
		Iterator<Object> itr = listset.iterator();
		ProductVO productVO = new ProductVO();
		ProductFileVO productFVO = new ProductFileVO();
		
		List<ProductVO> RecentList = new ArrayList<ProductVO>();
		List<ProductFileVO> RecentFileList = new ArrayList<ProductFileVO>();
		
		
		while(itr.hasNext()) {
			productVO = (ProductVO)itr.next();
			RecentList.add(productVO);
			
			productFVO = (ProductFileVO)itr.next();
			RecentFileList.add(productFVO);
		}
		
		
		request.setAttribute("RecentList", RecentList);
		request.setAttribute("RecentFileList", RecentFileList);
		
		return "/";
	}

}
