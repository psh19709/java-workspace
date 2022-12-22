package day21.format;

import java.text.DecimalFormat;

public class DecimalFormatApp {

	public static void main(String[] args) throws Exception {
		/*
		 * java.text.DecimalFormat
		 * 			숫자를 지정된 포멧을 문자열로 변환한ㄴ다.
		 * 			지정된 패턴으로 작성된 문자열을 숫자로 변환한다.
		 * 
		 * 		주요 API
		 * 			생성자
		 * 				DecimalFormat()
		 * 				DecimalFormat(String pattern)
		 * 					지정된 패턴이 적용된 DecimalFormat 객체를 생성한다.
		 * 			멤버메소드
		 * 				Void applyPattern(String pattern)
		 * 					DecimalFormat객체에 지정된 패턴을 적용한다.
		 * 				string format(long number)
		 * 					정수를 지정된 패턴의 문자열로 변환한다.
		 * 				String format(double number)
		 * 					실수를 지정된 패턴의 문자열로 변환한다.
		 * 				Number parse(String text)
		 * 					지정된 패턴으로 작성된 문자열을 Number객체로 변환한다.
		 * 				Number객체는 intValue(), longValue(), doubleValue() 등을 가지고 있다.
		 * 
		 * 		주요 패턴문자
		 * 			#		숫자 하나
		 * 			0		숫자 하나
		 * 			-		마이너스 부호
		 * 			,		자릿수
		 * 			.		소숫점
		 * 
		 */
		
		// 숫자를 지정된 패턴의 문자열로 변환하기
		DecimalFormat df = new DecimalFormat();
		
		// 소숫점이 없는 정수를 표현하고, 3자리마다 , 를 추가한다.
		df.applyPattern("#,###");
		String text1 = df.format(1000000000);
		System.out.println("[#,###] " + text1);			//1,000,000,000
		
		df.applyPattern("0,000");
		String text2 = df.format(123456789);
		System.out.println("[0,000] " + text2);			//123,456,789
		
		// 소숫점 3번째자리에서 반올림해서 문자열로 표현해라
		df.applyPattern("#,###.##");					// 소숫점 두번쨰자리까지 표현하라는 건데 그럼 소숫점 3번째 자리에서 반올림이 발생한다.
		String text3 = df.format(123.4517);
		System.out.println("[#,###.##] " + text3);		//123.46
		
		// 소숫점 3번째자리에서 반올림해서 문자열로 표현해라. 지정된 소숫점자리보다 소숫점 자리가 적으면 없는 부분은 표시하지 않는다.
		df.applyPattern("#,###.##");					
		String text4 = df.format(123.4);
		System.out.println("[#,###.##] " + text4);		//123.4
		
		// 소숫점 3번째자리에서 반올림해서 문자열로 표현해라. 지정된 소숫점자리보다 소숫점 자리가 적어도 0으로 표시한다.
		df.applyPattern("#,###.00");					
		String text5 = df.format(123.4);
		System.out.println("[#,###.##] " + text5);		//123.40
		
		double average = 220/3.0;
		String text6 = df.format(average);
		System.out.println("평균점수: " + text6);
		
		// 문자열을 숫자로 변환하기
		/*
		 * "1234" 				Integer.parsInt("1234") -> 1234
		 * "10000000000" 		Long.parsLong(10000000000) -> 10000000000
		 * "3.14" 				Double.parseDouble("3.14") -> 3.14
		 * 
		 * "1,000,000"			DecimalFormat객체의 parse("1,000,000") + Number 객체 -> Number객체의 intValue() -> 1000000
		 * "1,000,000.23"		DecimalFormat객체의 parse("1,000,000.23") + Number 객체 -> Number객체의 doubleValue() -> 1000000.23
		 */
		
		df.applyPattern("#,###");
		Number number1 = df.parse("10,000,000");
		int value1 = number1.intValue();
		System.out.println(value1);
	}

}
