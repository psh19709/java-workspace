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
	private UserService userService = new UserService();
	private ProductService productService = new ProductService();
	private CartItemService catCartItemService = new CartItemService();
	
	public void run() {
		메뉴();
		
	}
	
	private void 메뉴() {
		while(true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("1.회원가입 2.내정보보기 3.비밀번호변경 4.탈퇴 0.종료");
				System.out.println("5.전체조회 6.상세정보보기 7.상품등록 8.상품입고 9.상품출고 10.정보변경");
				System.out.println("11.장바구니조회 12.장바구니담기 13.장바구니비우기");
				System.out.println("------------------------------------------------------------");
				System.out.println();
				
				System.out.println("### 메뉴선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				if(menuNo == 1) {
					회원가입();
				} else if(menuNo == 2) {
					내정보보기();
				} else if(menuNo == 3) {
					비밀번호변경();
				} else if(menuNo == 4) {
					탈퇴하기();
				} else if(menuNo == 0) {
					System.out.println("[안내] 프로그램을 종료합니다.");
					System.exit(0);
				} else if(menuNo == 5) {
					전체조회();
				} else if(menuNo == 6) {
					상세정보보기();
				} else if(menuNo == 7) {
					상품등록();
				} else if(menuNo == 8) {
					상품입고();
				} else if(menuNo == 9) {
					상품출고();
				} else if(menuNo == 10) {
					상품정보수정();
				} else if(menuNo == 11) {
					내장바구니조회();
				} else if(menuNo == 12) {
					장바구니담기();
				} else if(menuNo == 13) {
					장바구니비우기();
				}
				
				
			} catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("[오류]  " + ex.getMessage());
			}
			
			System.out.println();
			System.out.println();
		}
		
	}
	
	private void 회원가입() {
		System.out.println(" << 회원 가입 >> ");
		
		System.out.println("### 회원정보를 입력하세요.");
		System.out.print("### 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("### 비밀번호 입력: ");
		String password = keyboard.getString();
		System.out.print("### 이름 입력: ");
		String name = keyboard.getString();
		System.out.print("### 이메일 입력: ");
		String email = keyboard.getString();
		System.out.print("### 전화번호 입력: ");
		String tel = keyboard.getString();
		System.out.print("### 성별 입력 (남/여): ");
		String gender = keyboard.getString();
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setTel(tel);
		user.setGender(gender);
		
		userService.registerUser(user);
		
		System.out.println("[완료] 회원가입이 완료되었습니다.");
		
	}

	private void 내정보보기() {
		System.out.println(" << 내 정보 보기 >> ");
		
		System.out.println("### 아이디와 비밀번호를 입력하세요.");
		
		System.out.print("### 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("### 비밀번호 입력: ");
		String password = keyboard.getString();
		
		User user = userService.getUserInfo(id, password);
		System.out.println("### 사용자 상세 정보");
		System.out.println("아이디: " + user.getId());
		System.out.println("이름: " + user.getName());
		System.out.println("이메일: " + user.getEmail());
		System.out.println("전화번호: " + user.getTel());
		System.out.println("포인트: " + user.getPoint());
		System.out.println("가입일자: " + user.getCreatedDate());
		
		System.out.println("[완료] 사용자 상세 정보를 확인하세요");
		
	}
	
	private void 비밀번호변경() {
		System.out.println(" << 비밀번호 변경하기 >> ");
		
		System.out.println("### 아이디, 비밀번호, 새 비밀번호를 입력하세요.");
		System.out.print("### 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("### 비밀번호 입력: ");
		String oldPassword = keyboard.getString();
		System.out.print("### 새 비밀번호 입력: ");
		String password = keyboard.getString();
		
		userService.updateUserInfo(id, oldPassword, password);
		
		System.out.println("[완료] 비밀번호가 변경되었습니다.");
		
	}

	private void 탈퇴하기() {
		System.out.println(" << 회원 탈퇴 >> ");
		
		System.out.println("### 아이디, 비밀번호를 입력하세요.");
		
		System.out.print("### 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("### 비밀번호 입력: ");
		String password = keyboard.getString();
		
		userService.disabledUser(id, password);
		
		System.out.println("[완료] 회원탈퇴가 완료되었습니다.");
		
	}
	
	private void 전체조회() {
		System.out.println(" << 전체 상품 조회 >> ");
		
		System.out.println("### 전체 상품 목록을 확인하세요.");
		System.out.println("번호\t가격\t수량\t상품이름");
		
		List<Product> Products = productService.getAllProduct();
		for(Product p : Products) {
			System.out.print(p.getNo() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print(p.getStock() + "\t");
			System.out.println(p.getName());
		}
		
		System.out.println("[완료] 모든 상품정보 조회가 완료되었습니다.");
	}
	private void 상세정보보기() {
		System.out.println(" << 상품 상세 정보 조회 >> ");
		
		System.out.println("### 조회할 상품 번호를 입력하세요.");
		System.out.print("### 상품번호 입력: ");
		int no = keyboard.getInt();
		
		Product product = productService.getProductInfo(no);
		System.out.println("상품 상세 정보 조회");
		System.out.println("-----------------------------------------------");
		System.out.println("상품번호 " + product.getNo());
		System.out.println("상품명 " + product.getName());
		System.out.println("제조사 " + product.getMaker());
		System.out.println("가격 " + product.getPrice());
		System.out.println("할인율 " + product.getDiscountRate());
		System.out.println("상품재고 " + product.getStock());
		System.out.println("판매여부 " + product.getOnSell());
		System.out.println("등록일 " + product.getCreatedDate());
		System.out.println("최종수정일 " + product.getUpdatedDate());
		System.out.println("-----------------------------------------------");
		
		System.out.println("[완료] 해당 상품정보 조회가 완료되었습니다.");
	}
	
	private void 상품등록() {
		System.out.println(" << 신규 상품 등록 >> ");
		
		System.out.println("### 상품명, 제조사, 가격, 재고수량을 입력하세요.");
		System.out.print("### 상품명 입력: ");
		String name = keyboard.getString();
		System.out.print("### 제조사 입력: ");
		String maker = keyboard.getString();
		System.out.print("### 가격 입력: ");
		int price = keyboard.getInt();
		System.out.print("### 할인율 입력: ");
		double discountRate = keyboard.getDouble();
		System.out.print("### 재고수량 입력: ");
		int stock = keyboard.getInt();
		
		Product product = new Product();
		product.setName(name);
		product.setMaker(maker);
		product.setPrice(price);
		product.setDiscountRate(discountRate);
		product.setStock(stock);
		
		productService.intoProduct(product);
		
		System.out.println("[완료] 신규 상품 등록이 완료되었습니다.");
	}
	private void 상품입고() {
		System.out.println(" << 상품 입고 >> ");
		
		System.out.println("### 상품번호와 입고수량을 입력하세요.");
		
		System.out.print("### 상품 번호 입력: ");
		int no = keyboard.getInt();
		System.out.print("### 입고수량 입력: ");
		int stock = keyboard.getInt();
		
		productService.updateProduct(no, stock);
		
		System.out.println("[완료] 상품입고 처리가 완료되었습니다.");
		
	}
	private void 상품출고() {
		
		System.out.println(" << 상품 출고 >> ");
		
		System.out.println("### 상품번호와 출고수량을 입력하세요.");
		System.out.print("### 상품 번호 입력: ");
		int no = keyboard.getInt();
		System.out.print("### 출고수량 입력: ");
		int stock = keyboard.getInt();
		
		productService.forwardingProduct(no, stock);
		
		System.out.println("[완료] 상품출고 처리가 완료되었습니다.");
		
	}
	private void 상품정보수정() {
		System.out.println(" << 상품정보 수정 >> ");
		System.out.print("### 상품번호 입력: ");
		int no = keyboard.getInt();
		System.out.print("### 상품가격 입력: ");
		int price = keyboard.getInt();
		System.out.print("### 할인율 입력: ");
		double discountRate = keyboard.getDouble();
		
		productService.updateProductInfo(no, price, discountRate);
		
		System.out.println("[완료] 상품정보 수정이 완료되었습니다.");
		
	}
	
	private void 내장바구니조회() {
		System.out.println("<< 내 장바구니 조회 >>");
		
		System.out.println("### 아이디를 입력해서 장바구니를 확인하세요.");
		System.out.print("###아이디 입력: ");
		String userId = keyboard.getString();
		
		List<CartItemDto> cartItemDtoList = catCartItemService.getMyCartItems(userId);
		
		if(cartItemDtoList.isEmpty()) {
			System.out.println("[안내] 장바구니에 저장된 상품이 없습니다.");
			return;
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("상품번호\t상품가격\t수량\t상품이름");
		for(CartItemDto dto : cartItemDtoList) {
			System.out.print(dto.getNo() + "\t");
			System.out.print(dto.getPrice() + "\t");
			System.out.print(dto.getAmount() + "\t");
			System.out.println(dto.getName());
		}
		System.out.println("------------------------------------------------");
		
	}
	
	private void 장바구니담기() {
		System.out.println("<< 장바구니 담기 >>");
		
		System.out.println("### 아이디, 상품번호, 수량을 입력받아서 장바구니에 담아보세요.");
		System.out.print("### 아이디 입력: ");
		String userId = keyboard.getString();
		System.out.print("### 상품번호 입력: ");
		int productNo = keyboard.getInt();
		System.out.print("### 수량 입력: ");
		int amount = keyboard.getInt();
		
		CartItem cartItem = new CartItem();
		cartItem.setUserId(userId);
		cartItem.setProductNo(productNo);
		cartItem.setAmount(amount);
		
		catCartItemService.addCartItem(cartItem);
		
		System.out.println("[완료] 장바구니에 상품이 추가되었습니다.");
		
	}
	
	private void 장바구니비우기() {
		System.out.println("<< 장바구니 비우기 >>");
		
		System.out.println("### 아이디를 입력해서 장바구니를 비워보세요.");
		System.out.print("### 아이디 입력: ");
		String userId = keyboard.getString();
		
		catCartItemService.deleteCartItems(userId);
		
		System.out.println("[완료] 내 장바구니의 모든 상품을 삭제하였습니다.");
		
	}
}

