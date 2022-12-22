package day21.date;

import java.util.Calendar;

public class CalendarApp {
	public static void main(String[] args) {
		/*
		 * Calendar
		 * 		- 날짜와 시간정보 및 다양한 정보를 표현하는 추상 클래스다.
		 * 		- Calendar 클래스를 구현하는 대표적인 클래스는 GregorianCalendar(서력기원 태양력)다.
		 * 		- 주요 API
		 * 			정적 메소드
		 * 				Calendar.getInstance()
		 * 					시스템의 현재 날짜와 시간정보를 포함하는 GregorianCalendar객체(실제로 생성되는 개체는 GregorianCalendar다.)를 반환한다.
		 *			멤버 메소드
		 *				int get(int field)
		 *					지정된 필드에 해당하는 정보를 반환한다.
		 *							field값은 상수로 장의되어 있다
		 *							Calendar.YEAR				년도	
		 *							Calendar.MONTH				월, 월은 0부터 시작한다. 1월 = 0
		 *							Calendar.DAY_OF_MONTH		일
		 *							Calendar.HOUR				시
		 *							Calendar.MINUTE				분
		 *							Calendar.SECOND				초
		 *							Calendar.DAY_OF_WEEK		요일(숫자)
		 *				void set(int field, int value)
		 *					지정된 필드에 해당하는 값을 변경한다.
		 *				void setTime(Date date)
		 *					전달받은 Date객체로 낳짜와 시간정보가 변경된다.
		 *				void getTime()
		 *					Calendar객체의 날짜와 시간정보외 동일한 정보를 가지는 Date객체를 반환한다.
		 *				void getTimeInMillis()
		 *					Calendar객체의 날짜와 시간정보에 해당하는 유닉스값을 반환한다.
		 *
		 */
		
		// 시스템의 지역, 시간대 정보를 바탕으로 현재 날짜와 시간정보를 포함하는 Calendar 객체가 반환된다.
		Calendar now = Calendar.getInstance();
		
		// 년,월,일 정보 변경하기
		now.set(Calendar.YEAR,1997);
		now.set(Calendar.MONTH, 9);
		now.set(Calendar.DAY_OF_MONTH, 9);
		
		// 년,월,일 정보 조회하기
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;					//1월은 0부터 시작하기 떄문에 + 1을 해줘야한다.
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.println("년: " + year);
		System.out.println("월: " + month);
		System.out.println("일: " + day);
		System.out.println("시: " + hour);
		System.out.println("분: " + minute);
		System.out.println("초: " + second);
	}
}
