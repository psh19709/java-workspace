package day11.bank;

/**
 * 은행 업무(신규 계좌, 조회, 입금, 출금, 비밀번호 변경, 해지 등) 가 구현된 클래스다.
 * @author 박수현
 *
 */

public class Banking {
	
		/*
		 * 		필드
		 * 				계좌정보를 여러 개 저장하는 배열
		 * 		기능
		 * 				신규계좌정보 등록 서비스, 계좌정보 조회 서비스, 입금 서비스, 출금 서비스, 비밀번호 변경 서비스, 해지 서비스
		 */
	
	// 개설된 계좌정보 객체를 저장하는 배열객체를 생성한다.
	private BankAccount[] accounts = new BankAccount[100];
	// 개설된 계좌정보객체가 저장되는 인덱스 값을 저장하는 변수를 생성한다.
	private int index = 0;
	
	// 기본 생성자 메소드 정의        //신규로 적지 않아도 저장되어 있는 계좌정보 값 데이터베이스 값
	public Banking() {
//		// createAccount() 메소드를 실행시켜서 Banking 객체가 생성되면 계좌 5개를 배열객체에 추가시킨다.
		createAccount("11-11-111", "한예희", 1234, 100000000);
		createAccount("11-11-222", "강감찬", 1234, 150000);
		createAccount("11-11-333", "이순신", 1234, 350000);
		createAccount("11-11-444", "류관순", 1234, 450000);
		createAccount("11-11-555", "홍길동", 1234, 550000);
	}
	/**
	 * 신규계좌 개설 기능이다.
	 * <p>계좌번호, 예금주, 비밀번호, 최초 입금액을 전달받아서 신규계좌를 개설한다.
	 * @param no		계좌번호
	 * @param name		예금주
	 * @param password	비밀번호
	 * @param amount	최초 입금액
	 */
	
	public void createAccount(String no, String name, int password, int amount) {
		//신규계좌정보 객체를 생성한다.
		BankAccount account = new BankAccount(no, name, password, amount);
		//생성된 계좌정보 객체를 accounts 배열의 지정된 위치에 저장한다.
		accounts[index] = account;
		// index 값을 1증가 시킨다.
		index++;
	}
	
	/**
	 * 개설된 전체 계좌정보를 목록으로 출력한다.
	 */
	public void printAllAccount() {
		System.out.println("### 전체 계좌 목록");
		
		System.out.println("-----------------------------");
		System.out.println("계좌 번호\t\t예금주\t비밀번호\t잔액");
		System.out.println("-----------------------------");
		for(BankAccount account : accounts) {
			if(account == null) {
				break;
			}
			System.out.print(account.getNo() + "\t");
			System.out.print(account.getName() + "\t");
			System.out.print((account.getPassword()/100) + "**\t");
			System.out.println(account.getBalance());
		}
		System.out.println("-----------------------------");
		
	}
	
	/**
	 * 계좌 조회기능이다.
	 * <p>계좌번호를 전달받아서 계좌번호에 해당하는 계좌정보를 반환한다.
	 * @param no 조회할 번호
	 * @return 계좌정보를 포함하고 있는 BankAccount객체
	 */
	
	public BankAccount findAccount(String no) {
		// **이부분 중요 혼자서는 이 부분을 코딩하지 못했음
		
		// 배열에서 전달받은 계좌번호와 일치하는 계좌정보를 찾아서 저장할 변수를 생성한다.
		BankAccount account = null;     // 위에 영어와 = null을 만들고 return에 account를 넣는다
		
		//accounts 배열에 저장된 BankAccount 객체의 주소값을 처음부터 순서대로 하나씩 item 변수에 대입하고, 수행문을 실행시킨다.
		for(BankAccount item : accounts) {
			// item에 저장된 주소값이 null아면 반복문을 탈출한다.
			if(item == null) {
				break;
			}
			// item에 저장된 주소값이 null이 아니면, 
			// item이 참조하는 BankAccount 객체의 grtNo()메소드를 실행해서 그 객테의 계좌번호를 획득한다.
			String accountNo = item.getNo();
			// 획득한 계좌번호와 메소드 실행시 매개변수로 전달받은 계좌번호가 일치하는지 체크한다.
			if(accountNo.equals(no)) {
				// 계좌번호가 일치하면 item에 저장된 BankAccount객체의 주소값을 account에 대입하고, 반복문을 탈출한다.
				account = item;
				break;
			}
		}
		
		//account 변수에 저장된 BankAccount객체의 주소값을 반환한다.
		// 단, 전달받은 계좌번호와 일치하는 계좌정보가 없을 경우 null이 반환된다.
		return account;
	}
	
