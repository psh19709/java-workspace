package day12;

/**
 * 아이폰을 표현하는 클래스다.
 * <p> SmartPhone 클래스가 부모 클래스다.
 * @author 박수현
 *
 */
public class Iphone extends SmartPhone {
	
	/**
	 * 전달받은 금액만큼 애플페이로 결제한다.
	 * @param amount
	 */
	
	public void applePay(int amount) {
		System.out.println("["+amount+"] 금액을 애플페이로 결제하는 기능을 실행합니다");
	}
	
	/**
	 * 페이스아이디로 잠금을 해제한다.
	 */
	public void faceId() {
		System.out.println("페이스 아이디 기능을 실행해서 잠금을 해재합니다.");
	}

}
