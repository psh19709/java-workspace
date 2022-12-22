package day13.car;

public class CarApp3 {

	public static void main(String[] args) {
		/*
		 * 강제 클래스형변환
		 * 
		 * 		- 실제로 생성한 하위클래스 타입의 객체를 상위클래스 타입의 참조변수가 참조하고 있는 경우,
		 * 		 실제 생성한 객체의 속성과 기능을 사용할 수 없다.
		 * 		- 실제로 생성한 객체가 클래스 형변환 되어서 참조되고 있는 경우, 실제 생성한 객체를 참조하기 위해서는
		 * 		  강제 클래스 형변환이 필요한다.
		 * 
		 * 		상위클래스 타입 참조변수1 = new 하위클래스타입();	// 자동 클래스 형변환 되었음.
		 * 		* 참조변수1은 하위클래스타입 객체의 속성과 기능을 사용할 수 없음.
		 * 		
		 * 		하위클래스타입 참조변수2 = (하위클래스타입) 참조변수1;	
		 * 		* 참조변수1이 참조하는 객체에서 지정된 하위클래스타입의 객체의 주소값을 참조변수2에 대입시킨다.
		 * 		* 참조변수2는 하위클래스타입 객체의 속성과 기능을 사용할 수 있다.
		 * 
		 * 		예시)
		 * 		Phone phone1 = new Iphone();
		 * 		*phone1은 tel(), sms() 기능만 실행할 수 있다.
		 * 
		 * 		SmartPhone phone2 = (SmartPhone) phone1;
		 * 		*phone2는 internet(), sendEmail() 기능도 실행할 수 있다.
		 * 
		 * 		Iphone phone3 = (Iphone)phone1;
		 * 		*phone3는 applePay(), appleMusic(), faceId() 기능도 실행할 수 있다.
		 * 
		 * 		* Iphone 타입의 참조변수를 따로 만들지 않고, 강제형변환해서 Iphone 객체의 속성과 기능 사용하기
		 * 		((Iphone)phone1).applePay();
		 * 		((Iphone)phone1).appleMusic();
		 * 		((Iphone)phone1).faceId();
		 */

		System.out.println("### MediumCar 객체를 Car타입의 참조변수로 참조하고 있다.");
		Car car1 = new MediumCar();
		car1.speedUp();		// Car객체의 공개된 기능이다.
		car1.speedDown();	// Car객체의 공개된 기능이다.
		car1.drive();		// Car객체의 공개된 기능이다.
		car1.stop();		// Car객체의 공개된 기능이다.
		
		// car1 참조변수가 참조하는 객체는 실제로는 MediumCar객체를 생성했을 때 생성된 Car객체다.
		// car1 참조변수가 참조하는 객체의 MediumCar 객체를 참조하게 할 수 있다.(강제형변환 활용)
		
		System.out.println("### 강제 클래스형변환으로 참조변수가 MediumCar 객체를 참조하고 있다.");
		MediumCar car2 = (MediumCar) car1;		//(강제 형변환)
		car2.speedUp();				// Car객체의 공개된 기능이다.
		car2.speedDown();			// Car객체의 공개된 기능이다.
		car2.drive();				// Car객체의 공개된 기능이다.
		car2.stop();				// Car객체의 공개된 기능이다.
		car2.audio();				// LightCar객체의 공개된 기능이다.
		car2.aircon();				// MediumCar 객체의 공개된 기능이다.
		car2.navigation();			// MediumCar 객체의 공개된 기능이다.
		
		// 참조변수를 따로 생성하지 않고, 강제형변환해서 기능 사용하기
		System.out.println("### 참조변수를 따로 생성하지 않고, 강제형변환해서 기능 사용하기");
		((LightCar) car1).audio();
		((MediumCar) car1).navigation();
		
		
		// car1 참조변수가 참조하는 객체는 실제로는 MediumCar객체를 생성했을 때 생성된 Car객체다.
		// Car car1 = new MediumCar();
		// car1 참조변수가 참조하는 객체의 어디에도 LuxuryCar 객체는 존재하지 않는다.
		// 프로그램 실행 싯점에 LuxuryCar car3 = (LuxuryCar) car1; 이 코드에서 ClassCastException 예외가 발생한다.
		// ClassCastException은 클래스형변환을 올바르지 않을 때 발생하는 오류다.
		LuxuryCar car3 = (LuxuryCar) car1;		// ClassCastException 오류 발생
		car3.speedUp();
		car3.speedDown();
		car3.drive();
		car3.stop();
		car3.audio();
		car3.aircon();
		car3.navigation();
		car3.autoDrive();
	}
}
