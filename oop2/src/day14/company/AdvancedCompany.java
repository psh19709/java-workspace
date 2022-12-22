package day14.company;

import day14.Printer;

public class AdvancedCompany {

	// Printer류 객체와 연결되는 멤버변수다.
	//private Printer printer;
	private Printer printer;
	
	// Printer류 객체를 매개변수 인자로 전달받아서 멤버변수에 대입한다.
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void printReporter(String data) {
		System.out.println("### 보고서를 출력 ###");
		// 프린터객체의 출력기능 사용
		printer.print(data);
	}
	public void printChart(String data) {
		System.out.println("### 차트를 출력 ###");
		// 프린터객체의 출력기능 사용
		printer.print(data);
	}
	public void printPdf(String data) {
		System.out.println("### PDF 출력 ###");
		// 프린터객체의 출력기능 사용
		printer.print(data);
	}
}
