package com.fiveand.auction.detail.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;

public class AuctionDetailController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
/*		AuctionDetailService service = new AuctionDetailService();
		
		Map<String, Object> result = service.selectBoardNo(no);
		
		ProductVO product = (ProductVO)result.get("product");
		List<ProductFileVO> fileList = (List<ProductFileVO>)result.get("fileList");

		request.setAttribute("product", product);*/
		return "/jsp/detail/detail.jsp?no="+no;
	}
}
