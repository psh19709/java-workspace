package day13.car;

public class CarApp5 {

	public static void main(String[] args) {
		// (X) LightCar car = new Car(); 상위타입의 객체를 하위타입을 담을 수 없다.
		System.out.println("### 자동자 주행기능을 테스트합니다.");
		CarApp5.testDrive(new Car());
		CarApp5.testDrive(new LightCar());
		CarApp5.testDrive(new MediumCar());
		CarApp5.testDrive(new LuxuryCar());
		
		// CarApp5.testAudio(new Car());				//컴파일오류
		System.out.println("### 자동자 오디오기능을 테스트합니다.");
		CarApp5.testAudio(new LightCar());
		CarApp5.testAudio(new MediumCar());
		CarApp5.testAudio(new LuxuryCar());
		
		System.out.println("### 자동자 길안내기능을 테스트합니다.");
		// CarApp5.testNavigation(new Car());			// 컴파일 오류
		// CarApp5.testNavigation(new LightCar());		// 컴파일 오류
		CarApp5.testNavigation(new MediumCar());
		CarApp5.testNavigation(new LuxuryCar());
		
		System.out.println("### 자동자 자율주행기능을 테스트합니다.");
		// CarApp5.testAutoDrive(new Car());			// 컴파일 오류
		// CarApp5.testAutoDrive(new LightCar());		// 컴파일 오류
		// CarApp5.testAutoDrive(new MediumCar());		// 컴파일 오류
		CarApp5.testAutoDrive(new LuxuryCar());
	}
	
	public static void testDrive(Car car) {		// Car, LightCar, MediumCar, LuxuryCar 객체는 drive 기능을 테스트 할 수 있다.
		car.drive();
	}
	
	public static void testAudio(LightCar car) {	//LightCar, MediumCar, LuxuryCar 객체는 audio 기능을 테스트 할 수 있다.
		car.audio();
	}
	
	public static void testNavigation(MediumCar car) {	//MediumCar, LuxuryCar 객체는 navigation 기능을 테스트 할 수 있다.
		car.navigation();	
	}
	
	public static void testAutoDrive(LuxuryCar car) {	//LuxuryCar 객체는 autoDrive 기능을 테스트 할 수 있다.
		car.autoDrive();
		
	}
	
}
