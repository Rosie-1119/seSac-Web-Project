package com.fiveand.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;
import com.fiveand.util.JDBCClose;

public class MyPageDAO2 {
	
	/**
	 * 내가 참여한 auction목록 (최근 순, 페이징 X)
	 *  
	 */
	public List<ProductVO> selectMySugg(String id){
		
			//System.out.println("dao id : " + id);
			List<ProductVO> list = new ArrayList<ProductVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = new ConnectionFactory().getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name, a.id  "
						+ "from ftbl_product p, "
						+ "( select pd_no, row_number() over(partition by pd_no order by pd_no) row_num, file_save_name from  ftbl_product_file) f, "
						+ "ftbl_category c, "
						+ "(select row_number() over(partition by pd_no order by pd_no) row_num, a.* from ftbl_auction a ) a "
						+ "where a.id = ? "
						+ "and f.row_num = 1 and a.row_num = 1 "
						+ "and p.pd_no = f.pd_no and p.c_no = c.c_no and a.pd_no = p.pd_no "
						+ "order by a.sug_date desc ");
				pstmt = conn.prepareStatement(sql.toString());
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
					
					list.add(productVO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(pstmt, conn);
			}
			
	        //System.out.println("dao list : " +list);
			return list;
		}
	
	/**
	 * 낙찰된 경매 리스트
	 *  
	 */
	public List<ProductVO> selectMyWin(String id){
		
			//System.out.println("dao id : " + id);
			List<ProductVO> list = new ArrayList<ProductVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = new ConnectionFactory().getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(" select p.pd_no, p.pd_name, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name, s.sug_id, s.sug_price, s.payment  "
						+ "from ftbl_product p, "
						+ "( select pd_no, row_number() over(partition by pd_no order by pd_no) row_num, file_save_name from  ftbl_product_file) f, "
						+ "ftbl_category c, "
						+ "( select * from ftbl_sold) s "
						+ "where s.sug_id = ? and p.due_date < sysdate "
						+ "and f.row_num = 1 "
						+ "and p.pd_no = f.pd_no and p.c_no = c.c_no and s.pd_no = p.pd_no "
						+ "order by s.sug_date desc ");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ProductVO productVO = new ProductVO();
					
					productVO.setPdNo(rs.getInt("pd_no"));
					productVO.setPdName(rs.getString("pd_name"));
					productVO.setDueDate(rs.getString("due_date"));
					productVO.setcNo(rs.getInt("c_no"));
					productVO.setcName(rs.getString("category"));
					productVO.setFileSaveName(rs.getString("file_save_name"));
					productVO.setSugId(rs.getString("sug_id"));
					productVO.setSugPrice(rs.getInt("sug_price"));
					productVO.setPayment(rs.getInt("payment"));
					
					list.add(productVO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(pstmt, conn);
			}
			
	        //System.out.println("dao list : " +list);
			return list;
		}
	
	
}
