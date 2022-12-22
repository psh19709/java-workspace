package day19;

import java.util.Date;

public class SystemApp2 {
	
	public static void main(String[] args) {
		
		long unixTime = System.currentTimeMillis();
		// 유닉스타임은 실행할 때 마다 다른 값을 출력하니까 같은이름을 회피할 때 사용가능 하다.
		System.out.println("유닉스타임: " + unixTime);			
		
		// Date객체를 생성하면 현재 싯점의 날짜, 시간 정보가 포함된 Date객체를 획득할 수 있다.
		Date now = new Date();
		System.out.println(now);
		long nowUnixTime = now.getTime();
		System.out.println("유닉스 타임: " + nowUnixTime);
		System.out.println();
		
		// Date객체를 생성할 때, 생성자의 매개변수 인자값으로 유닉스타임을 지정하면 해당 싯점의 날짜와 시간 정보가 포함된 Date객체를 획득할 수 있다.
		Date date = new Date(0);
		System.out.println(date);
		
	}

}
