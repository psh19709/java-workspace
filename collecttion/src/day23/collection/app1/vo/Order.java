package day23.collection.app1.vo;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private static final double DEPOSIT_POINT_RATE = 0.02;

	private int no;											// 주문번호
	private Date date;										// 주문날짜
	private String customerId;								// 주문고객 아이디
	private String customerName;							// 주문고객 이름
	private List<Item> items = new ArrayList<>();			// 주문아이템 목록
	

	public Order() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public int getTotalQuantity() {
		int totalQuantity = 0;
		
		for(Item item : items) {
			totalQuantity += item.getQuantity();
		}
		
		return totalQuantity;
	}

	public int getTotalOrderPrice() {
		int totalOrderPrice = 0;
		
		for(Item item : items) {
			int price = item.getPrice();
			int quantity = item.getQuantity();
			int orderPrice = price*quantity;
					
			totalOrderPrice += orderPrice;
		}
		
		return totalOrderPrice;
	}
	

	public int getDepositPoint() {
		int depositPoint = 0;
		
		int totalOrderPrice = getTotalOrderPrice();
		depositPoint = (int) (totalOrderPrice*DEPOSIT_POINT_RATE);
		
		return depositPoint;
	}

	
}
