package day19;

public class WrapperApp {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 * 		- 기본자료형 값을 담은 객체를 생성하는 클래스다.
		 * 		- 각각의 기본자료형마다 대응되는 Wrapper 클래스가 존재한다.
		 * 			- byte --- Byte
		 * 			- short --- Short
		 * 			- int --- Int
		 * 			- long --- Long
		 * 			- float --- Float
		 * 			- double --- Double
		 * 			- char --- Char
		 * 			- boolean --- Boolean
		 * 		- Wrapper 객체에 기본자료형값 담기
		 * 			Integer x = new Integer(10);
		 * 			Long x = new Long(100000000L);
		 * 			Double x = new Double(3.14);
		 * 			Boolean x = new Boolean(true);
		 * 		- Auto-boxing을 이용해서 Wrapper 객체에 기본자료값 담기
		 * 			Integer x = 10;              // 컴파일러가 Integer x = new Integer(10); 이렇게 해줌
		 * 			Long x = 100000000L;
		 * 			Double x = 3.14;
		 * 			Boolean x = true;
		 * 			* 오토박싱은 변수의 타입이 Wrapper클래스타입이면 왼쪽 코드와 같이 적었을 때
		 * 				실제로 오른쪽 코드가 실행되는 것이다.
		 * 			- Auto-Unboxing을 이용해서 Wrapper 객체를 기본자료형타입에 변수에 대입하기
		 * 				Integer x = new Integer(10);
		 * 				int y = x;			// int y = x.intValue(); x가 참조하는 Integer객체의 값에 10이 대입된다.
		 * 
		 * 			Double x = new Double(3.14);
		 * 			double y = x;			// double y = x.doubleValue();
		 * 				* 오토언박싱은 Wrapper객체를 기본자료형타입의 변수에 대입하면
		 * 					Wrapper객체의 xxValue() 메소드를 실행해서 Wrapper객체에 저장된 값이 대입된다.
		 * 
		 */
		
		// 오토박싱이 지원되기 때문에 기본자료형값을 대입하면 
		// 1. 지정값을 담고 있는 Wrapper객체가 생성된다.
		// 2. 생성된 Wrapper
		Integer a = 10;				// a는 Integer객체의 주소값을 가지고 있다.
		Long b = 10000000000000L;	// b는 Long객체의 주소값을 가지고 있다.
		Double c = 3.14;			// c는 Double객체의 주소값을 가지고 있다.
		
		System.out.println(a);		// System.out.println(a.toString());	"10" (String 문자열)
		System.out.println(b);		// System.out.println(a.toString());	"10000000000000" (String 문자열)
		System.out.println(c);		// System.out.println(a.toString());	"3.14" (String 문자열)
		System.out.println();
		
		int x = a;					// x는 a가 참조하는 Integer객체의 정수값 10을 가지고 있다.
		long y = b;					// y는 b가 참조하는 Long 객체의 정수의 10000000000000을 가지고 있다.
		double z = c;				// z는 c가 참조하는 double객체의 실수값 3.14를 가지고 있다.
		
		System.out.println(x);		//10(int)
		System.out.println(y);		//10000000000000(long)
		System.out.println(z);		//3,14(double)
		System.out.println();
		
		Integer k =10;				// 
		Integer i = 100;
		Double j = 3.0;
		
		// k, i, j는 객체의 주소값을 가지고 있지만, 사칙연산에 참여하게 되면 그 객체가 가지고 있는 기본자료형 값이 사칙연산에 이용된다.
		System.out.println(k + i + j);
				
	}
}
