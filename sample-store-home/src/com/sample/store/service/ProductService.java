package com.sample.store.service;

import java.util.List;

import com.sample.store.dao.ProductDao;
import com.sample.store.vo.Product;

public class ProductService {

	private ProductDao productDao = new ProductDao();
	
	/**
	 * 신규 상품정보를 전달받아서 등록한다.
	 * @param product 상품정보
	 */
	public void saveProduct(Product product) {
		// 1. ProductDao에 신규 상품정보를 전달해서 등록시킨다.
		productDao.insertProduct(product);
	}
	
	/**
	 * 전체 상품 목록을 반환한다.
	 * @return 전체 상품 목록
	 */
	public List<Product> getAllProducts() {
		// 1. ProductDao에서 전체상품 목록을 조회한다.
		return productDao.getAllProducts();
	}
	
	/**
	 * 상품번호를 전달받아서 상품정보를 반환한다.
	 * @param no 상품번호
	 * @return 조회된 상품정보, 상품번호에 해당하는 상품이 존재하지 않으면 예외를 던진다.
	 */
	public Product getProductByNo(int no) {
		// 1. ProductDao에서 상품번호에 해당하는 상품정보를 조회한다. 상품정보가 존재하지 않으면 예외를 던진다.
		Product savedProduct = productDao.getProductByNo(no);
		if (savedProduct == null) {
			throw new RuntimeException("상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		// 2. 조회된 상품정보를 반환한다.
		return savedProduct;
	}
	
	/**
	 * 상품번호, 입고량을 전달받아서 재고를 변경한다.
	 * @param productNo 상품번호
	 * @param amount 입고수량
	 */
	public void increaseProductStock(int productNo, int amount) {
		// 1. 상품번호에 해당하는 상품정보를 조회한다. 상품정보가 존재하지 않으면 예외를 던진다.
		Product savedProduct = productDao.getProductByNo(productNo);
		if (savedProduct == null) {
			throw new RuntimeException("상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		// 2. 조회된 상품정보의 재고를 증가시킨다.
		savedProduct.setStock(savedProduct.getStock() + amount);
		// 3. 조회된 상품정보의 판매여부를 "Y"로 변경한다.
		savedProduct.setOnSell("Y");
		// 4. ProductDao에 변경된 상품정보를 전달해서 테이블에 반영시킨다.
		productDao.updateProduct(savedProduct);
	}
	
	/**
	 * 상품번호, 출고량을 전달받아서 재고를 변경한다.
	 * @param productNo 상품번호
	 * @param amount 출고수량
	 */
	public void decreaseProductStock(int productNo, int amount) {
		// 1. 상품번호에 해당하는 상품정보를 조회한다. 상품정보가 존재하지 않으면 예외를 던진다.
		Product savedProduct = productDao.getProductByNo(productNo);
		if (savedProduct == null) {
			throw new RuntimeException("상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		// 2. 상품 판매상태가 'N'이면 예외를 던진다.
		if ("N".equals(savedProduct.getOnSell())) {
			throw new RuntimeException("판매중지된 상품입니다.");
		}
		// 3. 재고가 부족하면 예외를 던진다.
		if (savedProduct.getStock() < amount) {
			throw new RuntimeException("출고량보다 재고량이 적습니다.");
		}
		// 4. 조회된 상품의 재고를 변경한다.
		savedProduct.setStock(savedProduct.getStock() - amount);
		// 5. 출고 후 재고가 0이 되면 판매중지 상태로 변경한다.
		if (savedProduct.getStock() == 0) {
			savedProduct.setOnSell("N");			
		}
		// 6. ProductDao에 변경된 상품정보를 전달해서 테이블에 반영시킨다.
		productDao.updateProduct(savedProduct);
	}
	
	/**
	 * 상품번호, 가격, 할인율을 전달받아서 가격과 할인율을 변경한다.
	 * @param productNo 상품번호
	 * @param price 변경할 가격
	 * @param discountRate 변경할 할인율
	 */
	public void updateProduct(int productNo, int price, double discountRate) {
		// 1. 상품번호에 해당하는 상품정보를 조회한다. 상품정보가 존재하지 않으면 예외를 던진다.
		Product savedProduct = productDao.getProductByNo(productNo);
		if (savedProduct == null) {
			throw new RuntimeException("상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		// 2. 조회된 상품정보의 가격과 할인율을 변경한다.
		savedProduct.setPrice(price);
		savedProduct.setDiscountRate(discountRate);
		
		// 3. ProductDao에 변경된 상품정보를 전달해서 테이블에 반영시킨다.
		productDao.updateProduct(savedProduct);
	}
}
