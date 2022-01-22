package com.fiveand.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//대표적으로 요청을 받는 servlet을 만들어준다
public class DispatcherServlet extends HttpServlet{
	/*
	 * 가상의 url설정 예시
	 * 전체게시글 조회 :   /board/list.do
	 * 상세게시글 조회:   /board/detail.do
	 * 새 글 등록        :   /board/writeForm.do
	 * 마이페이지       :   /board/mypage.do
	 * 대부분 .do 이런식으로 작성
	 * 
	 * 다음 --> .daum
	 * 네이버 -> .naver 각자의 가상의 url생성
	 * =>MVC패턴으로 웹을 구성했음을 알 수 있음!
	 */
	
	
	//service()에서도 사용해야 하므로 지역변수로 선언
	private HandlerMapping mappings = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ServletConfig 가 환경설정에 대한 제어를 할 수 있음 => web.xml 에서 우선 <init-param> 설정
		String propLoc = config.getInitParameter("propLocation");
		//System.out.println("prop : " + propLoc);
		
		//Map객체를 요청받을때마다 생성하는 것이 아니라, 최초에 한 번만 생성하자
		mappings = new HandlerMapping(propLoc); //여기에서 객체 생성
		
	}
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("요청처리");
		//요청 .do로 끝나는 url이 들어오면 무조건 servlet에서 받아서 처리한다
		
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath(); 
		//톰캣 - Modules - path 에 저장된 경로의 이름을 가져오는 메서드
		//우리는 Dynamic Project 이름을 가져오는 용도로 사용할 수 있다
		uri = uri.substring(contextPath.length()); //contextPath 길이 이후부터 끝까지 잘라내기
		
		System.out.println("요청 URI : " + uri);
		//요청 URI : /Mission-Web-MVC/*.do
		//요청 URI : /Mission-Web-MVC/board/list.do 요청된 uri 형태를 가져올 수 있다
		
		
		try{
			
			//System.out.println("contextPath : " + contextPath);
			//요청된 uri를 분석
			/*
			switch(uri) {
				case "/board/list.do":
					//System.out.println("전체 게시글 조회");
					//BoardListController list = new BoardListController(); //객체지향 -> controller가 dao역할을 담당함
					control = new BoardListController(); //묵시적 형변환으로 자식객체 생성 -> 동일한 메서드를 실행하는 것이므로 switch문 밖에서 한꺼번에 실행
					
					//controller가 상세보기 할 경우, 글 번호처럼 요청 객체의 정보를 통해 작업해야 하는 경우가 생긴다
					//따라서 request, response 객체를 모두 넘겨주기 (response는 쿠키 조회를 할 때에 필요할 수 있으므로 같이 넘겨준다)
					
					break;
					
				case "/board/writeForm.do":
					//System.out.println("새 글 등록");
					//BoardWriteFormController write = new BoardWriteFormController();
					
					control = new BoardWriteFormController();
					break;
				
				//현재의 코드는 제공하는 기능마다 case를 하나씩 다 줘야 함 (기능30개 -> case 30개)
				//하지만 실제 실행되면 이 곳은 블랙박스가 되므로 고칠 수 없음 => 접근할 수 있는 다른 쪽에 만들어주자 => HandlerMapping
			}*/
			
			
			//HandlerMapping mappings = new HandlerMapping();
			Controller control = mappings.getController(uri); //init에서 생성된 객체를 사용
			//uri가 10만번 요청 될때마다 10만개 map객체를 또 생성 또 생성 ==> 안좋다 ==> init에서 만들어주자!!
			
			
			//if(control != null) 로 nullPointException 잡을 수 있음 --> 우선은 안넣음
				String callPage = control.handleRequest(request, response);
				
				
				//1. forward
				//2. sendRedirect 선택
				if(callPage.startsWith("redirect:")) {
					//redirect:가 붙어서 날라오므로 잘라줘야 함
					callPage = callPage.substring("redirect:".length());
					response.sendRedirect(request.getContextPath() + callPage);
					//로그인 실패하면 http://localhost:9999/Mission-Web-MVC/login.do
					//로그인 성공하면 http://localhost:9999/Mission-Web-MVC/
					//형태로 포워드가 아니라 이동할 주소로 바로 간다
					
					//이 때, redirect의 루트 위치는 forward 루트 위치와 다름
					//그래도 그냥 보내놓고 DispatcherServlet에서 붙여서 넘겨주자
					
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
					dispatcher.forward(request, response);
					//list.jsp로 포워드 시켰으므로 해당 url을 실행하면 현재 서블릿 이 응답해주는것이 아니라 list.jsp가 응답한 화면이 출력된다!
				}
				
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e); //발생한 예외를 다시 servletException으로 넘겨준다 -> 위에서 처리할 수 있도록
		} 
		
		
	}

	
}
