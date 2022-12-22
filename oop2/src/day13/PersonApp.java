package day13;

public class PersonApp {
	
	public static void main(String[] args) {
		System.out.println("###Employee 객체 생성하기");
	    Employee epm = new Employee("홍길동", "010-1111-1111", "영업 1팀", 600);
	    
	    System.out.println("### 직원정보 출력하기");
	    epm.display();
	    
	    System.out.println("###Student 객체 생성하기");
	    Student stu = new Student("김유신", "010-2222-2222", "컴퓨터공학", 4);
	    
	    System.out.println("### 학생정보 출력하기");
	    stu.display();
	    
	}

}
