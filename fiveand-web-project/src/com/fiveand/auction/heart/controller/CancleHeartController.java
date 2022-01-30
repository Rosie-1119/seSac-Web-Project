package com.fiveand.auction.heart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.heart.service.AuctionHeartService;
import com.fiveand.auction.heart.vo.HeartVO;
import com.fiveand.controller.Controller;

public class CancleHeartController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 포스트 방식 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 데이터 불러오기
		String id = request.getParameter("id");
		int pdNo = Integer.parseInt(request.getParameter("pdNo"));
		HeartVO heart = new HeartVO(id, pdNo);
		
		// 마음 삭제 성공 여부 저장 - -1일 경우 조회 실패
		AuctionHeartService service = new AuctionHeartService();
		int result = service.cancleHeart(heart);
		
		request.setAttribute("result", result);
		
		return "/jsp/auction/heartResult.jsp";
	}

}
