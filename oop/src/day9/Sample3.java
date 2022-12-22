package day9;

public class Sample3 {
	   /*
	    * 정수 2개를 전달받아서 그 합계를 화면에 출력하는 메소드
	    * 반환타입 : void
	    * 메소드명 : plus
	    * 매개변수 : int x, int y
	    */
	
	public void plus(int x, int y) {
		int z = x + y;
	   System.out.println("합계: " + z);
	}
	   
	   /*
	    * 정수 2개를 전달받아서 더 큰 정수를 반환하는 메소드
	    * 반환타입 : int
	    * 메소드명 : max
	    * 매개변수 : int x, int y
	    * if문을 사용해서 구현하세요
	    */
	public int max(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}
	   
	   /*
	    * 정수 3개를 전달받아서 더 큰 정수를 반환하는 메소드
	    * 반환타입 : int
	    * 메소드명 : max
	    * 매개변수 : int x, int y, int z
	    * if문을 2번 사용해서 구현하세요
	    */
	
//	public int max(int x, int y, int z) {
//		if (x > y) {
//			return x;
//		} else if (z > x) {
//			return z;
//		}  return y;
//	}
	   
	public int max(int x, int y, int z) {
		// 3, 2, 6
		int max = x;
		if(y > x) {
			max = y;
		}
		if(z > max) {
			max = z;
		}
		return max;
	}
	   /*
	    * 정수 2개를 전달받아서 첫번째 정수부터 두번째 정수사이 정수들의 합계를 반환하는 메소드
	    * 반환타입 : int
	    * 메소드명 : sum
	    * 매개변수 : int start, int end 
	    * for문을 사용해서 구현하세요. 합계를 저장할 변수를 먼저 정의하세요
	    */
	
	public int sum(int start, int end) {
		int total = 0;
		
		for (int i = start; i <= end; i++) {
			total += i;
		}
		
		return total;
	}
	
	   
	   /*
	    * 정수배열 객체를 전달받아서 배열객체에 저장된 정수의 총합을 반환하는 메소드
	    * 반환타입 : int
	    * 메소드명 : sum
	    * 매개변수 : int[] numbers
	    * 향상된 for문을 사용해서 구현하세요. 합계를 저장할 변수를 먼저 정의하세요
	    */
	public int sum(int[] numbers) {  
		int total = 0;
		
		for ( int value : numbers) {			//식을 구하는게 중요한 관건
			total += value;
		}
		
		return total;
	}
	   
	   /*
	    * 정수 2개를 전달받아서 첫번째 정수부터 두번째 정수 사이의 숫자들이 저장된 배열객체를 반환하는 메소드
	    * 반환타입 : int[] // 정수가 여러 개 저장된 배열객체의 주소값을 반환한다.
	    * 메소드명 : createArray
	    * 매개변수 : int begin, int end
	    * 첫번째 정수와 두번째 정수도 포함됩니다. 두 정수를 이용해서 배열의 크기를 먼저 구하고, 그 크기만큼 배열을 생성하세요.
	    * for문을 사용해서 배열의 0번째부터 값을 저장하세요.
	    */
	
	public int[] createArray(int begin, int end) {
		int [] numbers = new int[end - begin + 1];
		int index = 0;
		for(int i = begin; i <= end; i++) {
			numbers[index] = i;
			index++;
		}
		
		return numbers;
	}


}
