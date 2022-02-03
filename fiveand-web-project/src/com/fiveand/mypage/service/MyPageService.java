package com.fiveand.mypage.service;

import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.mypage.dao.MyPageDAO;

public class MyPageService {

	private MyPageDAO myInfoDao; //mypagedao 받아와서
	
	public MyPageService() {
		myInfoDao = new MyPageDAO();
	}
	
	/**
	 * 내정보 조회
	 */
	public MemberVO selectMyInfo(String id) {
		MemberVO member = myInfoDao.selectMyInfo(id);
		return member;
	}
	

	/**
	 * 내정보 수정 --
	 */
	public void updateMyInfo(MemberVO member) {
		myInfoDao.updateMyInfo(member);
	}
	
	

	/**
	 * 내계정 삭제 --
	 */
	public void deleteMyInfo(MemberVO member) {
		myInfoDao.deleteMyInfo(member);
	}
	
	
	/**
	 * 전체 물품 수 체크 서비스
	 */
	public int totalProductCnt() {
		
		int totalCount = myInfoDao.totalProductCnt();
		
		return totalCount;
	}
	
	/**
	 * 페이징 처리한 내 경매 목록 가져오기
	 */
	public List<ProductVO> pagingMyAuction(int currentPage, String id) {
		
		List<ProductVO> list = myInfoDao.pagingMyAuction(currentPage, id);
		
		return list;
	}
	
	
	 
	
	/**
	 * 내하트 조회
	 */
	public List<MemberVO> selectMyHeart() {
		List<MemberVO> list = myInfoDao.selectMyHeart();
		return list;
	}
	
	
}

