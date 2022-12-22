package com.sample.dao;

import java.util.List;

import com.sample.util.SqlMapper;
import com.sample.vo.User;

public class UserDao {
	
	public void insertUser(User user) {
		SqlMapper.insert("insertUser", user);
	}
	
	public void deleteUserById(String userId) {
		SqlMapper.delete("deleteUser", userId);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		List<User> users = (List<User>) SqlMapper.selectList("getAllUsers");
		return users;
	}
	
	public User getUserById(String userId) {
		User user = (User) SqlMapper.selectOne("getUserById", userId);
		return user;
	}
}
