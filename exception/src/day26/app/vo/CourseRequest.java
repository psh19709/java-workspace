package day26.app.vo;

public class CourseRequest {

	private int no;
	private String code;
	private String title;
	private String dept;
	private int grade;
	private String professor;
	private String id;
	private String name;
	private boolean isCanceled;
	
	public CourseRequest() {}

	public CourseRequest(int no, String code, String title, String dept, int grade, String professor, String id,
			String name) {
		super();
		this.no = no;
		this.code = code;
		this.title = title;
		this.dept = dept;
		this.grade = grade;
		this.professor = professor;
		this.id = id;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
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

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	@Override
	public String toString() {
		return "CourseRequest [no=" + no + ", code=" + code + ", title=" + title + ", dept=" + dept + ", grade=" + grade
				+ ", professor=" + professor + ", id=" + id + ", name=" + name + ", isCanceled=" + isCanceled + "]";
	}
	
}
