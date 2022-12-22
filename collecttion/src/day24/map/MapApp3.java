package day24.map;

import java.util.HashMap;
import java.util.Map;

import utils.KeyboardReader;
import utils.StringUtils;

public class MapApp3 {

	public static void main(String[] args) {
		
		// 고객 등급과 구매금액을 입력하면 적립포인트를 출력하는 프로그램
		// 고객등급: 일반(0.4% 적립), 로얄(1% 적립), 골드(2% 적립), 플래티넘(5% 적립)
		
		Map<String, Double> depositRatMap = new HashMap<>();
		depositRatMap.put("일반", 0.004);
		depositRatMap.put("로얄", 0.01);
		depositRatMap.put("골드", 0.02);
		depositRatMap.put("플래티넘", 0.05);
		
		KeyboardReader keyboard = new KeyboardReader();
		
		System.out.print("### 등급입력(일반, 로얄, 골드, 플래티넘) : ");
		String grade = keyboard.getString();
		System.out.print("### 구매 금액 입력: ");
		int orderPrice = keyboard.getInt();
		
		/*
		 * Map을 활용하면 if ~ else if ~ else if 문을 제거할 수 있다.
		 * 	조건식에서 비교대상으로 사용되는 값을 Map의 key로, 
		 * 			연산에 사용되는 값을 Map의 value로 저장한다.
		 * 	입력 값(등급)에 따라서 Map에서 해당되는 등급의 값을 가져와서 연산에 활용할 수 있다.
		 */
		double depositRate = depositRatMap.get(grade);
		int point = (int)(orderPrice*depositRate);
		
//		int point = 0
		
//		if("플래티넘".equals(grade)) {
//			point = (int)(orderPrice*0.05);
//		} else if("골드".equals(grade)) {
//			point = (int)(orderPrice*0.02);
//			
//		} else if("로얄".equals(grade)) {
//			point = (int)(orderPrice*0.01);
//			
//		} else if("일반".equals(grade)) {
//			point = (int)(orderPrice*0.004);
//		}
		
		System.out.println("고객등급: " + grade);
		System.out.println("주문금액: " + StringUtils.numberToString(orderPrice) + "원");
		System.out.println("포인트: " + StringUtils.numberToString(point) + "점");
		
	}
}
