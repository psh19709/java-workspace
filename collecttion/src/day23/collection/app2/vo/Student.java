package day23.collection.app2.vo;

public class Student {
	
	private String id;			// 학생 아이디
	private String name;	// 학생 이름
	private String dept;	// 학생 학과
	private int grade;	// 학생 학년
	
	public Student() {
	}
	
	public Student(String id, String name, String dept, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	

}
