package day18;

public class ContactApp2 {

	public static void main(String[] args) throws Exception {
		// 객체 복제본을 생성하기
		
		// 원본 Contact 객체
		Contact originContact = new Contact("김유신", "010-1111-1111", "kin@naver.com");
		
		// 복재본 Contact 객체
		// 복제본 Contact 객체는 원본 Contact 객체와 서로 다른 객체다
		// 복제본 Contact 객체는 원본 Contact 객체와 같은 값을 가지고 있다.
		Contact copiedContact = originContact.copy();
		
		System.out.println(originContact);
		System.out.println(copiedContact);
				
	}
}
