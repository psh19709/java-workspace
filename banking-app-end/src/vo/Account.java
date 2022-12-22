package vo;

public class Account {

	private int no;
	private int customerNo;
	private String owner;
	private int password;
	private long balance;
	private int period;
	private double interestRate;
	private boolean isCanceled;
	
	public Account() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
}
