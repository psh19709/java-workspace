package day14;

public class LaserPrinter extends Printer {

	/* 
	 * private Toner toner;
	public LaserPrinter(Toner toner) {
		this.toner = toner;
		
	}
	
	public void emptyTonerAlert() {
		...
	}
	public void changeToner(Toner toner) {
		this.toner = toner;
		
	}
	// 드럼 청소 기능
	public void cleanToner() {
	}
	*/
	// Printer 클래스로부터 상속받은 void print(String data) 메소드를 재정의하였음.
	public void print(String data) {
		System.out.println("["+data+"]를 레이저출력방식으로 출력합니다.");
	}
}
