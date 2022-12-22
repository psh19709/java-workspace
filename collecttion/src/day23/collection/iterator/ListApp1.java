package day23.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListApp1 {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("김유신");
		names.add("홍길동");
		names.add("류관순");
		names.add("이재원");
		names.add("이순신");
		
		Iterator<String> itr = names.iterator();		// 실제로는 Iterator 구현 객체가 반환된다.
		
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}
}
