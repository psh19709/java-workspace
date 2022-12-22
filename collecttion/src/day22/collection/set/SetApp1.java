package day22.collection.set;

import java.util.HashSet;
import java.util.TreeSet;

public class SetApp1 {

	public static void main(String[] args) {
		/*
		 * 	HashSet<E>
		 * 		- Set<E> 인터페이스의 구현클래스다.
		 * 		- 객체의 중복저장을 허용하지 않는다.
		 * 		- 객체의 hash코드 값을 비교해서 객체의 중복여부를 체크한다.
		 * 
		 * 	 TreeSet<E>
		 * 		- Set<E> 인터페이스의 구현클래스다.
		 * 		- 객체의 중복저장을 허용하지 않는다.
		 * 		- 저장된 객체를 오름차순으로 정렬해서 저장한다.
		 * 			(TreeSet<E>의 E에 해당하는 객체는 반드시 Comparable<E> 인터페이스를 구현해야 한다.)
		 * 
		 * 	자바의 자료구조 구현 클래스의 특징
		 * 		- Collection<E>의 구현체다.
		 * 			구현클래스와 상관없이 저장/삭제/조회 등의 작업을 동일한 방법으로 실행한다.
		 * 		- boolean add(E e) 메소드를 사용해서 객체를 저장한다.
		 * 		(저장위치(position)을 관리할 필요가 없다.)
		 * 		(저장하거나 삭제하면 자동으로 저장용량이 증가되거나 줄어든다.)
		 * 		- 객체만 저장할 수 있다.
		 * 		- 자료구조에 저장된 객체를 하나씩 처리할 때는 향상된 for문을 사용한다.(java 8부터는 Stream<E>을 사용한다.)
		 */
		HashSet<String> names = new HashSet<>();
		names.add("홍길동");
		names.add("홍길동");
		names.add("홍길동");
		names.add("홍길동");
		names.add("이재원");
		names.add("이재원");
		names.add("이재원");
		names.add("이재원");
		names.add("이재원");
		names.add("박재상");
		names.add("김헌곤");
		names.add("황대인");
		names.add("류현진");
		names.add("김광현");

		// 홍길동, 이재원을 여러 번 저장했지만, 중복을 허용하지 않기 떄문에 한번만 저장된다.
		// 저장된 순서와 상관없이 저장되어 있다.
		System.out.println(names);		// [박재상, 김헌곤, 김광현, 홍길동, 황대인, 류현진, 이재원]
		
		
		TreeSet<String>names2 = new TreeSet<>();		
		names2.add("홍길동");
		names2.add("이대호");
		names2.add("홍길동");
		names2.add("홍길동");
		names2.add("이재원");
		names2.add("박성한");
		names2.add("김성현");
		names2.add("이재원");
		names2.add("이재원");
		names2.add("박재상");
		names2.add("김헌곤");
		names2.add("황대인");
		names2.add("류현진");
		names2.add("김광현");
		
		// 중복을 허용하지 않는다. 오름차순으로 정렬되어 저장된다.
		System.out.println(names2);		// [김광현, 김헌곤, 류현진, 박재상, 이재원, 홍길동, 황대인]
	}
}
