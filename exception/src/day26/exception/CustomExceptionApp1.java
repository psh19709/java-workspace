package day26.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomExceptionApp1 {

	public static void main(String[] args) {
		/*
		 *  사용자 정의 예외클래스를 정의하는 목적
		 *  	- 개발하는 애플리케이션에 대한 오류 정보를 표현하는 예외 클래스를 정의하기 위해서다.
		 *  	- 개발하는 애플리케이션에서 발생하는 다양한 예외를 사용자정의 예외를 변환해서 예외처리를 단순화한다.
		 */
		
//		int result1 = CustomExceptionApp1.total(100, 100, 100);
//		System.out.println("합계: " + result1);
//		int result2 = CustomExceptionApp1.total(-10, 100, 100);
//		System.out.println("합계: " + result2);
		
//		int result3 = CustomExceptionApp1.textToInt("1234");
//		System.out.println("정수 값: " + result3);
//		System.out.println();
//		int result4 = CustomExceptionApp1.textToInt("123rkrk4");
//		System.out.println("정수 값: " + result4);
		
		Date result5 = CustomExceptionApp1.textToDate("2022-12-31");
		System.out.println("날짜: " + result5);
		System.out.println();
		Date result6 = CustomExceptionApp1.textToDate("2021231");
		System.out.println("날짜: " + result6);
		
	}
	
	// CustomUnchackedException 예외 발생 가능성이 있는 메소드
	public static int total(int kor, int eng, int math) {
		if(kor < 0) {
			throw new CustomUnchackedException("국어점수가 올바르지 않습니다.");
		}
		if(eng < 0 ) {
			throw new CustomUnchackedException("영어점수가 올바르지 않습니다.");
		}
		if(math < 0 ) {
			throw new CustomUnchackedException("수학점수가 올바르지 않습니다.");
		}
		int total = kor + eng + math;
		return total;
	}
	
	// NumberFormatException 발생 가능성이 있는 메소드
	public static int textToInt(String text) {
		try {
			return Integer.parseInt(text);		
		} catch (NumberFormatException cause) {
			// NumberFormatException -> CustomUnchackedException 발생 가능성이 있는 메소드로
			throw new CustomUnchackedException("숫자가 아닌 문자가 포함되어 있습니다.", cause);		
		}
	}
	
	// ParseException 발생 가능성이 있는 메소드
	public static Date textToDate(String text) {
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(text);
		
		return date;
		} catch (ParseException cause) {
			// ParseException -> CustomUnchackedException 발생 가능성이 있는 메소드로
			throw new CustomUnchackedException("yyyy-MM-dd 형식의 텍스트가 아닙니다.", cause);	
		}
	}
}
