package day16.bank;

/**
 * 은행 전산 시스템 클래스다.
 * <p>은행 업무에 맞는 AbstractBanking 구현 객체를 전달받아서 실행시킨다.
 * @author 박수현
 *
 */
public class BankingSystem {
	
	private AbstractBanking banking;
	
	public void  SetBusinessBankingComponent(AbstractBanking banking) {
		this.banking = banking;
	}
	
	public void runBankingProcess() {
		banking.process();
	}

}
