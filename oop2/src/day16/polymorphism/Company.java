package day16.polymorphism;

import day15.Chart;

public class Company {
	
	// Company클래스는 Chart 인터페이스에 의존한다.(Company 클래스와 Chart구현 클래스의 관계를 느슨하게 하기)
	private Chart chart;
	
	// Company클래스는 Chart 인터페이스를 구현한 객체를 직접 생성하지 않고 외부로부터 전달받는다.(의존성 주입받기)
	public void setChart(Chart chart) {
		this.chart = chart;
	}
	
	public void reporting() {
		// Company의 메소드에서는 Chart 인터페이스에 정의된 기능을 실행한다.(인터페이스 관점에서 코딩한다.)
		chart.drawChart();
	}

}
