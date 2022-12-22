package app1.copy;

public class SellItem {

	private int no;			// 판매한 상품번호
	private String name;	// 판매한 상품명
	private int price;		// 판매한 상품가격
	private int quantity;	// 판매한 상품수량
	
	public SellItem() {}
	
	public SellItem(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
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
	
	public int getSellPrice() {
		return price*quantity;
	}
}
