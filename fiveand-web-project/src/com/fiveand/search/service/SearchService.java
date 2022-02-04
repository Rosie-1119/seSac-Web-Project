package com.fiveand.search.service;

import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.search.dao.SearchDAO;

public class SearchService {

	private SearchDAO searchDao;

	public SearchService() {
		searchDao = new SearchDAO();
	}

	public List<ProductVO> searchList(String findStr) {

		List<ProductVO> list = searchDao.searchList(findStr);
		System.out.println(list);
		return list;
	}
}
