package day15;

/**
 * Chart 인터페이스를 구현하는 클래스다.
 * <p>Chart 인터페이스를 직접 구현하는 대신, Chart 인터페이스의 추상화된 메소드를 미리 구현하고 있는 
 * AbsrtactChart 추상클래스를 상속받아서 구현하는 클래스다.
 * <p> Chart 인터페이스를 직접 구현하는 것보다 AbsrtactChart 추상클래스를 상속받아서 구현하는 것이 
 * 훨씬 빠르게 차트 구현클래스를 작성하는 방법이다.
 * @author 박수현
 *
 */

public class BarChart extends AbsrtactChart {
	
	
//	private int[] data;
//	private String[] columnNames;
//	private String title; 
//
//	public void setData(int[] data) {
//		this.data = data;
//		
//	}
//	public void setColumnNames(String[] columnNames) {
//		this.columnNames = columnNames;
//	}
//	
//	public void setTitle(String title) {
//		this.title = title;
//	}
	/**
	 * 차트 데이터를 막대그래프로 표현하는 메소드다.
	 * <p>AbsrtactChart 추상클래스에 미구현한 추상메소드들 구현한 것이다.
	 * <p>Chart 인터페이스를 구현하는 각 구현클래스는 차트 데이터를 그래프로 표현하는 방식은
	 * 각 구현 클래스마다 전부 다르기 때문에, 해당기능은 각각의 구현클래스에서 직접 구현한다.
	 */
	
	public void drawChart() {
		String title = getTitle();
		String[] columnNames = getColumnNames();
		int[] data = getData();
		
		System.out.println("### BarChart ###");
		System.out.println("<< "+ title+" >>");
		
		for(int index = 0; index < columnNames.length; index++) {
			System.out.print("["+columnNames[index]+"]");
			for (int value = 0; value < data[index]; value++) {
				System.out.print("■");
			}
			System.out.println();
		}
		
	}
}
