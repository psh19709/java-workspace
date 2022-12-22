package day21.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatApp {

	public static void main(String[] args) throws Exception{
		/*
		 * java.text.SimpleDateFormat
		 * 		Date를 지정된 포맷을 문자열로 변환한다.
		 * 		지정된 패턴으로 작성된 문자열을 Date로 변환한다.
		 * 		주요 API
		 * 			생성자
		 * 				SimpleDateFormat()			//기본생성자
		 * 					SimpleDateFormat객체를 생성한다.
		 * 				SimpleDateFormat(String pattern)
		 * 					지정된 패턴을 가진 SimpleDateFormat객체를 생성한다.
		 * 			멤버매소드
		 * 				void applyPattern(String pattern)
		 * 					SimpleDateFormat객체의 패턴을 적용한다.
		 * 				String format(Date date)
		 * 					Date객체의 날짜와 시간정보를 지정된 패턴의 문자열로 반환한다.
		 * 				Date parse(String text)
		 * 					지정된 패턴으로 작성된 문자열을 분석해서 Date객체로 반환한다.
		 * 		주요 패턴문자
		 * 			Y	year					yyyy -> 2022	yy -> 22
		 * 			M	month					M -> 9			MM -> 09
		 * 			d	day in month			d -> 
		 * 			a	am/pm
		 * 			h	hour in am/pm(1~12)
		 * 			H 	hour in day(0~23)
		 * 			m	minute
		 * 			s	second
		 * 			S 	millisecond
		 * 			E	day name(요일)
		 * 
		 */
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		// Date객체의 날짜와 시간정보를 지정된 패턴의 문자열로 변환하기
		sdf.applyPattern("yyyy-MM-dd");
		String test1 = sdf.format(now);
		System.out.println(" [yyyy-MM-dd] " + test1);
		
		sdf.applyPattern("yyyy-M-d");
		String test2 = sdf.format(now);
		System.out.println(" [yyyy-M-d] " + test2);
		
		sdf.applyPattern("yyyy년 M월 d일");
		String test3 = sdf.format(now);
		System.out.println(" [yyyy년 M월 d일] " + test3);
		
		sdf.applyPattern("y년 M월 d일 EEEE");
		String test4 = sdf.format(now);
		System.out.println(" [y년 M월 d일 EEEE] " + test4);
		
		sdf.applyPattern("a h:m:s");
		String test5 = sdf.format(now);
		System.out.println(" [a h:m:s] " + test5);
		
		sdf.applyPattern("a hh:mm:ss");
		String test6 = sdf.format(now);
		System.out.println(" [a hh:mm:ss] " + test6);
		
		sdf.applyPattern("a h시 m분 s초");
		String test7 = sdf.format(now);
		System.out.println(" [a h시 m분 s초] " + test7);
		
		sdf.applyPattern("yyyy년 M월 d일 EEEE a h시 m분 s초");
		String test8 = sdf.format(now);
		System.out.println(" [yyyy년 M월 d일 EEEE a h시 m분 s초] " + test8);
	
	
		// 지정된 패턴으로 작성된 문자열을 분석해서 Date객체로 변환하기
		sdf.applyPattern("yyyy-MM-dd");
		Date birth = sdf.parse("1997-09-09");		// 내가 원하는 날짜의 원하는 데이터를 쉽게 얻을 수 있다 parse를 이용해서
		System.out.println(birth);
	}
}







