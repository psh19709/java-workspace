package day19;

import java.util.Arrays;

import utils.KeyboardReader;

public class SystemApp4 {
	
	public static void main(String[] args) {
		KeyboardReader keyboard = new KeyboardReader();
		// 입력된 점수를 저장하는 배열
		int[] scores = new int[5];
		// 배열을 만들고 여기 아래를 생각해내야함
		// 현재 저장위치
		int position = 0;
		// 현재 배열의 최대 크기
		int limit = scores.length;
		// 한번에 증가시킬 배열의 크기
		int size = 5;
		
		while(true) {
			System.out.println("--------------------------------------");
			System.out.println("1.입력 2.조회 3.평균 0.종료");
			System.out.println("--------------------------------------");
			
			System.out.print("메뉴선택: ");
			int menuNo = keyboard.getInt();
			System.out.println();
			
			if(menuNo == 1) {
				System.out.println("<< 점수 입력 >>");
				System.out.print("점수: ");
				int score = keyboard.getInt();
						
				scores[position] = score;
				position++;
				
				// 배열의 크기를 가변적으로 늘린다.
				if(position == limit) {			
					limit += size;
					int[] dest = new int[limit];
					System.arraycopy(scores, 0, dest, 0, scores.length);
					scores = dest;
				}
			} else if (menuNo == 2) {
				System.out.println("<< 점수 조회 >>");
				System.out.println(Arrays.toString(scores));
				
			} else if (menuNo == 3) {
				System.out.println("<< 평균 점수 조회 >>");
				
				// 총점과 평균 계산하기
				int total = 0;							// total을 담는 변수를 하나 만들고
				for(int score : scores) {
					total += score;
				}
				int average = total/position;
				System.out.println("평균점수: " + average);
				
				
			} else if (menuNo == 0) {
				System.out.println("### 프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}

}
