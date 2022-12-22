package selfMy;

public class OrderItem {
	
	String name;
	String com;
	int pri;
	int num;
	int total;
	
	public void setScore(String itemName, String company, int price, int number) {
		name = itemName;
		com = company;
		pri = price;
		num = number;
	
	}
	
	public void processScore() {
		total = pri*num;
	}
	
	public void printScore() {
		System.out.println("구매정보를 출력합니다.");
		System.out.println("상품이름: " + name);
		System.out.println("회사이름: " + com);
		System.out.println("가격: " + pri);
		System.out.println("구매수량: " + num);
		System.out.println("총 가격: " + total);
		System.out.println();
	}
	
	

}
