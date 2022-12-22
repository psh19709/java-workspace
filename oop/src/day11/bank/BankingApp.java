package day11.bank;

import utils.KeyboardReader;

public class BankingApp {
	
	/*
	 * 		메인
	 * 				서비스 메뉴 제공
	 */
	
	public static void main(String[] args) {
		// 키보드 입력을 읽어오는 기능이 구현된 객체를 생성한다.
		KeyboardReader keyboard = new KeyboardReader();
		// 은행업무 기능이 구현된 객체를 생성한다.
		Banking banking = new Banking();
		
		while (true) {					// 무한 반복문 while문 반복이 되는 메뉴를 출력
			System.out.println("------------------------------------------------------------");
			System.out.println("1.계좌개설 2.계좌조회 3.입금 4.출금 5.비밀번호 변경 6.전계좌조회 0.종료");
			System.out.println("------------------------------------------------------------");
			
			System.out.println();
			System.out.print("메뉴 선택 : ");
			int menuNo = keyboard.getInt();
			System.out.println();
			
			if (menuNo == 1) {
				System.out.println("<<  신규 계좌 개설  >>");
				
				// 신규 계좌 개설이 필요한 정보를 입력받는다.
				System.out.print("신규 계좌번호 입력: ");
				String no = keyboard.getString();
				System.out.print("예금주 이름 입력: ");
				String name = keyboard.getString();
				System.out.print("신규 계좌 비밀번호 입력: ");
				int password = keyboard.getInt();
				System.out.print("신규 계좌 최초 입금액 입력: ");
				int amount = keyboard.getInt();
				
				//Banking 객체의 createAccount() 메소드를 실행해서 신규 계좌를 개설한다.
				banking.createAccount(no, name, password, amount);
				
			} else if (menuNo == 2) {
				System.out.println("<<  계좌 정보 조회  >>");
				System.out.print("조회할 계좌번호 입력: ");
				String no = keyboard.getString();
				
				// **여기부터 중요 (혼자서는 이 부분을 적지 못했음)
				// Banking 객체의 findAccount() 메소드를 실행해서 전달한 계좌번호와 일치하는 계좌정보를 반환받는다.
				BankAccount account = banking.findAccount(no);
				if(account != null) {
					System.out.println("### 계좌정보가 조회되었습니다.");
					account.displayAccount();
				} else {
					System.out.println("### 계좌정보가 존재하지 않습니다.");
				}
				
				
			} else if (menuNo == 3) {
				System.out.println("<<  입금하기  >>");
				
				System.out.print("입금할 계좌번호 입력: " );
				String no = keyboard.getString();
				System.out.print("입금액 입력: "  );
				int amount = keyboard.getInt();
				
				banking.deposit(no, amount);
				
			} else if (menuNo == 4) {
				System.out.println("<<  출금하기  >>");
				//banking.withdraw(no, password, amount)
				
				System.out.print("출금할 계좌번호 입력: ");
				String no = keyboard.getString();
				System.out.print("계좌 비밀번호 입력: ");
				int password = keyboard.getInt();
				System.out.print("출금액 입력: ");
				int amount = keyboard.getInt();
				
				int withdrawAmount = banking.withdraw(no, password, amount);
				System.out.println("###["+withdrawAmount+"] 원을 출금하였습니다.");
				
			} else if (menuNo == 5) {
				System.out.println("<<  비밀번호 변경하기  >>");
				//banking.changeAccountPassword(no, prevPassword, password);
				
				System.out.print("계좌번호 입력: ");
				String no = keyboard.getString();
				System.out.print("이전 비밀번호 입력: ");
				int prevPassword = keyboard.getInt();
				System.out.print("새 비밀번호 입력: ");
				int password = keyboard.getInt();
				
				banking.changeAccountPassword(no, prevPassword, password);
				
				
			}  else if (menuNo == 6) {
				System.out.println("<<  전 계좌 리스트 출력  >>");
				banking.printAllAccount();				//중요하다.
				
			}	else if (menuNo == 0) {
				System.out.println("<<  프로그램 종료  >>");
				break;
				
			}
			System.out.println();
			System.out.println();
			
		}
		System.out.println("### 프로그램이 종료되었습니다.");
	}

}
