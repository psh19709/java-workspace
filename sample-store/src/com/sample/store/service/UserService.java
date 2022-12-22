package com.sample.store.service;

import com.sample.store.dao.UserDao;
import com.sample.store.vo.User;

/*
 * Service 클래스
 * 	- 업무로직이 구현되는 클래스
 * 	- 메소드 - 요구사항 하나외 대응
 * 		* 대체로 요구사항 하나마다 업무로직 메소드 하나가 필요하다.
 * 		* 업무로직을 구현하기 위해서는 대체로 1번 이상의 데이터베이스 엑세스 작업이 필요하다.
 * 		* 업무로직을 구현하기 위해서 DAO 객체릐 메소드를 1번 이상 호출하게 된다,
 * DAO 클래스
 * 	- 데이터베이스 액세스 작업이 구현되는 클래스
 * 	- 메소드 -SQL 하나와 대응
 * 		* SQL문 하나마다 메소드 하나가 필요하다.
 * 		* CRUD 작업을 구현한다.
 * 		- CRUL 작업을 구현한다,
 * 			Create : Insert문
 * 			Read : Select문
 * 			Update : UPDATE 문 
 * 			Delete : DELETE문 
 */
public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public void registerUser(User user) {
		// TODO 회원가입 기능 구현
		// 1. 아이디로 회원정보를 조회한다. -> 회원정보가 존재하면 예외를 던진다.
		// 2. 이메일로 회원정보를 조회한다. -> 회원정보가 존재하면 예외를 던진다.
		// 3. 1과 2번에서 조회된 회원정보가 없으면 전달받은 회원정보를 데이터베이스에 저장시킨다.
		
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null) {
			throw new RuntimeException("["+user.getId()+"] 이미 사용중인 아이디입니다.");
		}
		savedUser = userDao.getUserByEmail(user.getEmail());
		if(savedUser != null) {
			throw new RuntimeException("["+user.getEmail()+"] 이미 사용중인 이메일입니다.");
			
		}
		
		userDao.insertUser(user);
	}
	
	/**
	 * 아이디와 비밀번호를 전달받아서 일치하는 사용자 정보를 반환한다.
	 * <p>아이디에 해당하는 사용자 정보가 존재하지 않거나, 비밀번호가 일치하지 않으면 예외를 던진다.
	 * @param id	사용자 아이디
	 * @param password	사용자 비밀번호
	 * @return	사용자 정보
	 */
	public User getUserInfo(String id, String password) {
		// TODO 내 정보 조회 기능 구현
		// 1. 아이디로 사용자 정보를 조회한다. -> 사용자 정보가 존재하지 않으면 예외를 던진다.
		// 2. 조회된 사용자 정보의 비밀번호와 전달받은 비밀번호를 비교한다. -> 일치하지 않으면 예외를 던진다.
		// 3. 조회된 사용자 정보를 반환한다.
		User savedUser = userDao.getUserById(id);
		if(savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		
		if(!savedUser.getPassword().equals(password)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		
		return savedUser;
	}
	
	public void updateUserInfo(String id, String oldPassword, String password) {
		//TODO 내 정보 수정 기능 구현(비밀번호 변경 기능 구현)
		// 1. 아이디로 사용자 정보를 조회한다. -> 사용자 정보가 존재하지 않으면 예외를 던진다.
		// 2. 조회된 사용자 정보의 비밀번호와 전달받은 비밀번호를 비교한다. -> 일치하지 않으면 예외를 던진다.
		// 3. 조회된 사용자 정보의 비밀번호 멤버변수에 새 비밀번호를 대입한다. <--- User객체의 비밀번호를 변경하였음
		// 4. 변경된 비밀번호정보가 표함된 User객체를 UserDao에 전달해서 테이블에 반영시킨다.
		
		User savedUser = userDao.getUserById(id);
		if(savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		if(!savedUser.getPassword().equals(oldPassword)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 조회된 사용자 정보의 비밀번호를 새 비밀번호로 변경한다.
		savedUser.setPassword(password);
		// 변경된 비밀번호 정보가 포함된 User객체를 UserDao에 전달해서 테이블에 반영시킨다.
		userDao.updateUser(savedUser);
		
		
		
	}
	
	public void disabledUser(String id, String password) {
		// TODO 회원탈퇴 기능 구현
		// 1. 회원아이디로 사용자 정보를 조회한다. -> 사용자 정보가 존재하지 않으면 예외를 던진다.
		// 2. 비밀번호가 일치하지 않으면 예외를 던진다.
		// 3. 조회된 사용자 정보의 enabled 값을 "N"으로 변경한다.
		// 4. 변경된 정보가 포함된 User객체를 UserDao에 전달해서 테이블에 반영시킨다.
		
		User savedUser = userDao.getUserById(id);
		if(savedUser == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		if(!savedUser.getPassword().equals(password)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		
		savedUser.setEnabled("N");
		
		userDao.updateUser(savedUser);
	}

}
