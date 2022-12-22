package day8;

public class Score {
	
	String name;
	int kor;
	int eng;
	int math;
	int total;
	double average;
	boolean isPassed;
	
	//이름, 국어, 영어, 수학점수를 전달받아서 객체의 멤버변수에 대입하는 메소드
	// 접급제한자 : public
	// 반환차입 : void
	// 메소드이름 setScore
	// 매개변수 : String studentName, int korScore, int engScore, int mathScore
	
	public void setScore(String studentName, int korScore, int engScore, int mathScore) {
		name = studentName;
		kor = korScore;
		eng = engScore;
		math = mathScore;
	}
	
	//	속성에 저장된 국어, 영어, 수학점수로 총점과 평균을 계산해서 저장하고, 합격여부를 지정하는 메소드
	// 접급제한자 : public
	// 반환차입 : void
	// 메소드이름 processScore
	// 매개변수 : 없음
	
	public void processScore() {
		total = kor + eng + math;
		average = (double) total/3;
		isPassed = average >= 60;
	}
	
	// 모든 성적정보를 화면에 출력하는 메소드
	// 접근제한자 : public		// 모두 볼수 있다.
	// 반환타입 : void
	// 메소드이름 : printScore
	// 매개변수 : 없음
	public void printScore() {
		System.out.println("["+name+"] 성적정보를 출력합니다.");
		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("수학: " + math);
		System.out.println("영어: " + eng);
		System.out.println("총점: " + total);
		System.out.println("평균: " + average);
		System.out.println("합격여부: " + isPassed);
		System.out.println();
	}
}
