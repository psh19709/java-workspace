package day24.map;

import java.util.HashMap;
import java.util.Map;

public class MapApp2 {

	public static void main(String[] args) {
		Map<String, String> person = new HashMap<>();
		
		// Map객체에 key, value 쌍으로 저장하기
		person.put("name", "홍길동");
		person.put("tel", "010-1111-1111");
		person.put("email", "hong@naver.com");
		
		// Map객체에서 key로 value꺼내기
		String value1 =  person.get("name");
		String value2 =  person.get("tel");
		String value3 =  person.get("email");
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
	}
}
