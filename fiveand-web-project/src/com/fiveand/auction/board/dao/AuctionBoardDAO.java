package com.fiveand.auction.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		sql.append(" where pd_no = ? ");
		
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
	
	/**
	 * 번호에 따른 프로덕트(제품) 선택
	 * @param no 프로덕트 넘버
	 * @return 해당 프로덕트
	 */
	public ProductVO selectProductByNo(int no) {
		ProductVO product = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select  pd_no, id, pd_name, hope_price, start_price, ");
		sql.append(" 		to_char(reg_date, 'yyyy-mm-dd') reg_date, to_char(due_date, 'yyyy-mm-dd') due_date, ");
		sql.append(" 		pd_simple_info, pd_info, view_cnt, like_cnt, sug_cnt, category ");
		sql.append(" from ftbl_category c, ftbl_product p ");
		sql.append(" where c.c_no = p.c_no and pd_no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductVO();
				product.setPdNo(rs.getInt("pd_no"));
				product.setId(rs.getString("id"));
				product.setPdName(rs.getString("pd_name"));
				product.setHopePrice(rs.getInt("hope_price"));
				product.setStartPrice(rs.getInt("start_price"));
				product.setRegDate(rs.getString("reg_date"));
				product.setDueDate(rs.getString("due_date"));
				product.setPdSimpleInfo(rs.getString("pd_simple_info"));
				product.setPdInfo(rs.getString("pd_info"));
				product.setViewCnt(rs.getInt("view_cnt"));
				product.setLikeCnt(rs.getInt("like_cnt"));
				product.setSugCnt(rs.getInt("sug_cnt"));
				product.setcName(rs.getString("category"));
			}
			
		} catch(Exception e) {{
		}
			e.printStackTrace();
		}
		
		return product;
	}
	
	/**
	 * 번호에 따른 프로덕트(제품) 사진 선택
	 * @param no 프로덕트 넘버
	 * @return 해당 프로덕트(제품) 이미지 리스트
	 */
	public List<ProductFileVO> selectFileByNo(int no){
		List<ProductFileVO> files = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select pd_no, file_ori_name, file_save_name, file_size ");
		sql.append(" from ftbl_product_file ");
		sql.append(" where pd_no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductFileVO file = new ProductFileVO();
				file.setPdNo(rs.getInt("pd_no"));
				file.setFileOriName(rs.getString("file_ori_name"));
				file.setFileSaveName(rs.getString("file_save_name"));
				file.setFileSize(rs.getInt("file_size"));
				files.add(file);
				System.out.println("세이브 파일명 : "+file.getFileSaveName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return files;
	}
}
