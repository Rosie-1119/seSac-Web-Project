package com.fiveand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	//컨트롤러에서 사용하는 메서드들이 가져야 하는 통일성을 생성해두자
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
