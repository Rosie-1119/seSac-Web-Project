package com.fiveand.signup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fiveand.signup.vo.SignupVO;
import com.fiveand.util.ConnectionFactory;
import com.fiveand.util.JDBCClose;

public class SignupDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	/**
	 * 회원가입
	 */
	public void addMember(SignupVO signup) {
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into FTBL_MEMBER(ID, PWD, NAME, PHONE, EMAIL) ");
			sql.append("values(?, ?, ?, ?, ?) ");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, signup.getId());
			pstmt.setString(2, signup.getPwd());
			pstmt.setString(3, signup.getName());
			pstmt.setString(4, signup.getPhone());
			pstmt.setString(5, signup.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	
	/**
	 * 아이디 중복체크
	 * id = 1  ->  아이디 중복됨
	 */
	public int checkId(SignupVO signup) {
		
		int id = 0;
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select ID ");
			sql.append("from FTBL_MEMBER ");
			sql.append("where ID = ? ");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, signup.getId());
			
			id = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return id;
	}
}
