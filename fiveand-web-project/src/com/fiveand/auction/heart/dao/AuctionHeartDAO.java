package com.fiveand.auction.heart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fiveand.util.ConnectionFactory;

public class AuctionHeartDAO {
	
	/**
	 * 유저와 제품번호가 테이블에 존재하는지 체크
	 * @param id 회원 아이디
	 * @param no 제품 번호
	 * @return 존재할 경우 true, 없을 경우 false
	 */
	public boolean checkHeart(String id, int no) {
		boolean result = false;
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from ftbl_heart where id = ? and pd_no = ? ");

		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				result = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
