package day24.map;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapApp4 {

	public static void main(String[] args) {
		// Map<K, V>에 V의 타입이 매우 다양한 경우, V의 타입을 Object로 지정한다.
		// Map<K, V>에서 V를 Object 타입으로 지정하면 Map 객체의 Value로 모든 객체를 지정할 수 있다.
		// Map<K, V>객체에 저장된 Value를 조회할 떄 강제 형변환을 꼭 해줘야한다.
		Map<String, Object> map = new HashMap<>();
		
		
		//Map<String, Object> 객체에 key, value 저장하기
		map.put("no", 10000);
		map.put("title", "와칸다 포에버");
		map.put("openDate", new Date());
		map.put("runnungTime", 120);
		map.put("director", "라이언 쿠글러");
		map.put("actors", List.of("레티티아 라이드", "다나이 구리라", "루피타 뇽오"));
		
		// Map<String, Object> 객체에서 key로 value 조회하기
		int 번호 = (Integer)map.get("no");
		String 제목 = (String)map.get("title");
		Date 개봉일 = (Date)map.get("openDate");
		int 상영시간 = (Integer)map.get("runnungTime");
		String 감독 = (String)map.get("director");
		@SuppressWarnings("unchecked")
		List<String> 출연진 = (List<String>) map.get("actors");
		
		System.out.println(번호);
		System.out.println(제목);
		System.out.println(개봉일);
		System.out.println(상영시간);
		System.out.println(감독);
		System.out.println(출연진);
		
	}
}
