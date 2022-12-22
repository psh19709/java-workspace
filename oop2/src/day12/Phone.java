package day12;

public class Phone {
	//은익화된 변수
	private String number;
	
	/**
	 * 전화번호를 반환합니다
	 * @return 전화번호
	 */
	public String GerNumber() {
		return number;
	}
	
	/**
	 * 전화번호를 전달받아서 멤버변수 number에 대입한다.
	 * @param number 전화번호
	 */
	public void SetNumber(String number) {
		this.number = number;
	}
	
	/**
	 * 전화하기 기능을 실행합니다.
	 */
	public void tel() {
		System.out.println("["+number+"]전화하기 기능을 실행합니다.");
	}
	
	/**
	 * 문자하기 기능을 실행합니다.
	 * @return
	 */
	public void sms() {
		System.out.println("["+number+"]문자하기 기능을 실행합니다.");
	}

}
