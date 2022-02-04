package com.fiveand.category.service;

import java.util.List;

import com.fiveand.category.CategoryDAO;

public class CategoryService {
	
	private CategoryDAO ListDao;
	
	public CategoryService() {
		ListDao = new CategoryDAO();
	}
	
	//1. 카테고리-디지털기기
	public List<Object> selectDigital() {
		
		List<Object> list = ListDao.selectDigital();
		
		return list;
	}
	
	//2. 카테고리-생활가전
		public List<Object> selectElectronics() {
			
			List<Object> list = ListDao.selectElectronics();
			
			return list;
		}
	
	//3. 카테고리-가구/인테리어
		public List<Object> selectFurniture() {
				
			List<Object> list = ListDao.selectFurniture();
					
			return list;
		}		
		
	//4. 카테고리-의류잡화
		public List<Object> selectClothes() {
					
			List<Object> list = ListDao.selectClothes();
					
			return list;
				}
	//5. 카테고리-생활가전
		public List<Object> selectBeauty() {
					
			List<Object> list = ListDao.selectBeauty();
					
			return list;
				}		
		
	//6. 카테고리-도서, 음반
		public List<Object> selectBooks() {
			
			List<Object> list = ListDao.selectBooks();
			
			return list;
		}
	
	//7. 카테고리-기타
		public List<Object> selectEtc() {
			
			List<Object> list = ListDao.selectEtc();
			
			return list;
		}
		
		
}
