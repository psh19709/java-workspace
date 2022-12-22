package day16.polymorphism;

import day15.BarChart;
import day15.LineChart;
import utils.KeyboardReader;

public class CompanyApp {
	
	public static void main(String[] args) {
		KeyboardReader keyReader = new KeyboardReader();
		
		String title = "분기별 매출 보고서";
		String[] names = {"1분기", "2분기", "3분기", "4분기"};
		int[] data = {20, 7, 3, 10};
		
		
		Company company = new Company();
		
		BarChart barchart = new BarChart();
		barchart.setTitle(title);
		barchart.setColumnNames(names);
		barchart.setData(data);
		
		LineChart lineChart = new LineChart();
		lineChart.setTitle(title);
		lineChart.setColumnNames(names);
		lineChart.setData(data);
		
		while(true) {
		System.out.println("------------------------------------");
		System.out.println("1.차트변경 2.보고서 출력 0.종료");
		System.out.println("------------------------------------");
		System.out.println();
		
		System.out.print("메뉴선택: ");
		int menuNo = keyReader.getInt();
		System.out.println();
		
		if(menuNo == 1) {
			System.out.println("<< 차트 종류 변경 >>");
			System.out.print("차트 종류를 선택하세요(1.bar, 2.lline): ");
			int chartType = keyReader.getInt();
			if(chartType == 1) {
				// Company객체에 BarChart 객체를 전달한다.(의존하는 객체 전달)
				company.setChart(barchart);
			} else if(chartType == 2) {
				//Company객체에 LineChart객체를 전달한다.(의존하는 객체 전달)
				company.setChart(lineChart);
			}
			
		} else if (menuNo==2) {
			System.out.println("<< 보고서 출력 >>");
			
			//Company객체를 보고서 출력기능을 실행한다.
			company.reporting();
			
		} else if(menuNo == 0) {
			System.out.println(" ###프로그램을 종료합니다 ");
			System.exit(1);
		}
	}
}

}
