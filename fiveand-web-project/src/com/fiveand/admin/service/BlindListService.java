package com.fiveand.admin.service;

import java.util.List;

import com.fiveand.admin.dao.BlindListDAO;
import com.fiveand.auction.board.vo.ProductVO;

public class BlindListService {

	private BlindListDAO blindDao;
	
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
}
