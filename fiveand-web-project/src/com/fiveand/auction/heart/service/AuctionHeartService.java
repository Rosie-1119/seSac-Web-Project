package com.fiveand.auction.heart.service;

import com.fiveand.auction.heart.dao.AuctionHeartDAO;

public class AuctionHeartService {
	private AuctionHeartDAO heartDao;
	
	public AuctionHeartService() {
		heartDao = new AuctionHeartDAO();
	}
	
	/**
	 * 특정 유저가 해당 제품에 마음을 찍었는지 확인
	 * @param id 특정 유저
	 * @param no 제품 번호
	 * @return 마음을 찍었을 경우 true, 안 찍었을 경우 false
	 */
	public boolean checkHeart(String id, int no) {
		
		boolean result = heartDao.checkHeart(id, no);
		
		return result;
	}
}
