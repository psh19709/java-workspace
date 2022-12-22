package app1.copy;

public class Product {

	private int no;			// 상품번호
	private String name;	// 상품명
	private String maker;	// 제조사
	private int price;		// 가격
	private int stock;		// 재고
	private SellItem sellItem;
	
	
	public Product() {}

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

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

	public SellItem getSellItem() {
		return sellItem;
	}

	public void setSellItem(SellItem sellItem) {
		this.sellItem = sellItem;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", maker=" + maker + ", price=" + price + ", stock=" + stock
				+ ", sellItem=" + sellItem + "]";
	}

}
