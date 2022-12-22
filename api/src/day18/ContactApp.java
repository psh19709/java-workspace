package day18;

import java.lang.reflect.Field;

public class ContactApp {
	
	public static void main(String[] args) {
		Contact c1 = new Contact("김유신", "kim@naver.com", "010-1111-1111");
		Contact c2 = new Contact("강감찬", "kang@naver.com", "010-2222-2222");
		Contact c3 = new Contact("강감찬", "kang@naver.com", "010-2222-2222");
		
		// Object의 주요한 메소드 확인하기
		// int hashcode(); - 객체의 해시코드값을 반환한다.
		
		System.out.println("c1참조변수가 참조하는 Contact객체의 해시코드");
		System.out.println(c1.hashCode());
		System.out.println();
		System.out.println("c2참조변수가 참조하는 Contact객체의 해시코드");
		System.out.println(c2.hashCode());
		System.out.println();
		System.out.println("c3참조변수가 참조하는 Contact객체의 해시코드");
		System.out.println(c3.hashCode());
		System.out.println();
		
		// String toString() - 참조변수가 참조하는 객체에 대한 간단한 설명을 반환한다.
		//					   패키지명이 포함된 클래스 이름@16진수 해시코드 값
		//					   객체의 멤버변수 값으로 구성된 문자열을 반환하도록 toString() 메소드를 재정의하는 경우가 많다.
		// Object의 toString() 재정의의 대표적인 예
		//							String 클래스는 String객체가 가지고 있는 문자열을 반환하도록 재정의했다.
		//							Date 클래스는 Date객체의 현재 날짜와 시간정보를 문자열로 반환하도록 재정의했다.
		
		System.out.println("c1, c2참조변수가 참조하는 Contact객체의 정보를 문자열로 반환한다.");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c1);					// 실제로 실행되는 코드 System.out.println(c1.toString());
		System.out.println(c2);					// 실제로 실행되는 코드 System.out.println(c2.toString());
		System.out.println();
		
		// boolean equals(Object other) - equals(Object other)를 실행하는 객체와 매개변수로 전달받은 객체가 동일한 객체인지 여부를 반환한다.
		// 								- Object equals() 메소드는 두 객체의 주소값을 비교하는 메소드다.
		//								- Object equals() 메소드는 객체의 동일성을 검사한다.
		//								- Object equals() 메소드를 객체의 동등성을 검사하도록 재정의한다.
		// Object의 toString() 재정의의 대표적인 예
		//							String 클래스는 Object equals() 메소드를 재정의해서 객체가 서로 다르더라도 
		//										 객체가 가지고 있는 문자열이 같으면 true가 반환된다.
		//							String 클래스의 equals() 메소드는 동등성을 검사한다.
		System.out.println("### c1, c2참조변수가 참조하는 Contact객체가 같은 객체인지 여부를 반환한다.");
		System.out.println (c1.equals(c2));			// false
		System.out.println (c2.equals(c1));			// false
		System.out.println (c1.equals(c3));			// false
		System.out.println (c2.equals(c3));			// true. c2와 c3참조변수가 참조하는 객체는 같은 이름을 가지고 있다.
	
		// Class<?> getClass() - 객체의 설계도 정보를 표현하는 Class객체를 반환한다.
		//					   - Class객체는 패키지정보, 클래스정보, 멤버변수 정보, 생성자정보, 메소드 정보를 모두 포함하고 있다.
		Class<?> clazz = c1.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			String typeName = field.getType().getName();
			String fieldName = field.getName();
			System.out.println(typeName + ", " + fieldName);
			
		}
	}

}
