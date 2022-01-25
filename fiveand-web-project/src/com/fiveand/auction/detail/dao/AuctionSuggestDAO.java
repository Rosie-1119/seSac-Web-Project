package com.fiveand.auction.detail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.suggest.vo.SuggestListVO;
import com.fiveand.util.ConnectionFactory;

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
}
