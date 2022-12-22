package day17;

/**
 * 사칙연산 기능을 제공하는 클래스다.
 * @author 박수현
 *
 */
public class Calculator {
	
	private int x;
	private int y;
	
	/**
	 * 기본 생성자 메소드다.
	 */
	
	public Calculator() {}
	
	/**
	 * 정수 2개를 전달받아서 멤버변수를 초기화하는 생성자다.
	 * @param x
	 * @param y
	 */
	
	public Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 덧셈결과를 반환한다.
	 * @return
	 */
	public int plus() {
		return x + y;
	}
	
	
	/**
	 * 뺄셈결과를 반환한다.
	 * @return
	 */
	public int minus() {
		return x - y;
	}
	
	/**
	 * 곱셈 결과를 반환한다.
	 * @return
	 */
	public int multiple() {
		return x*y;
	}
	
	/**
	 * 나눗셈 결과를 반환한다.
	 */
	
	public double divibe() {
		return(double)x/y;
	}
}
