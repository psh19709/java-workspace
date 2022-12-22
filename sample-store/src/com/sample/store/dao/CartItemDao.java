package com.sample.store.dao;

import java.util.List;

import com.sample.store.dto.CartItemDto;
import com.sample.store.util.SqlMapper;
import com.sample.store.vo.CartItem;

public class CartItemDao {
	
	public void insertCartItem(CartItem cartItem) {
		SqlMapper.insert("insertCartItem", cartItem);
	}

	public void deleteCartItems(String userId) {
		SqlMapper.delete("deleteCartItems", userId);
	}
	
	@SuppressWarnings("unchecked")
	public List<CartItemDto> getCartItemsByUserId(String UserId){
		return (List<CartItemDto>)SqlMapper.selectList("getCartItemsByUserId", UserId);
	}
}
