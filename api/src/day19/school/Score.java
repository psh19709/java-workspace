package day19.school;

public class Score {
	
	private int kor;
	private int eng;
	private int math;
	
	// 기본 생성자
	
	public Score( ) {
		
	}
	
	// 모든 멤버변수를 초기화하는 생성자
	
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// Getter, Setter 메소드
	
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	//  총점을 반환하는 메소드
	// 반환타입: int 
	// 메소드명: getTotal
	// 매개변수: 없음
	
	public int getTotal() {
		return kor + eng + math;
	}
	
	// 평균점수를 반환하는 메소드
	// 반환타입: int 
	// 메소드명: getAverage
	// 매개변수: 없음
	public int getAverage() {
		return getTotal()/3;
	}

	// 모든 멤버변수의 값을 문자열로 반환하는 toString() 메소드의 재정의 - 소스메뉴의 genarate toSrting()기능을 사용하기
	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + ", getTotal()=" + getTotal()
				+ ", getAverage()=" + getAverage() + "]";
	}

	
	
	
}
