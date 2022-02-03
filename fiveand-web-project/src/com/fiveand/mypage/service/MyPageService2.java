package com.fiveand.mypage.service;

import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.mypage.dao.MyPageDAO2;

public class MyPageService2 {
	
	private MyPageDAO2 myInfoDao;
	
	public MyPageService2() {
		myInfoDao = new MyPageDAO2();
	}
	
	/**
	 * 내가 제안한 경매 물품 목록을 볼 수 있는 서비스
	 * @param id 현재 로그인 한 아이디
	 * @return 
	 */
	public List<ProductVO> selectMySugg(String id) { 
		  List<ProductVO> list = myInfoDao.selectMySugg(id);
		  System.out.println("service List : " + list);
		  return list;
	   }
	
	
}
