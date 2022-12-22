package day7;

/**
 *  고객 정보를 표현하는 객체생성에 사용되는 클래스다.
 *  고객 정보는 고객번호, 이름, 이메일, 전화번호, 포인트 등으로 구성되어 있다.
 *  			정수	  문자열	문자열	문자열	정수
 * @author 박수현
 *
 */
public class Car {
		// 필드, 멤버변수, 인스턴스변수, 프로퍼티, 속성
	String name;	//모델명
	String maker;	//제조사	
	int year;		//년(연)식
	int price;		//가격
	Car car;		// 고객이 보유하고 있는 차정보를 표현하는 객체
}
