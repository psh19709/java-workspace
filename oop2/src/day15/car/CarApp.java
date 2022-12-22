package day15.car;

public class CarApp {

	public static void main(String[] args) {
		
		System.out.println("### Genesis 타입 참조변수 참조");
		Genesis g1 = new Genesis();
		g1.cinema();			// Genesis 고유 기능
		g1.drive();				// Car의 기능
		g1.speedUp();			// Car의 기능
		g1.speedDown();			//Car의 기능
		g1.aircon();			//Airconditionable의 사양(추상화된 기능 구현)
		g1.autoDrive();			//AutoCloseable의 사양 (추상화된 기능 구현)
		
		System.out.println("### Car 타입 참조변수 참조");
		Car g2 = new Genesis();
		//g2.cinema();			// Genesis 고유 기능
		g2.drive();				// Car의 기능
		g2.speedUp();			// Car의 기능
		g2.speedDown();			//Car의 기능
//		g2.aircon();			//Airconditionable의 사양(추상화된 기능 구현)
//		g2.autoDrive();			//AutoCloseable의 사양 (추상화된 기능 구현)
		
		System.out.println("### AutoDrivable 타입 참조변수 참조");
		AutoDrivable g3 = new Genesis();
//		g3.cinema();			// Genesis 고유 기능
//		g3.drive();				// Car의 기능
//		g3.speedUp();			// Car의 기능
//		g3.speedDown();			//Car의 기능
//		g3.aircon();			//Airconditionable의 사양(추상화된 기능 구현)
		g3.autoDrive();			//AutoCloseable의 사양 (추상화된 기능 구현)
		
		System.out.println("### Airconditionable 타입 참조변수 참조");
		Airconditionable g4 = new Genesis();
//		g4.cinema();			// Genesis 고유 기능
//		g4.drive();				// Car의 기능
//		g4.speedUp();			// Car의 기능
//		g4.speedDown();			//Car의 기능
		g4.aircon();			//Airconditionable의 사양(추상화된 기능 구현)
//		g4.autoDrive();			//AutoCloseable의 사양 (추상화된 기능 구현)
	}
}
