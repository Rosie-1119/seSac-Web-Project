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
	 * 최근 등록 제품 정보를 가져올 리스트 DB(ftbl_product, ftbl_product_file, ftbl_category)에서 검색
	 * 
	 * @return 최근순  제품 정보+파일 Object 배열에 묶어서 리턴
	 */
	public List<Object> selectRecentList() {
	
		List<Object> list = ListDao.selectRecentList();
		
		return list;
	}
	
	/**
	 * 조회수 순으로 제품 정보 가져오기
	 */
	public List<Object> selectViewList() {
		
		List<Object> list = ListDao.selectViewList();
		
		return list;
	}
	
	/**
	 * 좋아요 순으로 제품 정보 가져오기
	 */
	public List<Object> selectHeartList() {
		
		List<Object> list = ListDao.selectHeartList();
		
		return list;
	}
	
	
	
	
}
