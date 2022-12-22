package day14;

public class ColorLaserPrinter extends LaserPrinter{

	// LaserPrinter 클래스로부터 상속받은 void print(String data) 메소드를 재정의하였음.
	public void print(String data) {
		System.out.println("["+data+"]를 컬러 레이저 출력방식으로 출력한다.");
	}
}
