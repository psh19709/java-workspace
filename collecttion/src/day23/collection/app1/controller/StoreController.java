package day23.collection.app1.controller;

import java.util.ArrayList;
import java.util.List;

import day23.collection.app1.service.StoreService;
import day23.collection.app1.vo.Customer;
import day23.collection.app1.vo.Item;
import day23.collection.app1.vo.Order;
import day23.collection.app1.vo.Product;
import utils.KeyboardReader;
import utils.StringUtils;

public class StoreController {
	
	/**
	 * 키보드 입력을 읽어오는 객체다.
	 */
	private KeyboardReader keyboard;
	/**
	 * 상점관련 업무로직이 구현된 객체다.
	 */
	private StoreService service;
	
	/**
	 * StoreController 객체의 생성자 메소드다.
	 * <p>StoreController의 실행애 필요한 KeyboardReader객체와 StoreService객체를 전달받아서 멤버변수에 대입한다.
	 * @param keyboard	키보드 입력을 읽어오는 객체
	 * @param service	상점관련 업무로직이 구현된 객체
	 */
	public StoreController(KeyboardReader keyboard, StoreService service) {
		this.keyboard = keyboard;
		this.service = service;
	}

	public void 실행() {
		메뉴();
	}
	
	private void 메뉴() {
		while (true) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("1.고객  2.상품  3.주문  0.종료");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println();
			
			System.out.print("# 메뉴선택: ");
			int mainMenuNo = keyboard.getInt();
			
			if (mainMenuNo == 1) {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("1.고객조회  2.고객등록");
				System.out.println("--------------------------------------------------------------------------");
				System.out.println();
				
				System.out.print("# 고객메뉴 선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				if (menuNo == 1) {
					고객정보출력();
				} else if (menuNo == 2) {
					신규고객등록();
				}
				System.out.println();
				
			} else if (mainMenuNo == 2) {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("1.상품목록  2.상품상세  3.상품입고");
				System.out.println("--------------------------------------------------------------------------");
				System.out.println();
				
				System.out.print("# 상품메뉴 선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				if (menuNo == 1) {
					전체상품리스트출력();
				} else if (menuNo == 2) {
					상품상세정보출력();
				} else if (menuNo == 3) {
					상품입고();
				}
				System.out.println();
				
			} else if (mainMenuNo == 3) {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("1.주문  2.전체주문내역  3.고객별주문내역  4.주문상세");
				System.out.println("--------------------------------------------------------------------------");
				System.out.println();
				
				System.out.print("# 주문메뉴 선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				if (menuNo == 1) {
					주문하기();
				} else if (menuNo == 2) {
					전체주문내역출력();
				} else if (menuNo == 3) {
					고객별주문내역출력();
				} else if (menuNo == 4) {
					주문상세정보출력();
				}
				System.out.println();
			} else if (mainMenuNo == 0) {
				System.out.println("### 프로그램 종료");
				System.exit(0);
			}			
			System.out.println();
		}
	}
	
	private void 전체상품리스트출력() {
		System.out.println("<< 전체 상품 목록 출력 >>");
		
		List<Product> products = service.getAllProducts();
		System.out.println("상품번호\t상품명\t가격");
		for(Product product : products) {
			System.out.print(product.getNo() + "\t");
			System.out.print(product.getName() + "\t");
			System.out.println(product.getDiscountPrice() + "\t");
			
			
		}
	}
	
	private void 상품입고() {
		System.out.println("<< 상품 입고 >>");
		System.out.print("## 상품 번호를 입력해주세요: ");
		int productNo = keyboard.getInt();
		
		System.out.print("## 입고 수량을 입력해주세요: ");
		int amount = keyboard.getInt();
		
		boolean isSuccess = service.updateProductStock(productNo, amount);
		if(isSuccess) {
			System.out.println("[성공] 재고수량이 변경되었습니다.");
		} else {
			System.out.println("[오류] 상품정보가 존재하지 않습니다.");
		}
	}
	
	private void 상품상세정보출력() {
		System.out.println("<<  상품 상세 정보 출력  >>");
		
		System.out.print("## 상품 번호를 입력해주세요: ");
		int productNo = keyboard.getInt();
		
		Product product = service.getProductDetail(productNo);
		if(product == null) {
			System.out.println("[ 오류 ] 상품 정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("==== 상품 상세 정보 ====");
		System.out.println("상품번호: " + product.getNo());
		System.out.println("상품이름: " + product.getName());
		System.out.println("상품가격: " + product.getPrice());
		System.out.println("할인가격: " + product.getDiscountPrice());
		System.out.println("재고수량: " + product.getStock());
		
	}
	
	private void 신규고객등록() {
		System.out.println("<< 신규 고객 등록 >>");
		
		System.out.print("## 고객 아이디 입력: ");
		String customerId = keyboard.getString();
		
		System.out.print("## 고객 이름 입력: ");
		String customerName = keyboard.getString();
		
		System.out.print("## 고객 이메일 입력: ");
		String customerEmail = keyboard.getString();
		
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setName(customerName);
		customer.setEmail(customerEmail);
		
		boolean isSuccess = service.addCustomer(customer);
		if(isSuccess ) {
			System.out.println("[성공] 고객정보가 등록되었습니다.");
		} else {
			System.out.println("[오류] 이미 사용중인 아이디 입니다.");
		}
		
	}
	
	private void 고객정보출력() {
		System.out.println("<<  고객 상세 정보 출력  >>");
		
		System.out.print("## 고객 아이디 입력: ");
		String customerId = keyboard.getString();
		
		Customer customer =  service.getCustomerById(customerId);
		if(customer != null) {			// null체크를 해야한다!
			System.out.println("=== 고객 상세 정보 ===");
			System.out.println("고객 아이디: " + customer.getId());
			System.out.println("고객 이름: " + customer.getName());
			System.out.println("고객 이메일: " + customer.getEmail());
			System.out.println("고객 포인트: " + customer.getPoint());
		} else {
			System.out.println("[ 오류 ] 고객 정보가 존재하지 않습니다.");
		}
	}
	
	private void 주문하기() {
		System.out.println("<<  주문하기  >>");
		
		System.out.print("## 고객 아이디 입력: ");
		String customerId = keyboard.getString();
		
		List<Integer> productNoList = new ArrayList<>();
		List<Integer> quantityList = new ArrayList<>();
		
		while(true) {
		System.out.print("## 상품번호 입력: ");
		int productNo = keyboard.getInt();
		
		System.out.print("## 구매수량입력: ");
		int quantityNo = keyboard.getInt();
		
		productNoList.add(productNo);
		quantityList.add(quantityNo);
		
		System.out.println("## 계속 구매하시겠습니까? (y/n)");
		String confirm = keyboard.getString();
		
		if("n".equals(confirm)) {
			break;
			}
			System.out.println();
		}
		boolean isSuccess = service.order(customerId, productNoList, quantityList);
		if(isSuccess) {
			System.out.println("[성공] 모든 주문이 완료되었습니다.");
		} else {
			System.out.println("[오류] 일부 혹은 모든 주문이 완료되지 않았습니다.");
		}
	}
	
	private void 전체주문내역출력() {
		System.out.println("<<  전체 주문 내역 출력  >>");
		
		List<Order> orderList = service.getAllOrders();
		if(orderList.isEmpty()) {
			System.out.println("[안내] 주문내역이 존재하지 않습니다.");
			
		} else {
			System.out.println("주문번호\t\t고객명\t총 구매금액");
			for (Order order : orderList) {
				System.out.print(order.getNo() + "\t\t");
				System.out.print(order.getCustomerName() + "\t");
				System.out.println(order.getTotalOrderPrice());
			}
		}
		
	}
	
	private void 고객별주문내역출력() {
		System.out.println("<<  고객별 주문 내역 출력  >>");
		
		System.out.print("## 고객 아이디 입력: ");
		String customerId = keyboard.getString();
		
		List<Order> orderList = service.getOrderByCustomerId(customerId);
		if(orderList.isEmpty()) {
			System.out.println("[안내] 주문내역이 존재하지 않습니다.");
		} else {
			System.out.println("주문번호\t\t주문날짜\t\t총구매금액");
			for(Order order : orderList) {
				System.out.print(order.getNo() + "\t\t");
				System.out.print(StringUtils.dateToString(order.getDate()) + "\t");
				System.out.println(StringUtils.numberToString(order.getTotalOrderPrice()) + " 원");
			}
		}
		
	}
	
	private void 주문상세정보출력() {
		System.out.println("<< 주문 상세 정보 출력 >>");
		
		System.out.print("## 주문번호 입력: ");
		int orderNo = keyboard.getInt();
		
		Order order = service.getOrderDetail(orderNo);
		if(order == null) {
			System.out.println("[안내] 주문정보가 존재하지 않습니다,");
		} else {
			System.out.println("=== 주문 상세 정보 ===");
			System.out.println("주문번호: " + order.getNo());
			System.out.println("주문 날짜ㅣ " + order.getDate());
			System.out.println("주문자 아이디: " + order.getCustomerId());
			System.out.println("주문자 이름: " + order.getCustomerName());
			System.out.println();
			
			List<Item> items = order.getItems();
			
			System.out.println("=== 주문 상품 정보 ===");
			System.out.println("상품번호\t상품이름\t상품가격\t\t구매수량\t구매가격");
			
			for(Item item : items) {
				System.out.print(item.getNo() + "\t");
				System.out.print(item.getName() + "\t");
				System.out.print(StringUtils.numberToString(item.getPrice()) + "원\t\t");
				System.out.print(item.getQuantity() + "\t");
				System.out.println(StringUtils.numberToString(item.getPrice()*item.getQuantity())+ "원");
			}
		}
		
	}
}
