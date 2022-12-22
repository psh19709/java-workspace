package controller;

import java.util.ArrayList;

import exception.BankingException;
import service.BankingService;
import utils.KeyboardReader;

public class BankingController {

	private KeyboardReader keyboard = new KeyboardReader();
	private BankingService service = new BankingService();
	
	public void 실행() {
		메뉴();
	}
	
	private void 메뉴() {
		while(true) {
			try {
				// 메뉴 출력
				// 메뉴번호 입력
				// 메뉴번호에 해당하는 메소드 호출
			} catch(BankingException ex) {
				System.out.println("### [오류] " + ex.getMessage());
				ex.printStackTrace();
			} catch(Exception ex) {
				System.out.println("### [오류] 알 수 없는 오류가 발생하였습니다.");
				ex.printStackTrace();
			}
		}
	}
}
