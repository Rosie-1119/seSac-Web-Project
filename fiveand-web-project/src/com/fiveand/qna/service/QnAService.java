package com.fiveand.qna.service;

import java.util.List;

import com.fiveand.qna.dao.QnADAO;
import com.fiveand.qna.vo.QnAVO;

public class QnAService {

	private QnADAO dao;
	
	public QnAService() {
		dao = new QnADAO();
	}
	
	
	/**
	 *  문의글 조회 서비스
	 */
	public List<QnAVO> selectAllBoard(int pdNo) {
		//request에서 가져오기
		
		List<QnAVO> list = dao.selectAllBoard(pdNo);
		System.out.println(list);
		return list;
	}
	
	/**
	 *  상세문의글 조회 서비스
	 */
	public QnAVO detailBoard(int no) {
		
		QnAVO qna = dao.detailBoard(no);
		return qna;
	}
	
	/**
	 *  문의글 등록 서비스
	 */
	public void insertBoard(QnAVO qna) {
		
//		dao.insertBoard(qna);
	}
	
	/**
	 * 문의글 삭제 서비스
	 */
	public void deleteBoard(QnAVO qna) {
		
//		dao.deleteBoard(qna);
	}
	
	/**
	 * 문의글 수정 서비스
	 */
	public void updateBoard(QnAVO qna) {
		
//		dao.updateBoard(qna);
	}
	
}
