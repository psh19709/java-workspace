package day10;

public class EmployeeApp1 {		// Employee.java를 가져다가 쓰는 
	
	public static void main(String[] args) {
		// Employee 객체 생성하기
		Employee emp1 = new Employee();
		Employee emp2 = new Employee(100, "류현진", 250);
		Employee emp3 = new Employee(200, "이순신", "개발1팀", "차장", 700, 150);			// 객체를 여러개 만들어도 그 갯수만큼 항상 실행된다.
		Employee emp4 = new Employee(300, "강한남", "영업1팀", "대리", 400, 200, false);			// 객체를 여러개 만들어도 그 갯수만큼 항상 실행된다.
		
//		Employee emp5 = new Employee();
//		emp5.Employee(100, "류관순", 250); 이렇게는 할 수 없다. 생성자 메소드는 new 뒤에만 올수 있다. 오류
		
		// 사원 정보 출력하기
		emp1.display();
		emp2.display();
		emp3.display();
		emp4.display();
	}

}
