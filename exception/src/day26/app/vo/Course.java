package day26.app.vo;

public class Course {

	private String code;
	private String title;
	private String dept;
	private int grade;
	private String professor;
	private int quota;			// 모집정원
	private int reqCount;		// 신청인원
	
	public Course() {}

	public Course(String code, String title, String dept, int grade, String professor, int quota) {
		super();
		this.code = code;
		this.title = title;
		this.dept = dept;
		this.grade = grade;
		this.professor = professor;
		this.quota = quota;
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

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getReqCount() {
		return reqCount;
	}

	public void setReqCount(int reqCount) {
		this.reqCount = reqCount;
	}

	@Override
	public String toString() {
		return "Course [code=" + code + ", title=" + title + ", dept=" + dept + ", grade=" + grade + ", professor="
				+ professor + ", quota=" + quota + ", reqCount=" + reqCount + "]";
	}
	
	
}
