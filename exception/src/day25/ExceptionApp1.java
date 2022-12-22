package day25;

public class ExceptionApp1 {
	/*
	 * 오류는 두가지 Error와 Exception으로 나뉜다.
	 * 
	 * 	Error
	 * 		- 시스템, 운영체제, 자바가상머신의 오류가 원인이다.
	 * 		- 개발자가 처리할 수 없는 오류다
	 * 		- Error는 예외처리대상이 아니다.
	 * 
	 * 	Exception
	 * 		- 개발자의 코딩실수, 사용자의 잘못된 사용으로 발생하는 오류가 원인이다.
	 *		- 예외는 예외처리를 통해서 프로그램의 비정상적인 종료를 방지할 수 있다.
	 *		- 예외는 UncheckedException, CheckedException이 있다.
	 *			최신의 라이브러리나 프레임워크는 대부분 UncheckedException을 사용한다.
	 */
	public static void main(String[] args) {
		
		System.out.println("### 프로그램 시작");
		
		// UncheckedException이 발생하는 예
		int number1 = Integer.parseInt("1234");
		System.out.println("첫번쨰 숫자: " + number1);
		
		int number2 = Integer.parseInt("1234A");
		System.out.println("두번쨰 숫자: " + number2);
		
		System.out.println("### 프로그램 종료");
	}
}
