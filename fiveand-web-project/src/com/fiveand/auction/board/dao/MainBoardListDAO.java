package com.fiveand.auction.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;

public class MainBoardListDAO {
	
	/**
	 *  ftbl_product 에서 최근 5개 제품 조회
	 */
	public List<ProductVO> selectRecentList(){
		
		Set<ProductVO, ProductFileVO> listset
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select row_num, tp.pd_no, pd_name, start_price, reg_date, due_date, c_no , tpf.file_save_name ");
		sql.append("  from (select rownum as row_num, pd_no, pd_name, start_price, reg_date, due_date, c_no) ");
		sql.append("  from (select * from ftbl_product order by reg_date desc)) tp, ftbl_product_file tpf ");
		sql.append("  where row_num <= 5 and row_num >= 1 ");
		sql.append(" and tp.pd_no = tpf.pd_no(+) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<ProductFileVO> selectRecentFileList(){
		
		List<ProductFileVO> RecentFileList = new ArrayList<ProductFileVO>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select pd_no, file_save_name ");
		sql.append(" from ftbl_product_file where pd_no = ? ");
		return list;
	}
	
}
