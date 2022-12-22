package day22.collection.set;

import java.util.Objects;

public class Employee {

	
	private int no;
	private String dept;
	private String name;
	private int salary;
	
	public Employee() {
		
	}

	public Employee(int no, String dept, String name, int salary) {
		super();
		this.no = no;
		this.dept = dept;
		this.name = name;
		this.salary = salary;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	// hashCode와 equals 메소드를 재정의해서 사원번호가 동일하면 같은 객체로 판단하게 한다.
	@Override
	public int hashCode() {
		return Objects.hash(no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return no == other.no;
	}

	@Override
	public String toString() {
		return "Employee [no=" + no + ", dept=" + dept + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
