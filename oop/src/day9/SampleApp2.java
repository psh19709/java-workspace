package day9;

public class SampleApp2 {
	public static void main(String[] args) {
		//반환타입 활용하기
		Sample sample = new Sample();
		
		// 반환타입이 void인 메소드 호출
		sample.hello();
		
		// 반환타입이 int인 메소드 호출
		int result1 = sample.plus(10, 30);
		System.out.println("결과값1: " + result1);
		
		// 반환타입이 void인 메소드 호출 -반환타입이 void인 메소드는 System.out.println() 메소드의 인자로 사용할 수 없다.
		//System.out.println(sample.hello());   	// 컴파일 오류가 나타난다.
		
		//반환타입이 int인 메소드 호출
		System.out.println(sample.plus(100, 200));
		
		// 반환타입이 boolean이고 매개변수타입이 String인 메소드 호출
		boolean result2 = sample.isEmptyString("");  // 빈 문자열
		boolean result3 = sample.isEmptyString("안녕하세요");
		boolean result4 = sample.isEmptyString(null);
		System.out.println("결과값2: " + result2);
		System.out.println("결과값3: " + result3);
		System.out.println("결과값4: " + result4);
		
		// 반환타입이 참조자료형인 메소드 호출
		SampleValue result5 = sample.createSampleValue(10, 20);
		SampleValue result6 = sample.createSampleValue(100, 220);
		SampleValue result7 = sample.createSampleValue(150, 620);
		System.out.println("result5가 참조하는 객체: " + result5);
		System.out.println(result5.x + " , " + result5.y);
		System.out.println("result6가 참조하는 객체: " + result6);
		System.out.println(result6.x + " , " + result6.y);
		System.out.println("result7가 참조하는 객체: " + result7);
		System.out.println(result7.x + " , " + result7.y);
		
	}

}
