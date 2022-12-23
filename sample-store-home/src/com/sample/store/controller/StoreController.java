package com.sample.store.controller;

import java.util.List;

import com.sample.store.dto.CartItemDto;
import com.sample.store.service.CartItemService;
import com.sample.store.service.ProductService;
import com.sample.store.service.UserService;
import com.sample.store.util.KeyboardReader;
import com.sample.store.vo.CartItem;
import com.sample.store.vo.Product;
import com.sample.store.vo.User;

public class StoreController {

	private KeyboardReader keyboard = new KeyboardReader();
	private CartItemService cartItemService = new CartItemService();
	private ProductService productService = new ProductService();
	private UserService userService = new UserService();
	
	public void run() {
		메뉴();
	}
	
	private void 메뉴() {
		while(true) {
			try {
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("1.회원가입  2.내정보보기  3.비밀번호변경  4.탈퇴  0.종료");
				System.out.println("5.전체조회  6.상품상세보기  7.상품등록  8.상품입고  9.상품출고 10.상품정보변경");
				System.out.println("11.장바구니보기  12.장바구니담기  13.장바구니비우기");
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println();
				
				System.out.print("### 메뉴선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				if (menuNo == 1) {
					회원가입();
				} else if (menuNo == 2) {
					내정보보기();
				} else if (menuNo == 3) {
					비밀번호변경();
				} else if (menuNo == 4) {
					회원탈퇴();
				} else if (menuNo == 5) {
					전체상품보기();
				} else if (menuNo == 6) {
					상품상세정보보기();
				} else if (menuNo == 7) {
					상품등록();
				} else if (menuNo == 8) {
					상품입고();
				} else if (menuNo == 9) {
					상품출고();
				} else if (menuNo == 10) {
					상품정보변경();
				} else if (menuNo == 11) {
					내장바구니보기();
				} else if (menuNo == 12) {
					장바구니담기();
				} else if (menuNo == 13) {
					장바구니비우기();
				} else if (menuNo == 0) {
					System.out.println("[안내] 프로그램을 종료합니다.");
					System.exit(0);
				}
				
			} catch (Exception ex) {
				System.out.println();
				System.out.println("[오류] " + ex.getMessage());
			}
			System.out.println();
			System.out.println();
		}
	}
	
