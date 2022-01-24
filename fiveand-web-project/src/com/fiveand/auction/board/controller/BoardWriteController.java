package com.fiveand.auction.board.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;
import com.fiveand.util.SesacFileNamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class BoardWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
			request.setCharacterEncoding("utf-8");
		
			 // 파일 업로드를 하기 위해서 cos.jar 추가 및 객체 생성
	        MultipartRequest multi = null;
	 
	        // 업로드 될 파일의 최대 사이즈 (50메가)
	        int sizeLimit = 50 * 1024 * 1024;
	 
	        // 파일이 업로드될 실제 tomcat 폴더의 경로 (WebContent 기준)
	        String savePath = request.getRealPath("/upload"); 
	 
	        // 
	        try{
	            multi=new MultipartRequest(
	                    request
	                    , savePath
	                    , sizeLimit
	                    , "UTF-8"
	                    , new SesacFileNamePolicy()); 
	 
	         }catch (Exception e) {
	                e.printStackTrace();
	        
	         }
	              
				String pdName = multi.getParameter("pdName");
				String id = multi.getParameter("id");
				int hopePrice = Integer.parseInt(multi.getParameter("hopePrice"));
				String pdSimpleInfo = multi.getParameter("pdSimpleInfo");
				String dueDate = multi.getParameter("dueDate");
				String pdInfo = multi.getParameter("pdInfo");
				
				ProductVO product = new ProductVO();
				product.setPdName(pdName);
				product.setId(id);
				product.setHopePrice(hopePrice);
				product.setPdSimpleInfo(pdSimpleInfo);
				//duedate
				product.setPdInfo(pdInfo);
				
				Enumeration<String> files = multi.getFileNames();
				
				while(files.hasMoreElements()) {
					
					//attachFile1, attachFile2를 가져옴
					String fileName = files.nextElement();
					
					//File 객체를 이용해서 (File에 대한 정보)
					//어디 경로에 있고, 어느 사이즈인지, 읽기전용인지 실행할 수 있는지에 대한 정보를 알 수 있음
					//첨부파일이 없으면 file이 null을 가짐
					File file = multi.getFile(fileName);
					
					if(file != null) {
						//attachFile1, ...
						String fileOriName = multi.getOriginalFileName(fileName);
						// 웹서버에 저장된 이름
						String fileSaveName = multi.getFilesystemName(fileName);
						// file 객체로 사이즈를 알 수 있음 (long)형인데 우리파일 사이즈는 작아서 int로 변환
						int fileSize = (int)file.length();
					
						//MVC는 저장할때 모델 단위로 움직이니까 fileVO도 필요함
						BoardFileVO fileVO = new BoardFileVO();
						fileVO.setFileOriName(fileOriName);
						fileVO.setFileSaveName(fileSaveName);
						fileVO.setFileSize(fileSize);
						
						fileList.add(fileVO);
				
					
		return null;
	}
				}
				

}
}
