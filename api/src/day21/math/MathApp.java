package day21.math;

import java.util.Arrays;

public class MathApp {

	public static void main(String[] args) {
		/*
		 * java.lang.Math
		 * 		수학연산과 관련된 기능을 제공하는 유틸클래스다.
		 * 		모든 메소드가 정적메소드다.
		 * 
		 * 		static int abs(int value)
		 * 			절대값을 반환한다.
		 * 		static int min(int a, int b)
		 * 			더 작은 값을 반환한다.
		 * 		static int max(int a, int b)
		 * 			더 큰 값을 반환한다.
		 * 		static long round(double)
		 * 			실수를 일의 자리까지 반올림해서 반환한다.
		 * 		static double ceil(double a)
		 * 			천정값을 반환한다.
		 * 			1 < x <= 2 x가 이 범위일 때, ceil(x)는 2.0이다.
		 * 		static double floor(double a)
		 * 			바닥값을 반환한다.
		 * 			1 <= x < 2 x가 이 범위일 때, floor(x)는 1.0이다.
		 * 		static random()
		 * 			0.0보다 크거나 같고, 1.0보다 작은 임의의 실수를 반환한다. 난수를 반환한다.
		 * 			0.0 <= ㅌ < 1.0 범위의 실수값을 반환한다.
		 * 
		 * 			(int)Math.random()*N는 0부터 (N - 1)까지의 숫자중에서 임의의 숫자가 반환된다.
		 * 			(int) (Math.random()*N + 1)는 1부터 N까지의 숫자중에서 임의의 숫자가 반환된다.
		 * 
		 */
		System.out.println("### round() 메소드");
		System.out.println(Math.round(1.3));		// 1
		System.out.println(Math.round(1.5));		// 2
		System.out.println(Math.round(1.6));		// 2
		System.out.println();
		System.out.println("### ceil() 메소드");
		System.out.println(Math.ceil(1.3));		// 2
		System.out.println(Math.ceil(1.5));		// 2
		System.out.println(Math.ceil(1.6));		// 2
		System.out.println();
		System.out.println("### floor() 메소드");
		System.out.println(Math.floor(1.3));		// 1
		System.out.println(Math.floor(1.5));		// 1
		System.out.println(Math.floor(1.6));		// 1
		System.out.println();
		System.out.println("### random() 메소드");
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println((int) (Math.random()*45 + 1));		
		System.out.println();
		
		int[] numbers = new int[10];
		for(int i = 0; i < 10; i++) {
			int number = (int) (Math.random()*100 + 1);
			numbers[i] = number;
		}
		System.out.println(Arrays.toString(numbers));
	}
}
