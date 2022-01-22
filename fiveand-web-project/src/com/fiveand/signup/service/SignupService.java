package com.fiveand.signup.service;

import com.fiveand.signup.dao.SignupDAO;
import com.fiveand.signup.vo.SignupVO;

public class SignupService {

	private SignupDAO signupDao;

	public SignupService() {
		signupDao = new SignupDAO();
	}

	
	/**
	 * 회원가입 서비스
	 */
	public void addMember(SignupVO signup) {
		signupDao.addMember(signup);
	}

}
