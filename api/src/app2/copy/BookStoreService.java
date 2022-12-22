package app2.copy;

public class BookStoreService {

	private Book[] books = new Book[10];
	private Order[] orders = new Order[5];
	
	private int position = 0;
	private int limit = 5;
	private final int size = 5;
	private int orderNo = 10000;	// 주문번호, 주문할 때마다 1씩 증가시킨다.
	
	public BookStoreService() {
		books[0] = new Book(101, "이것이 자바다", 30000, 27000, 10);
		books[1] = new Book(102, "이것이 자바다", 30000, 27000, 10);
		books[2] = new Book(103, "이것이 자바다", 30000, 27000, 10);
		books[3] = new Book(104, "이것이 자바다", 30000, 27000, 10);
		books[4] = new Book(105, "이것이 자바다", 30000, 27000, 10);
		books[5] = new Book(106, "이것이 자바다", 30000, 27000, 10);
		books[6] = new Book(107, "이것이 자바다", 30000, 27000, 10);
		books[7] = new Book(108, "이것이 자바다", 30000, 27000, 10);
		books[8] = new Book(109, "이것이 자바다", 30000, 27000, 10);
		books[9] = new Book(110, "이것이 자바다", 30000, 27000, 10);
	}
	
	// 전체상품정보 반환하기
	
	// 주문하기
	// "도서번호:구매수량,도서번호:구매수량,도서번호:구매수량"를 전달받는다.
	// Order객체를 생성해서 주문번호와 날짜를 저장한다.
	// 주문번호를 1증가시킨다.
	
	// ,를 기준으로 잘라서 배열을 획득한다.
	// {"도서번호:구매수량", "도서번호:구매수량", "도서번호:구매수량"} 배열을 반복처리한다.
	//		"도서번호:구매수량"을 :를 기준으로 잘라서 도서번호와 구매수량을 획득
	//		도서번호에 해당하는 도서정보 찾기
	//		도서번호에 해당하는 상품의 재고수량이 구매수량보다 작으면 continue; 실행
	//		OrderItem객체를 생성해서 책번호, 제목, 가격, 할인가격, 구매수량을 저장한다.
	// 		OrderItem객체를 위에서 생성한 Order객체의 orderItems배열에 저장한다. 필요한 경우 길이를 조절한다.
	//		도서번호에 해당하는 상품의 재고수량을 구매수량만큼 감소시킨다
	// Order객체를 orders 배열에 저장한다.
	
	// 전체주문정보를 반환하기
	
	// 주문상품정보 반환하기
	// 주문번호를 전달받아서 orders배열에서 주문번호에 해당하는 Order객체 반환하기
}
