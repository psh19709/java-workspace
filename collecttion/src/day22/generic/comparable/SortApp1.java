package day22.generic.comparable;

import java.util.Arrays;

public class SortApp1 {

	public static void main(String[] args) {
		int[] numbers = {10, 30, 12, 51, 65, 37, 95, 70, 18, 48};
		String[] names = {"홍길동", "김유신", "강감찬", "안중근", "이재원", "이봉창", "윤봉길"};
		
		Arrays.sort(numbers);			//오름차순으로 정렬
		Arrays.sort(names);				//오름차순으로 정렬
		
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(names));
	}
}
