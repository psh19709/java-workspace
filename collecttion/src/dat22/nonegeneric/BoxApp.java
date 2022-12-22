package dat22.nonegeneric;

import java.util.Date;

public class BoxApp {

	public static void main(String[] args) {
		
		//String 객체에 저장하는 박스객체
		Box box1 = new Box();
		String item1 = "안녕, 클래오파트라";
		
		// Box객체에 String 객체 저장하기 -> Box객체의 item변수에는 String객체의 부모갹체인 Object객체의 주소값이 저장된다.
		box1.setItem(item1);
		
		// Box객체에 저장된 String객체 획득하기 
		// 					-> Box객체의 item변수에 저장된 객체를 반환받으면 String 객체의 주소값 대신 Object객체의 주소값이 반환된다.
		Object obj1 = box1.getItem();
		System.out.println(obj1.toString());		//Object의 toString()을 실행하면 실제로 생성한 String객체에 재정의된 toString
		// obj1이 저장하고 있는 Object 객체의 주소값으로는 실제로 저장한 String의 고유한 속성과 기능을 실행할 수 없다.
		// System.out.println("문자열의 길이: " + obj1.length());		// 오류
		
		//String 객체의 고유한 속성과 기능을 사용하기 위해서는 다시 String 타입으로 강제 클래스 형변환해야한다.
		String value1 = (String) obj1;
		System.out.println(value1);
		System.out.println("문자열의 길이: " + value1.length());
		
		// Date객체에 저장하는 박스객체
		Box box2 = new Box();
		Date item2 = new Date();
		// Box객체에 Date 객체 저장하기 -> Box객체의 item변수에는 Date객체의 부모갹체인 Object객체의 주소값이 저장된다.
		box2.setItem(item2);
		// Box 객체에 저장된 Date객체 획득하기
		// 					-> Box객체의 item변수에 저장된 객체를 반환받으면 Date 객체의 주소값 대신 Object객체의 주소값이 반환된다.
		Object obj2 = box2.getItem();
		// obj2가 저장하고 있는 Object객체의 주소값으로는 실제로 생성해서 저장한 Date객체의 고유한 속성과 기능을 실행할 수 없다.
		// System.out.println("유닉스 타임: " + obj2.getTime());			//오류
		// Date객체의 고유한 속성과 기능을 사용하기 위해서는 다시 Date타입으로 강제 클래스형변환 해야 한다.
		Date value2 = (Date)obj2;
		System.out.println("유닉스 타임: " + value2.getTime());
		
	}
}
