package day15;

public class LineChart extends AbsrtactChart {		//인터페이스에 있는 것을 하나라도 빠지면 안된다.
	
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
	
	public void drawChart() {
		String title = getTitle();
		String[] columnNames = getColumnNames();
		int[] data = getData();
		
		System.out.println("### LineChart ###");
		System.out.println("<< "+ title+" >>");
		
		for(int index = 0; index < columnNames.length; index++) {
			System.out.print("["+columnNames[index]+"]");
			for (int value = 0; value < data[index]; value++) {
				System.out.print(" ");
			}
			System.out.println("|");
		}
	}	
}
