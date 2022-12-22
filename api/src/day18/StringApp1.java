package day18;

public class StringApp1 {
	public static void main(String[] args) {
		String str1 = "Hello, Java";
		// String str1 = new String("Hello, java")
		
		System.out.println("### length() 메소드");
		// int length () - 문자열의 길이를 반환한다. 공백도 길이에 포함된다.
		int len = str1.length();
		System.out.println("문자열의 길이: " + len);
		System.out.println();
		
		System.out.println("### isEmpty() 메소드");
		// boolean isEmpty() - 빈 문자열인(길이가 0인 문자열) 경우 true를 반환한다.
		System.out.println(str1.isEmpty());			//false
		System.out.println("    ".isEmpty());		//false
		System.out.println("".isEmpty());			//true
		System.out.println();
		
		System.out.println("### isBlank() 메소드");
		//boolean isBlank() - 빈 문자열(길이가 0인 문자열)이거나, 공백으로 구성된 문자열인 경우 true를 반환한다.
		System.out.println(str1.isBlank());			//false
		System.out.println("   ".isBlank());		//true
		System.out.println("".isBlank());			//true
		System.out.println();
		
		System.out.println("### equals(Object obj) 메소드");
		System.out.println("abc".equals("abc"));				//true
		System.out.println("abc".equals("ABC"));				//false
		System.out.println("abc".equalsIgnoreCase("abc"));		//true
		System.out.println("abc".equalsIgnoreCase("ABC"));		//true 대소문자 구분 안함
		System.out.println();
		// equals()
		//StringApp1.test1("골드");
		//StringApp1.test1(null);		// NullPointException 오류가 발생한다.
		//StringApp1.test2("골드");
		//StringApp1.test2(null);
		
		System.out.println("### contains(CharSequence) 메소드");
		//boolean contains(CharSequence charSequence) - 문자열이 지정된 CharSequence를 포하하고 있으면 true를 반환한다.
		System.out.println(str1.contains("Hello"));		//true
		System.out.println(str1.contains("product"));		//false, 문자열 str1은 "product"을 포함하고 있지 않음
		System.out.println();
		
		System.out.println("### substring(int begin), substring(int begin, int end) 메소드");
		// String substring(int begin) - 문자열에서 지정된 시작위치부터 문자열의 끝부분에 해당되는 부분 문자열을 반환한다.
		// String substring(int begin, int end) - 문자열에서 지정된 시작위치부터 지정된 끝위치 바로 앞부분에 해당되는 부분 문자열을 반환한다.
		//										 문자열의 위치는 0부터 시작한다.
		String str2 = "abcdefghijklnmopqrstuwvxyz";
		String substr1 = str2.substring(0);		// str2의 0번쨰부터 끝까지
		String substr2 = str2.substring(1);		// str2의 1번쨰부터 끝까지
		String substr3 = str2.substring(2);		// str2의 2번쨰부터 끝까지
		String substr4 = str2.substring(0, 10);	// str2의 0번쨰부터 9번째까지
		String substr5 = str2.substring(10, 20);	// str2의 10번쨰부터 19번째까지
		System.out.println(substr1);
		System.out.println(substr2);
		System.out.println(substr3);
		System.out.println(substr4);
		System.out.println(substr5);
		System.out.println();
		
		System.out.println("### indexOf(String str), lastIndexOf(String str) 메소드");
		// int indexOf(String str) - 문자열에서 지정된 문자열이 처음으로 등장하는 위치를 반환한다.
		// int indexOf(String str, fromIndex) - fromIndex로 지정된 위치부처 찾아서 등장하는 위치를 반환한다.
		// int lastIndexOf(String str) - 문자열에서 지정된 문자열이 마지막으로 등장하는 위치를 반환한다.
		//							지정된 문자열이 존재하지 않으면 -1을 반환한다.
		String str3 = "My black shirt is real black black shirt!";
		System.out.println(str3.indexOf("black"));			// 3
		System.out.println(str3.indexOf("black", 10));		// 23
		System.out.println(str3.lastIndexOf("black"));		// 29
		System.out.println();
		
		System.out.println("### strtsWith(String str), endsWith(String str) 메소드");
		// boolean strtsWith(String str) - 문자열이 지정된 문자열로 시작하면 true를 반환한다.
		// boolean endsWith(String str) - 문자열이 지정된 문자열로 끝나면 true를 반환한다.
		System.out.println("http:// www.naver.com".startsWith("http"));		//true
		System.out.println(" www.naver.com".startsWith("http"));			//false
		System.out.println("spring.io".startsWith("http"));					//false
		
		System.out.println("보고서.xlsx".endsWith("xlsx"));				//true
		System.out.println("보고서.docx".endsWith("xlsx"));				//false
		System.out.println("보고서.pptx".endsWith("xlsx"));				//false
		System.out.println("보고서.hwpx".endsWith("xlsx"));				//false
		System.out.println();
		
		System.out.println("### toUpperCase(), toLowerCase() 메소드");
		// String toUpperCase() - 문자열에 대해서 대문자로 구성된 새로운 문자열을 반환한다.
		// String toLowerCase() - 문자열에 대해서 소문자로 구성된 새로운 문자열을 반환한다.
		//							* 절대로 기존 문자열을 대문자나 소문자로 변환하는 것이 절대 절대 아니다.
		String str4 = "The String class represents character strings";
		String upperText = str4.toUpperCase();
		String lowerText = str4.toLowerCase();
		System.out.println(str4);					// "The String class represents character strings"
		System.out.println(upperText);				// "THE STRING CLASS REPRESENTS CHARACTER STRINGS"
		System.out.println(lowerText);				// "the string class represents character strings"
		System.out.println();
		
		System.out.println("### replace(CharSequence taget, CharSequence replacement) 메소드");
		// String replace(CharSequence target, CharSequence replacement) - 문자열에서 대상 문자열이 대체문자열로 변경된 새 문자열을 반환한다. 
		//																* 절대로 기존 문자열이 변경된 것이 아니다.
		String str5 = "나는 자바가 제일 좋아서 자바를 공부한다.";
		String replacedText = str5.replace("자바", "파이썬");
		System.out.println(str5);						// "나는 자바가 제일 좋아서 자바를 공부한다."
		System.out.println(replacedText);				// "나는 파이썬가 제일 좋아서 파이썬를 공부한다.";
		System.out.println();
		
		System.out.println("### trim() 메소드");
		//String trim() - 문자열에서 문자열의 좌/우에 위치하는 의미없는 공백이 없는 새로운 문자열을 반환한다.
		//				* 절대로 기존 문자열의 의미없는 공백을 없애는게 아니다.
		String str6 = "            안녕,            나는              홍길동이야         ";
		String trimedText = str6.trim();
		System.out.println("["+str6+"]");				// [            안녕,            나는              홍길동이야         ]
		System.out.println("["+trimedText+"]");			// [안녕,            나는              홍길동이야]
		System.out.println();
		
	}
		
