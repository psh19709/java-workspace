package day25;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp2 {
	
	// CheckedException은 반드시 예외처리를 해야함.
	// 안그러면 컴파일러가 시행을 하지 않음.
	
	public static void main(String[] args) {
		
		System.out.println("### 프로그램 시작");
		// CheckedException이 발생하는 예
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		// try에서는 블록 안에서 발생에 예상되는 변수를 놓는다.
		try {
		System.out.println("### 예외처리 발생이 예상되는 수행문 실행 시작");
		
		Date date1 = sdf.parse("2022-12-31");
		System.out.println("첫번째 날짜: " + date1);
		Date date2 = sdf.parse("2021231");
		System.out.println("두번째 날짜: " + date2);
		
		System.out.println("### 예외처리 발생이 예상되는 수행문 실행 종료");
		
		// catch안에서는 그것을 잡아채는(가로채는) 변수를 놓는다.
		} catch (Exception ex) {		// 실제로 발생하는 예외 타입 or 그 예외의 부모 타입
			System.out.println("### 가로챈 예외: " + ex);
			System.out.println("### 발생한 예외를 가로채고, 예외처리 작업을 수행");
		}
		
		System.out.println("### 프로그램 종료");
	}

}
