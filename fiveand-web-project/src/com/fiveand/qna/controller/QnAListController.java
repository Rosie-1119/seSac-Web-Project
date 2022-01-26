package com.fiveand.qna.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.controller.Controller;
import com.fiveand.qna.service.QnAService;
import com.fiveand.qna.vo.QnAVO;
import com.google.gson.Gson;

public class QnAListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//디테일 번호에 맞는 QnA 전체 게시글 가져오기
		//service selectAllBoard
		int pdNo = Integer.parseInt(request.getParameter("no"));
		
		QnAService service = new QnAService();
		List<QnAVO> list = service.selectAllBoard(pdNo);
		/*List<QnAVO> list = new ArrayList<>();
		list.add(new QnAVO(1, "aaa", "good", "2022-01-26"));
		list.add(new QnAVO(1, "aaa", "good2", "2022-01-26"));
		*/
		
		String json = new Gson().toJson(list);
		//System.out.println(json);

		request.setAttribute("json", json);
		
		return "/jsp/qna/qnaList.jsp";
		//return "/jsp/detail/detail.jsp";
		//수정
	}

}
