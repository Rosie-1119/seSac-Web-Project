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
	public List<QnAVO> selectAllBoard() {
		
		List<QnAVO> list = dao.selectAllBoard();
		return list;
	}
	
	/**
	 *  상세문의글 조회 서비스
	 */
	public QnAVO detailBoard(int no) {
		
	//	QnAVO qna = dao.detailBoard(no);
	//	return qna;
		return null;
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
