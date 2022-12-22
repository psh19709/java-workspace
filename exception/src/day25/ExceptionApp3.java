package day25;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp3 {
	
	/*
	 * 발생이 예상되는 예외가 checkedExcetion이면 try ~ catch를 사용해서 직접 예외처리 하던지,
	 * throws를 사용해서 예외처리를 위임할 것인지 정의해야 한다.(반드시)
	 * 발생이 예상되는 예외가 unchaeckedExcetion이면 에외처리를 하지 않아도 된다.
	 * try ~ catch를 사용해서 직접 예외처리를 할 수 있다.
	 * 예외처리를 위임시킬 때는 throws를 사용하지 않아도 이 메소드에서 발생한 예외가 이 메소드를 호출할 측에게 예외가 전달되고,
	 * 에외처리가 위임된다.
	 */
	
	
	// checkedException에서 예외처리하기 try{~}catch{~}
	public static void main(String[] args) {
		try {
		Date date = ExceptionApp3.stringToDate("2012-12-");
		System.out.println(date);
		
		ExceptionApp3.writeText("안녕하세요");
		} catch (ParseException ex) {
			System.out.println("### 올바른 날짜 형식의 문자열이 아닙니다.");
		} catch (IOException ex) {
			System.out.println("### 입출력 작업 중 오류가 발생하였습니다.");
		} catch (Exception ex) {
			System.out.println("### 알 수 없는 오류가 발생하였습니다.");
		}
		
	}
	
	// 예외처리를 이 메소드를 호출하는 측에게 위임함(throws)
	public static Date stringToDate(String text) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(text);
		
		return date;
	}
	
	public static void writeText(String text) throws IOException {
		FileWriter writer = new FileWriter("sample.txt");
		writer.write(text);
		writer.flush();
		writer.close();
		
	}

}
