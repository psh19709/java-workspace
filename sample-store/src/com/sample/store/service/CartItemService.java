package com.sample.store.service;

import java.util.List;

import com.sample.store.dao.CartItemDao;
import com.sample.store.dao.ProductDao;
import com.sample.store.dao.UserDao;
import com.sample.store.dto.CartItemDto;
import com.sample.store.vo.CartItem;
import com.sample.store.vo.Product;
import com.sample.store.vo.User;

public class CartItemService {
	
	private CartItemDao cartItemDao = new CartItemDao();
	private ProductDao productDao = new ProductDao();
	private UserDao userDao = new UserDao();
	
	public void addCartItem(CartItem cartItem) {
		User user = userDao.getUserById(cartItem.getUserId());
		if(user == null) {
			throw new RuntimeException("[오류] 사용자 정보가 존재하지 않습니다.");
		}
		Product product = productDao.getProductByNo(cartItem.getProductNo());
		if(product == null) {
			throw new RuntimeException("[오류] 상품정보가 존재하지 않습니다.");
		}
		if("N".equals(product.getOnSell())) {
			throw new RuntimeException("판매중인 상품이 아닙니다.");
		}
		
		cartItemDao.insertCartItem(cartItem);
	}
	
	public void deleteCartItems(String userId) {
		User user = userDao.getUserById(userId);
		if(user == null) {
			throw new RuntimeException("[오류] 사용자 정보가 존재하지 않습니다.");
		}
		
		cartItemDao.deleteCartItems(userId);
	}
	
	public List<CartItemDto> getMyCartItems(String userId){
		User user = userDao.getUserById(userId);
		if(user == null) {
			throw new RuntimeException("[오류] 사용자 정보가 존재하지 않습니다.");
		}
		
		return cartItemDao.getCartItemsByUserId(userId);
	}

}
