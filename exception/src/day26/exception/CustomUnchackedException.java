package day26.exception;
/*
 * 사용자 정의 unchacked 예외 클래스
 * 		RuntimException을 상속받는다
 */
public class CustomUnchackedException extends RuntimeException{

	private static final long serialVersionUID = 6414401511166969138L;

	public CustomUnchackedException(String message) {
		super(message);
	}
	
	public CustomUnchackedException(Throwable cause) {
		super(cause);
	}
	
	public CustomUnchackedException(String message, Throwable cause) {
		super(message, cause);
	}
}
