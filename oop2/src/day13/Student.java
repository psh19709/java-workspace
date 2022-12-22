package day13;

public class Student extends Person{

	private String major;
	private int grade;
	
	public Student() {
		super();			// Person 객체의 기본 생성자 메소드를 호출한다.
		System.out.println("Student() 생성자 실행됨");
	}
	
	public Student(String name, String tel, String major, int grade) {
		//super();				// Person 객체의 기본 생성자 메소드를 호출한다.
		super(name, tel); 		// Person 객체의 Person(String, String) 생성자 메소드를 호출한다.
		this.major = major;
		this.grade = grade;
		System.out.println("Student(String, String, String, int) 생성자 실행됨");
	}
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void display() {
		System.out.println("------------------------------");
		System.out.println("학생 이름: " + getName());				//getName() 메소드는 Person으로부터 상속받았다.
		System.out.println("학생 연락처: " + getTel());			//getTel() 메소드는 Person으로부터 상속받았다.
		System.out.println("학생 전공학과: " + major);
		System.out.println("학생 학년: " + grade);
		System.out.println("------------------------------");
		System.out.println();
	}
}

