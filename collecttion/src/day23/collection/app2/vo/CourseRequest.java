package day23.collection.app2.vo;

public class CourseRequest {
	private int no;					// 순번									
	private String code;			// 코드
	private String title;			// 제목
	private String dept;			// 학과
	private int grade;				// 학년
	private String pro;				// 담당교수
	private int id;					// 아이디
	private String name;			// 학생이름
	private int num;				// 모집정원
	private boolean isCancel;		// 취소여부						
	

	public CourseRequest() {
		
	}

	public CourseRequest(int no, String code, String title, String dept, int grade, String pro, int id, String name,
			int num, boolean isCancel) {
		super();
		this.no = no;
		this.code = code;
		this.title = title;
		this.dept = dept;
		this.grade = grade;
		this.pro = pro;
		this.id = id;
		this.name = name;
		this.num = num;
		this.isCancel = isCancel;
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


	public String getPro() {
		return pro;
	}


	public void setPro(String pro) {
		this.pro = pro;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public boolean isCancel() {
		return isCancel;
	}


	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}



	
	
	
}
