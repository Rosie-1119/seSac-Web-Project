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
	 * 전체 글 조회 서비스(페이징X)
	 */
	public List<QnAVO> selectAllBoard(int pdNo){
		List<QnAVO> list = dao.selectAllBoard(pdNo);
		
		return list;
	}

	/**
	 * 문의글 조회 서비스
	 */
	public List<QnAVO> selectPagingBoard(int pdNo, int currentPage) {
		// request에서 가져오기

		List<QnAVO> list = dao.selectPagingBoard(pdNo,currentPage);
		//System.out.println(list);
		return list;
	}

	/**
	 * 전체 글 수 조회 서비스
	 */
	public int totalCount() {

		int totalCount = dao.totalCount();
		return totalCount;
	}

	/**
	 * 상세문의글 조회 서비스
	 */
	public QnAVO detailBoard(int bNo) {

		QnAVO qna = dao.detailBoard(bNo);
		return qna;
	}

	/**
	 * 문의글 등록 서비스
	 */
	public void insertBoard(QnAVO qna) {

		dao.insertBoard(qna);
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
	
	/**
	 * 문의급 답글 등록 서비스
	 */
	public void replyBoard(QnAVO qna) {
		dao.upPos(qna.getGroupId(), qna.getPos());
		dao.replyboard(qna);
	}

}
