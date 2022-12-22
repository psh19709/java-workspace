package day16.bank;

public class BankingApp {
	
	public static void main(String[] args) {
		
		BankingSystem system = new BankingSystem();
		
		TransactionBanking banking = new TransactionBanking();
		system.SetBusinessBankingComponent(banking);
		
		system.runBankingProcess();
		
	}

}
