package app1.copy;

import utils.KeyboardReader;

public class StoreController {
	
	private KeyboardReader keyboard = new KeyboardReader();
	private StoreService service = new StoreService();

	public void 실행() {
		메뉴();
	}
	
	private void 메뉴() {
		while(true) {
			System.out.println("----------------------------------------------");
			System.out.println("1.새상품등록 2.상품입고 3.상품판매 4.상품현황출력 5.판매현황출력 0.종료");
			System.out.println("----------------------------------------------");
			System.out.println();
			
			System.out.print("메뉴선택: ");
			int menuNo = keyboard.getInt();
			System.out.println();
			
			if(menuNo == 1) {
				새상품등록();
			} else if (menuNo == 2) {
				상품입고();
			}
			 else if (menuNo == 3) {
				 상품판매();
			 }
			 else if (menuNo == 4) {
				 상품현황출력();
			 }
		 	else if (menuNo == 5) {
		 		판매현황출력();
			 	}
		 	else if(menuNo == 0) {
		 		System.out.println("### 프로그램을 종료합니다.");
		 		System.exit(0);
		 	}
			System.out.println();
			System.out.println();
			
			메뉴();
		}
		
	}
	private void 새상품등록() {
		// 상품번호, 상품명, 제조사, 가격, 최초입고수량을 입력받아서 상품을 등록시킨다.
		System.out.println("<< 새 상품 등록 >>");
		System.out.println("상품정보 입력(상품번호, 상품명, 제조사, 가격, 최초입고수량)");
		String text = keyboard.getString();
		String[] items = text.split(",");
		
		Product product = new Product();
		product.setNo(Integer.parseInt(items[0]));
		product.setName(items[1]);
		product.setMaker(items[2]);
		product.setPrice(Integer.parseInt(items[3]));
		product.setStock(Integer.parseInt(items[4]));
		System.out.println(product);
	}
	private void 상품입고() {
		// 상품번호, 추가입고수량을 입력받아서 상품의 재고수량을 증가시킨다.
		System.out.println("<< 상품 입고 >>");
		
		System.out.print("상품번호 입력: ");
		int no = keyboard.getInt();
		System.out.println("추가 입고 수량 입력: ");
		int stock = keyboard.getInt();
		
		Product product = new Product();
		product.setNo(no);
		product.setStock(stock);
		
		boolean isSeccess = service.updateProduct(no, stock);
			if(isSeccess){
				System.out.println("### 상품 정보가 변경되었습니다.");
			} else {
				System.out.println("### 상품 정보 변경에 실패하였습니다.");
			}
		}
	
	private void 상품판매() {
		// 상품번호, 구매수량을 입력받아서 해당 상품을 판매한다.
	}
	private void 상품현황출력() {
		// 전체 상품들의 상품번호, 상품명, 가격, 재고수량을 출력한다.
		System.out.println(" <<상품 현황 출력>> ");
		
		System.out.println("상품 번호 입력: ");
		int no = keyboard.getInt();
		
		Product product = service.findProductByNo(no);
		System.out.println();
		
		if(product == null) {
			System.out.println("### 상품 정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println(" ### 상품 현황 ### ");
		System.out.println("상품번호: " + product.getNo());
		System.out.println("상품명: " + product.getName());
		System.out.println("가격: " + product.getPrice());
		System.out.println("재고 수량: " + product.getStock());
		System.out.println();
	}
	private void 판매현황출력() {
		// 전체 판매상품의 상품번호, 상품명, 가격, 판매수량, 판매가격을 출력한다.
		
		System.out.println(" << 판매 현황 >> ");
		
		System.out.print("판매 상품의 상품번호 입력: ");
		int no = keyboard.getInt();
		SellItem sellItem = service.findSellProductByNo(no);
		System.out.println();
		
		if(sellItem == null) {
			System.out.println("### 판매 상품 정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println(" ### 판매 상품 현황 ### ");
		System.out.println("판매 상품 번호: " + sellItem.getNo());
		System.out.println("판매 상품 이름: " + sellItem.getName());
		System.out.println("판매 상품 수량: " + sellItem.getQuantity());
		System.out.println("판매 상품 가격: " + sellItem.getPrice());
		System.out.println();
	}
}
