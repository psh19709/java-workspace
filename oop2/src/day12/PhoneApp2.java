package day12;

public class PhoneApp2 {

	public static void main(String[] args) {
		System.out.println("### Iphone 객체를 생성해서 기능 사용하기");
		Iphone p1 = new Iphone();
		p1.SetNumber("010-1111-1111");		//Phone 클래스로 부터 상속받은 기능이다.
		p1.setEmail("kang@naver.com");		//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p1.setIp("192.168.10.100");			//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p1.tel();							//Phone 클래스로 부터 상속받은 기능이다.
		p1.sms();							//Phone 클래스로 부터 상속받은 기능이다.
		p1.internet();						//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p1.getEmail();						//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p1.applePay(10000);					//Iphone 클래스에 정의된 기능이다.
		p1.faceId();						//Iphone 클래스에 정의된 기능이다.
		
		System.out.println("### Galaxy 객체를 생성해서 기능 사용하기");
		Galaxy p2 = new Galaxy();
		p2.SetNumber("010-1111-1111");		//Phone 클래스로 부터 상속받은 기능이다.
		p2.setEmail("kang@naver.com");		//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p2.setIp("192.168.10.100");			//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p2.tel();							//Phone 클래스로 부터 상속받은 기능이다.
		p2.sms();							//Phone 클래스로 부터 상속받은 기능이다.
		p2.internet();						//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p2.getEmail();						//SmartPhone 클래스로부터 부터 상속받은 기능이다.
		p2.bixby("아이폰14");					//Galaxy 클래스에 정의된 기능이다.
		p2.samsungPay(2500000);				//Galaxy 클래스에 정의된 기능이다.
	}
	
		
}
