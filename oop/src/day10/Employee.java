package day10;

public class Employee {		
	// 이것은 Employee. java라는 컴파일(실행)하는 소스파일 클래스 영역에 들어간다.
	
	int no;				// 생성자 정의할 때 이 값을 이용하고 싶을 떈 this.  <- 이렇게 한다.
	String name;
	String dept;
	String position;
	int salary;
	int commission;
	boolean isExpired;
	
	
	/*
	 * 생성자 메소드
	 *	 - 객체 생성 직후에 실행되는 메소드다.
	 * 	 - 반드시 new연산자와 같이 사용한다.
	 *   - 주로, 객체의 초기화 작업과 관련된 수행문을 포함한다.
	 * 		- 객체의 초기화 작업
	 * 			* 멤버변수의 값을 초기화하는 것
	 * 			* 업무로직 수행전에 실행할 전처리 작업을 수행하는 것
	 * 			* 업무로직 수행에 필요한 리소스(자원)을 연결/획득하는 것
	 */
	// 기본 생성자 메소드. 
	//컴파일러가 자동으로 추가한다.
//	public Employee() {
//		
//	}				// 이것을 실제로는 있지만 보이지는 않고 내가 적지 않아도 자동으로 추가된다.
	
	// 기본 생성자 정의하기
	 public Employee() {		// 생성자도 메소드이기 때문에 중복정의가 가능하다.
		this(1, "홍길동", "인사팀", "인턴", 300, 0, false);
		System.out.println("생성자 실행됨.");
		
		// 멤버 변수의 값을 초기화하기
//		no = 1;
//		name = "홍길동";
//		dept = "인사팀";
//		position = "인턴";
//		salary = 300;
//		commission = 0;
//		isExpired = false;
	}
	
	// 생성자 중복정의 (내가 입력한 값이 출력이 되게)
	// 인턴사원 정보를 전달받아서 Employee객체를 초기화하는 생성자.
	public Employee(int no, String name, int salary) {
		this(no, name, "인사팀", "인턴", salary, 0, false);
		System.out.println("인턴 사원용 생성자 실행됨.");
//		this.no = no;			// this 또한 주소값을 갖고 있기 때문에 이렇게 해야 위의 no를 받을 수 있다.
//		this.name = name;       // 같은 변수를 구분하기 위해서 주소값을 가지고 있는 this를 사용한다.
//		this.salary = salary;
//		this.commission = 0;
//		this.dept = "인사팀";
//		this.position = "인턴";
//		this.isExpired = false;
		
	}
	// 생성자 중복정의 (내가 입력한 값이 출력이 되게)
	// 경력사원 정보를 전달받아서 Employee 객체를 초기화하는 생성자.
	public Employee(int no, String name, String dept, String position, 
			int salary, int commission) {
		this(no, name, dept, position, salary, commission, false);
		System.out.println("경력직 사원용 생성자 실행됨.");
//		this.no = no;
//		this.name = name;
//		this.dept = dept;
//		this.position = position;
//		this.salary = salary;
//		this.commission = commission;
//		this.isExpired = false;
		
	}
	// 생성자 중복정의 (내가 입력한 값이 출력이 되게)
	// 모든 사원 정보를 전달받아서 Employee 객체를 초기화하는 생성자
	public Employee(int no, String name, String dept, String position, 
			int salary, int commission, boolean isExpired) {
		System.out.println("모든 사원용 생성자 실행됨.");
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.position = position;
		this.salary = salary;
		this.commission = commission;
		this.isExpired = isExpired;
		
	}
	
	// 생성자 메소드는 void 뒤에도 오지 않는다. 
	// 즉 public void Employee 이것을 생성자 메소드로 정의할 수 없다. 
	
	
	// 멤버 메소드 정의하기
	public void display() {
		System.out.println("사원번호: " + no);
		System.out.println("사원이름: " + name);
		System.out.println("소속부서: " + dept);
		System.out.println("직위: " + position);
		System.out.println("급여: " + salary);
		System.out.println("커미션: " + commission);
		System.out.println("퇴사여부: " + isExpired);
	}
	
}
