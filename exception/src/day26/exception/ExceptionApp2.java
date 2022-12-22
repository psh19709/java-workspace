package day26.exception;

public class ExceptionApp2 {
	
	public static void main(String[] args) {
		
		// 예외 객체의 주요 메소드 사용하기
		try {
			int num = Integer.parseInt("1234A");
			System.out.println(num);
		} catch(Exception ex) {
			// 오류 메세지 조회
			String errorMessage = ex.getMessage();		//getMessage() 오류메세지를 반환한다.
			System.err.println("오류 메세지: " + errorMessage);
			System.out.println();
			
			// 디버깅에 필요한 정보 출력하기
			System.out.println("### 디버깅에 필요한 정보 출력하기");
			ex.printStackTrace();
			
		}
		
	}

}
