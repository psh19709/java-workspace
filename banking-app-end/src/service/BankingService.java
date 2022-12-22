package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import exception.BankingException;
import vo.Account;
import vo.Customer;

public class BankingService {

	private List<Customer> customerList = new ArrayList<>();
	private List<Account> accountList = new ArrayList<>();
	private AtomicInteger customerAtom = new AtomicInteger(1001);
	private AtomicInteger accountAtom = new AtomicInteger(1000001);
	
	public BankingService() {
		insertCustomer("홍길동", "010-1111-1111");
		insertCustomer("김유신", "010-1111-2222");
		insertCustomer("강감찬", "010-1111-3333");
		insertCustomer("이순신", "010-1111-4444");
		insertCustomer("류관순", "010-1111-5555");

		insertAccount(1001, 1234, 1500000);
		insertAccount(1002, 1234, 10000000);
		insertAccount(1003, 1234, 700000);
		insertAccount(1004, 1234, 120000000);
		insertAccount(1005, 1234, 5000000);
	}

	// 신규 고객 등록하기
	public void insertCustomer(String name, String tel) {
		Customer customer = new Customer();
		customer.setNo(customerAtom.getAndIncrement());
		
		customerList.add(customer);
	}

	// 신규 계좌 개설하기
	public void insertAccount(int customerNo, int password, int amount) {
		Customer customer = getCustomer(customerNo);
		Account account = new Account();
		account.setNo(accountAtom.getAndIncrement());
		account.setCustomerNo(customerNo);
		account.setOwner(customer.getName());
		account.setPassword(password);
		account.setBalance(amount);
		account.setInterestRate(0.05);
		
		accountList.add(account);
	}
	
	// 계좌정보 조회
	public Account getAccount(int accountNo, int password) {
		// 1. 계좌번호에 해당하는 계좌정보를 조회한다.
		Account account = getAccountByNo(accountNo);
		// 2. 계좌정보가 null이면 예외를 던진다.
		if (account == null) {
			throw new BankingException("계좌정보 없음: " + accountNo + ", 계좌정보가 존재하지 않습니다.");
		}
		// 3. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (account.getPassword() != password) {
			throw new BankingException("비밀번호 불일치: " + accountNo + ", 계좌 비밀번호가 일치하지 않습니다.");
		}
		
