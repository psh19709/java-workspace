package day10;

public class Product {
	
	int no;
	String name;
	String maker;
	String desctiption;
	int price;
	int discountPrice;
	
	public Product() {}
	
	

	public Product(int no, String name, String maker, int price) {
		this.no = no;
		this.name = name;
		this.maker = maker;
		this.desctiption = "없음";
		this.price = price;
		this.discountPrice = (int) (this.price*0.85);
	}



	public Product(int no, String name, String maker, String desctiption, int price, int discountPrice) {
		this.no = no;
		this.name = name;
		this.maker = maker;
		this.desctiption = desctiption;
		this.price = price;
		this.discountPrice = discountPrice;
	}

}
