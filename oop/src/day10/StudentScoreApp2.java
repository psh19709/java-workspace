package day10;

public class StudentScoreApp2 {
	public static void main(String[] args) {
		
		// StudentScore 객체의 주소값 5개를 저장할 수 있는 배열객체를 생성하고, 그 배열객체의 주소 값을 scores에 대입한다
		StudentScore[] scores = new StudentScore[5];
		
		// StudentScore 객체를 생성하고 멤버변수를 초기화하는 생성자를 실행하고, 그 객체의 주소값을 배열의 n번째 칸에 저장한다.
		scores[0] = new StudentScore("김유신", 80, 80, 60);
		scores[1] = new StudentScore("강감찬", 80, 90, 50);
		scores[2] = new StudentScore("이순신", 50, 90, 60);
		scores[3] = new StudentScore("류관순", 70, 40, 70);
		scores[4] = new StudentScore("안중근", 70, 70, 60);
		
		// 배열에 저장된 모든 성적 정보를 출력하기
		System.out.println("### 모든 성적정보 출력하기");
		for(StudentScore score : scores) {
			// score참조변수가 참조하는 객체의 void display() 메소드를 실행해서 해당 객체의 성적정보를 화면에 출력시킨다.
			score.display();
		}
//		scores[0].display();
//		System.out.println();
//		scores[1].display();
//		System.out.println();
//		scores[2].display();
//		System.out.println();
//		scores[3].display();
//		System.out.println();
//		scores[4].display();
		
		// 국어점수 평균을 계산하고 출력하기
		System.out.println("### 국어점수 평균을 출력하기");
		int totalKorScore = 0;
		for(StudentScore score : scores) {
			//score참조변수가 참조하는 객체의 int getkor() 메소드를 실행해서 해당 객체의 kor변수에 저장된 국어점수를 획득한다.
			int korScore = score.getKor();
			totalKorScore += korScore;
					
		}
		double averageKorScore = totalKorScore/scores.length;
		System.out.println("국어점수 평균: " + averageKorScore);
	}
	

}
