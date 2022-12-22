package selfMy;

import utils.KeyboardReader;

public class OrderItemApp1 {
	
	public static void main(String[] args) {
		 KeyboardReader keyboard = new KeyboardReader();
		
		OrderItem[] scores = new OrderItem[3];
		
		OrderItem orderItem = new OrderItem();
		   for (int index = 0; index < scores.length; index++) {
		   
		   System.out.print("상품명을 입력하세요 : ");
		   String itemName = keyboard.getString();
		   System.out.print("제조사을 입력하세요 : ");
		   String company = keyboard.getString();
		   System.out.print("가격를 입력하세요 : ");
		   int price = keyboard.getInt();
		   System.out.print("구매수량를 입력하세요 : ");
		   int number = keyboard.getInt();
		   
		   orderItem.setScore(itemName, company, price, number);
		   scores[index] = orderItem;
		   
		   System.out.println("배열의 ["+index+"]번째에 구매정보가 저장되었습니다.");
		   System.out.println();
		   }
		   
		   System.out.println("---------------------------------");
		   
		   
		   for (OrderItem orederItem : scores) {
			   orederItem.processScore();
			   orderItem.printScore();
		   }
		   
		   
	}
	
}


	


