package day13.car;

public class CarApp {

	public static void main(String[] args) {
		// 참조자료형의 형변환
		// 참조변수의 타입과 객체의 타입이 서로 다를 때 클래스 형변환이 발생한다.
		// 참조변수의 타입이 객체의 타입과 동일하거나, 참조변수의 타입이 객체 타입보다 상위타입일 때만 객체를 참조변수에 대입할 수 있다.
		Car car1 = new Car();				// car1은  Car객체를 참조한다.
		Car car2 = new LightCar();			// car2는 LightCar 객체를 생성될 때 같이 생성된 Car객체를 참조한다.
		Car car3 = new MediumCar();			// car3는 MediumCar 객체가 생성될  때 같이 생성된 Car객체를 참조한다.
		Car car4 = new LuxuryCar();			// car4는 LuxuryCar 객체가 생성될 때 같이 생성된 Car 객체를 참조한다.
		
		//LightCar car5 = new Car();				//컴파일오류, 상위 타입의 객체를 하위타입의 참조변수에 대입할 수 없다.
		LightCar car6 = new LightCar();
		LightCar car7 = new MediumCar();
		LightCar car8 = new LuxuryCar();
		
		//MediumCar car9 = new Car();				//컴파일오류, 상위 타입의 객체를 하위타입의 참조변수에 대입할 수 없다.
		//MediumCar car10 = new LightCar();		//컴파일오류, 상위 타입의 객체를 하위타입의 참조변수에 대입할 수 없다.
		MediumCar car11 = new MediumCar();		
		MediumCar car12 = new LuxuryCar();
		
		//LuxuryCar car13 = new Car();			//컴파일오류, 상위 타입의 객체를 하위타입의 참조변수에 대입할 수 없다.
		//LuxuryCar car14 = new LightCar();		//컴파일오류, 상위 타입의 객체를 하위타입의 참조변수에 대입할 수 없다.
		//LuxuryCar car15 = new MediumCar();		//컴파일오류, 상위 타입의 객체를 하위타입의 참조변수에 대입할 수 없다.
		LuxuryCar car16 = new LuxuryCar();
		
		
	}

}
