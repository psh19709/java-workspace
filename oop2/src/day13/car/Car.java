package day13.car;

/**
 * 모든 자동차가 공통으로 가지고 있는 기능
 * 모든 차량들이 공통으로 가지는 속성과 기능이 정의된 클래스다.
 * 속도 올리고, 속도 내리고 멈추는 기능
 * @author 박수현
 *
 */
public class Car {
	private int speed;
	
	public void speedUp() {
		if(speed == 250) {
			return;
		}
		speed += 10;
		System.out.println("### 속도 증가. 현재속도 : " + speed);
	}
	
	public void speedDown() {
		if(speed == 0) {
			return;
		}
		speed -= 10;
		System.out.println("### 속도 감소. 현재속도 : " + speed);
	}
	
	public void drive() {
		System.out.println("### 운전 중...");
	}
	
	public void stop() {
		System.out.println("### 정차 중...");
	}
}

