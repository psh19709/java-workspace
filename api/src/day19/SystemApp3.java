package day19;

import java.util.Arrays;

public class SystemApp3 {
	
	public static void main(String[] args) {
		/*
		 *  static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		 *   	- 배열을 다른 배열로 복사한다.
		 * 		- 매개변수
		 *   		src				: 원본배열
		 *   		srcPos(ition)	: 원본배열에서 복사 시작위치 (대부분 0이다.)
		 *   		dest			: 대상배열
		 *   		destPos(ition)	: 대상배열에 값 추가 위치 (대부분 0이다.)
		 *   		length			: 복사할 갯수 (대부분 원본배열의 길이와 동일한 값)
		 */
		 
		int[] src = {10, 20, 30, 40, 50};
		int[] dest = new int[10];
		
		// src 배열의 값을 dest 배열에 복사하기
		System.arraycopy(src, 0, dest, 0, src.length);
		
		// dest 배열에 저장된 값을 출력하기
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
	}

}
