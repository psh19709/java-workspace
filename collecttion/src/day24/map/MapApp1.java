package day24.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapApp1 {

	public static void main(String[] args) {
		/*
		 * Map<K, V>
		 * 	주요 메소드
		 * 		V 						put(K key, V value)
		 * 					Map객체에 key객체, value객체의 쌍으로 객체를 저장한다.
		 * 					key객체는 중복을 허용하지 않는다. 같은 key객체로 여러 번 저장하면 맨 마지막에 저장된 것만 유지된다
		 * 		V 						get(Object key)
		 * 					Map객체에서 지정된 key와 쌍으로 저장된 value객체를 반환한다. key가 존재하지 않으면 null을 반환
		 * 		boolean 				cintainsKey(Object key)
		 * 					Map객체에서 지정된 key가 존재하면 true를 반환한다.
		 * 		V 						remove(Object key)
		 * 					Map객체에서 지정된 객체를 가진 Entry객체(key객체와 value객체를 포함하고 있다)가 삭제된다.
		 * 		boolean 				isEmpty()
		 *					Map객체에 Entry객체가 존재하지 않으면 true를 반환한다. 
		 * 		int 					size()
		 * 					Map객체에 저장된 Entry객체의 갯수를 반환한다.
		 * 		void 					clear()
		 * 					Map객체에 저장된 모든 Entry객체를 삭제한다.
		 * 		Set<K> 					keySet()
		 * 					Map객체의 모든 key객체의 집합을 반환한다.
		 * 		Set<Map.Entry<K, V>>	entrySet()
		 * 					Map객체의 모든 Entry객체의 집합을 반환한다.
		 * 	주요 구현 클래스
		 * 			HashMap<K, V>, HashTable<K, V>
		 */
		
		Map<String, String> map1 = new HashMap<>();
		map1.put("name", "홍길동");
		map1.put("emil", "hong@naver.com");
		map1.put("tel", "010-1111-1111");
		map1.put("address", "서울시 종로구 한남동");
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("kor", 100);
		map2.put("eng", 90);
		map2.put("math", 70);
		map2.put("history", 90);
		map2.put("sci", 80);
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("no", 100);
		map3.put("dept", "영업1팀");
		map3.put("name", "홍길동");
		map3.put("position", "차장");
		map3.put("salary", 600);
		map3.put("commission", 0.35);
		map3.put("projects", List.of("삼성전자 차세대 프로젝트", "서우시청 인사정보 시스템 프로젝트", "우리은행 신용평가시스템"));
		
		Map<String, List<String>> map4 = new HashMap<>();
		map4.put("hyundai", List.of("황민경", "고예림", "야스민", "이다현", "양효진", "김다인", "김연견"));
		map4.put("hipass", List.of("카타리나", "전세얀", "박정아", "문정원", "배유나", "이윤정", "임명옥"));
		
		
	}
}
