package com.sample.store.service;

import com.sample.store.dao.UserDao;
import com.sample.store.vo.User;

public class UserService {

	private UserDao userDao = new UserDao();
	
	/**
	 * UserController로부터 신규 사용자정보가 포함된 User객체를 전달받아서 회원가입 시킨다.
	 * @param user 신규 사용자정보가 포함된 User객체
	 */
	public void registerUser(User user) {
		// 1. 아이디로 사용자 정보를 조회해서 사용자 정보가 존재하면 예외를 던진다.
		User savedUser = userDao.getUserById(user.getId());
		if (savedUser != null) {
			throw new RuntimeException("이미 사용중인 아이디입니다.");
		}
		// 2. 이메일로 사용자 정보를 조회해서 사용자 정보가 존재하면 예외를 던진다.
		savedUser = userDao.getUserByEmail(user.getEmail());
		if (savedUser != null) {
			throw new RuntimeException("이미 사용중인 이메일입니다.");
		}
		// 3. 신규 사용자 정보를 등록시킨다.
		userDao.insertUser(user);
	}
	
	/**
	 * 사용자 아이디와 비밀번호를 전달받아서 사용자 정보를 반환한다.
	 * @param id 사용자 아이디
	 * @param password 사용자 비밀번호
	 * @return 조회된 사용자 정보, 사용자정보가 존재하지 않거나 비밀번호가 틀리면 예외를 던진다.
	 */
	public User getUserById(String id, String password) {
		// 1. 아이디로 사용자 정보를 조회해서 사용자 정보가 존재하지 않으면 예외를 던진다.
		User savedUser = userDao.getUserById(id);
		if (savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 2. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (!savedUser.getPassword().equals(password)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 3. 조회된 사용자 정보를 반환한다.
		return savedUser;
	}
	
	/**
	 * 아이디, 비밀번호, 새 비밀번호를 전달받아서 비밀번호를 변경한다.
	 * @param id 아이디
	 * @param oldPassword 비밀번호
	 * @param password 새 비밀번호
	 */
	public void changePassword(String id, String oldPassword, String password) {
		// 1. 아이디로 사용자정보를 조회해서 사용자정보가 존재하지 않으면 예외를 던진다.
		User savedUser = userDao.getUserById(id);
		if (savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 2. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (!savedUser.getPassword().equals(oldPassword)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 3. 조회된 사용자정보의 비밀번호를 새 비밀번호로 변경한다.
		savedUser.setPassword(password);
		// 4. 변경된 사용자정보를 UserDao에 전달해서 테이블에 반영시킨다.
		userDao.updateUser(savedUser);
	}
	
	/**
	 * 아이디, 비밀번호를 전달받아서 사용자의 상태를 탈퇴상태로 변경한다.
	 * @param id 아이디
	 * @param password 비밀번호
	 */
	public void disabledUser(String id, String password) {
		// 1. 아이디로 사용자 정보를 조회해서 사용자정보가 존재하지 않으면 예외를 던진다.
		User savedUser = userDao.getUserById(id);
		if (savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 2. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (!savedUser.getPassword().equals(password)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 3. 조회된 사용자정보의 enabled를 "N"으로 변경한다.
		savedUser.setEnabled("N");
		// 4. 변경된 사용자정보를 UserDao에 전달해서 테이블에 반영시킨다.
		userDao.updateUser(savedUser);
	}
}
