package selfMy;

public class AccountBank {
	
	private Account[] accounts = new Account[100];
	private int index = 0;
	
	public AccountBank() {
		createAccount("11-11-1111", "박소린", 0000, 100000000);
	}

	
	public void createAccount(String no, String owner, int password, int balance) {
		Account account = new Account(no, owner, password, balance);
		accounts[index] = account;
		index++;
	}
	
	// TODO 비밀번호를 전달받아서 계좌정보를 화면에 출력하는 메소드를 정의하세요
	// 필드의 비밀번호와 매개변수로 전달받은 비밀번호가 일치하지 않으면 오류 메세지("비밀번호가 일치하지 않습니다.")를 출력한다
	// 필드의 비밀번호와 매개변수로 전달받은 비밀번호가 일치하면 계좌번호, 예금주, 잔액을 출력한다.
	
	public Account findAccount(String no) {
		Account account = null;
		for(Account num : accounts) {
			if(num == null) {
				break;
			}
			String accountNo = num.getNo();
			if(accountNo.equals(no)) {
				account = num;
				break;
			}
		}
		return account;
	}
	// TODO 입금액을 전달받아서 잔액을 증가시키는 메소드를 정의하세요
	// 입금액이 0이하면 오류 메세지("입금액이 올바르지 않습니다.")를 출력한다.
	// 입금액이 0보다 크면 잔액을 입금액만큼 증가시키고, 완료 메세지("입금이 완료되었습니다.")를 출력한다.
	
	public void deposit(String no, int amount) {
		Account account = findAccount(no);
		if(account == null) {
			System.out.println(" ### 계좌번호가 존재하지 않습니다.");
			return;
		} else {
			if(amount <= 0) {
				return;
			} else {
			int nowBalance = account.getBalance();
			int updateBalance = nowBalance + amount;
			account.setBalance(updateBalance);
			
			System.out.println(" ###입금이 완료 되었습니다.");
			System.out.println();
			System.out.println("현재 잔액: " + updateBalance);
			}
		}
		
	}
	
	// TODO 비밀번호, 출금액을 전달받아서 잔액을 감소시키고, 출금액만큼의 금액을 반환하는 메소드를 정의하세요
	// 필드의 비밀번호와 매개변수로 전달받은 비밀번호가 일치하지 않으면 오류 메세지("비밀번호가 일치하지 않습니다.")를 출력한다
	// 잔액이 전달받은 출금액보다 적으면 오류 메세지("잔액이 부족합니다.")를 출력한다.
	// 비밀번호가 일치하고, 잔액이 출금액보다 크면 출금액만큼 잔액을 감소시키고, 완료 메세지("출금이 완료되었습니다.")를 출력한다.
	// 출금액을 반환한다.
	
	// TODO 이전 비밀번호, 새 비밀번호를 전달받아서 비밀번호를 변경하는 메소드를 정의하세요.
	// 필드의 비밀번호와 매개변수로 전달받은 비밀번호가 일치하지 않으면 오류 메세지("비밀번호가 일치하지 않습니다.")를 출력한다
	// 기본 비밀번호와 새 비밀번호로 일치하면 오류 메세지("이전 비밀번호와 동일한 비밀번호는 사용할 수 없습니다.")를 출력한다.
	// 기존 비밀번호를 새 비밀번호로 변경하고, 완료 메세지("비밀번호가 변경되었습니다")를 출력한다.

}
