package day15;

/**
 * Chart 인터페이스에 정의된 기능 중에서 모든 하위 클래스들이 같은 내용으로 구현하는 기능들을 미리 구현하는 클래스다.
 * <p>Chart 인터페이스를 구현하는 다양한 Chart 구현 클래스는 Chart 인터페이스를 직접 구현하기보다는 
 * @author 박수현
 *
 */
public abstract class AbsrtactChart  implements Chart{
	
	private String title;
	private String[] columnNames;
	private int[] data;
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
	
	@Override
	public void setData(int[] data) {
		this.data = data;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}
	
	public int[] getData() {
		return data;
	}

}
