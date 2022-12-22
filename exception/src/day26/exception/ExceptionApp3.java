package day26.exception;

public class ExceptionApp3 {

	public static void main(String[] args) {
		// 예외 강제 발생
		// 오류 상황(업무로직 상의 오류)이 발생했을 떄 예외 객체를 생성하고 이 메소드를 호출한 측에게 전달(던지기) 하는 것
		// 오류 상황에 대한 더 많은 정보를 제공할 수 있다.
		// 
		//	throws와 throw
		//		throws는 예외처리 위임
		//			public void method() throws 예외1, 예외2 { 	// throws는 메소드 선언부에서 사용
		//				예외1과 예외2개 발생되는 수행문들;		// 예외를 직접 처리하지 않고 예외처리를 위임하기 위해서 throws 사용
		//			}
		//		throw는 예외 강제 발생
		//			public void method() {
		//				if(업무로직오류가 발생하는지 체크하는 조건식[ex) score < 0])	{	// 점수는 절대로 음수가 될 수 없다. 이 조건이 true로 판정되는 경우는 잘못된 경우다
		//					throw new 예외클래스("오류메세지 : 올바른 점수가 아닙니다.");	// 예외 강제발생		// throw는 메소드 안에서 사용
		//					}
		// }
		//			* 강제로 발생시키는 예외는 자바에서 제공하는 예외클래스 혹은 사용자정의 예외클래스로 예외객체를 생성할 수 있다.
	
		// 예외 일괄처리
		try {
		ExceptionApp3.method2(100, 100, 100);
		ExceptionApp3.method2(100, 100, -2);
		} catch (RuntimeException ex) {
			System.err.println("### 오류상황 발생");
			
			String errorMessage = ex.getMessage();
			System.err.println("오류 메세지: " + errorMessage);
			
			System.err.println("### 디버깅 정보 출력");
			ex.printStackTrace();
		}
	}
	
	// checkedException이 발생되는 메소드
	// 이렇게 하는 목적 : 이 메소드를 호출한 측에게 오류 발생 원인을 정확하게 전달할 수 있다.
	public static void method1(int korScore, int engScore, int mathScore) throws Exception {
		if(korScore < 0) {
			throw new Exception("국어점수가 올바르지 않습니다.");
		} 
		if(engScore < 0) {
			throw new Exception("영어점수가 올바르지 않습니다.");
		} 
		if(mathScore < 0) {
			throw new Exception("수학점수가 올바르지 않습니다.");
		} 
		
		int total = korScore + engScore + mathScore;
		System.out.println("합계: " + total);
	}
	
	// uncheckedException이 발생되는 메소드
	// 이렇게 하는 목적 : 이 메소드를 호출한 측에게 오류 발생 원인을 정확하게 전달할 수 있다.
	public static void method2(int korScore, int engScore, int mathScore) {
		if(korScore < 0) {
			throw new RuntimeException("국어점수가 올바르지 않습니다.");
		} 
		if(engScore < 0) {
			throw new RuntimeException("영어점수가 올바르지 않습니다.");
		} 
		if(mathScore < 0) {
			throw new RuntimeException("수학점수가 올바르지 않습니다.");
		} 
		
		int total = korScore + engScore + mathScore;
		System.out.println("합계: " + total);
		
	}
	
	// 업무로직의 성공/실패 여부만 제공하는 메소드
	// 아래와 같이 한다면 이 메소드를 호출한 측에게 단순하게 업무로직의 성공/실패 여부만 제공한다.
	public static boolean method3(int korScore, int engScore, int mathScore) {
		if(korScore < 0) {
			return false;
		}
		if(engScore < 0) {
			return false;
		}
		if(mathScore < 0) {
			return false;
		}
		int total = korScore + engScore + mathScore;
		System.out.println("합계: " + total);
		
		return true;
	}
	
	
}
