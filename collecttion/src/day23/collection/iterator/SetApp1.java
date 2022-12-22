package day23.collection.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetApp1 {
	
	public static void main(String[] args) {
		/*
		 * Iterator<E>
		 * 		- 인터페이스다
		 * 		- 콜렉션에 대한 반복적업을 수행하는 객체들이 구현할 사양이 정의되어 있다.
		 * 		- 향상된-for문이 제공되기 전까지 콜렉션에 저장된 객체들을 반복처리할 때 Iterator<E> 구현객체를 사용했다.
		 * 		- 주요 메소드
		 * 			boolean hasNext()
		 * 				- 반복처리 할 객체가 남아 있으면 true를 반환한다.
		 * 			E 		next()
		 * 				-  객체를 꺼낸다.
		 * 			void	remove()
		 * 				- 이번 반복작업에서 다루고 객체를 삭제한다.
		 * 		- Iterator<E> 인터페이스의 구현객체를 획득하는 방법
		 * 			Collection<E> 인터페이스를 구현한 모든 자료구조 구현객체는 Iterator<E> 구현객체를 제공하는 메소드가 있다.
		 * 			모든 자료구조 구현 클래스는 Iterator<E>를 반환하는 iterator() 메소드를 구현하고 있다.
		 */
		//Set<String> names = Set.of("이순신", "김유신", "강감찬", "류관순", "윤봉길");
		
		Set<String> names = new HashSet<>();
		names.add("김유신");
		names.add("강감찬");
		names.add("류관순");
		names.add("이순신");
		names.add("윤봉길");
		
		// 향상된 for문을 사용해서 반복작업 수행하기
		System.out.println("### 향상된 for문을 사용해서 콜력센 객체에 저장된 객체들을 반복처리하기");
		for(String name : names) {
			System.out.println(name);
		// 향상된 for문 내부에서는 콜렉션에 저장된 객체를 절대로 삭제할 수 없다.
//			if(name.equals("김유신")) {
//				names.remove("김유신");
//			}
		}
		
		System.out.println();
		System.out.println("### Iterator를 사용해서 콜렉션 객체에 저장된 객체들을 반복처리하기");
		//Iterator<E> 객체를 획득해서 반복작업 수행하기
		Iterator<String> itr = names.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
			// 콜렉션의 객체들을 반복처리하면서 특정 객체를 삭제할 수 있다.
			if(name.equals("김유신")) {
				itr.remove();
			}
		}
		System.out.println(names);
		
		/*
		 * 콜렉션에 대한 반복작업 처리하기
		 * 1순위
		 * 		향상된 for문을 사용해서 반복작업을 수행하기
		 * 2순위
		 * 		삭제 작업을 해야할 때
		 * 			Iterator를 사용해서 반복작업을 수행하자
		 * 			(반복작업을 처리하면서 콜렉션에 저장한 객체를 삭제해야하는 경우)
		 * 		index를 사용해야 할 때(Set<E> 구현객체는 사용 불가)
		 * 			for (int x = 0; x < size; x++){
		 * 			}
		 */
		
	}

}
