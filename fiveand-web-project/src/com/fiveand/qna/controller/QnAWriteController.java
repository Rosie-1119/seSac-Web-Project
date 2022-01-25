package com.fiveand.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.qna.service.QnAService;
import com.fiveand.qna.vo.QnAVO;

public class QnAWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청객체데이터 인코딩
		request.setCharacterEncoding("utf-8");

		// 요청객체에서 입력한 데이터 추출
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		int no = Integer.parseInt(request.getParameter("no"));
		String regDate = request.getParameter("regDate");
		
		QnAVO qna = new QnAVO();
		qna.setTitle(title);
		qna.setId(id);
		qna.setRegDate(regDate);
		qna.setNo(no);
		
		QnAService service = new QnAService();
		
		service.insertBoard(qna);
		
		return "redirect:/detail/list.do";
	}

}
