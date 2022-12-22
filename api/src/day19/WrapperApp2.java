package day19;

public class WrapperApp2 {
	
	public static void main(String[] args) {
		
		/*
		 * Wrapper 클래스의 주요 API
		 * 		Integer
		 * 			필드
		 * 				static final int MAX_VALUE
		 * 						int 타입의 최대값
		 * 				static final int MIN_VALUE
		 * 						int 타입의 최소값
		 * 			메소드
		 * 				정적메소드
		 * 					static int Integer.parseInt(String text)
		 * 					숫자로 구성된 문자열을 정수로 변환해서 반환한다.
		 * 					"1234" -> 1234
		 * 					"3.14" -> 오류 
		 * 				static String toBinaryString(int value)
		 * 					정수를 2진수로 구성된 문자열을 반환한다.
		 * 				static String toHexString(int Value)
		 * 					정수를 16진수로 구성된 문자열을 반환한다.
		 * 				static String toOctalString(int value)
		 * 					정수를 8진수로 구성된 문자열을 반환한다.
		 * 					
		 * 
		 * 		Long
		 * 			필드
		 * 				static final long MAX_VALUE
		 * 						long 타입의 최대값
		 * 				static final long MIN_VALUE
		 * 						long 타입의 최소값
		 * 			메소드
		 * 				정적메소드
		 * 					static long Long.parseLong(String text)
		 * 					숫자로 구성된 문자열을 정수로 변환해서 반환한다.
		 * 					"1000000000" -> 100000000
		 * 					"3.14" -> 오류 
		 * 				static String toBinaryString(long value)
		 * 					정수를 2진수로 구성된 문자열을 반환한다.
		 * 				static String toHexString(long Value)
		 * 					정수를 16진수로 구성된 문자열을 반환한다.
		 * 				static String toOctalString(long value)
		 * 					정수를 8진수로 구성된 문자열을 반환한다.
		 * 
		 * 		Double
		 * 			필드
		 * 				static final double MAX_VALUE
		 * 						double 타입의 양수 최대값
		 * 				static final double MIN_VALUE
		 * 						double 타입의 양수 최소값
		 * 			메소드
		 * 				정적메소드
		 * 					static double Double.parseDouble(String text)
		 * 					숫자로 구성된 문자열을 실수로 변환해서 반환한다.
		 * 					"123" -> 123.0
		 * 					"3.14" -> 3.14
		 * 				
		 */
		
		
		String text1 = "1234";				// text의 값이 공백, 숫자가 아닌 문자, 소숫점이 포함되어 있으면 정수로 변환할 때 오류 발생
		String text2 = "33";
		int value1 = Integer.parseInt(text1);
		int value2 = Integer.parseInt(text2);
		
		System.out.println(value1*value2);
	}

}
