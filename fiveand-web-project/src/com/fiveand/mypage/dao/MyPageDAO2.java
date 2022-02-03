package com.fiveand.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;

public class MyPageDAO2 {
	
	/**
	 * 내가 참여한 auction목록 (최근 순, 페이징 X)
	 *  
	 */
	public List<ProductVO> selectMySugg(String id){
			System.out.println("dao id : " + id);
			List<ProductVO> list = new ArrayList<ProductVO>();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from ( select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
			sql.append("  from ftbl_product p ");
			sql.append("  , ( select pd_no, row_number() over(partition by pd_no order by pd_no) f_row_num, file_save_name from  ftbl_product_file) f ");
			sql.append("  , ftbl_category c ");
			sql.append("  , (select row_number() over(partition by pd_no order by pd_no) a_row_num, a.* from ftbl_auction a ) a ");
			sql.append(" where a.id = ? ");
			sql.append("        and f_row_num = 1 and a_row_num = 1 ");
			sql.append("        and p.pd_no = f.pd_no and p.c_no = c.c_no and a.pd_no = p.pd_no ");
			sql.append("  order by a.sug_date desc) ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ProductVO productVO = new ProductVO();
					
					productVO.setPdNo(rs.getInt("pd_no"));
					productVO.setPdName(rs.getString("pd_name"));
					productVO.setStartPrice(rs.getInt("start_price"));
					productVO.setDueDate(rs.getString("due_date"));
					productVO.setcNo(rs.getInt("c_no"));
					productVO.setcName(rs.getString("category"));
					productVO.setFileSaveName(rs.getString("file_save_name"));
					System.out.println("dao sug product : " + productVO);
					list.add(productVO);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("dao List : " + list);
			return list;
		}
}
