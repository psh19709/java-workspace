package day7;

public class PersonApp3 {
	
	public static void main(String[] args) {
		
	
	/*
	 * Person person = new Person() 살펴보기
	 * 	person
	 * 		변수의 타입을 지정한다.
	 * 		Person클래스로 생성한 Person객체의 주소값을 담는 변수를 정의하는 것이다.
	 * 	person
	 * 		변수의 이름을 지정한다.
	 * 		person은 변수의 타입이 Person이기 때문에 Person객체의 주소값을 저장하는 참조변수다.
	 * 		person 참조변수가 참조하는 객체의 속성, 기능을 사용할 때 이용된다.
	 * 	new
	 * 		객체를 생성시키는 명령어다.
	 * 		메모리의 객체영역(Heap 메모리 영역)에 객체를 생성한다.
	 * 		객체가 생성된 곳의 조소값(Heap 메모리 영역에서 객체가 위치하고 있는 곳의 주소)을 반환한다.
	 * 		new 카워드가 반환한 객체의 주소값을 참조변수 person에 대입된다.
	 * 	Person()
	 * 		생성자 메소드다.
	 * 		생성자 메소드는 클래스의 이름과 같은 이름을 가지는 메소드다.
	 * 		생성자 메소드는 객체 생성 직후 실행되는 메소드다.
	 * 		new 다음에만 적을 수 있다.
	 * 		new 키워드는 생성자 메소드의 이름과 동일한 이름의 설계도를 메모리에 로딩해서 객체를 생성하고, 생성자 메소드를 실행해서 객
	 * 
	 */
	Person person1 = new Person();
		
	
	System.out.println("person1 참조변수가 참조하는 객체의 속성값 출력하기");
	
	// 객체를 생성하고 객체의 변수에 데이터를 저장하지 않으면, 해당 변수의 기본값으로 초기화되어 있다.
	System.out.println("번호 : " + person1.no);			// 0이 출력된다.
	System.out.println("이름 : " + person1.name);			//null이 출력된다.
	System.out.println("이메일 : " + person1.email);		//null이 출력된다.
	System.out.println("전화번호 : " + person1.tel);		//null이 출력된다.
	System.out.println("포인트 : " + person1.point);		//0이 출력된다.
	
	Person person2 = new Person();
	// person2 참조변수가 참조하는 객체의 속성에 값 대입하기
	person2.no = 20;
	person2.name = "강감찬";
	person2.email = "kang_gc@gamil.com";
	person2.tel = "010-3333-3333";
	person2.point = 193843;
	
	System.out.println("person2 참조변수가 참조하는 객체의 속성값 출력하기");
	System.out.println("번호 : " + person2.no);			// 20이 출력된다.
	System.out.println("이름 : " + person2.name);			//"강감찬"이 출력된다.
	System.out.println("이메일 : " + person2.email);		//"kang_gc@gmail.com"이 출력된다.
	System.out.println("전화번호 : " + person2.tel);		//"010-3333-3333"이 출력된다.
	System.out.println("포인트 : " + person2.point);		//193843이 출력된다.
	
	
	}
}
