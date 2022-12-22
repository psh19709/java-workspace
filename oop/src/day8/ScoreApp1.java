package day8;

public class ScoreApp1 {
	
	public static void main(String[] args) {
		// Score 객체 맴버변수의 기본값 확인해보기
		
		Score score = new Score();
		
		System.out.println("이름: " + score.name);			// String 타입의 멤버변수. null
		System.out.println("국어: " + score.kor);				// int 타입의 멤버변수. 0
		System.out.println("수학: " + score.math);			// int 타입의 멤버변수. 0
		System.out.println("영어: " + score.eng);				// int 타입의 멤버변수. 0
		System.out.println("총점: " + score.total);			// int 타입의 멤버변수. 0
		System.out.println("평균: " + score.average);			//double 차입의 멤버변수. 0.0
		System.out.println("합격여부: " + score.isPassed);		// boolean타입의 멤버변수. false
		
	}

}
