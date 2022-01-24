package com.fiveand.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class HandlerMapping {
	
	/*dispatcherServlet 의 switch문을 대체할 수 있는 클래스 필요
	 * switch(uri) {
		case "/board/list.do":
			control = new BoardListController();
			break;
		
		case "/board/writeForm.do":
			control = new BoardWriteFormController();
			break;
		
		-> 해당 uri와 생성되는 controller의 객체가 서로 한 쌍을 이뤄서 움직여지게 하면 된다
			Map으로 Key,Value 저장!
	}
	*/
	
	
	//Key값은 uri이므로 String
	//BoardListController, BoardWriteFormController 모두 Controller를 상속받고 있으므로 Controller타입으로 넣어줄 수 있음
	private Map<String, Controller> mappings = null;
	
	
	//생성자에서 Mapping하기
	public HandlerMapping(String propLoc) {
		
		Properties prop = new Properties();
		mappings = new HashMap<>();
		
		try {
			/*
			 * properties 경로 설정 ==> web.xml의 <init-param>에서 설정 => DispatcherServlet 의 init()메서드에서 읽어오도록 설정
			 */
			//InputStream is = new FileInputStream("F:\\Java\\web-workspace_launch\\Mission-Web-MVC\\bean.properties");
			//-> 사용자마다 경로 주소가 다르다
			InputStream is = new FileInputStream(propLoc); //init에서 가져온 경로를 넘겨받으면 됨!
			prop.load(is);
			
			Set<Object> keys = prop.keySet(); //set형식으로 key값들을 가져온다
			System.out.println(keys);
			for(Object key : keys) {
				//System.out.println(key); 모든 key값들이 출력되는지 확인
				
				
				String className = prop.getProperty(key.toString()); //getProperty의 매개변수 타입은 string 이므로 변환필요
				//System.out.println(key + " : " + className);
				/*  /board/writeForm.do : kr.co.mlec.controller.BoardWriteFormController
				    /board/list.do : kr.co.mlec.controller.BoardListController
				    ==> 클래스 명만 가져왔음 -> 생성해서 Controller타입으로 넣어주려면?? ==> 리플렉션
				*/
				
				Class<?> clz = Class.forName(className);
				//className은 경로 명을 가지고 있는 String 이므로 forName메서드에 넣어서 해당 경로에 맞는 클래스를 인식하게 해준다
				//반환한 클래스에서 새로운 객체 생성
				mappings.put(key.toString(), (Controller)clz.newInstance());
				/*
				 * //키값에 해당하는 밸류값 -> 현재 우리는 string 패키지 주소만 가지고 있는 상태
					//그걸 받아와서 객체로 생성하려면 forName 실행
					Class<?> clz = Class.forName("kr.co.mlec.controller.BoardListController");
					BoardListController obj = (BoardListController)clz.newInstance();
					System.out.println(obj.handleRequest(null, null));
					///jsp/board/list.jsp 객체 만들어서 주소값 리턴해줬음
		
				 */
				//이렇게 Map에 넣어주면 bean.properies에 넣어 주기만 해도 된다
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	//이제는 uri요청하는 즉시 getController로 객체를 생성해서 실행해주기 때문에
	//기능을 추가할 때에는 이 생성자에만 키밸류값을 넣어주면 된다 
	//======================> 하지만, 실제 실행하면 HandlerMapping도 블랙박스이므로 값을 추가해줄 수 없음
	//===========> 리플렉션 필요(put 자동화)
	//=====> properties 확장자 파일 필요
	//=>bean.properties 생성 -> 공백 절대 있으면 안됨 & name(key)=value 형태로 입력
	//bean으로 쓴 이유 : 스프링에서 xml로 만들 때, <bean></bean>으로 생성 -> 객체를 하나 생성해준다고 보면 됨
		//<bean class="kr.co.mlec.controller.BoardListController" id="list" /> 이름이 list인 boardListController 객체 생성함
		//@bean 으로도 생성
	
	//uri를 넘겨주면 controller 객체를 반환해주는 메서드 선언
	public Controller getController(String uri) {
		return mappings.get(uri); //여기에서도 mappings객체를 사용해야 하므로 지역변수로 선언해주기 확인
	}
	

}
