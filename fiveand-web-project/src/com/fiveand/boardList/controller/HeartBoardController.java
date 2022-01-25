package com.fiveand.boardList.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.boardList.service.BoardListService;
import com.fiveand.controller.Controller;

public class HeartBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardListService service = new BoardListService();
		List<Object> list = service.selectHeartList();

		// 0, 2, 4, 6, 8
		List<ProductVO> heartList = new ArrayList<ProductVO>();
		// 1, 3, 5, 7, 9
		List<ProductFileVO> heartFileList = new ArrayList<ProductFileVO>();
		
		for(int i = 0, j = 0; i < list.size(); i += 2, j++) {
			heartList.add((ProductVO)list.get(i));
			heartFileList.add((ProductFileVO)list.get(i+1));
		}
	
		request.setAttribute("heartList", heartList);
		request.setAttribute("heartFileList", heartFileList);

		return "/jsp/boardList/heartList.jsp";
	}
}