		// 4. 계좌정보를 반환한다.
		return account;
	} 
	
	// 입금하기
	public void deposit(int accountNo, int amount) {
		// 1. 계좌번호에 해당하는 계좌정보를 조회한다.
		Account account = getAccountByNo(accountNo);
		// 2. 계좌정보가 존재하지 않으면 예외를 던진다.
		if (account == null) {
			throw new BankingException("계좌정보 없음: " + accountNo + ", 계좌정보가 존재하지 않습니다.");			
		}
		
		// 3. 입금액 만큼 계좌의 잔액을 증가시킨다.
		account.setBalance(account.getBalance() + amount);
	}
	
	// 출금하기
	public long withdraw(int accountNo, int password, int amount) {
		// 1. 계좌번호에 해당하는 계좌정보를 조회한다.
		Account account = getAccountByNo(accountNo);
		// 2. 계좌정보가 존재하지 않으면 예외를 던진다.
		if (account == null) {
			throw new BankingException("계좌정보 없음: " + accountNo + ", 계좌정보가 존재하지 않습니다.");			
		}
		// 3. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (account.getPassword() != password) {
			throw new BankingException("비밀번호 불일치: " + accountNo + ", 계좌 비밀번호가 일치하지 않습니다.");
		}
		// 4. 잔액이 부족하면 예외를 던진다.
		if (account.getBalance() < amount) {
			throw new BankingException("잔액부족: " + account.getBalance() + ", 출금액보다 잔액이 부족합니다.");
		}
		
		// 5. 출금액만큼 잔액을 감소시킨다.
		account.setBalance(account.getBalance() - amount);
		
		// 6. 출금액을 반환한다.
		return amount;
	}
	
	// 이체하기
	public void doTransaction(int srcAccountNo, int password, int amount, int destAccountNo) {
		// 1. 내 계좌와 대상 계좌정보를 조회한다.
		Account srcAccount = getAccountByNo(srcAccountNo);
		Account destAccount = getAccountByNo(destAccountNo);
		// 2. 내 계좌정보가 존재하지 않으면 예외를 던진다.
		if (srcAccount == null) {
			throw new BankingException("계좌정보 없음: " + srcAccountNo + ", 출금 계좌정보가 존재하지 않습니다.");		
		}
		// 3. 대상 계좌정보가 존재하지 않으면 예외를 던진다.
		if (destAccount == null) {
			throw new BankingException("계좌정보 없음: " + destAccountNo + ", 대상 계좌정보가 존재하지 않습니다.");		
		}
		// 4. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (srcAccount.getPassword() != password) {
			throw new BankingException("비밀번호 불일치: " + srcAccountNo + ", 계좌 비밀번호가 일치하지 않습니다.");
		}
		// 5. 이체금액이 부족하면 예외를 던진다.
		if (srcAccount.getBalance() < amount) {
			throw new BankingException("잔액부족: " + srcAccount.getBalance() + ", 이체금액보다 잔액이 부족합니다.");
		}
		srcAccount.setBalance(srcAccount.getBalance() - amount);
		destAccount.setBalance(destAccount.getBalance() + amount);
	}
	
	// 비밀번호 변경하기
	public void changePassword(int accountNo, int prevPassword, int password) {
		// 1. 계좌번호에 해당하는 계좌정보를 조회한다.
		Account account = getAccountByNo(accountNo);
		// 2. 계좌정보가 존재하지 않으면 예외를 던진다.
		if (account == null) {
			throw new BankingException("계좌정보 없음: " + accountNo + ", 계좌정보가 존재하지 않습니다.");			
		}
		// 3. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (account.getPassword() != prevPassword) {
			throw new BankingException("이전 비밀번호 불일치: " + accountNo + ", 이전 비밀번호가 일치하지 않습니다.");
		}
		// 4. 기존 비밀번호와 새 비밀번호가 일치하면 예외를 던진다.
		if (prevPassword == password) {
			throw new BankingException("유효하지 않은 비밀번호: 이전 비밀번호와 같은 비밀번호로 변경할 수 없습니다.");
		}
		// 5. 비밀번호에 중복된 숫자가 있으면 예외를 던진다.
		if (isNumberDuplicated(password)) {
			throw new BankingException("유효하지 않은 비밀번호: 비밀번호에 같은 숫자가 2개 이상 포함되어 있습니다.");
		}
		
		// 6. 비밀번호를 변경한다.
		account.setPassword(password);
	}
	
	// 해약하기
	public long cancelAccount(int accountNo, int password) {
		// 1. 계좌번호에 해당하는 계좌정보를 조회한다.
		Account account = getAccountByNo(accountNo);
		// 2. 계좌정보가 존재하지 않으면 예외를 던진다.
		if (account == null) {
			throw new BankingException("계좌정보 없음: " + accountNo + ", 계좌정보가 존재하지 않습니다.");			
		}
		// 3. 비밀번호가 일치하지 않으면 예외를 던진다.
		if (account.getPassword() != password) {
			throw new BankingException("비밀번호 불일치: " + accountNo + ", 계좌 비밀번호가 일치하지 않습니다.");
		}
		
		// 4. 해지 환급금을 계산한다.
		int period = account.getPeriod() == 0 ? 1 : account.getPeriod();
		int amount = (int) (account.getBalance() + account.getBalance()*(account.getInterestRate()/12)*period);
		
		// 5. 계좌상태를 취소상태로 변경한다.
		account.setCanceled(true);
		
		// 6. 해지환급금을 반환한다.
		return amount;
	}
	
	// 지정된 고객번호에 해당하는 고객정보를 반환하는 메소드
	private Customer getCustomer(int customerNo) {
		for (Customer customer : customerList) {
			if (customer.getNo() == customerNo) {
				return customer;
			}
		}
		return null;
	}
	
	// 지정된 계좌번호에 해당하는 계좌정보를 반환하는 메소드
	// 해약된 계좌인 경우 null을 반환한다.
	private Account getAccountByNo(int accountNo) {
		for (Account account : accountList) {
			if (account.getNo() == accountNo && !account.isCanceled()) {
				return account;
			}
		}
		return null;
	}
	
	// 지정된 비밀번호에 같은 숫자가 2개 이상 있는 경우 true를 반환하는 메소드다.
	private boolean isNumberDuplicated(int number) {
		Map<String, Integer> map = new HashMap<>();
		
		String text = String.valueOf(number);
		for (int index = 0; index < text.length(); index++) {
			String numberString = text.substring(index, index + 1);
			if (map.containsKey(numberString)) {
				int count = map.get(numberString);
				map.put(numberString, count + 1);
			} else {
				map.put(numberString, 1);
			}
		}
		
		Collection<Integer> values = map.values();
		for (int value : values) {
			if (value >= 2) {
				return true;
			}
		}
		return false;
	}
}
