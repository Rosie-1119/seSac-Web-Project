package com.fiveand.boardList.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.boardList.service.BoardListService;
import com.fiveand.controller.Controller;

public class ViewBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardListService service = new BoardListService();
		List<Object> list = service.selectViewList();

		// 0, 2, 4, 6, 8
		List<ProductVO> viewList = new ArrayList<ProductVO>();
		// 1, 3, 5, 7, 9
		List<ProductFileVO> viewFileList = new ArrayList<ProductFileVO>();
		
		for(int i = 0, j = 0; i < list.size(); i += 2, j++) {
			viewList.add((ProductVO)list.get(i));
			viewFileList.add((ProductFileVO)list.get(i+1));
		}
	
		request.setAttribute("viewList", viewList);
		request.setAttribute("viewFileList", viewFileList);

		return "/jsp/boardList/viewList.jsp";
	}
}
