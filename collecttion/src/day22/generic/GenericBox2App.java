package day22.generic;

public class GenericBox2App {
	
	public static void main(String[] args) {
		
		GenericBox2<String> box1 = new GenericBox2<>();
		box1.add("김유신");
		box1.add("강감찬");
		box1.add("이순신");
		box1.add("류관순");
		box1.add("안중근");
		
		int size = box1.getSize();
		for(int index = 0; index < size; index++) {
			int value = box1.getItems(index);
			System.out.println(value);
		}
		
		// 기본 자료형 타입의 타입파라미터는 지정할 수 없다.
		// 대신 기본자료형타입의 Wrapper 클래스 타입을 타입파라미터로 지정하면 된다.
		System.out.println("### 기본자료형 타입의 값은 타입파라미터를 Wrapper 클래스타입으로 지정한다.");
		GenericBox2<Integer> scores = new GenericBox2<>();
		// void add(Integer t) 메소드로 정수를 추가할 때, Integer객체를 생성해서 전달할 필요는 없다.
		// 정수 100을 전달해도 t의 타입이 Integer 타입이면, 자동으로 new Integer(100)이 전달된다.
		scores.add(100);
		scores.add(80);
		scores.add(70);
		scores.add(90);
		scores.add(40);
		scores.add(50);
		scores.add(60);
		
		size = scores.getSize();
		for(int index = 0; index < size; index++){
			int score = scores.getItems(index);
			System.out.println(score);
		}
				
	}

}
