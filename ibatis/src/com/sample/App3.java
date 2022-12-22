package com.sample;

import java.util.List;

import com.sample.dao.UserDao;
import com.sample.vo.User;

public class App3 {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();
		
		System.out.println("### 모든 사용자 정보");
		List<User> users = userDao.getAllUsers();
		for(User user : users) {
			System.out.println(user.getId() + ", " + user.getName() + ", " + user.getEmail());
		}
		
		System.out.println("### 아이디로 사용자 정보 조회");
		User user = userDao.getUserById("kim");
		System.out.println(user.getId() + ", " + user.getName() + ", " + user.getEmail());
	}
}
