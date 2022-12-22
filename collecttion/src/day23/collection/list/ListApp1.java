package day23.collection.list;

import java.util.ArrayList;

public class ListApp1 {

	public static void main(String[] args) {
		/*
		 *  List<E> 인터페이스의 구현 클래스
		 *  	- ArrayList<E>
		 *  		가장 많이 사용되는 리스트 인터패이스의 구현클래스다.
		 *  		0번쨰 부터 차례대로 저장하기, 0번째부터 차례대로 꺼내기 작업에 가장 적합하다.
		 *  		내부적으로 가변길이 배열을 활용해서 객체를 저장한다.
		 *  	- LinkedList<E>
		 *  		중간에 객체를 삽입하거나, 중간에 저장된 객체를 삭제하는 일이 빈번한 경우에 사용하는 구현 클래스다.
		 *  		-------------		-------------		-------------
		 *  		|  |	 |	| <----	|- |	 |	|<----- |- |	 |  |
		 *  		|  | 객체 |	|		|  | 객체 |	|		|  | 객체 |	|
		 *  		|  |	 | -| ---->	|  |	 |	|-----> |  |	 |  |
		 *  		-------------		-------------		-------------
		 *  		LinkedList<E>는 List<E>의 인터페이스의 구현 클래스고, Queue<E> 인터페이스의 구현 클래스다.
		 *			Queue<E>는 FILO(First-In Last-Out) 자료구조를 표현하는 인터페이스다.
		 *			LinkedList<E>의 FILO(First-In Last-Out) 기능을 지원하는 메소드
		 *				boolean offer(E item)
		 *					리스트의 last element
		 *				E peek()
		 *					리스트의 first element를 반환한다.
		 *				E pool()
		 *					리스트의 first element를 삭제하고, 그 엘리먼트를 반환한다.
		 *  							-------------		-------------		-------------
		 *  							|  |	 |	| <----	|- |	 |	|<----- |- |	 |  |
		 *  			E poll() <---	|  | 객체 |	|		|  | 객체 |	|		|  | 객체 |	|	<---- offer(E e)
		 *  							|  |	 | -| ---->	|  |	 |	|-----> |  |	 |  |
		 *  							-------------		-------------		-------------
		 *  	- Vector<E>
		 *  		ArrayList<E>와 구현이 완전히 동일하다.
		 *  		ArrayList<E>는 Thread-unsafe하고, Vector<E>는 Thread-safe하다.
		 *  	- Stack<E>
		 *  		FILO(First-In Last-Out) 자료구조를 구현한 객체다.
		 *  		Stack<E>의 고유 기능을 지원하는 메소드.
		 *  			E push(E item)
		 *  				Stack에 새로운 객체를 저장한다.
		 *  			E peek()
		 *  				Stack의 맨 꼭대기에 위치한 객체를 반환한다.
		 *  			E pop()
		 *  				Stack의 맨 꼭대기에 위치한 객체를 삭제하고, 그 객체를 반환한다.
		 *  				E push(E item)			E pop()
		 *						|						^
		 *						|						|
		 *						∨  		                |
		 *             		  ----------------------------
		 *       			    |                          |
		 *    		           ----------------------------
		 *           		    |                          |
		 * 			            ----------------------------
		 *           		    |                          |
		 *       		        ----------------------------
		 *             		   |                     |
		 *	           		  ----------------------------
		 */						
		ArrayList<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("김유신");
		names.add("류관순");
		names.add("이재원");
		names.add("홍길동");
		names.add("이순신");
		names.add("류관순");
		
		for(String name : names) {
			System.out.println("이름: " + name);
		}
	}
}
