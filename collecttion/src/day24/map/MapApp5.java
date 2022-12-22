package day24.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapApp5 {

	public static void main(String[] args) {
		
		Map<Integer, String> depts = new HashMap<>();
		
		// V put(K k, V v)로 맵 객체 저장하기
		depts.put(1001, "국어국문학과");
		depts.put(1002, "영어영문학과");
		depts.put(1003, "경영학과");
		depts.put(1004, "전자공학과");
		depts.put(1005, "기계공학과");
		
		// boolean containsKey(Object key)로 지정된 Map 객체에 key가 존재하는지 확인하기
		boolean isContains =  depts.containsKey(1001);
		System.out.println("키의 존재 여부: " + isContains);
		
		// 동일한 key로 중복저장하는 경우
		// put은 키가 존재하지 않으면 추가하고 key가 존재하는 경우는 그위에 덮어쓰기를 한다.
		// V put(K k, V v)는 Map객체에 동일한 key가 존재하지 않으면 key, value를 추가하고,
		//							 동일한 key가 존재하면 value를 덮어쓴다.
		depts.put(1004, "컴퓨터공학과");		
		System.out.println(depts);
		
		// V remove(Object key)로 Map객체에서 지정한 key로 저장된 key, value 삭제하기
		depts.remove(1002);
		System.out.println(depts);
		
		// boolean isEmpty()로 Map객체가 비어있는지 확인하기
		boolean isEmpty = depts.isEmpty();
		System.out.println("비어있는가: " + isEmpty);
		
		// int size()로 Map객체에 저장된 key, value의 갯수 조회하기
		int size = depts.size();
		System.out.println("저장된 갯수: " + size);
		
		//Set<K> keySet()로 Map객체의 모든 Key값이 저장된 Set객체 조회하기
		Set<Integer> keys = depts.keySet();
		System.out.println("키 집합: " + keys);
		for(int key : keys) {
			System.out.println("["+key+"] " + depts.get(key));
		}
		
		
		// void clear()로 Map객체에 저장된 모든 key, value 삭제하기
		depts.clear();
		System.out.println(depts);
		
	}
}
