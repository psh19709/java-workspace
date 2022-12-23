package com.sample.store.dao;

import com.sample.store.util.SqlMapper;
import com.sample.store.vo.User;

public class UserDao {

	/**
	 * 아이디를 전달받아서 아이디로 사용자정보를 조회해서 반환한다.
	 * @param id 사용자 아이디
	 * @return 사용자 정보, 사용자 정보가 존재하지 않으면 null을 반환한다.
	 */
	public User getUserById(String id) {
		return (User) SqlMapper.selectOne("getUserById", id);
	}
	
	/**
	 * 이메일을 전달받아서 이메일로 사용자정보를 조회해서 반환한다.
	 * @param email 사용자 이메일
	 * @return 사용자 정보, 사용자 정보가 존재하지 않으면 null을 반환한다.
	 */
	public User getUserByEmail(String email) {
		return (User) SqlMapper.selectOne("getUserByEmail", email);
	}
	
	/**
	 * 신규 사용자정보가 포함된 사용자정보를 전달받아서 테이블에 저장한다.
	 * @param user 사용자 정보
	 */
	public void insertUser(User user) {
		SqlMapper.insert("insertUser", user);
	}
	
	/**
	 * 변경된 사용자정보가 포함된 사용자정보를 전달받아서 테이블에 반영한다.
	 * @param user 변경된 정보가 포함된 사용자 정보
	 */
	public void updateUser(User user) {
		SqlMapper.update("updateUser", user);
	}
}
