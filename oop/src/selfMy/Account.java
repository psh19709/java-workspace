package selfMy;

public class Account {

	private String no;				//계좌번호
	private String owner;		//예금주
	private int password;		//비밀번호
	private int balance;		//잔액
	
	public Account(String no, String owner, int password, int balance) {
		super();
		this.no = no;
		this.owner = owner;
		this.password = password;
		this.balance = balance;
	}
	
	//{ getter 메소드 
	//잔액 반환
	public String getNo() {
		return no;
	}
	
	//예금주 전환
	public String getOwner() {
		return owner;
	}
	
	//비밀번호 전환
	public int getPassword() {
		return password;
	}
	
	//잔액 전환
	public int getBalance() {
		return balance;
	}
	
	// } getter 메소드
	
	//{ setter 메소드
	
	/**
	 * 기존 비밀번호에서 새로운 비밀번호로 전환
	 */
	public void setPassword(int password) {
		this.password = password;
	}
	
	/**
	 * 변경된 잔액으로 변경하기
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * 출력하기
	 */
	public void disparyAccount() {
		System.out.println("계좌번호: " + no);
		System.out.println("예금주: " + owner);
		System.out.println("잔액: " + balance);
	}
	
}
