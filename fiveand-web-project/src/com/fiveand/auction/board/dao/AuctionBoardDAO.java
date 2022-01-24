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
		sql.append(" insert into ftbl_product(pd_no, id, pd_name, hope_price, start_price, due_date, pd_simple_info, pd_info, c_no) ");
		sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, product.getPdNo());
			pstmt.setString(2, product.getId());
			pstmt.setString(3, product.getPdName());
			pstmt.setInt(4, product.getHopePrice());
			pstmt.setInt(5, product.getStartPrice());
			pstmt.setString(6, product.getDueDate());
			pstmt.setString(7, product.getPdSimpleInfo());
			pstmt.setString(8, product.getPdInfo());
			pstmt.setInt(9, product.getcNo());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ftbl_product_file에 파일들 저장
	 */
	public void insertFile(ProductFileVO fileVO) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into ftbl_product_file( ");
		sql.append(" no, pd_no, file_ori_name, file_save_name, file_size ) ");
		sql.append(" values( seq_ftbl_product_file_no.nextval, ?, ?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, fileVO.getPdNo());
			pstmt.setString(2, fileVO.getFileOriName());
			pstmt.setString(3, fileVO.getFileSaveName());
			pstmt.setInt(4, fileVO.getFileSize());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ftbl_product에 게시글 조회수 + 1
	 */
	public void addViewCnt(int pdNo)
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" update ftbl_product ");
		sql.append(" set view_cnt = view_cnt+1 ");
		sql.append(" where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, pdNo);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