	// 아이디, 비밀번호, 이름, 이메일, 전화번호, 성별을 입력한다.
	private void 회원가입() {
		System.out.println("<< 회원 가입 >>");
		
		// 회원가입에 필요한 정보를 입력받는다.
		System.out.print("## 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("## 비밀번호 입력: ");
		String password = keyboard.getString();
		System.out.print("## 이름 입력: ");
		String name = keyboard.getString();
		System.out.print("## 이메일 입력: ");
		String email = keyboard.getString();
		System.out.print("## 전화번호 입력: ");
		String tel = keyboard.getString();
		System.out.print("## 성별 입력(남/여): ");
		String gender = keyboard.getString();
		
		// User객체를 생성해서 입력된 회원정보를 담는다.
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setTel(tel);
		user.setGender(gender);
		
		// UserService에서 회원정보가 포함된 User객체를 전달해서 회원가입을 요청한다.
		userService.registerUser(user);
		
		System.out.println();
		System.out.println("[안내] 회원가입이 완료되었습니다.");
	}
	
	// 아이디와 비밀번호를 입력한다.
	private void 내정보보기() {
		System.out.println("<< 내정보 보기 >>");
		
		// 내정보보기에 필요한 아이디와 비밀번호를 입력받는다.
		System.out.print("## 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("## 비밀번호 입력: ");
		String password = keyboard.getString();
		System.out.println();
		
		// UserService에 아이디와 비밀번호를 전달해서 사용자정보를 요청한다.
		User user = userService.getUserById(id, password);
		
		// 조회된 사용자 정보를 출력한다.
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("아이디: " + user.getId());
		System.out.println("이름: " + user.getName());
		System.out.println("이메일: " + user.getEmail());
		System.out.println("전화번호: " + user.getTel());
		System.out.println("성별: " + user.getGender());
		System.out.println("포인트: " + user.getPoint());
		System.out.println("사용여부: " + user.getEnabled());
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	// 아이디, 비밀번호, 새 비밀번호를 입력한다.
	private void 비밀번호변경() {
		System.out.println("<< 비밀번호 변경 >>");
		
		// 아이디, 비밀번호, 새 비밀번호를 입력받는다.
		System.out.print("## 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("## 비밀번호 입력: ");
		String oldPassword = keyboard.getString();
		System.out.print("## 새 비밀번호 입력: ");
		String password = keyboard.getString();
		System.out.println();
		
		// UserService에 아이디, 비밀번호, 새 비밀번호를 전달해서 비밀번호 변경을 요청한다.
		userService.changePassword(id, oldPassword, password);
		
		System.out.println("[안내] 사용자 비밀번호가 변경되었습니다.");
	}
	
	// 아이디, 비밀번호를 입력받는다.
	private void 회원탈퇴() {
		System.out.println("<< 회원 탈퇴 >>");
		
		// 회원탈퇴에 필요한 아이디, 비밀번호를 입력받는다.
		System.out.print("## 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("## 비밀번호 입력: ");
		String password = keyboard.getString();
		System.out.println();
		
		// UserService에 아이디와 비밀번호를 전달해서 회원탈퇴를 요청한다.
		userService.disabledUser(id, password);
		
		System.out.println("[안내] 탈퇴처리가 완료되었습니다.");
	}
	
	private void 전체상품보기() {
		System.out.println("<< 전체 상품 조회 >>");
		
		// ProductService에 전체 상품 목록을 요청한다.
		List<Product> products = productService.getAllProducts();
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("상품번호\t상품가격\t수량\t상품이름");
		for (Product product : products) {
			System.out.print(product.getNo() + "\t");
			System.out.print(product.getPrice() + "\t");
			System.out.print(product.getStock() + "\t");
			System.out.println(product.getName());
		}
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	// 상품번호를 입력한다.
	private void 상품상세정보보기() {
		System.out.println("<< 상품 상세 정보 보기 >>");
		
		// 1. 상품번호를 입력받는다.
		System.out.print("## 상품번호 입력: ");
		int productNo = keyboard.getInt();
		System.out.println();
		
		// 2. ProductService에 상품번호에 전달해서 해당 상품의 상세정보를 요청한다.
		Product product = productService.getProductByNo(productNo);
		
		// 3. 조회된 상품정보를 출력한다.
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("상품번호: " + product.getNo());
		System.out.println("상품이름: " + product.getName());
		System.out.println("제조회사: " + product.getMaker());
		System.out.println("상품가격: " + product.getPrice());
		System.out.println("할인비율: " + product.getDiscountRate());
		System.out.println("상품재고: " + product.getStock());
		System.out.println("판매여부: " + product.getOnSell());
		System.out.println("---------------------------------------------------------------------------------");
		
	}
	
	// 상품명, 제조사, 가격, 할인율, 수량을 입력한다.
	private void 상품등록() {
		System.out.println("<< 신규 상품 등록 >>");
		
		// 상품명, 제조사, 가격, 할인율, 수량을 입력받는다.
		System.out.print("## 상품명 입력: ");
		String name = keyboard.getString();
		System.out.print("## 제조사 입력: ");
		String maker = keyboard.getString();
		System.out.print("## 가격 입력: ");
		int price = keyboard.getInt();
		System.out.print("## 할인율 입력: ");
		double discountRate = keyboard.getDouble();
		System.out.print("## 수량 입력: ");
		int stock = keyboard.getInt();
		System.out.println();
		
		// Product객체를 생성해서 신규 상품정보를 저장한다.
		Product product = new Product();
		product.setName(name);
		product.setMaker(maker);
		product.setPrice(price);
		product.setDiscountRate(discountRate);
		product.setStock(stock);
		
		// ProductService에 Product객체를 전달해서 등록을 요청한다.
		productService.saveProduct(product);
		
		System.out.println("[안내] 신규 상품이 등록되었습니다.");
		
	}
	
	// 상품번호, 입고량 입력
	private void 상품입고() {
		System.out.println("<< 상품 입고 >>");
		
		// 상품번호, 입고량을 입력받는다.
		System.out.print("## 상품번호 입력: ");
		int productNo = keyboard.getInt();
		System.out.print("## 입고수량 입력: ");
		int amount = keyboard.getInt();
		System.out.println();
		
		// ProductService에 상품번호와 입고량을 전달해서 재고를 증가시킨다.
		productService.increaseProductStock(productNo, amount);
		
		System.out.println("[안내] 상품입고가 완료되었습니다.");
	}
	
	// 상품번호, 출고량 입력
	private void 상품출고() {
		System.out.println("<< 상품 출고 >>");
		
		// 상품번호, 출고량을 입력받는다.
		System.out.print("## 상품번호 입력: ");
		int productNo = keyboard.getInt();
		System.out.print("## 출고수량 입력: ");
		int amount = keyboard.getInt();
		System.out.println();
		
		// ProductService에 상품번호와 출고량을 전달해서 재고를 감소시킨다.
		productService.decreaseProductStock(productNo, amount);
		
		System.out.println("[안내] 상품출고가 완료되었습니다.");
		
	}
	
	// 상품번호, 가격, 할인률 입력
	private void 상품정보변경() {
		System.out.println("<< 상품 정보 변경 >>");
		
		// 상품번호, 상품가격, 할인율을 입력받는다.
		System.out.print("## 상품번호 입력: ");
		int productNo = keyboard.getInt();
		System.out.print("## 가격 입력: ");
		int price = keyboard.getInt();
		System.out.print("## 할인율 입력: ");
		double discountRate = keyboard.getDouble();
		System.out.println();
		
		// ProductService에 상품번호, 상품가격, 할인율를 전달해서 변경을 요청한다.
		productService.updateProduct(productNo, price, discountRate);
		
		System.out.println("[안내] 상품정보가 변경되었습니다.");
	}
	
	// 사용자 아이디 입력
	private void 내장바구니보기() {
		System.out.println("<< 내 장바구니 보기 >>");
		
		// 사용자 아이디를 입력 받는다.
		System.out.print("## 아이디 입력: ");
		String userId = keyboard.getString();
		System.out.println();
		
		// CartItemService에 사용자 아이디를 전달해서 해당 사용자의 장바구니 아이템 정보를 모두 조회한다.
		List<CartItemDto> cartItemDtoList = cartItemService.getMyCartItemDtos(userId);
		
		if (cartItemDtoList.isEmpty()) {
			System.out.println("[안내] 장바구니에 저장된 상품정보가 존재하지 않습니다.");
			return;
		}
		
		// 조회된 장바구니 아이템정보를 출력한다.
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("상품번호\t상품가격\t수량\t상품이름");
		for (CartItemDto dto : cartItemDtoList) {
			System.out.print(dto.getNo() + "\t");
			System.out.print(dto.getPrice() + "\t");
			System.out.print(dto.getAmount() + "\t");
			System.out.println(dto.getName());
		}
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	// 사용자 아이디, 상품번호, 수량 입력
	private void 장바구니담기() {
		System.out.println("<< 장바구니 담기 >>");
		
		// 사용자 아이디, 상품번호, 수량을 입력 받는다.
		System.out.print("## 아이디 입력: ");
		String userId = keyboard.getString();
		System.out.print("## 상품번호 입력: ");
		int productNo = keyboard.getInt();
		System.out.print("## 상품수량 입력: ");
		int amount = keyboard.getInt();
		System.out.println();
		
		// CartItem 객체를 생성해서 입력된 정보를 저장한다.
		CartItem cartItem = new CartItem();
		cartItem.setUserId(userId);
		cartItem.setProductNo(productNo);
		cartItem.setAmount(amount);
		
		// CartItemService에 CartItem 객체를 전달해서 장바구니에 추가 요청을 한다.
		cartItemService.addCartItem(cartItem);
		
		System.out.println("[안내] 장바구니에 상품이 추가되었습니다.");
	}
	
	// 사용자 아이디, 비밀번호 입력
	private void 장바구니비우기() {
		System.out.println("<< 장바구니 비우기 >>");
		
		// 사용자아이디, 비밀번호를 입력받는다.
		System.out.print("## 아이디 입력: ");
		String userId = keyboard.getString();
		System.out.print("## 비밀번호 입력: ");
		String password = keyboard.getString();
		System.out.println();
		
		// CartItemService에 사용자아이디와 비밀번호를 전달해서 장바구니 비우기를 요청한다.
		cartItemService.clearMyCartItems(userId, password);
		
		System.out.println("[안내] 장바구니 아이템 정보를 삭제하였습니다.");
		
	}
}
