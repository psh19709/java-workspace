package day10;

public class StudentScore {
	
	private String name;			
	private int kor;				
	private int eng;			
	private int math;	
	
	/*
	 *  개발자가 정의한 생성자가 이미 존재하기 때문에 컴파일러가 기본 생성자를 추가하지 않는다.
	 *  public StudentScore() {} 생성자는 정의되지 않았다.
	 */
	
	// 기본 생성자 -  컴파일러가 자동으로 추가한다.
	//public StudentScore() {}
	
	public StudentScore(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// 은낙화된 필드의 값을 제공하는 Getter 메소드 정의하기
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
	
	// 은닉화된 필드의 값을 활용해서 계산된 결과를 제공하는 Getter 메소드 정의하기
	public int getTotal() {
		return kor + eng + math;
	}
	public double getAverage() {
		return getTotal()/3.0;
	}
	
	public boolean isPassed() {				//boolean 타입의 이름 지정은 is~, has~이렇게 많이쓴다. //get~는 X
		return getAverage() >= 60;
	}
	
	public void display() {
		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("총점: " + getTotal());
		System.out.println("평균: " + getAverage());
		System.out.println("합격여부: " + isPassed());
	}

}
