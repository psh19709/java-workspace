package day23.collection.list;

//import java.util.ArrayList;
import java.util.Vector;

public class ListApp2 {

	public static void main(String[] args) {
		/*
		 * ArrayList<E>와 Vector<E>의 주요메소드
		 * 		boolean 	add(E e)
		 * 			리스트의 맨 마지막에 새로운 객체를 저장한다.
		 * 		void 		add(int index, E e)
		 * 			리스트의 지정된 위치에 새로운 객체를 추가한다.
		 * 			해당 위치부터 맨마지막 객체들은 전부 한 칸씩 뒤로 이동한다.
		 * 		boolean 	addAll(Collection<? extends E> c)
		 * 			리스트에 다른 콜렉션객체에 저장된 모든 객체가 저장된다.
		 * 		boolean 	addAll(int index, Collection<? extends E> c)
		 * 			리스트의 지정된 위치에 다른 콜렉션객체에 저장된 모든 객체를 추가한다.
		 * 		void 		clear()
		 * 			리스트에 지정된 모든 객체를 삭제한다.
		 * 		boolean 	contains(Object o)
		 * 			리스트에 지정된 객체가 존재하면 true를 반환한다.
		 * 		E			get(int index)
		 * 			리스트에서 지정된 위치에 저장된 객체를 반환한다.
		 * 		boolean 	isEmpty()
		 * 			리스트가 비어 있으면 true를 반환한다.
		 * 		Iterator<E> iterator
		 * 			리스트에 저장된 객체를 반복처리하는 Iterator객체를 반환한다.
		 * 		boolean		remove(Object o)
		 * 			리스트에서 지정된 객체를 삭제한다.
		 * 		E			remove(int index)
		 * 			리스트에서 지정된 위치에 저장된 객체를 삭제한다.
		 * 		E			set(int index, E e)
		 * 			리스트에서 지정된 위치에 저장된 객체를 새 객체로 교체한다.
		 * 		int 		size()
		 * 			리스트에 저장된 객체의 갯수를 반환한다.
		 */
		
		Vector<String> names = new Vector<>();
		
		//boolean add(E e)를 사용해서 리스트에 객체 추가하기
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		System.out.println(names);
		
		//void add(int index, E e)를 사용해서 리스트에 객체 추가하기
		names.add(1, "류관순");
		System.out.println(names);
		
		// E get(int index)를 사용해서 리스트에 저장된 객체 조회하기
		System.out.println(names.get(0));
		System.out.println(names.get(1));
		System.out.println(names.get(2));
		System.out.println(names.get(3));
		
		
		// E set(int index, E e)를 사용해서 리스트에 저장된 객체를 교체하기
		names.set(2, "윤봉길");
		System.out.println(names);
		
		// void clear()를 사용해서 리스트에 저장된 객체 삭제하기
		names.clear();
		System.out.println(names);
	}
}
