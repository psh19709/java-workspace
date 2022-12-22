package day15;

public class ChartApp {

	public static void main(String[] args) {
		Chart chart = new LineChart();
		
		chart.setData(new int[] {10, 25, 7, 30});
		chart.setTitle("2021년 분기별 순이익 (단위: 억원)");
		chart.setColumnNames(new String [] {"1분기", "2분기", "3분기", "4분기"});
		chart.drawChart();
	}
}
