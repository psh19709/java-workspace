package com.book.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.book.management.dao.BookDao;
import com.book.management.vo.Book;

public class BookService {
	
	private BookDao bookDao = new BookDao();

	public List<Book> getAllBooks() {
		// 모든 책 정보를 조회한다.
		// BookDao -> public List<Book> getAllBooks() 실행
		return bookDao.getAllBooks();
	}
	
	public List<Book> searchBooks(String title){
		// 제목을 전달해서 책 정보를 조회한다.
		// BookDao -> public List<Book> getBookByTitle(String title) 실행
		return bookDao.getBooksByTitle(title);
		
	}
	public List<Book> searchBooks(int minPrice, int maxPrice){
		// 가격을 전달해서 책정보를 조회한다.
		// BookDao -> public List<Book> getBookByPrice(Map<String, Integer> map) 실행
		Map<String, Integer> map = new HashMap<>();
		map.put("min", minPrice);
		map.put("max", maxPrice);
		
		return bookDao.getBooksByPrice(map);
		
	}
	
	public void addNewBook(Book book) {
		// 새 책정보를 전달해서 저장시킨다.
		// BookDao -> public void insertBook(Book book) 실행
		
		bookDao.insertBook(book);
	}
	
	public void changeBookPrice(Book book) {
		// 데이터베이스에 저장된 책정보를 조회한다.
		// BookDao -> public void getBooksByNo(Book book) 실행
		Book savedBook = bookDao.getBooksByNo(book.getNo());
		
		// 조회된 책정보에 전달받은 가격, 할인가격정보를 저장한다. --> 조회된 책정보에서 가격과 할인가격을 변경하였음
		savedBook.setPrice(book.getPrice());
		savedBook.setDiscountPrice(book.getDiscountPrice());
		
		// 변경된 가격정보가 포함된 조회된 책정보를 DAO 객체의 메소드로 전달해서 테이블에 반영시킨다.
		// BookDao -> public void updateBook(Book book) 실행
		bookDao.updateBook(savedBook);
		
	}
	
	public void increaseBookStock(int no, int amount) {
		// 데이터 베이스에 저장된 책정보를 조회한다.
		// BookDao -> public void getBooksByNo(Book book) 실행
		Book savedBook = bookDao.getBooksByNo(no);
		if(savedBook == null) {
			throw new RuntimeException("[오류] 책 번호에 해당하는 책 정보가 존재하지 않습니다");
		}
		
		// 조회된 책정보 재고량을 amount만큼 증가시킨다.
		savedBook.setStock(savedBook.getStock() + amount);
		// 재고량이 변경된 조회된 책정보를 DAO 객체의 메소드로 전달해서 테이블에 반영시킨다.
		bookDao.updateBook(savedBook);
		
	}
	
	public void decreaseBookStock(int no, int amount) {
		// 데이터 베이스에 저장된 책정보를 조회한다.
		// BookDao -> public void getBooksByNo(Book book) 실행
		Book savedBook = bookDao.getBooksByNo(no);
		if(savedBook == null) {
			throw new RuntimeException("[오류] 책 번호에 해당하는 책 정보가 존재하지 않습니다");
		}
		if(savedBook.getStock() < amount) {
			throw new RuntimeException("[오류] 재고량이 부족합니다.");
		}
		
		// 조회된 책정보 재고량을 amount만큼 감소시킨다.
		savedBook.setStock(savedBook.getStock() - amount);
		// 재고량이 변경된 조회된 책정보를 DAO 객체의 메소드로 전달해서 테이블에 반영시킨다.
		bookDao.updateBook(savedBook);
	}
	
	public void romoveBookStock(int no) {
		// 책번호를 전달해서 책번호에 해당하는 책정보를 삭제한다.
		bookDao.deleteBook(no);
	}
	
}
