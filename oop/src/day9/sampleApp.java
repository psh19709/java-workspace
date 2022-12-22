package day9;

public class sampleApp {
	
	public static void main(String[] args) {
		
		Sample sample = new Sample();		// 알고보니 생성자 메소드 컴파일러가 자동으로 지정했다.
		
		//매개변수 없는 메소드 실행 / 호출
		sample.test1();			// 메소드 실행시 인자로 전달할 값 없음
		
		// 기본자료형 타입 매개변수가 있는 메소드 실행
		int num1 = 10;
		int num2 = 20;
		sample.test2(num1, num2);

		System.out.println("num1의 값 : " + num1);
		System.out.println("num2의 값 : " + num2);
		
		// 클래스타입 매개변수가 있는 메소드 실행
		SampleValue sampleValue = new SampleValue();
		sampleValue.x = 100;
		sampleValue.y = 200;
		// sampleValue에 저장된 SampleValue 객체의 주소값을 전달한다.
		sample.test3(sampleValue); 		//sampleValue 참조변수에 저장된 주소값을 전달한다.
		
		System.out.println("main의 sampleValue.x의 값" + sampleValue.x);
		System.out.println("main의 sampleValue.y의 값" + sampleValue.y);
	}

}
