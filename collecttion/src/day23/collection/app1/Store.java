package day23.collection.app1;

import day23.collection.app1.controller.StoreController;
import day23.collection.app1.service.StoreService;
import utils.KeyboardReader;

public class Store {
	
	public static void main(String[] args) {
// 상품 애플리케이션을 구성하는 객체 생성하기
		// KeyboardReader, StoreService, StoreController 생성
		KeyboardReader keyboard = new KeyboardReader();
		StoreService service = new StoreService();
		
// 객체들 조립하기
		// StoreController객체의 멤버변수(private KeyboardReader keyboard, private StoreService service)에
		// KeyboardReader객체와 StoreService객체의 주소값을 생성자 메소드로 전달함.
		StoreController controller = new StoreController(keyboard, service);
		
// 프로그램 실행
		controller.실행();
	}

}
