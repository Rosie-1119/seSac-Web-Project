package com.fiveand.search.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;

public class SearchDAO {
	/**
	 * 카테고리 설정 후, 검색한 리스트 조회
	 * cNo, text 를 넘겨줘야 함
	 */
	public List<ProductVO> searchList(String findStr) {
		
		List<ProductVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append("  from ftbl_product p, ( ");
		sql.append("  select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append("  from  ftbl_product_file) f, ftbl_category c ");
		sql.append("  where row_num = 1 and p.pd_no = f.pd_no and p.c_no = c.c_no and instr(p.pd_name, ?) != 0 ");
		sql.append("  order by reg_date desc ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, findStr);
			ResultSet rs = pstmt.executeQuery();;
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setRegDate(rs.getString("reg_date"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				productVO.setFileSaveName(rs.getString("fileSaveName"));
				
				list.add(productVO);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
		
	}
	
}
