package com.fiveand.admin.service;

import java.util.List;

import com.fiveand.admin.dao.BlindListDAO;
import com.fiveand.auction.board.dao.AuctionBoardDAO;
import com.fiveand.auction.board.vo.ProductVO;

public class BlindListService {

	private BlindListDAO blindDao;
	private AuctionBoardDAO auctionBoardDao;
	
	public BlindListService() {
		blindDao = new BlindListDAO();
	}
	
	/**
	 * 블라인드 리스트 출력
	 */
	public List<ProductVO> blindList() {
		List<ProductVO> list = blindDao.blindList();
		return list;
	}
	
	
	/**
	 * FTBL_PRODUCT --> FTBL_BLIND로 삭제할 게시글 복제
	 */
	public void insertBlind(int pdNo) {
		blindDao.insertBlind(pdNo);
		auctionBoardDao.removeProduct(pdNo);
	}
	
	
	/**
	 * FTBL_PRODUCT에서 복제한 데이터 삭제
	 */
	public void removeProduct(int pdNo) {
		
	}
}
