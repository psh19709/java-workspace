package day13.car;

public class CarApp2 {

	public static void main(String[] args) {
		// 클래스 형변환된 객체의 속성과 기능 사용하기
		/*
		 * 생성한 객체는 동일한 객체여도 
		 * 그 객체를 참조하는 참조변수의 타입에 따라서 
		 * 사용가능한 속성과 기능의 범위가 달라진다.
		 */
		
		// car1 참조변수는 MediumCar, LightCar, Car 객체의 공개된 속성과 기능을 사용할 수 있다,
	 MediumCar car1 = new MediumCar();
	 car1.speedUp();
	 car1.speedDown();
	 car1.drive();
	 car1.stop();
	 car1.audio();
	 car1.aircon();
	 car1.navigation();
	 
	 // car2 참조변수는 LightCar, Car 객체의 공개된 속성과 기능을 사용할 수 있다,
	 LightCar car2 = new MediumCar();
	 car2.speedUp();
	 car2.speedDown();
	 car2.drive();
	 car2.stop();
	 car2.audio();
	 //car2.aircon();  		// 컴파일 오류 car2 참조변수로 사용할 수 없다.MediumCar 객체의 기능이다
	 //car2.navigation();		// 컴파일 오류 car2 참조변수로 사용할 수 없다.MediumCar 객체의 기능이다
	 
	 // car3 참조변수는 Car 객체의 공개된 속성과 기능을 사용할 수 있다,
	 Car car3 = new MediumCar();
	 car3.speedUp();
	 car3.speedDown();
	 car3.drive();
	 car3.stop();
	 // car3.audio();			//// 컴파일 오류 car2 참조변수로 사용할 수 없다. LightCar객체의 기능이다.
	 // car3.aircon();			// 컴파일 오류 car2 참조변수로 사용할 수 없다.	MediumCar 객체의 기능이다
	 //car3.navigation();		// 컴파일 오류 car2 참조변수로 사용할 수 없다.	MediumCar 객체의 기능이다
	 
	}
}
