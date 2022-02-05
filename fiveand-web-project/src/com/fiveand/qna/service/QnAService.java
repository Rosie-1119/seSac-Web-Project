package com.fiveand.qna.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fiveand.qna.dao.QnADAO;
import com.fiveand.qna.vo.CommentVO;
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
	 * 수정할 게시글 정보 가져오기
	 */
	public QnAVO updateFormBoard(int bNo) {
		QnAVO qna = dao.updateFormBoard(bNo);
		return qna;
	}
	
	/**
	 * 문의글 수정 서비스
	 */
	public void updateBoard(QnAVO qna) {
		
		dao.updateBoard(qna);
	}

	/**
	 * 문의글 삭제 서비스
	 */
	public void deleteBoard(int bNo) {

		dao.deleteBoard(bNo);
	}
	
	/**
	 * 문의급 답글 등록 서비스
	 */
	public void replyBoard(QnAVO qna) {
		dao.upPos(qna.getGroupId(), qna.getPos());
		dao.replyboard(qna);
	}
	
	/**
	 * 댓글 등록 서비스
	 */
	public HashMap<String, Object> insertComment(String id, String comContent, int bNo) {
		HashMap<String, Object> list =dao.insertComment(id, comContent, bNo);
		return list;
	}
	
	/**
	 * 댓글 조회 서비스
	 */
	public ArrayList<CommentVO> selectComment(int bNo, int comPageNum){
		ArrayList<CommentVO> comList = dao.selectComment(bNo, comPageNum);
		return comList;
	}
	
	
	
	
	
	
}
