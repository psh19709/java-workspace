package day15.car;

public class Genesis extends Car implements Airconditionable, AutoDrivable {

	//제네시스의 고유 기능
	public void cinema() {
		System.out.println("제네시스의 영화 감상 기능 실행 중...");
	}
	
	@Override
	public void speedUp() {
		changeSpeed(50);
		System.out.println("제네시스의 속도 증가기능 실행 중...");
	}
	
	@Override
	public void speedDown() {
		changeSpeed(-50);
		System.out.println("제네시스의 속도 감소기능 실행 중...");
	}
	
	@Override
	public void autoDrive() {
		System.out.println("제네시스의 자율 주행 기능 실행 중...");
	}
	
	
	@Override
	public void aircon() {
		System.out.println("제네시스의 온도 조절 및 공기 청정기능 실행중...");
		
	}
}
