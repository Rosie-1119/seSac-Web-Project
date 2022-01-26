package com.fiveand.mypage.service;

import java.util.List;

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
	

	/**z
	 * 내정보 수정
	 */
	public void UpdateMyInfo(String id) {
		
	}
	
	
	
	/**
	 * 내옥션 조회 ----수정해야함
	 * 
	 */
	  public List<Object> selectMyAuction(String id) { 
		  List<Object> member2 = myInfoDao.selectMyAuction();
		  return member2;
	   }
	 
	
	/**
	 * 내하트 조회
	 */
	public List<MemberVO> selectMyHeart() {
		List<MemberVO> list = myInfoDao.selectMyHeart();
		return list;
	}
	
	
}

