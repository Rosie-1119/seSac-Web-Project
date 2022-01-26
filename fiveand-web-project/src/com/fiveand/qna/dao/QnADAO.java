package com.fiveand.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			sql.append("select b_no, id, to_char(reg_date, 'yyyy-mm-dd') as reg_date, title, content ");
			sql.append(" from ftbl_qna_board where pd_no = ? ");
			sql.append(" order by reg_date desc ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pdNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bNo = rs.getInt("b_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String regDate = rs.getString("reg_date");

				QnAVO qna = new QnAVO(bNo, title, content, id, regDate);
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
	 * 페이징 처리된 게시글 조회 메서드
	 */
	public List<QnAVO> selectPagingBoard(int pdNo) {

		List<QnAVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			//쿼리문 확인하기
			sql.append("SELECT * from ( SELECT ROWNUM AS row_num, b_no, id, title, to_char(reg_date, 'yyyy-mm-dd') as reg_date, depth ");
			sql.append(" FROM ( SELECT * FROM tbl_board ORDER BY group_id DESC, pos ) board ) ");
			sql.append(" WHERE row_num >= ? AND row_num <= ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pdNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bNo = rs.getInt("b_no");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String regDate = rs.getString("reg_date");
				int depth = rs.getInt("depth");

				QnAVO qna = new QnAVO(bNo, title, id, regDate, depth);
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

	public QnAVO detailBoard(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		QnAVO qna = null;
		// 리턴형은 무조건 try문 위에서 선언해줘야 함 -> 마지막에 리턴해주기 위해!

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, title, content ");
			sql.append(" from ftbl_qna_board ");
			sql.append(" where no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);

			ResultSet rs = pstmt.executeQuery();
			// rs 의 개수는 최소0 ~ 최대1 (하지만, 늘렀을 당시 이미 존재하였으므로 0개일 수는 없음 ) => 무조건 1개 조회
			// if, while 필요 없지만
			// -> DAO입장에서는 select결과가 없을 수도 있으므로 제어조건 if처리 우선 실행 (안전한 코드 지향)

			if (rs.next()) {

				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");

				qna.setId(id);
				qna.setTitle(title);
				qna.setContent(content);
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
	public synchronized int insertBoard(QnAVO qna) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into ftbl_qna_board ");
			sql.append(" values(seq_ftbl_qna_board_b_no.nextval, ?, ?, ?, ?, seq_ftbl_qna_board_b_no.currval, 0, 0, 0, sysdate ) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, qna.getId());
			pstmt.setInt(2, qna.getPdNo());
			pstmt.setString(3, qna.getTitle());
			pstmt.setString(4, qna.getContent());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return result;
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


