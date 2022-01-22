package com.fiveand.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fiveand.login.vo.LoginVO;
import com.fiveand.util.ConnectionFactory;

public class LoginDAO {

	public LoginVO login(LoginVO loginVO) { 

	
	LoginVO userVO = null;
	

	StringBuilder sql = new StringBuilder();
	sql.append("select id, pwd, type ");
	sql.append("  from ftbl_member ");
	sql.append(" where id = ? and pwd = ? ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				userVO = new LoginVO();
				
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("pwd"));
				userVO.setType(rs.getString("type"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return userVO;
	}
	}
