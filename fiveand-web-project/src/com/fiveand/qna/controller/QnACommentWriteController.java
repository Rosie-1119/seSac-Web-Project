package com.fiveand.qna.controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fiveand.controller.Controller;
import com.fiveand.qna.service.QnAService;

public class QnACommentWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String comContent = request.getParameter("comContent");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		HashMap<String, Object> result = null;
		
		
//		CommentVO com = new CommentVO();
//		com.setId(id);
//		com.setComContent(comContent);
//		com.setbNo(bNo);
		
		QnAService service = new QnAService();
		result = service.insertComment(id, comContent, bNo);
		
		JSONObject jsonObj = new JSONObject(result);
		PrintWriter pw = response.getWriter();
		pw.println(jsonObj);
		
		return null;
	}

}