	/**
	 * 입금기능이다.
	 * <p>계좌번호와 입금액을 전달받아서 해당 계좌는 잔액을 입금액만큼 증가시킨다.
	 * @param no		계좌번호
	 * @param amount	입금액
	 */
	public void deposit(String no, int amount) {
		// 전달받은 계좌번호에 해당하는 계좌정보를 조회한다.
		BankAccount account = findAccount(no);
		// 조횐된 계좌정보가 null이면, 메소드를 종료시킨다. return 빠른 종료 사용.
		if(account == null) {
			System.out.println("### 계좌번호와 일치하는 계좌정보가 존재하지 않습니다.");
			return; 			//빠른 종료
		} 
		//현재 잔액을 조회한다.
		int currentBanlace = account.getBalance();
		// 현재 잔액에 입금액을 더한 겂을 계산한다
		int updatedBalance = currentBanlace + amount;
		// 계좌의 현재 잔액을 변경한다.
		account.setBalnce(updatedBalance);
		
		System.out.println("### 입금이 완료되었습니다.");
	}
	
	/**
	 * 출금기능이다.
	 * <p>계좌번호, 비밀번호, 출금액을 전달받아서 해당 계좌의 잔액을 출금액만큼 감소시키고, 출금액 만큼 금액을 반환한다.
	 * @param no			계좌번호
	 * @param password		비밀번호
	 * @param amount		출금액
	 * @return				인출된 금액
	 */
	public int withdraw(String no, int password, int amount) {
		int withdrawAmount = 0;

		// 전달받은 계좌번호에 해당하는 계좌정보를 조회한다.
		BankAccount account = findAccount(no);
		// 조횐된 계좌정보가 null이면, 메소드를 종료시킨다. return 빠른 종료 사용.
		if(account == null) {
			System.out.println("### 계좌번호와 일치하는 계좌정보가 존재하지 않습니다.");
			return 0; 			//빠른 종료
		} 
		
		//비밀번호를 체큰한다.
		int accountPassword = account.getPassword();
		if(accountPassword != password) {
			System.out.println("### 비밀번호가 일치하지 않습니다.");
			return 0;  // 빠른 종료
		}
		
		//잔액을 체크한다.
		int currentBalance = account.getBalance();
		if(currentBalance < amount) {
			System.out.println("### 잔액이 부족합니다.");
			return 0; //빠른 종료
		}
		
		//잔액의 출금액만큼 감소시키고, 계좌의 잔액을 변경시킨다.
		int updateBalance = currentBalance - amount - 1200;		//1200원은 수수료
		account.setBalnce(updateBalance);
		withdrawAmount = amount;
		
		System.out.println("###["+withdrawAmount+"] 원을 출금합니다");
		
		return withdrawAmount;
	}

	/**
	 * 비밀번호 변경 기능이다.
	 * <p>계좌번호, 이전 비밀번호, 새 비밀번호를 전달받아서 해당 계좌의 비밀번호를 변경한다.
	 * @param no			계좌번호
	 * @param prevPassword	이전 비밀번호
	 * @param password		새 비밀번호
	 */
	public void changeAccountPassword(String no, int prevPassword, int password) {
		// 전달받은 계좌번호와 일치하는 계좌정보 조회하기
			BankAccount account = findAccount(no);
				// 조횐된 계좌정보가 null이면, 메소드를 종료시킨다. return 빠른 종료 사용.
		if(account == null) {
			System.out.println("### 계좌번호와 일치하는 계좌정보가 존재하지 않습니다.");
			return; 			//빠른 종료  int 일 때는 return 0;
		} 
		
		//비밀번호를 체크한다.
		int accountPassword = account.getPassword();
		if(accountPassword != prevPassword) {
			System.out.println("### 비밀번호가 일치하지 않습니다.");
			return;		// 빠른종료
		}
		
		// 이전 비밀번호와 새 비밀번호가 일치하는지 체크한다.
		if(accountPassword == password) {
			System.out.println("### 이전 비밀번호와 같은 번호로 변경할 수 없습니다.");
			return;		//빠른종료
		
		}
		// 계좌의 비밀번호를 새 비밀번호로 변경한다.
		account.setPassword(password);
		
		System.out.println("### 비밀번호가 변경되었습니다.");
	}
}
