package selfMy;

public class StudentScore {
	private String name;			// 필드를 은닉화함 private
	private int kor;				// 필드를 은닉화함
	private int eng;				// 필드를 은닉화함
	private int math;				// 필드를 은닉화함
	
	public StudentScore(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void display() {
		System.out.println("이름: " + name);
		System.out.println("국어점수: " + kor);
	}

	/*
	 * Getter 메소드
	 *  	 - 필드가 은닉화되어 있을 때, 필드의 값을 제공하는 메소드다.
	 *  	 - 은닉화된 필드의 값을 이용해서 계산된 값을 제공하는 메소드다.
	 */
	public String getName() {  			
		return name;				
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTotal() {
		return kor + eng + math;
	}
	public double getAverage() {
		return getTotal()/3.0;
	}
	
	public boolean isPassed() {
		return getAverage() >= 60;
	}
	
}
