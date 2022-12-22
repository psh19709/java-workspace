package day10;

public class StudentScoreApp {
	
	public static void main(String[] args) {
		StudentScore score1 = new StudentScore("홍길동", 100, 80, 70);
		// score.no 필드가 은낙화 되어 있기 때문에 찾지 못한다.
		
		// Getter 메소드를 이용해서 총점과 평균을 조회하고 출력하기
		int total = score1.getTotal();
		double average = score1.getAverage();
		System.out.println("총점: " + total);
		System.out.println("평균: " + average);
		System.out.println();		// 빈줄
		
		// void display() 메소드를 실행해서 성적정보 출력하기
		score1.display();
	}

}
