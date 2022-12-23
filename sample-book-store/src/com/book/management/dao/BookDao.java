package com.book.management.dao;

import java.util.List;
import java.util.Map;

import com.book.management.util.SqlMapper;
import com.book.management.vo.Book;

public class BookDao {
	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks(){
		return (List<Book>)SqlMapper.selectList("getAllBooks");
		
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByTitle(String title) {
		return (List<Book>)SqlMapper.selectList("getBooksByTitle", title);
	}
	@SuppressWarnings("unchecked")
	public List<Book> getBooksByPrice(Map<String, Integer> condition) {
		return (List<Book>)SqlMapper.selectList("getBooksByPrice", condition);
	}

	public void insertBook(Book book) {
		SqlMapper.insert("insertBook", book);
	}
	
	public Book getBooksByNo(int no) {
		return (Book) SqlMapper.selectOne("getBookByNo", no);
	}
	
	public void updateBook(Book book) {
		SqlMapper.update("updateBook", book);
	}


	public void deleteBook(int no) {
		SqlMapper.delete("deleteBook", no);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
