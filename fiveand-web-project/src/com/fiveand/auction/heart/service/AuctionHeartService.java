package com.fiveand.auction.heart.service;

import com.fiveand.auction.heart.dao.AuctionHeartDAO;
import com.fiveand.auction.heart.vo.HeartVO;

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
	
	/**
	 * 마음찍기 서비스 - 마음찍기 dao 호출
	 * @param heart 유저 아이디와 제품 정보 담은 vo
	 * @return 총 마음 수
	 */
	public int addHeart(HeartVO heart) {
		int result = heartDao.addHeart(heart);
		
		return result;
	}
	
	/**
	 * 마음취소 서비스 - 마음찍기 dao 호출
	 * @param heart 유저 아이디와 제품 정보 담은 vo
	 * @return 총 마음 수
	 */
	public int cancleHeart(HeartVO heart) {
		int result = heartDao.cancleHeart(heart);
		
		return result;
	}
}
