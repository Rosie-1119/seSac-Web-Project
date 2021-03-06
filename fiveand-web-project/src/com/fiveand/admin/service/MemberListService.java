package com.fiveand.admin.service;

import java.util.List;

import com.fiveand.admin.dao.MemberListDAO;
import com.fiveand.member.vo.MemberVO;

public class MemberListService {

	private MemberListDAO memberDao;
	
	public MemberListService() {
		memberDao = new MemberListDAO();
	}
	
	/**
	 * 전체 회원 목록 조회
	 */
	public List<MemberVO> selectAllMember() {
		List<MemberVO> list = memberDao.selectAllMember();
		return list;
	}
}
