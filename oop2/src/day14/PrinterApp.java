package day14;

public class PrinterApp {

	public static void main(String[] args) {
		
		Printer p1 = new Printer();
		p1.print("회계 분석 자료");
				
		Printer p2 = new LaserPrinter();
		p2.print("재고량 분석 자료");
		
		Printer p3 = new ColorLaserPrinter();
		p3.print("2분기 실적 분석 자료");
	}
}
