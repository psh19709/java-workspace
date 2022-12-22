package day13.car;

public class CarApp4 {

	public static void main(String[] args) {
		Car car1 = new Car();
		LightCar car2 = new LightCar();
		MediumCar car3 = new MediumCar();
		LuxuryCar car4 = new LuxuryCar();
		
		
		/*
		boolean result1 = car1 instanceof Car;
		boolean result2 = car1 instanceof LightCar;
		boolean result3 = car1 instanceof MediumCar;
		boolean result4 = car1 instanceof LuxuryCar;
		System.out.println("car1이 참조하는 객체에는 Car 타입의 객체가 있습니까? " +result1);			//true
		System.out.println("car1이 참조하는 객체에는 LightCar 타입의 객체가 있습니까? " +result2);		//false
		System.out.println("car1이 참조하는 객체에는 MediumCar 타입의 객체가 있습니까? " +result3);	//false
		System.out.println("car1이 참조하는 객체에는 LuxuryCar 타입의 객체가 있습니까? " +result4);	//false
		System.out.println();
		
		boolean result5 = car2 instanceof Car;
		boolean result6 = car2 instanceof LightCar;
		boolean result7 = car2 instanceof MediumCar;
		boolean result8 = car2 instanceof LuxuryCar;
		System.out.println("car2이 참조하는 객체에는 Car 타입의 객체가 있습니까?" +result5);			//true
		System.out.println("car2이 참조하는 객체에는 LightCar 타입의 객체가 있습니까?" +result6);		//true	
		System.out.println("car2이 참조하는 객체에는 MediumCar 타입의 객체가 있습니까?" +result7);		//false
		System.out.println("car2이 참조하는 객체에는 LuxuryCar 타입의 객체가 있습니까?"+result8);		//false
		System.out.println();
		
		
		boolean result9 = car4 instanceof Car;
		boolean result10 = car4 instanceof LightCar;
		boolean result11 = car4 instanceof MediumCar;
		boolean result12 = car4 instanceof LuxuryCar;
		System.out.println("car4이 참조하는 객체에는 Car 타입의 객체가 있습니까?" +result9);			//true
		System.out.println("car4이 참조하는 객체에는 LightCar 타입의 객체가 있습니까?" +result10);		//true
		System.out.println("car4이 참조하는 객체에는 MediumCar 타입의 객체가 있습니까?" +result11);	//true
		System.out.println("car4이 참조하는 객체에는 LuxuryCar 타입의 객체가 있습니까?" +result12);	//true
		*/
		
		Car[] cars = new Car[4];
		cars[0] = car1;
		cars[1] = car2;
		cars[2] = car3;
		cars[3] = car4;
		
		for(Car car : cars) {
			System.out.println("### car가 참조하는 객체의 기능 실행해보기" + "["+car+"]");
			car.speedUp();
			car.speedDown();
			car.drive();
			car.stop();
			
			if(car instanceof LuxuryCar) {
				((LightCar) car).audio();
			}
			if(car instanceof MediumCar) {
				((MediumCar)car).navigation();
				((MediumCar)car).aircon();
			}
			if((car)instanceof LuxuryCar) {
				((LuxuryCar)car).autoDrive();
			}
			
			System.out.println();
		}
	}
}
