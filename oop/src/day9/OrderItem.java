package day9;

public class OrderItem {
	

		String name;
		String company;
		int price;
		int number;
		int orderPrice;
		
		/**
		 * 구매상품정보를 전달받아서 객체의 멤버변수에 대입한다.
		 * @param name 상품명
		 * @param maker 제조사
		 * @param price 가격
		 * @param quantity 구매수량
		 */
		public void setOrderItem(String name, String company, int price, int number) {
			this.name = name;
			this.company = company;
			this.price = price;
			this.number = number;
			this.orderPrice = price*number;
		}
		
		/**
		 * 구매상품정보를 출력한다.
		 */
		public void printOrderItem() {
			System.out.println("상품명: " + name);
			System.out.println("제조사: " + company);
			System.out.println("가격: " + price);
			System.out.println("구매수량: " + number);
			System.out.println("구매가격: " + orderPrice);
			System.out.println();
		}

}
