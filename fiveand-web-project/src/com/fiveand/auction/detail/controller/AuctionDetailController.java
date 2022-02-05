package com.fiveand.auction.detail.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fiveand.auction.board.service.AuctionBoardService;
import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.auction.detail.service.AuctionDetailService;
import com.fiveand.auction.heart.service.AuctionHeartService;
import com.fiveand.auction.suggest.service.AuctionProcessService;
import com.fiveand.auction.suggest.vo.SuggestListVO;
import com.fiveand.controller.Controller;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.qna.service.QnAService;
import com.fiveand.qna.vo.QnAVO;

public class AuctionDetailController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		
		
		int no = Integer.parseInt(request.getParameter("no"));
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("userVO");
		System.out.println("로그인 정보 : "+user);
		// 프로덕트 정보(ProductVO)와 프로덕트 사진(List<ProductFileVO>) 받아옴
		AuctionDetailService auctionDetailService = new AuctionDetailService();		
		Map<String, Object> result = auctionDetailService.selectBoardNo(no);
		
		ProductVO product = (ProductVO)result.get("product");
		List<ProductFileVO> fileList = (List<ProductFileVO>)result.get("fileList");

		// 프로덕트 옥션 정보 받아옴
		AuctionProcessService auctionProcessService = new AuctionProcessService();
		List<SuggestListVO> suggestList = auctionProcessService.selectSuggestNo(no); 
		
		// 하트 정보 받아옴 (true, false로 구분하여 넘겨주기)
		boolean isHeart = false;
		if (user != null)
		{
			String id = user.getId();
			System.out.println("디테일 창에 들어온 id : "+id);
			AuctionHeartService auctionHeartService = new AuctionHeartService();
			isHeart = auctionHeartService.checkHeart(id, no);
			System.out.println("마음 찍었는지? : "+isHeart);
		}
		// 공유 영역에 등록
		request.setAttribute("product", product);
		request.setAttribute("fileList", fileList);
		request.setAttribute("suggestList", suggestList);
		request.setAttribute("isHeart", isHeart);
		
		//---QnA관련 추가
		QnAService service = new QnAService();
		List<QnAVO> list = service.selectAllBoard(no);
		int totalCount = service.totalCount();
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		System.out.println(list);


		
		//----relatedList 추가
		AuctionBoardService relatedService = new AuctionBoardService();
		List<Object> relatedList = relatedService.relatedList(product.getId());
		request.setAttribute("relatedList", relatedList);
		
		return "/jsp/detail/detail.jsp?no="+no;
	}
}
