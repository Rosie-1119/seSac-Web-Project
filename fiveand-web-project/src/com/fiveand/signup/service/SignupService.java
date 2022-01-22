package com.fiveand.signup.service;

import com.fiveand.member.vo.MemberVO;
import com.fiveand.signup.dao.SignupDAO;

public class SignupService {

	private SignupDAO signupDao;

	public SignupService() {
		signupDao = new SignupDAO();
	}

	
	/**
	 * 회원가입 서비스
	 */
	public void addMember(MemberVO memberVo) {
		signupDao.addMember(memberVo);
	}

}
