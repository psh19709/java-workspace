package app2.copy;

import utils.KeyboardReader;

public class BookStoreController {
	
	private KeyboardReader keyReader = new KeyboardReader();
	private BookStoreService service = new BookStoreService();

	public void 실행() {
		메뉴();
		
	}
	
	private void 메뉴() {
		while(true) {

			System.out.println("---------------------------");
			System.out.println("1.전체도서목록 2.구매하기 3.구매목록출력 4.구매상세정보출력 0.종료");
			System.out.println("---------------------------");
			System.out.println();
			
			System.out.print("메뉴선택: ");
			int menuNo = keyReader.getInt();
			System.out.println();
			
			if(menuNo == 1) {
				전체도서목록출력();
			} else if(menuNo == 2) {
				구매하기();
			} else if(menuNo == 3) {
				구매목록출력();
			} else if(menuNo == 4) {
				구매상세정보출력();
			} else if(menuNo == 0) {
				System.out.println(" ###프로그램을 종료합니다.");
				System.exit(0);
			}
			System.out.println();
			System.out.println();
			
			메뉴();
		}
		
	}
	
	private void 전체도서목록출력() {
		// 도서번호,제목,가격,할인가격,재고현황 출력하기
	}
	
	private void 구매하기() {
		// "도서번호:구매수량,도서번호:구매수량,도서번호:구매수량"의 형식으로 값을 입력받는다.
		// 위의 정보를 서비스에 전달
		
	}
	
	private void 구매목록출력() {
		// 주문번호, 주문날짜, 총구매가격, 총구매수량 목록
		// 주문번호, 주문날짜, 총구매가격, 총구매수량 목록
		// 주문번호, 주문날짜, 총구매가격, 총구매수량 목록
		// 주문번호, 주문날짜, 총구매가격, 총구매수량 목록
		
	}
	
	private void 구매상세정보출력() {
		// 주문번호를 입력받는다.
		// 주문번호에 해당하는 주문상품정보를 획득
		
		// 주문번호, 주문날짜
		// 상품번호, 상품명, 가격, 할인가격, 구매수량, 구매가격
		// 상품번호, 상품명, 가격, 할인가격, 구매수량, 구매가격
		// 상품번호, 상품명, 가격, 할인가격, 구매수량, 구매가격
		// 상품번호, 상품명, 가격, 할인가격, 구매수량, 구매가격
		//                            총 구매수량
		//                            총 구매가격
	}
}
