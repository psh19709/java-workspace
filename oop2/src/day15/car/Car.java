package day15.car;

public class Car {
	
	private int speed;
	
	public void drive() {
		System.out.println("운전기능 실행중...");
	}
	
	public void changeSpeed(int speed) {
		this.speed += speed;
		System.out.println("현재 속도: " + this.speed);
	}
	
	public void speedUp() {
		if(speed == 300) {
		 return;
	 }
	 speed += 10;
	 System.out.println("현재 속도: " + speed);
 }
 	public void speedDown() {
 		if(speed == 0) {
		 return;
	 }
	 speed -= 10;
	 System.out.println("현재 속도: " + speed);
 }

}
