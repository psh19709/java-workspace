package com.sample.store.dao;

import java.util.List;

import com.sample.store.dto.CartItemDto;
import com.sample.store.util.SqlMapper;
import com.sample.store.vo.CartItem;

public class CartItemDao {

	/**
	 * 신규 장바구니 아이템정보를 전달받아서 테이블에 저장한다.
	 * @param cartItem 장바구니 아이템정보
	 */
	public void insertCartItem(CartItem cartItem) {
		SqlMapper.insert("insertCartItem", cartItem);
	}
	
	/**
	 * 전달받은 사용자 아이디로 저장된 모든 장바구니 아이템정보를 테이블에서 삭제한다.
	 * @param userId 사용자 아이디
	 */
	public void deleteCartItemsByUserId(String userId) {
		SqlMapper.delete("deleteCartItemsByUserId", userId);
	}
	
	/**
	 * 전달받은 사용자아이디로 저장된 모든 장바구니 아이템정보를 조회해서 반환한다.
	 * @param userId 사용자 아이디
	 * @return 장바구니 아이템 정보(상품테이블과 조인해서 상품정보와 장바구니 아이템정보가 모두 포함되어 있은 객체)
	 */
	@SuppressWarnings("unchecked")
	public List<CartItemDto> getCartItemDtosByUserId(String userId) {
		return (List<CartItemDto>) SqlMapper.selectList("getCartItemDtosByUserId", userId);
	}
}
