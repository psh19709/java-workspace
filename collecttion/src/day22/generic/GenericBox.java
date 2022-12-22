package day22.generic;

/*
 * 제네릭 클래스
 * 		타입파라미터를 사용해서 객체 생성시 전달받은 타입으로 T의 자리가 대체되는 클래스다.
 * 			타입파라미터는 클래스이름 옆에 <T>와 같은 형태로 지정한다.
 * 			타입파라미터는 <A, B>와 같이 여러 개 지정할 수도 있다.
 * 			타입파라미터의 별칭은 일반적으로 대문자로 적고, 아무 문자나 적어도 상관없다. 
 * 		소스코드 레벨에서 타입을 지정하지 않고, 객체 생성싯점에서 타입이 결정되는 클래스다.
 * 		T의 자리에는 참조타입만 가능하다 ( 기본자료형타입은 T를 대체할 수 없다.)
 * 
 * 		GenericBox<String> box1 = new Generic<String>();
 * 		GenericBox<Book> box2 = new Generic<book>();
 * 		GenericBox<Gift> box3 = new Generic<Gift>();
 * 		GenericBox<Studnet> box4 = new Generic<Student>();
 * 
 * 		// 타입파라미터 자리에 기본자료형 타입을 지정할 수 없다.
 * 		GenericBox<int> box1 = new Generic<int>();			// 컴파일 오류
 * 		GenericBox<double> box1 = new Generic<double>();	// 컴파일 오류
 * 
 * 		// 타입파라미터 자리에 기본자료형타입 대신 기본자료형의 Wrapper클래스타입을 지정한다.
 * 		GenericBox<Integer> box1 = new Generic<Integer>();
 * 		GenericBox<Double> box1 = new Generic<Double>();
 * 
 */
public class GenericBox<T> {
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	
}
