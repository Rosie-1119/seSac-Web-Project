package com.fiveand.login.service;

import com.fiveand.login.dao.LoginDAO;
import com.fiveand.login.vo.LoginVO;

public class LoginService {
	private LoginDAO loginDao;
	
	public LoginService() {
		loginDao = new LoginDAO();
	}
	
	public LoginVO login(LoginVO loginVO) {
		return loginDao.login(loginVO);
	}
}
