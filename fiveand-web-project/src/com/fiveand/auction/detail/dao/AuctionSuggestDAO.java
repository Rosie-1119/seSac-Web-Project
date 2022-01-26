package com.fiveand.auction.detail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.suggest.vo.SuggestListVO;
import com.fiveand.util.ConnectionFactory;
import com.fiveand.util.JDBCClose;

public class AuctionSuggestDAO {

	
	/**
	 * 해당 제품에 대한 제시 현황(최고가 top3)
	 * @param pdNo 제품 코드
	 * @return 제시 현황 리스트
	 */
	public List<SuggestListVO> selectSuggestNo(int pdNo){
		List<SuggestListVO> suggestList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select a_no, pd_no, id, sug_price, sug_date ");
		sql.append(" from (select * from ftbl_auction where pd_no = ? order by sug_price desc) ");
		sql.append(" where rownum <= 3 ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());				
		){
			pstmt.setInt(1, pdNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SuggestListVO suggest = new SuggestListVO();
				suggest.setaNo(rs.getInt("a_no"));
				suggest.setPdNo(rs.getInt("pd_no"));
				suggest.setId(rs.getString("id"));
				suggest.setSugPrice(rs.getInt("sug_price"));
				suggest.setSugDate(rs.getString("sug_date"));
				suggestList.add(suggest);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return suggestList;
	}
	
	/**
	 * 제시가 ftbl_auction에 추가 및 ftbl_product에 제시 수 증가
	 * @param suggest
	 */
	public void insertSuggest(SuggestListVO suggest) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		
		
		try {
			conn = new ConnectionFactory().getConnection();
			// 오토커밋 종료
			conn.setAutoCommit(false);
			
			// ftbl_auction에 삽입
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into ftbl_auction ( ");
			sql.append(" a_no, pd_no, id, sug_price ) ");
			sql.append(" values( seq_ftbl_auction_a_no.nextval, ?, ?, ?) ");
			
			// 1번 쿼리용 pstmt 실행
			pstmt1 = conn.prepareStatement(sql.toString());
			pstmt1.setInt(1, suggest.getPdNo());
			pstmt1.setString(2, suggest.getId());
			pstmt1.setInt(3, suggest.getSugPrice());
			pstmt1.executeUpdate();
			
			// sql 초기화
			sql.setLength(0);
			
			sql.append(" update ftbl_product ");
			sql.append(" set sug_cnt = sug_cnt + 1 ");
			sql.append(" where pd_no = ? ");
			
			//2번 쿼리용 pstmt 실행
			pstmt2 = conn.prepareStatement(sql.toString());
			pstmt2.setInt(1, suggest.getPdNo());
			pstmt2.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.stmtClose(pstmt1);
			JDBCClose.stmtClose(pstmt2);
			JDBCClose.connClose(conn);
		}
		
	}
}
