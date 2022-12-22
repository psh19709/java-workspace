package day12;

/**
 * 갤럭시를 표현하는 클래스다.
 * <p> SmartPhone 클래스가 부모 클래스다.
 * @author 박수현
 *
 */

public class Galaxy extends SmartPhone {
	/**
	 * 전달받은 금액만큼 삼성페이로 결재한다.
	 * @param amount 결제금액
	 */
	public void samsungPay(int amount) {
		System.out.println("["+amount+"] 금액을 삼성페이로 결제하는 기능을 실행합니다");
	}
	
	/**
	 * 전달받은 키워드로 검색한다.
	 * @param keyword 키워드
	 */
	public void bixby(String keyword) {
		System.out.println("["+keyword+"] 빅스비로 검색어를 검색합니다.");
	}

}
