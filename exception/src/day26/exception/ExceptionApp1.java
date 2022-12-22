package day26.exception;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp1 {

	public static void main(String[] args) throws IOException {
		
		// main() 메소드에서 method1()과 method2()를 호출했을 때 발생이 예상되는 메소드를 다시 예외처리 위임 할 수 있다.
		// main() 매소드에서 예외처리를 위임하면, 예외가 발생했을 때 자바가상머신으로 예외가 전달되고, 프로그램이 종료된다.
		// 따라서, main() 메소드에서 예외처리를 위임하는 것은 실제로는 아무런 예외처리도 하지 않는 것과 같다.
		ExceptionApp1.method1();
		ExceptionApp1.method2("1234", "5678");
		
		
	}
	
	// chackedException 발생이 예상되는 수행문을 실행하는 메소드
	// 컴파일러가 예외처리 여부를 검사하기 떄문에 try ~ catch, throws 중 하나를 이용해서 예외처리를 해야한다.
	// 만약 method1()에서 발생이 예상되는 예외를 직접처리하지 않고,
	//		이 메소드를 호출할 측에서 예외가 전달하고
	//		이 메소드를 호출한 측에서 예외처리를 위임하기 위해서는 throws 키워드를 사용해야한다.
	//		이 메소드를 호출한 측에서는 반드시 예외처리(try ~ catch로 직접처리, throws로 다시 위임)를 해야한다.
	public static void method1() throws IOException {
		FileWriter writer = new FileWriter("sample.txt");
		writer.write("연습입니다");
		writer.flush();
		writer.close();
	}
	
	// UncheckedException 발생이 예상되는 수향문을 실행하는 메소드
	// 컴파일러가 예외처리 여부를 검사하지 않기 때문에 try ~ catch, throws를 작성할 필요가 없다.
	// 만약 method2() 메소드에서 예외가 발생하면,
	//		이 메소드를 호출할 측에서 예외가 전달되고
	//		이 메소드를 호출한 측에서 예외처리를 해야한다.(예외처리 위임)
	//		물론, 이 메소드를 호출한 측에서도 예외처리를 반드시 할 필요는 없다.
	public static void method2(String str1, String str2) {
		int number1 = Integer.parseInt(str1);
		int number2 = Integer.parseInt(str2);
		
		System.out.println("합계: " + (number1 + number2));
	}
}
