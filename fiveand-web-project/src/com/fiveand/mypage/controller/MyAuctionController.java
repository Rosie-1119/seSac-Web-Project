package com.fiveand.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.mypage.service.MyPageService;
import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;
import com.fiveand.member.vo.MemberVO;

public class MyAuctionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		MyPageService service = new MyPageService();
		List<Object> list = service.selectMyAuction(id);

		// 0, 2, 4, 6, 8
		List<ProductVO> myList = new ArrayList<ProductVO>();
		// 1, 3, 5, 7, 9
		List<ProductFileVO> myFileList = new ArrayList<ProductFileVO>();

		for (int i = 0, j = 0; i < list.size(); i += 2, j++) {
			myList.add((ProductVO) list.get(i));
			myFileList.add((ProductFileVO) list.get(i + 1));
		}

		request.setAttribute("myList", myList);
		request.setAttribute("myFileList", myFileList);
		request.setAttribute("list", list);

		return "/jsp/member/myAuction.jsp";
	}
}
