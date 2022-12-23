package com.book.management.controller;

import java.util.List;

import com.book.management.service.BookService;
import com.book.management.util.KeyboardReader;
import com.book.management.vo.Book;

public class BookController {

	private BookService bookService = new BookService();
	private KeyboardReader keyboard = new KeyboardReader();
	
	public void run() {
		메뉴();
	}
	
	private void 메뉴() {
		while(true) {
			try {
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("1.전체조회 2.제목검색 3.가격검색 4.책등록 5.수정 6.입고 7.출고 8.삭제 0.종료");
				System.out.println("--------------------------------------------------------------------------");
				
				System.out.print("### 메뉴선택 : ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				switch(menuNo) {
				case 1: 전체조회(); break;
				case 2: 제목검색(); break;
				case 3: 가격검색(); break;
				case 4: 책등록(); break;
				case 5: 수정(); break;
				case 6: 입고(); break;
				case 7: 출고(); break;
				case 8: 삭제(); break;
				case 0: 종료(); break;
				}
			} catch(Exception e){
				System.out.println("[오류] " + e.getMessage());
			}
			System.out.println();
			System.out.println();
		}
	}
	
	private void 전체조회() {
		System.out.println("<< 전체 조회 >>");
		
		// 모든 책 정보를 조회해서 화면에 출력 : 기대값 - List<Book>, 인자 : 없다.
		// BookService -> public List<Book> getAllBooks() 실행
		List<Book> books = bookService.getAllBooks();
		
		// 조회된 책 목록 출력
		this.printBooks(books);
	}
	
	// 제목 입력
	private void 제목검색() {
		System.out.println("<< 제목 검색 >>");
	
		// 제목을 입력받아서 제목에 해당하는 책정보를 조회해서 화면에 출력 : 기대값 - List<Book>, 인자 : 제목
		// BookService -> public List<Book> searchBooks(String title) 실행
		System.out.print("## 제목 입력: ");
		String title = keyboard.getString();
		
		List<Book> books = bookService.searchBooks(title);
		
		// 조회된 책 목록 출력
		this.printBooks(books);
		
	}
	
	// 최소가격, 최대가격 입력
	private void 가격검색() {
		System.out.println("<< 가격 검색 >>");
		
		// 최소가격, 최대가격을 입력받아서 가격범위에 해당하는 책 정보를 조회해서 화면에 출력 기대값 - List<Book> 인자 : 최소가격, 최대가격
		// BookService -> public List<Book> searchBooks(int minPrice, int maxPrice) 실행
		System.out.print("## 최소가격 입력: ");
		int minPrice = keyboard.getInt();
		System.out.print("## 최소가격 입력: ");
		int maxPrice = keyboard.getInt();
		System.out.println();
		
		List<Book> books = bookService.searchBooks(minPrice, maxPrice);
		// 조회된 책 목록 출력
		this.printBooks(books);
		
	}
	
	// 제목, 저자, 출판사, 가격, 할인가격, 수량 입력
	private void 책등록() {
		System.out.println("<< 책 등록 >>");
		
		// 제목, 저자, 출판사, 가격, 할인가격, 수량을 입력받아서 새 책정보를 전달해서 저장시키기 : 기대값 - 없음, 인자 : 책정보
		// BookService -> public void addNewBook(Book book) 실행
		System.out.print("## 제목 입력 : ");
		String title = keyboard.getString();
		System.out.print("## 저자 입력 : ");
		String author = keyboard.getString();
		System.out.print("## 출판사 입력 : ");
		String publisher = keyboard.getString();
		System.out.print("## 가격 입력 : ");
		int price = keyboard.getInt();
		System.out.print("## 할인가격 입력 : ");
		int discountPrice = keyboard.getInt();
		System.out.print("## 수량 입력 : ");
		int amount = keyboard.getInt();
		System.out.println();
		
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setDiscountPrice(discountPrice);
		book.setStock(amount);
		
		bookService.addNewBook(book);
		
		System.out.println("[완료] 책 등록이 완료되었습니다.");
		
	}
	
	// 책번호, 가격, 할인가격 입력
	private void 수정() {
		System.out.println("<< 책 정보 수정 >>");
		//  책번호, 가격, 할인가격을 입력받아서 해당 책번호에 해당하는 책정보(가격, 할인가격) 수정시키기 : 개대값 - 없음, 인자 : 책정보
		// BookService -> public void changeBookPrice(Book book)
		
		System.out.print("## 책번호 입력 : ");
		int no = keyboard.getInt();
		System.out.print("## 가격 입력 : ");
		int price = keyboard.getInt();
		System.out.print("## 할인가격 입력 : ");
		int discountPrice = keyboard.getInt();
		System.out.println();
		
		Book book = new Book();
		book.setNo(no);
		book.setPrice(price);
		book.setDiscountPrice(discountPrice);
		
		bookService.changeBookPrice(book);
		
	}
	
	// 책번호, 수량 입력
	private void 입고() {
		System.out.println("<< 책 입고 >>");
		
		// 책 번호, 입고수량을 입력받아서 책 번호에 해당하는 책정보의 재고량을 증가시킨다. : 기대값 - 없음, 인자 - 책번호, 수량
		// BookServise -> public void increaseBookStock(int no, int amount)
		System.out.print("## 책번호 입력 : ");
		int no = keyboard.getInt();
		System.out.print("## 입고수량 입력 : ");
		int amount = keyboard.getInt();
		System.out.println();
		
		bookService.increaseBookStock(no, amount);
		System.out.println("[완료] 책 입고가 완료되었습니다.");
	}
	
	// 책번호, 수량 입력
	private void 출고() {
		System.out.println("<< 책 출고 >>");
		
		// 책 번호, 출고수량을 입력받아서 책 번호에 해당하는 책정보의 재고량을 감소시킨다. : 기대값 - 없음, 인자 - 책번호, 수량
		// BookServise -> public void decreaseBookStock(int no, int amount)
		System.out.print("## 책번호 입력 : ");
		int no = keyboard.getInt();
		System.out.print("## 출고수량 입력 : ");
		int amount = keyboard.getInt();
		System.out.println();
		
		bookService.decreaseBookStock(no, amount);
		
		System.out.println("[완료] 책 출고가 완료되었습니다.");
	}
	
	// 책번호 입력
	private void 삭제() {
		System.out.println("<< 책 정보 삭제 >>");
		
		// 책번호를 입력받아서 책 번호에 해당하는 책 정보를 삭제한다. : 기대값 - 없음, 인자 - 책번호
		// BookServise -> public void romoveBookStock(int no)
		System.out.print("## 책번호 입력 : ");
		int no = keyboard.getInt();
		System.out.println();
		
		bookService.romoveBookStock(no);
		
		System.out.println("[완료] 책 정보가 삭제되었습니다.");
	}
	
	private void 종료() {
		System.out.println("<< 종료 >>");
		System.exit(0);
	}
	
	private void printBooks(List<Book> books) {
		if(books.isEmpty()) {
		System.out.println("[안내] 책 정보가 존재하지 않습니다.");
		return;
		}
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("번호\t가격\t할인가격\t수량\t제목");
		for(Book book : books) {
			System.out.print(book.getNo() + "\t");
			System.out.print(book.getPrice() + "\t");
			System.out.print(book.getDiscountPrice() + "\t");
			System.out.print(book.getStock() + "\t");
			System.out.println(book.getTitle());
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
}
