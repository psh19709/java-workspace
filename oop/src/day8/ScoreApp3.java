package day8;

public class ScoreApp3 {
	
	public static void main(String[] args) {
		
		// 학생성적정보를 3개 저장하는 Score배열 객체를 생성하고, 학생성적정보 3개를 저장한다.
		
		//scores는 Score객체를 3개 저장하는 배열객체를 참조하는 참조변수다.
		Score[] scores = new Score[3];
		
		// 김유신, 강감찬, 홍길동의 성적정보를 저장하는 Score객체를 생성한다.
		Score score1 = new Score();
		score1.setScore("김유신", 80, 100, 70);
		Score score2 = new Score();
		score2.setScore("강감찬", 70, 50, 60);
		Score score3 = new Score();
		score3.setScore("홍길동", 50, 40, 50);
		
		// scores 참조변수가 참조하는 배열객체의 0번째, 1번째, 2번째 칸에 위에서 생성한 Score객체를 저장하기
		scores[0] = score1;
		scores[1] = score2;
		scores[2] = score3;
		
		// scores 참조변수가 참조하는 배열객체에 저장된 모든 성적정보를 출력하기
		for (Score score : scores) {
			score.processScore();
			score.printScore();
		}
		
		
		
	}

}
