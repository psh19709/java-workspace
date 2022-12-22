package day9;

import utils.KeyboardReader;

public class OrderItemApp1 {
		
	public static void main(String[] args) {
			
		KeyboardReader keyboard = new KeyboardReader();
		OrderItem[] orderItems = new OrderItem[3];
			
			OrderItem orderItem = new OrderItem();
			
			   for (int index = 0; index < orderItems.length; index++) {
				   System.out.print("상품명 입력: ");
				   String itemName = keyboard.getString();
				   System.out.print("제조사 입력: ");
				   String company = keyboard.getString();
				   System.out.print("가격 입력: ");
				   int price = keyboard.getInt();
				   System.out.print("구매수량 입력: ");
				   int number = keyboard.getInt();
				   
				   orderItem.setOrderItem(itemName, company, price, number);
				   orderItems[index] = orderItem;
	}
			   int totalOrderPrice = 0;
			   for(OrderItem item : orderItems) {
				   item.printOrderItem();
				   totalOrderPrice += item.orderPrice;
			   }
			   
			   System.out.println("총 구매 가격:" + totalOrderPrice);

		}
		

}
