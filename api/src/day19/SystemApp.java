package day19;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemApp {

	public static void main(String[] args) {
		/*
		 * System 클래스
		 * 		- 자바 애플리케이션이 실행되는 시스템에 대한 정보 및 시스템과 연결된 입출력 객체를 제공한다.
		 * 		- 공개된 모든 필드와 모든 메소드가 정적변수, 정적메소드다.
		 * 		- 객체 생성없이 정적변수와 정적메소드를 사용할 수 있다.
		 * 		- 주요 API
		 * 			변수
		 * 				static InputStream System.in;
		 * 					- 표준 입력장치(키보드)와 연결된 객체를 제공한다.
		 * 				static PrintStream System.out;
		 * 					- 표준 출력장치(모니터 혹은 콘솔)와 연결된 객체를 제공한다.
		 * 				static PrintStream System.err;
		 * 					- 표준 에러장치(모니터 혹은 콘솔)와 연결된 객체를 제공한다.
		 * 			메소드
		 * 				static String getenv(String name)
		 * 					- 지정된 이름의 컴퓨터의 환경변수 값을 반환한다.
		 * 				static String getProperty(String name)
		 * 					- 지정된 이름의 컴퓨터 속성값을 반환한다.
		 *  			static long	currentTimeMillis()
		 *  				- 컴퓨터의 현재 날짜와 시간정보를 유닉스타입으로 반환한다.
		 *  				- 유닉스타임은 1970년 1월 1일 0시 0분 0초부터 지금 이 순간까지의 경과시간은 1/1000초 단위로 환산한 값이다.
		 *  			static String lineSeparator()
		 *  				- 이 시스템의 줄바꿈문자를 반환한다.
		 *  			static void exit(int status)
		 *  				- 현재 실행중인 자바가상머신을 종료시킨다.
		 *   			static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		 *   				- 배열을 다른 배열로 복사한다.
		 *   				- 매개변수
		 *   					src				: 원본배열
		 *   					srcPos(ition)	: 원본배열에서 복사 시작위치 (대부분 0이다.)
		 *   					dest			: 대상배열
		 *   					destPos(ition)	: 대상배열에 값 추가 위치 (대부분 0이다.)
		 *   					length			: 복사할 갯수 (대부분 원본배열의 길이와 동일한 값)
		 */
		
		// 시스템의 환경 변수값 조회하기
		String value1 = System.getenv("path");
		System.out.println("시스템환경변수 [PATH] " + value1);
		String value2 = System.getenv("username");
		System.out.println("시스템 사용자 이름 [USERNAME] " + value2);
		
		// 시스템의 모든 환경 변수값 출력해보기
	      Map <String, String> envMap =  System.getenv();
	      Set<Map.Entry<String, String>> entries = envMap.entrySet();
	      for (Map.Entry<String, String> entry : entries) {
	         System.out.println("[" + entry.getKey() + "] " + entry.getValue());
	      }
	      
	      // 시스템의 속성값 조회
	      String value3 = System.getProperty("user.home");
	      System.out.println("사용자의 디렉토리: " + value3);
	      String value4 = System.getProperty("user.dir");
	      System.out.println("프로젝트 디렉토리: " + value4);
	      
	      // 시스템의 모든 속성값 조회하기
	      System.out.println("### 시스템의 환경 속성값 출력하기");
	      Properties properties = System.getProperties();
	      Set<Object> keys = properties.keySet();
	      for (Object obj : keys) {
	         String key = (String) obj;
	         String value = properties.getProperty(key);
	         System.out.println("["+key+"] " + value);
	      }
	}
}
