package day9;

public class Sample {
	
	// 매개변수가 없는 메소드
	public void test1() {
		System.out.println("매개변수 없음");

	}
	
	// 기본자료형 타입의 매개변수가 있는 메소드
	// 매개변수 : int x, int y
	//			정수 2개를 요구한다.
	public void test2(int x, int y) {
		System.out.println("x의 값 : " + x);
		System.out.println("y의 값 : " + y);
		
		x++;
		y++;
		System.out.println("x의 값 : " + x);
		System.out.println("y의 값 : " + y);
	}
	
	// 참조자료형 타입(객체, 배열)의 매개변수가 있는 메소드
	// 매개 변수 : SampleValue sampleValue
	//			SampleValue클래스로 생성한 주소값을 요구한다.
	public void test3(SampleValue sampleValue) {
		System.out.println("test3의 SampleValue: " + sampleValue);
		System.out.println("test3의 SampleValue: " + sampleValue.x);
		System.out.println("test3의 SampleValue: " + sampleValue.y);
		
		
		System.out.println("test3의 SampleValue가 참조하는 객체의 x, y값 변경하기");
		sampleValue.x = 300;
		sampleValue.y = 500;
		
	}
	
	// 반환타입이 void인 메소드
	public void hello() {
		System.out.println("hello");
	}
	
	public void minuse(int x, int y) {   		// void는 반환 타입이 없다고 명시해둔 것이다.
		
		
	}
	// 기본자료형타입의 반환타입이 있는 메소드
	// 반환타입
	//			기본자료형타입(정수, 실수, 문자, 불린)
	//			값이 반환된다.
	public int plus(int x, int y) {
		int z = x + y;
		return z;
	}
	
	// 정수 타입의 z값이 실수타입의 값으로 형변환된 후 반환된다.
//	public double plus2(int x, int y) {
//		int z = x + y;
//		return z;
//	}
//	
//	// 실수타입의 z값이 정수타입의 값으로 형변환되면 데이터 손실이 발생함으로 컴파일 오류다.(명시를 해주면 오류가 발생하지 않는다.)
//	public int plus3(double x, double y) {
//		double z = x + y;
//		//return z;				//이것은 오류이다. 왜냐하면 int와 double은 데이터의 손실이 발생하기 때문이다.
//		return (int)z;          // 이렇게 데이터 손실이 없게 맞춰주면 오류가 발생하지 않는다.
//	}
	 
	// 4byte 정수타입의 z값이 8byte 정수타입의 값으로 형변환된 후 반환된다.
//	public long plus4(int x, int y) {
//		int z = x + y;
//		return z;
//	}
	
	public boolean isEmptyString(String str) {
		if (str == null) {		// 방어적 코딩
			return true;
		}
		int len = str.length();
		if(len > 0) {
			return false;
			} else {
				return true;
			}
	}
	
	// 참조자료형 타입(객체, 배열)의 반환타입이 있는 메소드
	// 반환타입
	//				참조자료형 타입(객체, 배열)
	//				객체나 배열의 주소값이 반환된다.
	//				이 메소드는 반환타입에 지정된 객체의 주소값을 제공한 책임이 있다.
	public SampleValue createSampleValue(int num1, int num2) {
		// SampleValue객체를 생성하고, 생성된 객체의 주소값을 참조변수에 대입한다.
		SampleValue sampleValue = new SampleValue();
		sampleValue.x = num1;
		sampleValue.y = num2;
		
		// 참조변수의 저장된 주소값을 반환한다.
		return sampleValue;
	}

}
