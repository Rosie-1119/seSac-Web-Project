package com.fiveand.boardList.service;

import java.util.List;

import com.fiveand.boardList.dao.BoardListDAO;

public class BoardListService {
	
private BoardListDAO ListDao;
	
	/**
	 * 해당 service가 호출될 때마다, 새로운 DAO객체 생성
	 */
	public BoardListService() {
		ListDao = new BoardListDAO();
	}
	
	
	/**
	 * 최근 등록 제품 정보를 가져올 리스트 DB(ftbl_product, ftbl_product_file)에서 검색
	 * 
	 * @return 최근 5개 제품 정보+파일 Object 배열에 묶어서 리턴
	 */
	public List<Object> selectRecentList() {
	
		List<Object> list = ListDao.selectRecentList();
		
		return list;
	}
	
}
