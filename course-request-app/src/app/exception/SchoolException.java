package app.exception;

public class SchoolException extends RuntimeException {

	private static final long serialVersionUID = -4309126405868086271L;

	public SchoolException(String message) {
		super(message);
	}
	
	public SchoolException(Throwable cause) {
		super(cause);
	}
	
	public SchoolException(String message, Throwable cause) {
		super(message, cause);
	}
}
