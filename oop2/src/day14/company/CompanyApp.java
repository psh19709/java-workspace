package day14.company;

public class CompanyApp {

	public static void main(String[] args) {
		Company company = new Company();
		
		company.printReporter("2분기 실적 분석 보고서");
		company.printChart("2분기 실적 분석 차트");
		company.printPdf("2분기 실적 분석.pdf");
	}
}
