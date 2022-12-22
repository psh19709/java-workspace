package com.sample.store.dao;

import java.util.List;
import java.util.Map;

import com.sample.store.util.SqlMapper;
import com.sample.store.vo.Product;

public class ProductDao {
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){
		return (List<Product>) SqlMapper.selectList("getAllProducts");
	}
	
	public Product getProductByNo(int productNo) {
		return (Product) SqlMapper.selectOne("getProductByNo", productNo);
	}

	public void insertProduct(Product product) {
		SqlMapper.insert("insertProduct", product);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByName(String name){
		return (List<Product>)SqlMapper.selectList("getProductsByName", name);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByPrice(Map<String, Object> param) {
		return (List<Product>)SqlMapper.selectList("getProductsByPrice", param);
	}
	
	public void updateProduct(Product product) {
		SqlMapper.update("updateProduct", product);
	}
	
}
