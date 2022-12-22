package dat22.nonegeneric;

	// item 객체에 모든 객체를 저장할 수 있다.
	// 저장되는 모든 객체는 Object타입으로 클래스형변환된다.
	// 저장된 객체를 꺼내서 사용할 떄는 반드시 실제로 생성해서 저장한 객체의 타입으로 강제 클래스형변환 해야한다.
	// 강제 클래스 형변환할 때 실제로 생성해서 저장한 객체와 다른 타입으로 형변환하도록 소스코드를 작성해서 오류가 검출되지 않는다.

//public class Box {
//	
//	private Object item;
//
//	public Object getItem() {
//		return item;
//	}
//
//	public void setItem(Object item) {
//		this.item = item;
//	}
	
	// ### item 변수 타입을 실제로 저장되는 객체의 타입으로 지정하는 경우
	// 지정된 타입의 객체만 저장할 수 있다.(따라서, 프로그램에서 사용하는 객체의 종류만큼 xxBox클래스를 정의해야 한다.)
	// 저장되는 객체가 클래스형변환 없이 실제로 생성한 객체의 주소값이 저장되기 때문에 저장된 객체를 꺼낼 떄도 별도로 강제 클래스형변환이 필요없다.
	
	
	// ### item 변수의 타입을 소스코드레벨에서 지정하지 않고 타입파라미터를 사용해서 지정하는 경우
	// 제네릭으로 저장하면 별칭으로만 소스를 지정하고 앞에 객체는 적어두지 않는다.
	// 이렇게 하면 객체의 형이 자유로울 수 있다.
	// 소스코드 타입에서 변수를 지정해 버리면 해당 변수만 담을 수 있기 떄문에 모든 코드에서 강제형변환이 일어나서 반환할떄 다시 클래스형변환을 해야하기 떄문에
	// 출력에 어려워진다. 코드 작성중에 검사에서도 옳다고 나오기 떄문에 헷갈리기 쉽다.
	
	
	public class Box<T>{
		T[] items;
		public void setItem(String t) {
			this.item = item;
		}
		public T getItem() {
			return item;
		
	}
	
	Box<String> box1 = new Box<String>();
	Box<String> box2 = new Box<Book>();
	
	public class Box2<Book>{
		Book item;
		public void SetItem(Book b) {
			this.item = item;
		}
		public Book getItem() {
			return item;
		}
	}
}
