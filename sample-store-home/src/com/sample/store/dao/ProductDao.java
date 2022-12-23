package com.sample.store.dao;

import java.util.List;

import com.sample.store.util.SqlMapper;
import com.sample.store.vo.Product;

public class ProductDao {

	/**
	 * 신규 상품정보를 전달받아서 테이블에 저장한다.
	 * @param product 신규 상품정보
	 */
	public void insertProduct(Product product) {
		SqlMapper.insert("insertProduct", product);
	}
	
	/**
	 * 전체 상품목록을 조회해서 반환한다.
	 * @return 전체 상품목록
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return (List<Product>) SqlMapper.selectList("getAllProducts");
	}
	
	/**
	 * 상품번호를 전달받아서 상품정보를 조회해서 반환한다.
	 * @param no 상품번호
	 * @return 조회된 상품정보
	 */
	public Product getProductByNo(int no) {
		return (Product) SqlMapper.selectOne("getProductByNo", no);
	}
	
	/**
	 * 변경된 상품정보가 포함된 상품정보를 전달받아서 테이블에 반영한다.
	 * @param product 변경된 상품정보가 포함된 상품정보
	 */
	public void updateProduct(Product product) {
		SqlMapper.update("updateProduct", product);
	}
} 
