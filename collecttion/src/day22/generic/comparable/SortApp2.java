package day22.generic.comparable;

import java.util.Arrays;

public class SortApp2 {

	public static void main(String[] args) {
		
		Score[] scores = new Score[5];
		scores[0] = new Score("이순신", 100, 90, 90);
		scores[1] = new Score("강감찬", 80, 50, 50);
		scores[2] = new Score("이재원", 90, 90, 90);
		scores[3] = new Score("김유신", 70, 70, 80);
		scores[4] = new Score("홍길동", 30, 70, 50);
		
		// 총점이 낮은 순에서 높은 순으로 배열에 저장된 Score객체를 정렬하기
		Arrays.sort(scores);
		
		System.out.println("정렬된 결과: " + Arrays.toString(scores));
	}
}
