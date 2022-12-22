package day12;

import java.text.DecimalFormat;

public class NumberUtils {
	
	/**
	 * 숫자를 3자리마다 , 가 포함된 문자열로 반환한다.
	 * @param number 숫자
	 * @return , 가 포함된 문자열
	 */

	public static String numberToStringWithComma(long number) {
		DecimalFormat format = new DecimalFormat("#,###");
		return format.format(number);
	}
	
	public static int stringToInt(String str) {
		
		
	}
	
	public static long stringToLong(String str) {
		
		
	}
	
	public static int stringToInt(String str) {
		
		
	}
}
