package com.fiveand.auction.board.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.oreilly.servlet.MultipartRequest;

public class BoardWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		

				
				// 제목, 작성자 ,내용 추출 (읽어오는 애가 multipartRequest인것만 달라지는 것!)
				// ==> tbl_board 저장
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
				BoardVo board = new BoardVO();
				board.setTitle(title);
				board.setWriter(writer);
				board.setContent(content);
		return null;
	}

}
