package com.fiveand.auction.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;

public class AuctionBoardDAO {
	
	/**
	 * 제품 번호 설정
	 */
	public int selectProductNo() {
		String sql = " select seq_ftbl_product_pd_no.nextval from dual ";
		int pdNo = 0;
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			pdNo = rs.getInt(1);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return pdNo;
	}
	
	/**
	 * ftbl_product에 제품 정보 저장
	 */
	public void insertProduct(ProductVO product) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into ftbl_product(pd_no, id, pd_name, hope_price, start_price, due_date, pd_info, c_no) ");
		sql.append(" values(?, ?, ?, ?, ?, ?, ?, ? ) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, product.getPdNo());
			pstmt.setString(2, product.getId());
			pstmt.setString(3, product.getPdName());
			p
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ftbl_product_file에 파일들 저장
	 */
	public void insertFile(ProductFileVO fileVO) {
		
	}
}
