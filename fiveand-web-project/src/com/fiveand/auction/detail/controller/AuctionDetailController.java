package com.fiveand.auction.detail.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.auction.detail.service.AuctionDetailService;
import com.fiveand.auction.suggest.service.AuctionProcessService;
import com.fiveand.auction.suggest.vo.SuggestListVO;
import com.fiveand.controller.Controller;

public class AuctionDetailController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		AuctionDetailService auctionDetailService = new AuctionDetailService();
		
		// 프로덕트 정보(ProductVO)와 프로덕트 사진(List<ProductFileVO>) 받아옴
		Map<String, Object> result = auctionDetailService.selectBoardNo(no);
		
		ProductVO product = (ProductVO)result.get("product");
		List<ProductFileVO> fileList = (List<ProductFileVO>)result.get("fileList");

		// 프로덕트 옥션 정보 받아옴
		AuctionProcessService auctionProcessService = new AuctionProcessService();
		List<SuggestListVO> suggestList = auctionProcessService.selectSuggestNo(no); 
		
		// 공유 영역에 등록
		request.setAttribute("product", product);
		request.setAttribute("fileList", fileList);
		request.setAttribute("suggestList", suggestList);
		
		return "/jsp/detail/detail.jsp?no="+no;
	}
}
