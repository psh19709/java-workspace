package day24.map.notice;

public class AppMessenger implements Messenger{

	@Override
	public void send(String from, String to, String content) {
		System.out.println("<< 스마트폰 앱 푸시로 메세지로 발송 >>");
		System.out.println("발신자: " + from);
		System.out.println("수신자: " + to);
		System.out.println("내용" + content);
	}
}
