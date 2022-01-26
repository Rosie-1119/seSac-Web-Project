package com.fiveand.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.qna.service.QnAService;
import com.fiveand.qna.vo.QnAVO;

public class QnAListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//디테일 번호에 맞는 QnA 전체 게시글 가져오기
		//service selectAllBoard
		int pdNo = Integer.parseInt(request.getParameter("no"));
		
		QnAService service = new QnAService();
		List<QnAVO> list = service.selectAllBoard(pdNo);
		
		request.setAttribute("list", list);
		
		return "/jsp/detail/detail2.jsp";
		//return "/jsp/detail/detail.jsp";
		//수정
	}

}
