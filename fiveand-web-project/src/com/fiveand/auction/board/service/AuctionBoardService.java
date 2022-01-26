package com.fiveand.auction.board.service;

import java.util.List;

import com.fiveand.auction.board.dao.AuctionBoardDAO;
import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;

public class AuctionBoardService {
	
	private AuctionBoardDAO auctionBoardDao;
	
	// 생성자
	public AuctionBoardService() {
		auctionBoardDao = new AuctionBoardDAO();
	}
	
	
	/**
	 * 게시글 등록
	 */
	public int insertBoard(ProductVO product, List<ProductFileVO> fileList) {
		
		// 제품번호 설정
		int pdNo = auctionBoardDao.selectProductNo();
		product.setPdNo(pdNo);
		
		// ftbl_product에 저장
		auctionBoardDao.insertProduct(product);
		
		// ftbl_product_file에 저장
		for (ProductFileVO fileVO : fileList) {
			fileVO.setPdNo(pdNo);
			auctionBoardDao.insertFile(fileVO);
		}
		return pdNo;
	}
	
	/**
	 * 게시글 조회수 증가
	 */
	public void addViewCnt(int pdNo) {
		auctionBoardDao.addViewCnt(pdNo);
	}
	
	/**
	 * 게시글 수정
	 */
	public void updateBoard(ProductVO product) {
		auctionBoardDao.updateProduct(product);
	}
}
