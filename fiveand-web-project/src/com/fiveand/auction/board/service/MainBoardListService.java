package com.fiveand.auction.board.service;

import java.util.List;
import java.util.Set;

import com.fiveand.auction.board.dao.MainBoardListDAO;
import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;

public class MainBoardListService {
	private MainBoardListDAO ListDao;
	
	/**
	 * 해당 service가 호출될 때마다, 새로운 DAO객체 생성
	 */
	public MainBoardListService() {
		ListDao = new MainBoardListDAO();
	}
	
	
	/**
	 * index의 최근 경매 부분에 들어갈 최근 등록 제품 5개의 정보를 가져올 리스트 DB(ftbl_product, ftbl_product_file)에서 검색
	 * 
	 * @return 최근 5개 제품 정보+파일 Object 배열에 묶어서 리턴
	 */
	public List<Object> selectRecentList() {
	
		List<Object> list = ListDao.selectRecentList();
		
		return list;
	}
	
	/**
	 * 제일 많이 제시 받은 탑5 리스트 가져오기
	 */
	public List<ProductVO> selectTopSugList() {
		
		List<ProductVO> sugList = ListDao.selectTopSugList();
		
		return sugList;
	}
	
	/**
	 * 요즘 뜨는 경매 - 제일 좋아요수 많이 받은 리스트 가져오기
	 */
	public List<ProductVO> selectTopLike() {
		
		List<ProductVO> topLike = ListDao.selectTopLike();
		
		return topLike;
	}
	
	/**
	 * 오늘의 경매 - 오늘 등록된 경매 리스트 가져오기 (무작위 4개)
	 */
	public List<ProductVO> selectToday() {
		
		List<ProductVO> today = ListDao.selectToday();
		
		return today;
	}
	
	
	/**
	 * 마감 임박 경매 - 마감기한이 오늘과 가장 가까운 경매 리스트 가져오기
	 */
	public List<ProductVO> selectDeadLine() {
		
		List<ProductVO> deadLine = ListDao.selectDeadLine();
		
		return deadLine;
	}
}
