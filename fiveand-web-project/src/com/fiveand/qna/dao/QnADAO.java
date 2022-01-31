package com.fiveand.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.qna.vo.PagingVO;
import com.fiveand.qna.vo.QnAVO;
import com.fiveand.util.ConnectionFactory;
import com.fiveand.util.JDBCClose;

public class QnADAO {

	/**
	 * 전체 게시글 조회 메소드
	 */
	public List<QnAVO> selectAllBoard(int pdNo) {

		List<QnAVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select b_no, id, to_char(reg_date, 'yyyy-mm-dd') as reg_date, title ");
			sql.append(" from ftbl_qna_board where pd_no = ? ");
			sql.append(" order by b_no desc ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pdNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bNo = rs.getInt("b_no");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String regDate = rs.getString("reg_date");

				QnAVO qna = new QnAVO(bNo, title, id, regDate);
				list.add(qna);
				System.out.println(list);

				// board 하나가 <tr>
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

		return list;
	}
	
	/**
	 * 페이징 처리된 게시글 조회 메서드 (답글 처리한 후..)
	 */
	public List<QnAVO> selectPagingBoard(int pdNo, int currnetPage) {
		
		PagingVO paging = new PagingVO();
		List<QnAVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int startNum = ((currnetPage - 1) * paging.getDisplayRow()) + 1;
        int endNum = currnetPage * paging.getDisplayRow();

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT * from ( SELECT ROWNUM AS row_num, b_no, id, pd_no, title, to_char(reg_date, 'yyyy-mm-dd') as reg_date, depth ");
			sql.append(" FROM ( SELECT * FROM ftbl_qna_board ORDER BY group_id DESC ) board ) ");
			sql.append(" WHERE row_num >= ? AND row_num <= ? and pd_no = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			pstmt.setInt(3, pdNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bNo = rs.getInt("b_no");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String regDate = rs.getString("reg_date");

				QnAVO qna = new QnAVO(bNo, title, id, regDate);
				list.add(qna);
				System.out.println(list);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

		return list;
	}
	
	/**
	 * 전체 게시글 수 조회 메서드
	 */
	public int totalCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int totalList = 0; //전체 글 수 
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(*) from ( ");
			sql.append(" 	select * from ftbl_qna_board order by b_no desc)");
			pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			totalList = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return totalList;
	}
	
	

	/**
	 * 문의글 상세 게시글 조회 서비스
	 */

	public QnAVO detailBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		QnAVO qna = null;
		

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select b_no, title, id, to_char(reg_date, 'yyyy-mm-dd') as reg_date , content ");
			sql.append(" from ftbl_qna_board ");
			sql.append(" where b_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int bNo = rs.getInt("b_no");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String regDate = rs.getString("reg_date");
				String content = rs.getString("content");
				
				qna = new QnAVO(bNo, title, id, regDate, content);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return qna;
	}
	
	
	/**
	 * 문의글 작성 서비스
	 */
	public void insertBoard(QnAVO qna) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//int result = 0;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into ftbl_qna_board ");
			sql.append(" values(seq_ftbl_qna_board_b_no.nextval, ?, ?, ?, ?, sysdate, seq_ftbl_qna_board_b_no.currval, 0, 0 ) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, qna.getId());
			pstmt.setInt(2, qna.getPdNo());
			pstmt.setString(3, qna.getTitle());
			pstmt.setString(4, qna.getContent());
			
			//result = pstmt.executeUpdate();
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		//return result;
	}
	
	
	
	/**
	 * 문의글 수정 서비스
	 */
	public void updateBoard(QnAVO qna) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" update ftbl_qna_board ");
			sql.append(" set title = ?, content = ? ");
			sql.append(" where no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}

	/**
	 * 문의글 삭제 서비스
	 */

	public void deleteBoard(QnAVO qna) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from ftbl_qna_board ");
			sql.append("where b_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
		//	pstmt.setInt(1, qna.getNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

	}
	
	/**
	 *  답글 순서 
	 */
	public void replyStep(int groupNo, int groupStep) {
		
		String sql = "update ftbl_qna_board set group_step=group_step+1 where groupNo=? and group_step>? ";
		
		try (	Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, groupNo);
				pstmt.setInt(2, groupStep);
				ResultSet rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	/**
	 *  문의글 답글 서비스
	 */
	
	/*public void reply(QnAVO qna) {
		
		replyStep(groupNo, groupStep);
		ArrayList<>
		
	}*/
	
	
	
	
}


