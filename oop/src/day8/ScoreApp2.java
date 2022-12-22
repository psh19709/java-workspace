package day8;

public class ScoreApp2 {
	
	public static void main(String[] args) {
		// 김유신, 이순신, 류관순의 성적정보를 각각 저장하는 Score객체 생성하기
		Score score1 = new Score();
		score1.setScore("김유신", 100, 90, 80);
		score1.processScore();
		score1.printScore();
		
		Score score2 = new Score();
		score2.setScore("이순신", 90, 80, 70);
		score2.processScore();
		score2.printScore();

		Score score3 = new Score();
		score3.setScore("류관순", 80, 70, 60);
		score3.processScore();
		score3.printScore();
		
	}
}
