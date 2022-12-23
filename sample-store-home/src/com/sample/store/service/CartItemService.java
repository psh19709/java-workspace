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
	
	private UserDao userDao = new UserDao();
	private ProductDao productDao = new ProductDao();
	private CartItemDao cartItemDao = new CartItemDao();

	/**
	 * 장바구니 아이템 정보(사용자아이디, 상품번호, 수량)를 전달받아서 장바구니에 추가시킨다.
	 * @param cartItem 장바구니 아이템 정보
	 */
	public void addCartItem(CartItem cartItem) {
		// 1. 사용자아이디로 사용자정보를 조회한다. 사용정보가 존재하지 않으면 예외를 던진다.
		User savedUser = userDao.getUserById(cartItem.getUserId());
		if (savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 2. 사용자의 enabled상태가 "N"이면 예외를 던진다.
		if ("N".equals(savedUser.getEnabled())) {
			throw new RuntimeException("탈퇴처리된 회원입니다.");
		}
		// 3. 상품번호로 상품정보를 조회한다. 상품정보가 존재하지 않으면 예외를 던진다.
		Product savedProduct = productDao.getProductByNo(cartItem.getProductNo());
		if (savedProduct == null) {
			throw new RuntimeException("상품번호에 해당하는 상품정보가 존재하지 않습니다.");
		}
		// 4. 상품판매상태가 "N"이면 예외를 던진다.
		if ("N".equals(savedProduct.getOnSell())) {
			throw new RuntimeException("상품번호에 해당하는 상품은 판매중지된 상품입니다.");
		}
		// 5. CartItemDao에 장바구니 아이템정보를 전달해서 저장시킨다.
		cartItemDao.insertCartItem(cartItem);
	}
	
	/**
	 * 전달받은 사용자 아이디와 비밀번호로 사용자정보를 확인하고, 해당 사용자의 장바구니 아이템정보를 삭제한다.
	 * @param userId 사용자 아이디
	 * @param password 사용자 비밀번호
	 */
	public void clearMyCartItems(String userId, String password) {
		// 1. 사용자아이디로 사용자정보를 조회한다. - 사용자 정보가 존재하지 않으면 예외를 던진다.
		User savedUser = userDao.getUserById(userId);
		if (savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		// 2. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (!savedUser.getPassword().equals(password)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		// 3. CartItemDao에 사용자아이디를 전달해서 해당 사용자의 장바구니 아이템정보를 삭제한다.
		cartItemDao.deleteCartItemsByUserId(userId);
	}
	
	/**
	 * 전달받은 사용자아이디로 장바구니 아이템정보(상품번호, 상품이름, 상품가격, 아이템수량, 등록일)을 조회한다.
	 * @param userId 사용자 아이디
	 * @return 장바구니 아이템 정보 목록
	 */
	public List<CartItemDto> getMyCartItemDtos(String userId) {
		// 1. 사용자아이디로 사용자정보를 조회한다. - 사용자 정보가 존재하지 않으면 예외를 던진다.
		User savedUser = userDao.getUserById(userId);
		if (savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		// 2. 사용자의 enabled상태가 "N"이면 예외를 던진다.
		if ("N".equals(savedUser.getEnabled())) {
			throw new RuntimeException("탈퇴처리된 회원입니다.");
		}
		// 3. CartItemDao에 사용자 아이디를 전달해서 장바구니 아이템 정보를 조회해서 반환한다.
		List<CartItemDto> cartItemDtos = cartItemDao.getCartItemDtosByUserId(userId);
		
		return cartItemDtos;
	}
}
