package com.sample.store.dao;

import java.util.List;

import com.sample.store.util.SqlMapper;
import com.sample.store.vo.User;

public class UserDao {
	
	/**
	 * 사용자 아이디를 전달받아서 사용자 정보를 반환한다.
	 * @param userId 사용자 아이디
	 * @return 조회된 사용자 정보(일치하는 정보가 없으면 null이 반환된다.)
	 */
	public User getUserById(String userId) {
		User user = (User) SqlMapper.selectOne("getUserById", userId);
		 return user;
	}
	
	/**
	 * 사용자 이메일을 전달받아서 사용자 정보를 반환한다.
	 * @param email 사용자 이메일
	 * @return 조회된 사용자 정보(일치하는 정보가 없으면 null이 반환된다.)
	 */
	public User getUserByEmail(String email) {
		User user = (User) SqlMapper.selectOne("getUserByEmail", email);
		return user;
	}	
	
	/**
	 * 사용자 정보를 전달받아서 저장한다.
	 * @param user 사용자 정보
	 */
	public void insertUser(User user) {
		SqlMapper.insert("insertUser", user);
	}
	
	/**
	 *  회원가입한 모든 사용자 수를 조회하기
	 */
	public int getUsersCount() {
		int count = (Integer)SqlMapper.selectOne("getUsersCount");
		return count;
	}
	
	/**
	 * 사용자 이름으로 회원정보 조회한다,
	 * @param name 사용자 이름
	 * @return 이름으로 조회된 사용자 정보들(이유는 동명이인이 있을수 있기 떄문)
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsersByName(String name){
		List<User> users = (List<User>) SqlMapper.selectList("getUsersByName", name);
		return users;
	}
	
	/**
	 * 변경된 정보가 포함된 사용자 정보를 전달받아서 데이터베이스에 반영시킨다.
	 * @param user 변경된 정보가 포함된 사용자 정보
	 */
	public void updateUser(User user) {
		SqlMapper.update("updateUser", user);
	}
	
	
	
}
