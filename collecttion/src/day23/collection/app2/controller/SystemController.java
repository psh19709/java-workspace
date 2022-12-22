package day23.collection.app2.controller;

import day23.collection.app2.service.SystemService;
import utils.KeyboardReader;

public class SystemController {
	
	private KeyboardReader keyboard;
	private SystemService service;
	
	public SystemController(KeyboardReader keyboard, SystemService service) {
		this.keyboard = keyboard;
		this.service = service;
	}
	
	public void 실행() {
		메뉴();
	}
	
	private void 메뉴() {
		while(true) {
			System.out.println("----------------------------------------------------");
			System.out.println("1.학생 2. 강좌 0. 종료");
			System.out.println("----------------------------------------------------");
			System.out.println();
			
			System.out.print("# 메뉴선택: ");
			int mainMenuNo = keyboard.getInt();
			
			if(mainMenuNo == 1) {
				System.out.println();
				System.out.println("-----------------------------------------------------------");
				System.out.println("1.학생등록 2.수강신청가능강좌조회 3.수강신청 4.수강신청 조회 5.수강철회");
				System.out.println("-----------------------------------------------------------");
				System.out.println();
				
				System.out.println("# 학생메뉴선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				if(menuNo == 1) {
					학생등록();
				} else if(menuNo == 2) {
					수강신청가능강좌();
				} else if(menuNo == 3) {
					수강신청();
				}
				System.out.println();
			} else if(mainMenuNo == 2) {
				System.out.println();
				System.out.println("------------------------------------------------");
				System.out.println("1.강좌등록 2.모든 강좌 출력 3.강좌상세 4.교수별강좌");
				System.out.println("------------------------------------------------");
				System.out.println();
				
				System.out.print("# 강좌메뉴 선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				if(menuNo == 1) {
					강좌등록();
				} else if(menuNo == 2) {
					모든강좌출력();
				} else if(menuNo == 3) {
					강좌상세();
				} else if(menuNo == 4) {
					교수별강좌();
				}
				System.out.println();
			} else if(mainMenuNo == 0) {
				System.out.println("### 프로그램을 종료합니다.");
				System.exit(0);
			}
			System.out.println();
		}
	}

}
