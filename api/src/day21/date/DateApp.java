package day21.date;

import java.util.Date;

public class DateApp {

	public static void main(String[] args) {
		/*
		 * java.util.Date
		 * 		날짜와 시간정보를 표현하는 클래스
		 * 		가장 많이 사용되는 클래스다.
		 * java.sql.Date
		 * 		날짜 정보를 표현하는 클래스
		 * java.sql.Timestamp
		 * 		시간 정보를 표현하는 클래스
		 * 
		 * 자바1.8부터 날짜와 시간정보를 제공하는 클래스가 추가됨
		 * java.time.LocalDate
		 * 		날짜 정보를 표현하는 클래스
		 * java.time.LocalTime
		 * 		시간 정보를 표현하는 클래스
		 * java.time.LocalDateTime
		 * 		날짜와 시간정보를 표현하는 클래스
		 */
		
		/*
		 * java.util.Date의 주요 API
		 * 		생성자
		 * 			new Date()
		 * 					시스템의 현재 날짜와 시간정보를 표현하는 객체를 생성한다.
		 * 			new Date(long unixTime)
		 * 					지정된 유닉스타임에 해당하는 날짜와 시간정보를 표현하는 객체를 생성한다.
		 * 		주요 메소드
		 * 			long getTime()
		 * 				Date객체의 유닉스타임을 반환한다.
		 * 			boolean before(Date other)
		 * 				Date객체의 날짜와 시간 정보 other보다 이전이면 true를 반환한다.
		 * 			boolean after(Date other)
		 * 				Date객체의 날짜와 시간 정보 other보다 이후이면 true를 반환한다.
		 * 			int compare(Date other)
		 * 				Date객체의 날짜와 시간 정보가 other보다 이전이면 0보다 작은 값
		 * 				Date객체의 날짜와 시간 정보가 other보다 이후이면 0보다 큰 값
		 * 				Date객체의 날짜와 시간 정보가 other과 같으면 0을 반환한다.
		 * 			String toString()
		 * 				Date객체의 날짜와 시간정보를 반환하도록 Object의 toString()을 재정의하였음
		 */
		
		//	시스템의 현재 날짜와 시간정보를 가지고 있는 Date객체 생성하기
		Date now = new Date();
		System.out.println(now);	
		
		// 생성된 Date객체에서 유닉스타임 획득하기
		long unixTime = now.getTime();
		System.out.println(unixTime);
		
		
	}	
}
