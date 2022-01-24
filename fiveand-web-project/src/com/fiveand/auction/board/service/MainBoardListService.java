package com.fiveand.auction.board.service;

import java.util.List;

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
	
//	/**
//	 * index의 최근 경매 부분에 들어갈 최근 등록 제품 5개의 정보를 가져올 리스트 DB(ftbl_product)에서 검색
//	 * @return 최근 5개 제품 정보
//	 */
//	public List<ProductVO> selectRecentList(){
//		
//		List<ProductVO> RecentList = ListDao.selectRecentList();
//		
//		return RecentList;
//	}
//	
//	
//	/**
//	 * 위의 제품에 맞는 파일 정보를 DB(ftbl_product_file)에서 검색
//	 * @return selectRecentList() 제품에 맞는 파일 
//	 */
//	public List<ProductFileVO> selectRecentFileList(){
//		
//		List<ProductFileVO> RecentFileList = ListDao.selectRecentFileList();
//		
//		return RecentFileList;
//	}
	
	/**
	 * index의 최근 경매 부분에 들어갈 최근 등록 제품 5개의 정보를 가져올 리스트 DB(ftbl_product, ftbl_product_file)에서 검색
	 * 
	 * @return 최근 5개 제품 정보+파일 Object 배열에 묶어서 리턴
	 */
	public Object[] selectRecentList() {
	
		List<ProductVO> RecentList = ListDao.selectRecentList();
		List<ProductFileVO> RecentFileList = ListDao.selectRecentFileList();
		
		Object[] arr = {RecentList, RecentFileList};
		
		return arr;
	}
	
	
	
}
