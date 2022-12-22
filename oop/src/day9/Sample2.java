package day9;

public class Sample2 {
	
	/*
	 * 메소드 중복정의
	 * 		- 하나의 클래스안에 같은 이름의 메소드를 중복정의하는 것이다.
	 * 		- 메소드 중복정의의 필요조건은 매개변수의 타입, 매개변수의 갯수가 서로 달라야한다.
	 * 		- 자바가상머신은 메소드를 호출시 전달받은 매개변수 인자들을 분석해서 중복정의된 메소드중에서 
	 * 		매개변수의 타입과 갯수가 일치하는 메소드를 실행한다.
	 * 		- 중복정의의 이유
	 * 			비슷한 기능은 일관되게 하나의 이름으로 정의하고 사용하자.
	 * 
	 * 메소드 재정의(Method Overriding) -> 엄청 중요한 개념 9월 15일자로 다음주에 학습
	 * 		상속관계에 있는 클래스
	 */
	
	public int plus(int x, int y) {
		System.out.println("정수 + 정수");
		int z = x + y;
		return z;
	}
	
	public double plus(int a, double b) {
		System.out.println("정수 + 실수");
		double c = a + b;
		return c;
	}
	
	public int plus (int a, int b, int c) {
		System.out.println("정수 + 정수 + 정수");
		int d = a + b + c;
		return d;
	}
	
	public double plus(double x, double y) {
		System.out.println("실수 + 실수");
		double z = x + y;
		return z;
	}
		// 하나의 클래스 안에 같은 메소드 이름을 여러개 중복정의 할 수 있다 -> 메소드 중복정의
		// 메소드 이름을 같이 하려면 매개변수 타입이나 매개변수의 갯수가 다르면 가능하다.
	
}
