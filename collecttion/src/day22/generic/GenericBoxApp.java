package day22.generic;

import java.util.Date;

public class GenericBoxApp {
	
	public static void main(String[] args) {
		// 타입추론 (자바7버전 이후부터)
		// box1이 참조되는 객체는 T의 자리가 전부 String으로 대체된 GenericBox객체다.
		GenericBox<String> box1 = new GenericBox<String>();
		// T의 자리가 전부 String으로 대체되었기 때문에 String객체를 저장하면 Object로 클래스형변환없이 실제 생성된 String객체를 참조하게 된다. 
		box1.setItem("안녕 클래오 파트라");
		// T의 자리가 전부 String으로 대체되었기 때문에 GenericBox객체에서 객체를 가져올 때도 String객체의 주소값이 반환된다.
		//			- 강제 클래스 형변환이 필요없다.
		//			- 실제로 저장한 객체와 다른 타입의 객체로 형변환하게 되면 컴파일 오류가 발생한다.
		String value1 = box1.getItem();
		System.out.println("문자열의 길이: " + value1.length());
		
		// box2가 참조하는 객체는 T의 자리가 전부 Date로 대체된 GenericBox객체다.
		GenericBox<Date> box2 = new GenericBox<>();
		box2.setItem(new Date());
		Date value2 = box2.getItem();
		System.out.println("유닉스타임: " + value2.getTime());
	}

}
