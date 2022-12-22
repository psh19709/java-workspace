package com.sample;

import com.sample.dao.UserDao;
import com.sample.vo.User;

public class App1 {
	
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		
		User user = new User();
		user.setId("sh");
		user.setPassword("zxcv1234");
		user.setName("박수현");
		user.setEmail("tntntn@naver.com");
		user.setTel("010-1111-1111");
		user.setGender("여");
		
		userDao.insertUser(user);
	}

}
