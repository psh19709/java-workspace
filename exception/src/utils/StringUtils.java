package utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat();
	private static DecimalFormat df = new DecimalFormat();
	
	/**
	 * 정수를 전달받아서 3자리마다 , 가 포함된 문자열로 반환한다.
	 * @param number 정수
	 * @return	"#,###" 형식의 문자열
	 */
	public static String numberToString(long number) {
		df.applyPattern("#,###");	
		return df.format(number);
	}
	
	/**
	 * 실수를 전달받아서 3자리마다 , 가 포함되고, 소숫점 2자리까지 표현되는 문자열로 반환한다.
	 * @param number 실수
	 * @return "#,###.00" 형식의 문자열
	 */
	public static String numberToString(double number) {
		df.applyPattern("#,###.00");	
		return numberToString(number, "#,###.00");
	}
	
	/**
	 * 실수를 전달받아서 지정된 패턴의 문자열로 반환한다.
	 * @param number 숫자
	 * @param pattern 패턴
	 * @return 지정된 패턴 형식의 문자열
	 */
	public static String numberToString(double number, String pattern) {
		df.applyPattern(pattern);
		return df.format(number);
	}
	
	/**
	 * java.util.Date를 전달받아서 형식의 문자열로 반환한다.
	 * @param date 날짜
	 * @return "yyyy-MM-dd" 형식의 문자열
	 */
	public static String dateToString(Date date) {
		return dateToString(date, "yyyy-MM-dd");
	}
	
	/**
	 * java.util.Date와 패턴을 전달받아서 지정된 패턴형식의 문자열로 반환한다.
	 * @param date	날짜
	 * @param pattern 패턴
	 * @return	지정된 패턴 형식의 문자열
	 */
	public static String dateToString(Date date, String pattern) {
		if(date == null || pattern == null) {
			return null;
		}
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
	/**
	 * "yyyy-MM-dd"형식의 문자열을 java.util.Date로 반환한다.
	 * @param text	"yyyy-MM-dd" 형식의 문자열
	 * @return 날짜
	 */
	public static Date textToDate(String text) {
		return textToDate(text, "yyyy-MM-dd");
	}
	
	/**
	 * 지정된 패턴형식의 문자열과 패턴을 java.util.Date로 반환한다.
	 * @param text 지정된 날짜 형식의 문자열
	 * @param pattern패턴
	 * @return 날짜
	 */
	public static Date textToDate(String text, String pattern) {
		sdf.applyPattern(pattern);
		try {
			return sdf.parse(text);
		} catch (ParseException ex){
			throw new RuntimeException(ex);
		}
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(StringUtils.dateToString(new Date()));
//		System.out.println(StringUtils.dateToString(new Date(), "a hh:mm:ss"));
//	}
	
	
}
