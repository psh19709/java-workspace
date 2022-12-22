package day22.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetApp2 {

	public static void main(String[] args) {
		/*
		 * HashSet<E>의 주요 메소드
		 * 		- boolean add(E e)
		 * 			전달받은 E타입의 객체를 HashSet 객체에 저장한다.
		 * 		- void addAll(Collection<? extends E> c)
		 * 			전달받은 다른 콜렉션 객체에 저장된 모든 객체를 HashSet 객체에 저장한다.
		 * 		- boolean contains(Object e)
		 * 			전달받은 객체와 같은 객체가 HashSet객체에 저장되어 있으면 true를 반환한다.
		 * 		- boolean remove(Object e)
		 * 			전달받은 객체와 같은 객체가 HashSet객체에 저장되어 있으면 삭제하고 true를 반환한다.
		 * 		- boolean isEmpty()
		 * 			HashSet객체에 저장된 객체가 하나도 없으면 true를 반환한다.
		 * 		- int size()
		 * 			HashSet객체에 저장된 객체의 갯수를 반환한다.
		 * 		- void clear()
		 * 			HashSet객체에 저장된 모든 객체를 삭제한다.
		 * 		- Iterator<E> iterator()
		 * 			HashSet객체에 저장된 객체를 반복처리할 수 있는 Iterator객체를 반환한다.
		 * 			Iterator객체는 반복작업을 하는 도중에 저장된 객체를 삭제할 수 있다.
		 * 			(향상된 for문으로 반복작업을 하는 도중에는 절대로 저장된 객체를 삭제할 수 없다.)
		 * 		- Stream<E> stream()
		 * 			HashSet객체에 저장된 객체를 Stream으로 반환한다.
		 * 			(Stream은 다양한 데이터 소스(컬렉션, 배열 등)을 표준화된 방법으로 다루기 위한 객체)
		 */
		
		Set<String> names0 = new HashSet<>();
		names0.add("강감찬");
		names0.add("이재원");
		Set<String> names = new HashSet<>();
		
		// boolean add(E e)를 사용해서 HashSet객체에 String객체 저장하기
		names.add("홍길동");
		names.add("김유신");
		
		// boolean addAll(Collection<? extends E> c)를 사용해서 HashSet객체에 다른 콜렉션객체에 저장된 객체를 저장하기
		names.addAll(names0);
		System.out.println(names);
		
		// boolean contains(Object o)를 사용해서 HashSet객체에 특정객체가 존재하는지 확인하기
		boolean isExist = names.contains("강감찬");
		System.out.println(isExist);				// true
		
		// boolean remove(Object o)를 사용해서 HashSet객체에서 특정 객체를 삭제하기
		names.remove("강감찬");
		System.out.println(names);
		
		// int size()를 사용해서 HashSet객체에 저장된 객체의 갯수를 조회하기
		int size = names.size();
		System.out.println("저장된 객체의 갯수: " + size);
		
		// void clear()를 사용해서 HashSet객체에 저장된 모든 객체를 삭제하기
		names.clear();
		System.out.println(names);
	}
}
