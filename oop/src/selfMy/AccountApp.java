package selfMy;

import utils.KeyboardReader;

public class AccountApp {

	public static void main(String[] args) {
		KeyboardReader keyboard = new KeyboardReader();
		AccountBank accountBank = null;
		
		while (true) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1.계좌생성   2.조회   3.입금   4.출금   5.비밀번호변경   0.종료");
			System.out.println("---------------------------------------------------------------------");

			System.out.print("메뉴번호를 입력하세요: ");
			int menuNo = keyboard.getInt();
			System.out.println();
			
			if (menuNo == 1) {
				System.out.println("### 계좌 생성 ###");
				
				System.out.print("계좌번호를 입력하세요: ");
				int no = keyboard.getInt();
				System.out.print("예금주를 입력하세요: ");
				String owner = keyboard.getString();
				System.out.print("비밀번호를 입력하세요: ");
				int password = keyboard.getInt();
				System.out.print("최초 잔액을 입력하세요: ");
				int amount = keyboard.getInt();
				
				account = new Account(no, owner, password, amount);				
				
			} else if (menuNo == 2) {
				System.out.println("### 계좌정보 조회 ###");
				System.out.print("비밀번호를 입력하세요: ");
				
				// TODO Account객체의 계좌정보 출력기능을 실행한다.

			} else if (menuNo == 3) {
				System.out.println("### 입금 ###");
				System.out.print("입금액을 입력하세요: ");
				
				// TODO Account객체의 입금 기능을 실행한다.
				
			} else if (menuNo == 4) {
				System.out.println("### 출금 ###");
				System.out.print("비밀번호를 입력하세요: ");
				System.out.print("출금액을 입력하세요: ");
				
				// TODO Account객체의 출금 기능을 실행한다.
				
			} else if (menuNo == 5) {
				System.out.println("### 비밀번호 변경 ###");
				System.out.print("이전 비밀번호를 입력하세요: ");
				System.out.print("새 비밀번호를 입력하세요: ");
				
				// TODO Account객체의 비밀번호 변경기능을 실행한다.
				
			} else if (menuNo == 0) {
				System.out.println("### 프로그램을 종료합니다.");
				System.exit(1);
			}
			System.out.println("");
			System.out.println("");
		}
		
		
	}
}
