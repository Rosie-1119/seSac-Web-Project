package com.fiveand.auction.suggest.service;

import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.detail.dao.AuctionSuggestDAO;
import com.fiveand.auction.suggest.vo.SuggestListVO;

public class AuctionProcessService {
	
	private AuctionSuggestDAO auctionSuggestDao;
	
	public AuctionProcessService() {
		auctionSuggestDao = new AuctionSuggestDAO();
	}
	
	/**
	 * 해당 프로덕트에 현재까지 제시된 내역 (최신순 3개까지)
	 * @param no 프로덕트 번호
	 * @return 제시 리스트
	 */
	public List<SuggestListVO> selectSuggestNo(int no) {
		
		List<SuggestListVO> suggestList = auctionSuggestDao.selectSuggestNo(no);		
		
		return suggestList;
	}
	
}
