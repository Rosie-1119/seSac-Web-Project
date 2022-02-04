package com.fiveand.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.util.ConnectionFactory;

public class CategoryDAO {
	
	//1. 카테고리-디지털기기
	public List<Object> selectDigital() {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append(" from ftbl_product p, (  ");
		sql.append(" select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append(" from  ftbl_product_file) f, ftbl_category c " );
		sql.append(" where row_num=1 and p.pd_no = f.pd_no and p.c_no = c.c_no ");
		sql.append(" order by reg_date desc) ");
		sql.append("  where c_no = 1 ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	
	
	//2. 카테고리-생활가전
	public List<Object> selectElectronics() {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append(" from ftbl_product p, (  ");
		sql.append(" select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append(" from  ftbl_product_file) f, ftbl_category c " );
		sql.append(" where row_num=1 and p.pd_no = f.pd_no and p.c_no = c.c_no ");
		sql.append(" order by reg_date desc) ");
		sql.append("  where c_no = 2 ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	//3. 카테고리-가구/인테리어
	public List<Object> selectFurniture() {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append(" from ftbl_product p, (  ");
		sql.append(" select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append(" from  ftbl_product_file) f, ftbl_category c " );
		sql.append(" where row_num=1 and p.pd_no = f.pd_no and p.c_no = c.c_no ");
		sql.append(" order by reg_date desc) ");
		sql.append("  where c_no = 3 ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	//4.카테고리-의류,잡화
	public List<Object> selectClothes() {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append(" from ftbl_product p, (  ");
		sql.append(" select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append(" from  ftbl_product_file) f, ftbl_category c " );
		sql.append(" where row_num=1 and p.pd_no = f.pd_no and p.c_no = c.c_no ");
		sql.append(" order by reg_date desc) ");
		sql.append("  where c_no = 4 ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	//5. 카테고리-뷰티,미용
	public List<Object> selectBeauty() {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append(" from ftbl_product p, (  ");
		sql.append(" select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append(" from  ftbl_product_file) f, ftbl_category c " );
		sql.append(" where row_num=1 and p.pd_no = f.pd_no and p.c_no = c.c_no ");
		sql.append(" order by reg_date desc) ");
		sql.append("  where c_no = 5 ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	//6. 카테고리-도서, 음반
	public List<Object> selectbooks() {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append(" from ftbl_product p, (  ");
		sql.append(" select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append(" from  ftbl_product_file) f, ftbl_category c " );
		sql.append(" where row_num=1 and p.pd_no = f.pd_no and p.c_no = c.c_no ");
		sql.append(" order by reg_date desc) ");
		sql.append("  where c_no = 6 ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	//7. 카테고리-기타
	public List<Object> selectEtc() {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from(   ");
		sql.append(" select p.pd_no, p.pd_name, p.start_price, p.reg_date, to_char(p.due_date, 'mm-dd') as due_date , p.c_no, c.category, f.file_save_name ");
		sql.append(" from ftbl_product p, (  ");
		sql.append(" select pd_no,  row_number() over(partition by pd_no order by pd_no) row_num, file_save_name ");
		sql.append(" from  ftbl_product_file) f, ftbl_category c " );
		sql.append(" where row_num=1 and p.pd_no = f.pd_no and p.c_no = c.c_no ");
		sql.append(" order by reg_date desc) ");
		sql.append("  where c_no = 7 ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				ProductFileVO productFVO = new ProductFileVO();
				productVO.setPdNo(rs.getInt("pd_no"));
				productVO.setPdName(rs.getString("pd_name"));
				productVO.setStartPrice(rs.getInt("start_price"));
				productVO.setDueDate(rs.getString("due_date"));
				productVO.setcNo(rs.getInt("c_no"));
				productVO.setcName(rs.getString("category"));
				
				productFVO.setPdNo(rs.getInt("pd_no"));
				productFVO.setFileSaveName(rs.getString("file_save_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
}

		
		
		
		
		
		
		
		
		
		
		
		
		