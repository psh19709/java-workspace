package day23.collection.app2.vo;

public class Subject {

	private int code;			//코드
	private String title;		//제목
	private String dept;		//학과
	private String grade;		//학년
	private String pro;			//담당교수
	private int num;			//모집정원
	
	public  Subject() {
	}

	public Subject(int code, String title, String dept, String grade, String pro, int num) {
		super();
		this.code = code;
		this.title = title;
		this.dept = dept;
		this.grade = grade;
		this.pro = pro;
		this.num = num;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return "Subject [code=" + code + ", title=" + title + ", dept=" + dept + ", grade=" + grade + ", pro=" + pro
				+ ", num=" + num + "]";
	}
	
	
}
