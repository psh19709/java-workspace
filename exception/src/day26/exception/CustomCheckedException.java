package day26.exception;
/*
 *  사용자정의 chacked 예외 클래스
 *  	Exception 클래스를 상속받는다.
 */
public class CustomCheckedException extends Exception{
	
	private static final long serialVersionUID = -3829452579232924198L;

	public CustomCheckedException(String message) {
		super(message);
	}
	
	public CustomCheckedException(Throwable cause) {
		super(cause);
	}
	
	public CustomCheckedException(String message, Throwable cause) {
		super(message, cause);
	}
}
