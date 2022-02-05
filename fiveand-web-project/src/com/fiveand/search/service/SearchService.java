package com.fiveand.search.service;

import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.search.dao.SearchDAO;

public class SearchService {

	private SearchDAO searchDao;

	public SearchService() {
		searchDao = new SearchDAO();
	}

	/**
	 * 전체 물품 수 체크 서비스
	 */
	public int totalProductCnt() {
		
		int totalCount = searchDao.totalProductCnt();
		
		return totalCount;
	}
	
	/**
	 * 페이징 처리한 내 경매 목록 가져오기
	 */
	public List<ProductVO> searchList(int currentPage, String findStr) {
		
		List<ProductVO> list = searchDao.searchList(currentPage, findStr);
		System.out.println(list);
		return list;
	}
	

}
