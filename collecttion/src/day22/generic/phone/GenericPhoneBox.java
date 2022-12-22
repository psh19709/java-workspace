package day22.generic.phone;
/*
 * 제네릭 클래스에서 타입파라미터의 타입을 제한 할 수 있다.
 * 		<T extends 상위타입>
 * 			T는 지정된 상위타입 및 그 상위타입을 상속받은 하위타입만 지정가능하다.
 * 			상위타입은 부모클래스타입이나 부모인터페이스 타입 모두 가능하다.
 */
public class GenericPhoneBox<T extends Phone> {

	private T item;
	
	public T getItem() {
		return item;
	}
	
	public void setItem(T t) {
		this.item = t;
	}
}
