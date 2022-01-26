package com.fiveand.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.util.ConnectionFactory;
import com.fiveand.util.JDBCClose;

public class MyPageDAO {

	/**
	 * 마이페이지(내정보 조회) ---미완...내 아이디 가져와서 조회해야하잖아 왜 안됨?? 샹
	 */
	public MemberVO selectMyInfo(String id) {
		
		MemberVO member = null;	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, phone, email, warning_cnt ");
			sql.append(" from ftbl_member " );
			sql.append(" where id = ? " );
			

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				int warningCnt = rs.getInt("warning_cnt");

				member = new MemberVO(id, name, phone, email, warningCnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return member;

	}
	
	
	/**
	 * 마이페이지(내정보 수정) -----미완(where check 할것!)
	 */
	public void UpdateMyInfo(MemberVO member) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try { 
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" update ftbl_member ");
			sql.append(" pwd = ? , phone = ? , email = ? ");
			sql.append(" where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	
	/**
	 * 내가 등록한 auction목록
	 *  
	 */
	/**
	 * 최근 등록된 순으로 리스트 조회 (3*3 개씩 페이징 예정 - 일단 전체 리스트 구현 후 페이징 기능 추가..)
	 * @return
	 */
	public List<Object> selectMyAuction(){
			
			List<Object> list = new ArrayList<Object>();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
			sql.append("  from ftbl_product p, ( ");
			sql.append("  select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
			sql.append("  from  ftbl_product_file) f, ftbl_category c ");
			sql.append("  where id = ? ");
			sql.append("  order by reg_date desc ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					//pstmt.setString(1, membervo.getId());
			){
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ProductVO productVO = new ProductVO();
					ProductFileVO productFVO = new ProductFileVO();
					
					//System.out.println("[[[[" + rs.getString("due_date") + "]");
					
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
	
	
	/**
	 * 내가 등록한 하트 목록 -------미완.
	 *  
	 */
	
	public List<MemberVO> selectMyHeart() {
		
		List<MemberVO> list = new ArrayList<>();	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("pd_no, pd_name, , email, warning_cnt ");
			sql.append(" from ftbl_product");

			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				int warningCnt = rs.getInt("warning_cnt");

				MemberVO member = new MemberVO(id, name, phone, email, warningCnt);
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
