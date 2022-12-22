package exception;

public class BankingException extends RuntimeException {

	private static final long serialVersionUID = -3516735087310881349L;

	public BankingException(String message) {
		super(message);
	}
}
