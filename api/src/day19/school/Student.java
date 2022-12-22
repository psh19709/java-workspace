package day19.school;

public class Student {

	private String name;
	private int grade;
	private String tel;
	private String email;
	private Score score;			//Student has a Score. Student객체는 Score객체를 포함한다. 포함관계
	
	public Student() {
	}
	
	// Getter, Setter 메소드 생성
	
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public Score getScore() {
		return score;
	}
	public String getEmail() {
		return email;
	}
	public String getTel() {
		return tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setScore(Score score) {
		this.score = score;
	}

	// alt + shift + s 소스
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", tel=" + tel + ", email=" + email + ", score=" + score
				+ "]";
	}
}
