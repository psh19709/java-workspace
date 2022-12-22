package com.sample;

import com.sample.dao.UserDao;

public class App2 {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		
		userDao.deleteUserById("sh");
	}

}
