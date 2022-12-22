package day13;

public class Employee extends Person {

	private String department;
	private int salary;
	
	public Employee() {
		super(); 			// Person 객체의 기본 생성자 메소드를 호출한다.
		System.out.println("Employee() 생성자 실행됨");
	}
	
	public Employee(String name, String tel, String department, int salary) {
		//super();			   		// Person 객체의 기본 생성자 메소드를 호출한다.
		super(name, tel); 			// Person 객체의 Person(String, String) 생성자 메소드를 호출한다.
		this.department = department;
		this.salary = salary;
		System.out.println("Employee(String, String, String, int) 생성자 실행됨");
		
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void display() {
		System.out.println("------------------------------");
		System.out.println("직원이름: " + getName());			//getName() 메소드는 Person으로부터 상속받았다.
		System.out.println("직원연락처: " + getTel());			//getTel() 메소드는 Person으로부터 상속받았다.
		System.out.println("직원 소속부서: " + department);
		System.out.println("직원 급여: " + salary);
		System.out.println("------------------------------");
		System.out.println();
	}
}
