package day8;

import utils.KeyboardReader;

public class ScoreApp4 {
	
	
	public static void main(String[] args) {
		//	키보드로 학생이름, 국어, 영어, 수학 점수를 입력받아서 성적을 출력하는 프로그램
	   KeyboardReader keyboard = new KeyboardReader();
	   
	   // 학생 성적 3개를 저장하는 배열객체 생성하기
	   Score[] scores = new Score[3];
	   
	   Score score = new Score();
	   for (int index = 0; index < scores.length; index++) {
	   //학생이름, 국어, 영어, 수학점수를 입력받기
	   System.out.print("이름을 입력하세요 : ");
	   String studentName = keyboard.getString();
	   System.out.print("국어점수를 입력하세요 : ");
	   int korScore = keyboard.getInt();
	   System.out.print("영어점수를 입력하세요 : ");
	   int engScore = keyboard.getInt();
	   System.out.print("수학점수를 입력하세요 : ");
	   int mathScore = keyboard.getInt();
	   
	   // 입력된 성적정보를 저장할 Score객체를 생성하고, setScore() 메소드를 실핼해서 생성된 Score 객체의 멤버변수에 값을 대입시킨다.
	   score.setScore(studentName, korScore, engScore, mathScore);
	   
	   //배열에 Score 객체를 저장하기
	   scores[index] = score;
	   
	   System.out.println("배열의 ["+index+"]번째에 성적정보가 저장되었습니다.");
	   System.out.println();
	   
	   }
	   
	   // 배열에 저장된 학생 성적 정보 출력하기
	   System.out.println("---------------------------------");
	   for (Score score1 : scores) {
		   score1.processScore();
		   score1.printScore();
	   }
	   
	   
	}

}
