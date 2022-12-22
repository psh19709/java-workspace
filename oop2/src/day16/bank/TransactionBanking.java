package day16.bank;

public class TransactionBanking extends AbstractBanking {
	
	public void business() {

		System.out.println("--------------------------------");
		System.out.println("### 이체작업 시작");
		System.out.println("### 1. 수신메세지에서 이체정보 획득");
		System.out.println("### 2. 잔액 호가인 및 비밀번호 확인");
		System.out.println("### 3. 상대방 계좌에 이체금액 송금");
		System.out.println("### 4. 내 계좌의 잔액 변경");
		System.out.println("### 5. 이체 내역정보 저장");
		System.out.println("### 6. 이체작업 종료");
		System.out.println("--------------------------------");
	}

}
