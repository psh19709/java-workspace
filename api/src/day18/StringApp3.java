package day18;

public class StringApp3 {
	
	public static void main(String[] args) {
		// String의 클래스 메소드
		//String.valueOf(값) 메소드는 지정된 값을 문자열로 변환해서 반환한다.
		// String String.valueOf(boolean value) - true or false를 "true", "false"로 변환해서 반환한다.
		// String String.valueOf(int value) - 100000을 "100000"으로 변환해서 반환한다.
		// String String.valueOf(long value) 
		// String String.valueOf(double value)
		// String String.valueOf(object value)
		
		// 정수를 문자열로 변환하기
		// 정수의 첫번쨰 숫자를 출력하기
		int number = 1234567890;
		String text = String.valueOf(number);		// 문자열로 변환한다 int의 값을
		System.out.println(text.substring(0, 1));
		
	}

}
