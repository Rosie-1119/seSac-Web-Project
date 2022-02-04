package com.fiveand.auction.payment.service;

import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.auction.payment.dao.PayDAO;

public class PayService {

	private PayDAO payDao;
	
	public PayService() {
		payDao = new PayDAO();
	}
	
	/**
	 * 결제할 경매 물품 정보를 볼 수 있는 서비스
	 * @param id 현재 로그인 한 아이디
	 * @return 
	 */
	public ProductVO selectMyWin(String id, int pdNo) { 
		  ProductVO productVO = payDao.selectMyWin(id, pdNo);
		  return productVO;
	   }
	
}
