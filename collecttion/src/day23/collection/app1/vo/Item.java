package day23.collection.app1.vo;

public class Item {

	private int no;			// 구입한 상품번호
	private String name;	// 구입한 상품이름
	private int price;		// 구입한 상품가격(할인가격 기준)
	private int quantity;	// 구입한 수량
	
	
	public Item() {
		
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
