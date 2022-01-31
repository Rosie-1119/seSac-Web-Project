package com.fiveand.qna.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fiveand.controller.Controller;
import com.fiveand.qna.service.QnAService;
import com.fiveand.qna.vo.CommentVO;

public class QnACommentReadController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		ArrayList<CommentVO> comList = null;
		
		QnAService service = new QnAService();
		comList = service.selectComment(bNo);
		
		JSONArray jsonArr = new JSONArray(comList);
		PrintWriter pw = response.getWriter();
		pw.println(jsonArr);
		
		return null;
	}

}
