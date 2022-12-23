package com.sample.store.dto;

import java.util.Date;

public class CartItemDto {

	private int no;				// 상품번호
	private String name;		// 상품이름
	private int price;			// 상품가격
	private int amount;			// 장바구니에 저장한 수량
	private Date createdDate;	// 장바구니에 등록한 날짜와 시간
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
