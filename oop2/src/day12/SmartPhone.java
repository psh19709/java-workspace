package day12;

/**
 * 스마트폰을 표현하는 클래스다.
 * <p> Phone 클래스가 부모 클래스다.
 * @author 박수현
 *
 */

public class SmartPhone extends Phone {
	
	private String email;
	private String ip;
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIp() {
		return ip;
	}
	
	/**
	 * ip주소를 전달받아서 멤버변수 ip에 대입한다.
	 * @param ip ip주소
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 이메일 보내기 기능을 실행합니다.
	 */
	public void senfEmail() {
		System.out.println(" ["+email+"] 이메일 보내기 기능을 실행합니다. ");
	}
	
	/**
	 * 인터넷 기능을 실행합니다.
	 */
	public void internet() {
		System.out.println(" ["+ip+"] 인터넷 기능을 실행합니다. ");
	}

}
