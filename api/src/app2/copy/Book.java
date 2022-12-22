package app2.copy;

public class Book {

	private int no;
	private String title;
	private int price;
	private int discount;
	private int stock;
	
	public Book(int no, String title, int price, int discount, int stock) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.stock = stock;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", price=" + price + ", discount=" + discount + ", stock="
				+ stock + "]";
	}
	
	
}
