package day23.collection.app1.service;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import day23.collection.app1.vo.Customer;
import day23.collection.app1.vo.Item;
import day23.collection.app1.vo.Order;
import day23.collection.app1.vo.Product;

public class StoreService {
	
	private static AtomicInteger atom = new AtomicInteger(1001);
	/**
	 * 상품정보 객체를 저장하는 ArrayList 객체다
	 */
	private List<Product> productList = new ArrayList<>();
	/**
	 * 고객정보 객체를 저장하는 ArrayList 객체다.
	 */
	private List<Customer> customerList = new ArrayList<>();
	/**
	 * 주문정보 객체를 저장하는 ArrayList 객체다.
	 */
	private List<Order> orderList = new ArrayList<>();
	
	
	public StoreService() {		
		
		customerList.add(new Customer("kim", "김유신", "kim@naver.com"));
		customerList.add(new Customer("lee", "이재원", "lee@naver.com"));
		customerList.add(new Customer("ahn", "안중근", "ahn-jg@naver.com"));
		customerList.add(new Customer("kiyou", "류관순", "akwansnoon@naver.com"));
		
		productList.add(new Product(atom.getAndIncrement(), "삼각김밥", 3000, 2700, 100));
		productList.add(new Product(atom.getAndIncrement(), "하얀우유", 1200, 1100, 10));
		productList.add(new Product(atom.getAndIncrement(), "도시락", 5000, 4700, 20));
		productList.add(new Product(atom.getAndIncrement(), "샐러드", 4000, 3700, 20));
		productList.add(new Product(atom.getAndIncrement(), "딸기우유", 1200, 1000, 10));
		productList.add(new Product(atom.getAndIncrement(), "하리보", 1500, 1350, 5));
		productList.add(new Product(atom.getAndIncrement(), "오레오", 1200, 1050, 5));
		productList.add(new Product(atom.getAndIncrement(), "컵라면", 2000, 1900, 50));
		productList.add(new Product(atom.getAndIncrement(), "캔커피", 2500, 2250, 20));
		productList.add(new Product(atom.getAndIncrement(), "캔음료", 2000, 1800, 20));
	}
	
	// 신규 고객 등록하기
	/*
	 * 반환타입 : boolean
	 * 메소드명 : addCustomer
	 * 매개변수 : 고객정보
	 */
	
	public boolean addCustomer(Customer customer) {
		Customer saveCustomer = getCustomerById(customer.getId());
			if(saveCustomer != null) {
				return false;
			}
			
		customerList.add(customer);
		
		return true;
	}
	
	//고객 상세 정보 등록하기
	/*
	 * 반환타입 : Customer
	 * 메소드명 : getCustomerById
	 * 매개변수 : String 고객 아이디
	 */
	
	public Customer getCustomerById(String customerId) {
		for(Customer customer : customerList) {
			if(customer.getId().equals(customerId)) {
				return customer;
			}
		}
		return null;
	}

	// 상품전체목록 제공하기
	/*
	 *  반환타입 : List<Product>
	 *  메소드명 : getAllProducts
	 *  매개변수 : 없음
	 */
	public List<Product>getAllProducts(){
		return productList;
	}
	
	
	// 상품 입고하기(새 상품추가 없이 기존 상품의 재고량을 증가시킴)	
	/*
	 *  반환타입 : boolean
	 *  메소드명 : updateProductStock
	 *  매개변수 : int 상품번호, int 입고수량
	 */
	
	public boolean updateProductStock(int productNo, int amount) {
		Product product = getProductDetail(productNo);
		if(product == null) {
			return false;
		}
		int stock = product.getStock() + amount;
		product.setStock(stock);
		
		return false;
	}
	
	// 상품상세 정보 제공하기
	/*
	 *  반환타입 : Product
	 *  메소드명 : getProductDetail
	 *  매개변수 : int 상품번호
	 */
	
	public Product getProductDetail(int productNo) {
		for(Product product : productList) {
			if(product.getNo() == productNo) {
				return product;
			}
		}
		return null;
	}
	
	
	// 상품주문하기
	/*
	 *  반환타입 : boolean
	 *  메소드명 : order
	 *  매개변수 : String 고객아이디, List<Integer> 상품번호, List<Integer> 수량
	 */
	
	public boolean order(String customerId, List<Integer> productNos, List<Integer> quantities) {
		Customer saveCustomer = getCustomerById(customerId);
		if(saveCustomer == null) {
			return false;
		}
		
		Order order = new Order();
	    order.setNo(atom.getAndIncrement());
	    order.setDate(new Date());
	    order.setCustomerId(customerId);
	    order.setCustomerName(saveCustomer.getName());

		
		int size = productNos.size();
		for(int index = 0; index < size; index++) {
			int productNo = productNos.get(index);
			int quantity = quantities.get(index);
			
			Product saveProduct = getProductDetail(productNo);
			if(saveProduct == null) {
				continue;
			}
			if(saveProduct.getStock() < quantity) {
				continue;
			}
			
			Item item = new Item();
			item.setNo(saveProduct.getNo());
			item.setName(saveProduct.getName());
			item.setPrice(saveProduct.getDiscountPrice());
			item.setQuantity(quantity);
			
			order.addItem(item);
			
			int stock = saveProduct.getStock() - quantity;
			saveProduct.setStock(stock);
			
		}
		
		int point = saveCustomer.getPoint() + order.getDepositPoint();
		saveCustomer.setPoint(point);
		
		orderList.add(order);
		
		
		return true;
	}
	
	// 전체 주문내역 제공하기
	/*
	 *  반환타입 : List<Order>
	 *  메소드명 : getAllOrders
	 *  매개변수 : 없음
	 */
	
	public List<Order> getAllOrders(){
		
		return orderList;
	}
	
	// 고객별 주문내역 제공하기
	/*
	 *  반환타입 : List<Order>
	 *  메소드명 : getOrderByCustomerId
	 *  매개변수 : String 고객아이디
	 */
	
	public List<Order> getOrderByCustomerId(String customerId){
		List<Order> customerOrderList = new ArrayList<>();
		
		for(Order order : orderList) {
			if(order.getCustomerId().equals(customerId)) {
				customerOrderList.add(order);
			}
		}
		
		return customerOrderList;
	}
	
	// 주문별 상세정보 제공하기
	/*
	 *  반환타입 : Order
	 *  메소드명 : getOrderDetail
	 *  매개변수 : int 주문번호
	 */
	
	public Order getOrderDetail(int orderNo) {
		Order foundOrder = null;
		
		for(Order order : orderList) {
			if(order.getNo() == orderNo) {
				foundOrder = order;
				break;
			}
		}
		
		return foundOrder;
	}
	
}
