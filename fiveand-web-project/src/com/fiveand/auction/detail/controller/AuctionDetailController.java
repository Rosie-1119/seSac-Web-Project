package com.fiveand.auction.detail.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.auction.detail.service.AuctionDetailService;
import com.fiveand.controller.Controller;

public class AuctionDetailController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		AuctionDetailService service = new AuctionDetailService();
		
		// 프로덕트 정보(ProductVO)와 프로덕트 사진(List<ProductFileVO>) 받아옴
		Map<String, Object> result = service.selectBoardNo(no);
		
		ProductVO product = (ProductVO)result.get("product");
		List<ProductFileVO> fileList = (List<ProductFileVO>)result.get("fileList");

		// 공유 영역에 등록
		request.setAttribute("product", product);
		request.setAttribute("fileList", fileList);
		
		return "/jsp/detail/detail.jsp?no="+no;
	}
}
