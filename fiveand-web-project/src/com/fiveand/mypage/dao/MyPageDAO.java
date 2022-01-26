package com.fiveand.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.fiveand.member.vo.MemberVO;
import com.fiveand.util.ConnectionFactory;
import com.fiveand.util.JDBCClose;

public class MyPageDAO {

	/**
	 * 마이페이지(내정보 조회) ---완
	 */
	public List<MemberVO> selectMyInfo() {
	
		List<MemberVO> list = new ArrayList<>();	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, phone, email, warning_cnt ");
			sql.append(" from ftbl_member");

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
			sql.append(" where no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			
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
	
	public List<MemberVO> selectMyAuction() {
		
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
