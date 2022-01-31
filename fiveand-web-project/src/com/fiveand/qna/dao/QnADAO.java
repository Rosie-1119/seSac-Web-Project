package com.fiveand.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fiveand.qna.vo.CommentVO;
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
			sql.append("select * ");
			sql.append(" from (select b_no, id, pd_no, title, to_char(reg_date, 'yyyy-mm-dd') as reg_date, group_id, depth, pos from ftbl_qna_board ");
			sql.append(" where pd_no = ? order by group_id desc, depth asc) ftbl_qna_board ");

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
	 * + 총 댓글수 같이 불러오기
	 */

	public QnAVO detailBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		QnAVO qna = null;
		

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select b_no, pd_no, title, id, to_char(reg_date, 'yyyy-mm-dd') as reg_date , content, group_id, depth, pos ");
			sql.append(" from ftbl_qna_board ");
			sql.append(" where b_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int bNo = rs.getInt("b_no");
				int pdNo = rs.getInt("pd_no");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String regDate = rs.getString("reg_date");
				String content = rs.getString("content");
				int groupId = rs.getInt("group_id");
				int depth = rs.getInt("depth");
				int pos = rs.getInt("pos");
				
				qna = new QnAVO(bNo, pdNo, title, id, regDate, content, groupId, depth, pos);
				
			}
			
			StringBuilder sql2 = new StringBuilder();
			sql2.append(" select count(*) from ftbl_qna_comment ");
			sql2.append(" where b_no = ? ");
			
			pstmt = conn.prepareStatement(sql2.toString());
			pstmt.setInt(1, boardNo);

			ResultSet rs2 = pstmt.executeQuery();
			if(rs2.next()) {
				qna.setComCount(rs.getLong(1));
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
	 *  문의글 답글 (pos : 답글의 순서) 설정
	 */
	public void upPos(int groupId, int pos) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("update ftbl_qna_board set pos = pos + 1 ");
			sql.append(" where group_id = ? and pos >= ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, groupId);
			pstmt.setInt(2, pos);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	/**
	 *  문의글 답글 삽입
	 */
	public void replyboard(QnAVO qna) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into ftbl_qna_board ");
			sql.append(" values(seq_ftbl_qna_board_b_no.nextval, ?, ?, ?, ?, sysdate, ?, ?, ? ) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, qna.getId());
			pstmt.setInt(2, qna.getPdNo());
			pstmt.setString(3, qna.getTitle());
			pstmt.setString(4, qna.getContent());
			pstmt.setInt(5, qna.getGroupId());
			pstmt.setInt(6, qna.getDepth()+1); //깊이 +1
			pstmt.setInt(7, qna.getPos()+1); //답글 순서 +1
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	/**
	 * 댓글 리스트 조회 기능
	 */
	public ArrayList<CommentVO> selectComment(int boardNo, int comPageSize){
		Connection conn = null;
		PreparedStatement pstmt = null;
		CommentVO com = null;
		ArrayList<CommentVO> comList = new ArrayList<>();

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append(" from (select id, c_content, c_date, b_no from ftbl_qna_comment ");
			sql.append(" where b_no = ? order by c_no desc) ftbl_qna_comment ");
			sql.append(" where rownum between 1 and ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, comPageSize);

			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String id = rs.getString("id");
				String comContent = rs.getString("c_content");
				String comDate = rs.getString("c_date");
				int bNo = rs.getInt("b_no");
				
				com = new CommentVO(id, comContent, comDate, bNo);
				comList.add(com);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return comList;
		
	}
	
	/**
	 * 댓글 삽입 기능
	 */
	public HashMap<String, Object> insertComment(String id, String comContent, int bNo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		HashMap<String, Object> hm = new HashMap<>();

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into ftbl_qna_comment ");
			sql.append("  values(seq_ftbl_qna_comment_c_no.nextval, ?, ?, sysdate, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, comContent);
			pstmt.setInt(3, bNo);
			
			int result = pstmt.executeUpdate();
			ArrayList<CommentVO> comments = selectComment(bNo, 10);
			
			hm.put("result", result);
			hm.put("comments", comments);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return hm;
	}
	
	
	
	
}


