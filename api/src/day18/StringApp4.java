package day18;

public class StringApp4 {

	public static void main(String[] args) {
		/*
		 * StringBuilder와 StringBuffer
		 * 		값을 저장하는 내부 저장소를 가지고 있는 객체다.
		 * 		주요 API
		 * 			StringBuilder append(String str)
		 * 			StringBuilder append(int value)
		 * 			StringBuilder append(long value)
		 * 			StringBuilder append(double value)
		 * 			StringBuilder append(boolean value)
		 * 			StringBuilder append(char value)
		 * 					- 매개변수의 인자로 전달받은 값은 StringBuilder의 내부 저장소에 순서대로 저장시킨다.
		 * 			StringBuilder toString() 
		 * 				- 내부저장소에 저장된 값을 하나의 문자열로 만들어서 반환한다.
		 * 				- Object toString() 메소드를 재정의하였다.
		 */
		
		StringBuilder builder = new StringBuilder();	// 멀티 쓰레드 환경이 아닐 때 
		//StringBuffer buffer = new StringBuffer();		//synchronized 키워드가 붙어있다. 멀티 쓰레드 환경일 때
		
		// StringBuilder객체의 내부저장소(버퍼)에 값 추가하기
		builder.append("홍길동");
		builder.append(", ");
		builder.append("전자공학과");
		builder.append(", ");
		builder.append(3);
		builder.append(", ");
		builder.append(180.5);
		builder.append(", ");
		builder.append(81.3);
		builder.append(", ");
		builder.append('A');
		
		// 내부저장소에 추가관 값을 문자열로 반환하기
		String text = builder.toString();
		System.out.println(text);
		
		StringBuilder builder2 = new StringBuilder();
		// StringBuilder 객체의 append()메소드는  StringBuilder객체를 반환하기 때문에
		// 메소드 체이닝(Method Chaining)이 지원되는 메소드다.
		// 메소드 체이닝을 지원하는 객체는 자기 자신을 반환한다.
		String text2 = builder2.append("김유신")
		.append(", ")
		.append("기계공학과")
		.append(", ")
		.append(4)
		.append(", ")
		.append(178.6)
		.append(", ")
		.append(70.3)
		.append(", ")
		.append("AB")
		.toString();
		System.out.println(text2);
		
	}
}
