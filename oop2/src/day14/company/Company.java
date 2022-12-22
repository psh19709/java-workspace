package day14.company;

import day14.ColorLaserPrinter;
import day14.Printer;

public class Company {
	
	private Printer printer = new ColorLaserPrinter();
	
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
