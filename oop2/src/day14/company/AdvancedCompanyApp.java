package day14.company;

import day14.ColorLaserPrinter;
import day14.LaserPrinter;
import day14.Printer;

public class AdvancedCompanyApp {
	
	public static void main(String[] args) {
		
		Printer p1 = new Printer();
		LaserPrinter p2 = new LaserPrinter();
		ColorLaserPrinter p3 = new ColorLaserPrinter();
		
		AdvancedCompany company = new AdvancedCompany();
		
		company.setPrinter(p1);
		
		company.printReporter("2분기 경영실적 분석 보고서");
		company.printChart("2분기 경영실적 분석 보고서");
	} 


}
