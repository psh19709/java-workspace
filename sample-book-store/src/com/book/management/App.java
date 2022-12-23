package com.book.management;

import com.book.management.controller.BookController;

public class App {
	
	public static void main(String[] args) {
		BookController controller = new BookController();
		controller.run();
	}

}
