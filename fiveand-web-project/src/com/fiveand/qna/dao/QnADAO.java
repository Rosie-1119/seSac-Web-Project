package com.fiveand.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.qna.vo.QnAVO;
import com.fiveand.util.ConnectionFactory;

public class QnADAO {

	/**
	 * 전체 게시글 조회 메소드
	 */
	public List<QnAVO> selectAllBoard() {

		List<QnAVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append(" from tbl_board");
			sql.append(" order by no desc ");

			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");

				BoardVO board = new BoardVO(no, title, writer, regDate);
				// System.out.println(board);
				list.add(board);
				// board 하나가 <tr>
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

		return list;
	}
}