	// 이 메소드는 grade가 null값을 인자로 전달받으면 NullPointException 오류가 발생한다.
	public static void test1(String grade) {
		if(grade.equals("골드")) {
			System.out.println("골드 등급은 5&를 적립합니다.");
		} else if(grade.equals("실버")) {
			System.out.println("실버 등급은 2%를 적립합니다.");
			
		} else if(grade.equals("브론즈")) {
			System.out.println("브론즈 등급은 1%를 적립합니다.");
			
		} else {
			System.out.println("유효한 등급이 아닙니다.");
			
		}
			
	}
	
	// 이 메소드는 grade가 null값을 인자로 전달받으면 "유효한 등급이 아닙니다."가 출력된다.
	// 문자열 비교를 할 때 "문자열".equals(변수)의 형태로 작성하자.
	// null 값을 가질 다능성이 더 적은 값이 앞에 위치해야 한다.
	public static void test2(String grade) {
		if("골드".equals(grade)) {
			System.out.println("골드 등급은 5&를 적립합니다.");
		} else if("실버".equals(grade)) {
			System.out.println("실버 등급은 2%를 적립합니다.");
			
		} else if("브론즈".equals(grade)) {
			System.out.println("브론즈 등급은 1%를 적립합니다.");
			
		} else {
			System.out.println("유효한 등급이 아닙니다.");
			
		}
		
	}

}
