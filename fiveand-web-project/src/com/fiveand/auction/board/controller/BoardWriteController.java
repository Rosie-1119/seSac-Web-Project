package com.fiveand.auction.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.service.AuctionBoardService;
import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;
import com.fiveand.util.SesacFileNamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class BoardWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		// 파일이 업로드될 실제 tomcat 폴더의 경로 (WebContent 기준)
		String savePath = request.getRealPath("/upload");
		// 업로드 될 파일의 최대 사이즈 (50메가)
		int sizeLimit = 50 * 1024 * 1024;
		
		// 파일 업로드를 하기 위해서 cos.jar 추가 및 객체 생성
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new SesacFileNamePolicy());
		

		String pdName = multi.getParameter("pdName"); // 제품명
		String id = multi.getParameter("id"); // 등록자 아이디
		int hopePrice = Integer.parseInt(multi.getParameter("hopePrice").trim()); // 희망가
		String pdSimpleInfo = multi.getParameter("pdSimpleInfo"); // 한줄정보
		int startPrice = Integer.parseInt(multi.getParameter("startPrice").trim()); // 시작가
		String dueDate = multi.getParameter("dueDate"); // 마감일
		String pdInfo = multi.getParameter("pdInfo").trim(); // 상세정보
		//System.out.println(multi.getParameter("cNo"));
		int cNo = Integer.parseInt(multi.getParameter("cNo")); // 카테고리수
		
		
		ProductVO product = new ProductVO();
		product.setPdName(pdName);
		product.setId(id);
		product.setHopePrice(hopePrice);
		product.setPdSimpleInfo(pdSimpleInfo);
		product.setStartPrice(startPrice);
		product.setDueDate(dueDate);
		product.setPdInfo(pdInfo);
		product.setcNo(cNo);

		List<ProductFileVO> fileList = new ArrayList<>();
		Enumeration<String> files = multi.getFileNames();

		while (files.hasMoreElements()) {

			// attachFile1, attachFile2를 가져옴
			String fileName = files.nextElement();

			// File 객체를 이용해서 (File에 대한 정보)
			// 어디 경로에 있고, 어느 사이즈인지, 읽기전용인지 실행할 수 있는지에 대한 정보를 알 수 있음
			// 첨부파일이 없으면 file이 null을 가짐
			File file = multi.getFile(fileName);

			if (file != null) {
				// attachFile1, ...
				String fileOriName = multi.getOriginalFileName(fileName);
				// 웹서버에 저장된 이름
				String fileSaveName = multi.getFilesystemName(fileName);
				// file 객체로 사이즈를 알 수 있음 (long)형인데 우리파일 사이즈는 작아서 int로 변환
				int fileSize = (int) file.length();

				// MVC는 저장할때 모델 단위로 움직이니까 fileVO도 필요함
				ProductFileVO fileVO = new ProductFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);

				fileList.add(fileVO);
			}
		}

		AuctionBoardService service = new AuctionBoardService();

		int no = service.insertBoard(product, fileList);


		
		System.out.println("pdName : " + pdName);
		System.out.println("pdId : " + id);
		System.out.println("hopePrice : " + hopePrice);
		System.out.println("pdSimpleInfo : " + pdSimpleInfo);
		System.out.println("startPrice : " + startPrice);
		System.out.println("dueDate : " + dueDate);
		System.out.println("pdInfo : " + pdInfo);
		System.out.println("cNo : " + cNo);

		//return "redirect:/auction/detail.do?pdNo="+pdNo;
		return "redirect:/detail/detail.do?no="+no;
	}

}
