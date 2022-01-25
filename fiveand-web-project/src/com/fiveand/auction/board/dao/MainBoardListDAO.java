package com.fiveand.auction.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;

public class MainBoardListDAO {
	
	/**
	 *  ftbl_product 에서 최근 5개 제품 조회
	 *  (productVO 셋팅)
	 */
	public List<Object> selectRecentList(){
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append("  select p.pd_no, p.pd_name, p.start_price, p.reg_date, p.due_date, p.c_no, c.category, pf.file_save_name ");
		sql.append("  		from ftbl_product p, ftbl_product_file pf, ftbl_category c ");
		sql.append("  where p.pd_no = pf.pd_no(+) and p.c_no = c.c_no ");
		sql.append("  order by reg_date desc) ");
		sql.append("   where rownum <= 5 ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				
				//set 순서 x, 타입 알 수 없음
				//List<Object>
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
				
				list.add(productVO); //0, 2, 4, 6, 8
				list.add(productFVO); //1, 3, 5, 7, 9
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
