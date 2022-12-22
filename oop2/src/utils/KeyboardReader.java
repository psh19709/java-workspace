package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 키보드 입력을 읽어서 정수, 실수, 문자, 불린, 문자열로 반환하는 기능이 구현된 클래스다.
 * @author lee_e
 *
 */
public class KeyboardReader {

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * 키보드로 입력된 소숫점이 없는 숫자를 읽어서 정수로 제공한다.
	 * @return int타입의 정수
	 */
	public int getInt() {
		return Integer.parseInt(getValue());
	}
	
	/**
	 * 키보드로 입력된 소숫점이 없는 숫자를 읽어서 정수로 제공한다. 숫자가 아닌 문자는 입력할 수 없다.
	 * @return long타입의 정수
	 */
	public long getLong() {
		return Long.parseLong(getValue());
	}
	
	/**
	 * 키보드로 입력된 소숫점이 있는 숫자를 읽어서 실수로 제공한다. 소숫점을 제외하고 숫자가 아닌 문자는 입력할 수 없다.
	 * @return double타입의 정수
	 */
	public double getDouble() {
		return Double.parseDouble(getValue());
	}
	
	/**
	 * 키보드로 입력된 글자를 읽어서 문자로 반환한다. 여러 글자를 입력하더라도 첫번째 글자만 제공한다.
	 * @return char타입의 문자
	 */
	public char getChar() {
		return getValue().charAt(0);
	}
	
	/**
	 * 키보드로 입력된 글자를 읽어서 불린값으로 반환한다. 입력하는 글자는 true나 false 중에서 하나다.
	 * @return boolean타입의 값
	 */
	public boolean getBoolean() {
		return Boolean.parseBoolean(getValue());
	}
	
	/**
	 * 키보드로 입력된 글자를 읽어서 문자열로 제공한다. 
	 * @return String타입의 문자열
	 */
	public String getString() {
		return getValue();
	}
	
	private String getValue() {
		String value = "";
		try {
			value = in.readLine().trim();
		} catch (IOException e) {}
		return value;
	}
}
