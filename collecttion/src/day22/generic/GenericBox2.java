package day22.generic;

public class GenericBox2<T> {

	private Object[] items = new Object[5];
	private int position = 0;
	private int limit = 5;
	private final int size = 5;
	
	@SuppressWarnings("unchecked")
	public int getItems(int index) {
		return (int) items[index];
	}
	
	public void add(T t) {
		resize();
		items[position] = t;
		position++;
		
	}
	
	public int getSize() {
		return position;
	}
	
	private void resize() {
		if(position == limit){
			limit += limit + size;
			Object[] temp = new Object[limit];
			System.arraycopy(items, 0, temp, 0, position);
			
			items = temp;
		}
	}
}
