package com.fiveand.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;
import com.fiveand.util.JDBCClose;

public class BlindListDAO {

	
	/**
	 * 블라인드 리스트 출력
	 */
	public List<ProductVO> blindList() {
		
		List<ProductVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select  pd_no, id, pd_name, category, hope_price, start_price, ");
			sql.append("to_char(reg_date, 'yyyy-mm-dd') reg_date, to_char(due_date, 'yyyy-mm-dd') due_date, to_char(del_date, 'yyyy-mm-dd') del_date ");
			sql.append("from ftbl_category c, ftbl_blind b ");
			sql.append("where c.c_no = b.c_no ");
			
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int pdNo = rs.getInt("pd_no");
				String id = rs.getString("id");
				String pdName = rs.getString("pd_name");
				String cName = rs.getString("category");
				int hopePrice = rs.getInt("hope_price");
				int startPrice = rs.getInt("start_price");
				String regDate = rs.getString("reg_date");
				String dueDate = rs.getString("due_date");
				String delDate = rs.getString("del_date");
				
				ProductVO product = new ProductVO(pdNo, id, pdName, cName, hopePrice, startPrice, regDate, dueDate, delDate);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
}
