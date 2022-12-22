package day9;

import java.util.Arrays;

public class SampleApp4 {
	
	public static void main(String[] args) {
		
		Sample3 sample = new Sample3();
		
		//void plus (int x, int y) 실행하기
		sample.plus(10, 30);
		sample.plus(3456, 12433);

		//int max (int x, int y) 실행하기
		int max1 = sample.max(10, 14);
		int max2 = sample.max(10, 10);
		int max3 = sample.max(-4, 0);
		System.out.println("큰 값: " + max1);
		System.out.println("큰 값: " + max2);
		System.out.println("큰 값: " + max3);

		//int max(int x, int y, int z) 실행하기
		int max4 = sample.max(30, 10, 20);
		int max5 = sample.max(10, 10, 10);
		int max6 = sample.max(-32, -4, -7);
		System.out.println("큰 값: " + max4);
		System.out.println("큰 값: " + max5);
		System.out.println("큰 값: " + max6);
		
		
		// int sum (int start, int end) 실행하기
		int sum1 = sample.sum(10, 100);
		int sum2 = sample.sum(-10, -1);
		int sum3 = sample.sum(0, 0);
		System.out.println("합계: " + sum1);
		System.out.println("합계: " + sum2);
		System.out.println("합계: " + sum3);

		// int sum(int[] numbers) 실행하기
		int[] numbers1 = {10, 2, 6, 8, 5, 6};
		int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] numbers3 = {1, 2, 3, 5, 7, 11, 13, 17, 19};
		int sum4 = sample.sum(numbers1);
		int sum5 = sample.sum(numbers2);
		int sum6 = sample.sum(numbers3);
		
		System.out.println("총합: " + sum4);
		System.out.println("총합: " + sum5);
		System.out.println("총합: " + sum6);
		
		// int[] createArray(int begin, int end) 실행하기
		int[] number4 = sample.createArray(1, 10);
		int[] number5 = sample.createArray(100, 1000);
		int[] number6 = sample.createArray(1000, 2000);
		System.out.println(Arrays.toString(number4));
		System.out.println(Arrays.toString(number5));
		System.out.println(Arrays.toString(number6));
	}

}
