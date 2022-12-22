package com.sample.store.service;

import java.util.List;

import com.sample.store.dao.ProductDao;
import com.sample.store.vo.Product;

public class ProductService {

	private ProductDao productDao = new ProductDao();
	
	// 전체조회 -> 모든 상품정보를 반환하는 기능
	public List<Product> getAllProduct() {
		return productDao.getAllProducts();
	}
	
	// 상품상세정보 보기 -> 상품번호를 전달받아서 해당 상품정보를 반환하는 기능
	public Product getProductInfo(int no) {
		
		Product savedProduct = productDao.getProductByNo(no);
		if(savedProduct == null) {
			throw new RuntimeException("["+no+"]상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		
		return savedProduct;
	}
	
	
	// 상품등록 -> 상품정보(상품명, 제조사, 가격, 할인율, 수량)을 전달받아서 등록하는 기능
	public void intoProduct(Product product) {
		productDao.insertProduct(product);
		
	}
	
	
	// 상품입고 -> 상품번호, 입고수량을 전달받아서 상품의 재고량을 증가시키는 기능
	public void updateProduct(int no, int stock) {
		Product savedProduct = productDao.getProductByNo(no);
		if(savedProduct == null) {
			throw new RuntimeException("["+no+"]상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		
		savedProduct.setStock(savedProduct.getStock() + stock);
		savedProduct.setOnSell("Y");
		
		productDao.updateProduct(savedProduct);

	}
	
	
	// 상품출고 -> 상품번호, 출고수량을 전달받아서 상품의 재고량을 감소시키는 기능
	public void forwardingProduct(int no, int stock) {
		Product savedProduct = productDao.getProductByNo(no);
		if(savedProduct == null) {
			throw new RuntimeException("["+no+"]상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		if("N".equals(savedProduct.getOnSell())){
			throw new RuntimeException("["+savedProduct.getName()+"] 재고가 없습니다.");
		}
		if(savedProduct.getStock() < stock) {
			throw new RuntimeException("["+stock+"] 출고량보다 재고량이 부족합니다.");
		}
		
		savedProduct.setStock(savedProduct.getStock() - stock);
		
		if(savedProduct.getStock() == 0) {
			savedProduct.setOnSell("N");
		}
		productDao.updateProduct(savedProduct);
	}
	
	
	// 상품정보 변경 -> 상품번호, 가격, 할인율을 전달받아서 해당 정보를 변경하는 기능
	public void updateProductInfo(int no, int price, double discountRate) {
		Product savedProduct = productDao.getProductByNo(no);
		if(savedProduct == null) {
			throw new RuntimeException("["+no+"]상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		savedProduct.setPrice(price);
		savedProduct.setDiscountRate(discountRate);
		
		productDao.updateProduct(savedProduct);
	}
}
