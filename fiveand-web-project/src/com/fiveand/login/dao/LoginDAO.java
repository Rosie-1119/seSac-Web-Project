package com.fiveand.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fiveand.member.vo.MemberVO;
import com.fiveand.util.ConnectionFactory;

public class LoginDAO {

	public MemberVO login(MemberVO memberVO) { 

	
	MemberVO userVO = null;
	
	System.out.println("member dao : " + memberVO);
	StringBuilder sql = new StringBuilder();
	sql.append("select id, pwd, type ");
	sql.append("  from ftbl_member ");
	sql.append(" where id = ? and pwd = ? ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				
				userVO = new MemberVO();
				
				userVO.setId(rs.getString("id"));
				userVO.setPwd(rs.getString("pwd"));
				userVO.setType(rs.getString("type"));
				System.out.println("dao userVO : " + userVO);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return userVO;
	}
	}
