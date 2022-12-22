package day16.bank;

public abstract class AbstractBanking {
	
	public void process() {
		connect();
		receive();
		
		business();
		
		send();
		disconnect();
	}
	
	// 변하는 부분은 추상화한다.
	public abstract void business();
	
	// 변하지 않는 부분은 구현한다.
	private void connect() {
		System.out.println("### ATM 기기의 연결 요청을 수락한다.");
		System.out.println("### ATM 기기와 연결을 유지한다. 수락한다.");
		
	}
	private void receive() {
		System.out.println("### ATM 기기가 전송한 메세지를 읽어온다.");
		System.out.println("### 수신된 암호화된 메세지의 유효성을 체크한다.");
		System.out.println("### 수신된 암호화된 메세지를 복호화해서 평문으로 변환한다.");
	}
	
	private void send() {
		System.out.println("### 처리결과를 암호화된 메세지로 변환한다.");
		System.out.println("### 암호화된 메세지를 ATM으로 전송한다.");
	}
	
	private void disconnect() {
		System.out.println("### ATM 기기와의 연결을 해제한다.");
		
	}
	
}
