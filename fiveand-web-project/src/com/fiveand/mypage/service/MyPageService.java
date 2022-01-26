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
	public List<MemberVO> selectMyInfo() {
		List<MemberVO> list = myInfoDao.selectMyInfo();
		return list;
	}
	
	/**
	 * 내옥션 조회
	 */
	public List<MemberVO> selectMyAuction() {
		List<MemberVO> list = myInfoDao.selectMyAuction();
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

