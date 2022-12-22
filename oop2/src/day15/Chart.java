package day15;

public interface Chart {

	//구현부가 없는 추상메소드
	void setData(int[] data);
	void setColumnNames(String[] columnNames);
	void setTitle(String title);
	void drawChart();
	
}
