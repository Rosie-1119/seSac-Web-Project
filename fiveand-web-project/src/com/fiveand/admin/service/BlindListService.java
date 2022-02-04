package com.fiveand.admin.service;

import java.util.List;

import com.fiveand.admin.dao.BlindListDAO;
import com.fiveand.auction.board.dao.AuctionBoardDAO;
import com.fiveand.auction.board.vo.ProductVO;

public class BlindListService {

	private BlindListDAO blindDao;
	private AuctionBoardDAO auctionBoardDao;
	
	public BlindListService() {
		System.out.println("blindDAO 생성");
		blindDao = new BlindListDAO();
		System.out.println("auctionBoardDao 생성");
		auctionBoardDao = new AuctionBoardDAO();
	}
	
	/**
	 * 블라인드 리스트 출력
	 */
	public List<ProductVO> blindList() {
		List<ProductVO> list = blindDao.blindList();
		return list;
	}
	
	
	/**
	 * 특정 게시글 블라인드 처리하기
	 * FTBL_PRODUCT --> FTBL_BLIND로 삭제할 게시글 복제
	 * FTBL_PRODUCT에 해당 게시글 삭제
	 * FTBL_MEMBER에 경고수 증가
	 */
	public void insertBlind(ProductVO product) {
		
		// 블라인드 처리
		blindDao.insertBlind(product.getPdNo());
		
		// 게시글 삭제
		auctionBoardDao.removeFileByNo(product.getPdNo());
		auctionBoardDao.removeProduct(product.getPdNo());
		
		// 경고수 증가
		blindDao.addWarnCnt(product.getId());
	}
	
}
