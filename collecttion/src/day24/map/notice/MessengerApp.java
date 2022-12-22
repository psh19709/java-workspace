package day24.map.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessengerApp {

	public static void main(String[] args) {
		
		
		// Messenger 인터페이스를 구현한 객체 생성
		SmsMessender smsMessender = new SmsMessender();
		KakaoTalkMessenger kakaoTalkMessenger = new KakaoTalkMessenger();
		AppMessenger appMessenger = new AppMessenger();
		
		
		// Map<String, Messenger>에 위에서 생성한 구현객체를 저장한다.
		// Map<String, Messenger>에 메신저타입을 key, Messenger구현객체를 value로 저장한다.
		// Map<K, V> 이 한쌍을 Entry(key와 value)라고 지칭한다.
		Map<String, Messenger> messengetMap = new HashMap<>();
		messengetMap.put("sms", smsMessender);
		messengetMap.put("kakao", kakaoTalkMessenger);
		messengetMap.put("app", appMessenger);
		
		// 사용자 리스트
		List<User> users = new ArrayList<>();
		users.add(new User("홍길동", "sms"));
		users.add(new User("김유신", "app"));
		users.add(new User("강감찬", "sms"));
		users.add(new User("이순신", "kakao"));
		users.add(new User("류관순", "app"));
		
		// 사용자 리스트에서 사용자정보를 하나씩 조회해서 해당 사용자정보의 messageType을 확인하고,
		// messageType에 맞는 Messenger 구현객체를 Map<string, Messenger> 객체에 조회한다.
		for (User user : users) {
			// 사용자의 메세지타입 조회하기("sms", "kakao", "app" 중에 하나다.)
			String messageType = user.getMessageType();
			// Map<String, Messenger> 맵객체에서 메신저타입의 값을 key로 value를 조회한다.
			// 메신저 참조변수는 smsMessender 객체, kakaoTalkMessenger appMessenger 객체중에서
			// Map<String, Messenger> 맵객체에서 조회된 Messenger 구현객체의 메신저를 참조한다.
			Messenger messenger = messengetMap.get(messageType);
			
			// Map<String, Messenger> 맵객체에서 조회한 Messenger 구현객체로 메세지 발송하기
			// messenger.send() 메소드를 실행시켜서 메세지를 발송하게 되는데, 
			// 	messenger 참조변수가 참조하는 Messenger 구현 객체에 따라서 메세지 전송방식이 달라진다.
			// !!!! 다형성 - 사용방법은 동일하지만 실제로 사용하는 객체에 따라서 실행결과도 달라진다.
			messenger.send("홍보팀", user.getName(), "세일해요!!!");
		}
		
		
//		for (User user : users) {
//			String messageType = user.getMessageType();
//			if("sms".equals(messageType)) {
//				smsMessender.send("홍보팀", user.getName(), "세일을 시작합니다");
//			} else if("kakao".equals(messageType)) {
//				kakaoTalkMessenger.send("홍보팀", user.getName(), "세일을 시작합니다");
//			} else if("app".equals(messageType)) {
//				appMessenger.send("홍보팀", user.getName(), "세일을 시작합니다");
//			}
//		}
	}
}
