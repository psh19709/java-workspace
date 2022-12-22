package day23.collection.list;

import java.util.Stack;

public class ListApp3 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("홍길동1");
		stack.push("홍길동2");
		stack.push("홍길동3");
		stack.push("홍길동4");
		stack.push("홍길동5");
		System.out.println(stack);
		
		String name1 = stack.pop();
		System.out.println(name1);
		System.out.println(stack);
		
		String name2 = stack.pop();
		System.out.println(name2);
		System.out.println(stack);
		
		String name3 = stack.pop();
		System.out.println(name3);
		System.out.println(stack);
		
		String name4 = stack.pop();
		System.out.println(name4);
		System.out.println(stack);
		
		String name5 = stack.pop();
		System.out.println(name5);
		System.out.println(stack);
		
	}
}
