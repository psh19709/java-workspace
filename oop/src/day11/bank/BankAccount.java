package day11.bank;

/**
 * 계좌정보를 표현하는 클래스
 * @author 박수현
 *
 */

/*
 * 		필드
 * 				계좌번호, 예금주, 비밀번호, 잔액
 * 		기능
 * 				계좌정보 출력기능, 
 * 				Setter 메소드
 * 					잔액변경기능,
 * 						public void setBalance(int balance){
 * 									this. balance = balance;
 * 							}
 * 					비밀번호 변경 기능
 * 						public void setPassword(int password){
 * 									this. password = password;
 * 				Getter메소드
 * 					
 */

public class BankAccount {

	
		private String no;
		private String name;
		private int password;
		private int balance;
		
		/**
		 * 계좌정보를 초기화하는 생성자다
		 * @param no
		 * @param name
		 * @param password
		 * @param balance
		 */
		
		public BankAccount(String no, String name, int password, int balance) {
			this.no = no;
			this.name = name;
			this.password = password;
			this.balance = balance;
		}
		
		
		/**
		 * 계좌번호를 반환한다.
		 */
		public String getNo() {
			return no;
		}
		/**
		 * 예금주 이름을 반환한다.
		 * @return 예금주 이름
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * 비밀번호를 반환한다.
		 * @return
		 */
		public int getPassword() {
			return password;
		}
		
		/**
		 * 현재 잔액을 반환한다.
		 * @return
		 */
		public int getBalance() {
			return balance;
		}

		
		/**
		 * 새비밀번호를 전달받아서 비밀번호를 변경한다.
		 * @param password
		 */
		public void setPassword(int password) {
			this.password = password;
		}
		
		
		/**
		 * 변경된 잔액을 전달받아서 현재 잔액을 출력한다.
		 * @param balance 변경된 잔액
		 */
		public void setBalnce(int balance) {
			this.balance = balance;
		}
		
		
		/**
		 * 계좌정보를 화면에 출력한다.
		 */
		
		public void displayAccount() {
			System.out.println("["+name+"]님의 계좌정보");
			System.out.println("계좌번호: " + no);
			System.out.println("예금주: " + name);
			System.out.println("비밀번호: " + (password/100)+"**");
			System.out.println("현재잔액: " + balance + " 원");
		}
}

	