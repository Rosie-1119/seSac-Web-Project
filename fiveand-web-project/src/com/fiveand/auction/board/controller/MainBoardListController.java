package com.fiveand.auction.board.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiveand.auction.board.service.MainBoardListService;
import com.fiveand.auction.board.vo.ProductFileVO;
import com.fiveand.auction.board.vo.ProductVO;
import com.fiveand.controller.Controller;

public class MainBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MainBoardListService service = new MainBoardListService();
		List<Object> list = service.selectRecentList();

		// 0, 2, 4, 6, 8
		ProductVO[] recentList = new ProductVO[5];
		// 1, 3, 5, 7, 9
		ProductFileVO[] recentFileList = new ProductFileVO[5];
		
		for(int i = 0, j = 0; i < list.size(); i += 2, j++) {
			recentList[j] = (ProductVO)list.get(i);
			recentFileList[j] = (ProductFileVO)list.get(i+1);
		}
		
		System.out.println(Arrays.toString(recentList));
		System.out.println(Arrays.toString(recentFileList));
/*		
		
		
//		ProductVO productVO = new ProductVO();
//		ProductFileVO productFVO = new ProductFileVO();
		
//		List<ProductVO> RecentList = new ArrayList<ProductVO>();
//		List<ProductFileVO> RecentFileList = new ArrayList<ProductFileVO>();

		//Object배열을 가지고 있는 리스트 생성
		List<Object[]> MainList = new ArrayList<>();
		//5개의 제품정보, 파일 저장 공간에 저장 해야함
		MainList.add(new ProductVO[5]);
		MainList.add(new ProductFileVO[5]);
		
		//list에 저장되어 있는 값 추출
//		for(int i=0; i<=5; i++) {
//			ProductVO[] = (ProductVO[])list.get(0);
//		}
		
		//ProductVO[] RecentList = (ProductVO[])list.get(0);
		//ProductFileVO[] RecentFileList = (ProductFileVO[])list.get(1);
		
 */		
		request.setAttribute("recentList", recentList);
		request.setAttribute("recentFileList", recentFileList);
		return "/index.jsp";
	}
}
