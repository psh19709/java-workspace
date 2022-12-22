package day18;

public class StringApp2 {
	
	public static void main(String[] args) {
		
		//String[] split(String delim) - 지정된 구문문자로 문자열을 잘라서 각 성분을 배열에 담아서 반환한다.
		String text = "이재원,이이,이황,김유신,강감찬,이순신,류관순,안중근,이성계,이방원";
		
		// text가 참조하는 문자열을 ","를 기준으로 잘라서 각각의 이름들을 배열에 순서대로 저장해서 반환한다.
		// names <= {"이재원", "이이", "이황", "김유신", "강감찬", "이순신", "류관순", "안중근", "이성계", "이방원"}
		String[] names = text.split(",");
		
		// 아래의 텍스트에서 성씨가 "이씨"인 사람만 출력하기 
		for(String name : names) {
			if(name.startsWith("이")) {
				System.out.println(name);
			}
		}
		
	}
}
