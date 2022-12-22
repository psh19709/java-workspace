package day12;

public class SamplrApp {

	int x;
	static int y = 2000;
	
	public void test1() {
		System.out.println(x);
		System.out.println(SamplrApp.y);
		System.out.println(y);		//SamplrApp 내부에서는 클래스 이름을 생략해도 정적변수, 정적메소드를 사용할 수 있다. 비추천이다.
	}
	
	
	public static void main(String[] args) {
		
		// System.out.println(x);           //컴파일 오류, 정적메소드에서 인스턴스 변수에 접근할 수 없다.
		System.out.println(SamplrApp.y);	// 정적메소드에서 정적변수를 사용할 수 있다.
		
		SamplrApp app = new SamplrApp();
		app.x = 100;		// 인스턴스 변수는 객체 생성 후, 참조변수를 통해서 사용가능하다.
		System.out.println(app.x);
				
	}
}
