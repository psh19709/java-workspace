package day13;

public class Person {

	private String name;
	private String tel;
	
	public Person() {
		super();		//Object 객체의 기본 생성자 메소드를 호출한다.
		System.out.println("Person() 생성자 실행됨");
	}
	
	public Person(String name, String tel) {
		super();		//Object 객체의 기본 생성자 메소드를 호출한다.
		this.name = name;
		this.tel = tel;
		System.out.println("Person(String, String) 생성자 실행됨");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
}
