package day12;

public class PhoneApp1 {
	
	public static void main(String[] args) {
		
		Phone p1 = new Phone();
		p1.SetNumber("010-1111-1111");
		p1.tel();
		p1.sms();
		
		System.out.println(" ### SmartPhone객체 생성해거 사용하기");
		SmartPhone p2 = new SmartPhone();
		p2.SetNumber("010-2222-2222");		 //Phone클래스로부터 상속받은 기능이다.
		p2.setEmail("qkrtngus09@naver.com"); //SmartPhone 클래스에 정의된 기능이다
		p2.setIp("192.168.10.100");			 //SmartPhone 클래스에 정의된 기능이다
		p2.tel();							 //Phone클래스로부터 상속받은 기능이다.
		p2.sms();							 //Phone클래스로부터 상속받은 기능이다.
		p2.senfEmail();						 //SmartPhone 클래스에 정의된 기능이다
		p2.internet();						 //SmartPhone 클래스에 정의된 기능이다
	}

}

/*
 * 상속이 안되는 것
 * 은익화된것
 * 생성자
 * 이것들은 자식에게 상속이 되지 않음
 */
