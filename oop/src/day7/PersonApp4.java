package day7;

public class PersonApp4 {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.no = 10;
		p1.name = "홍길동";
		p1.email = "hong@naver.com";
		p1.tel = "010-1111-1111";
		p1.point = 320000;
		
		System.out.println("p1 참조변수가 참조하는 Person객체의 속성값 출력하기");
		System.out.println("번호: " + p1.no);
		System.out.println("이름: " + p1.name);
		System.out.println("이메일: " + p1.email);
		System.out.println("전화번호: " + p1.tel);
		System.out.println("포인트: " + p1.point);
		System.out.println("보유차량: " + p1.car);
		// p1.car에는 null값이 저장되어 있다
		// p1.car가 참조하는 객체는 존재하지 않는다.
		// p1.car.가 참조하는 객체가 존재하지 않기 때문에 p1.car.name은 오류다.
		// 주의) p1.car가 참조하는 객체가 존재하지 않더라고, p1.car.name 코드가 자동완성된다.
		// null값이 대입되어 있는 참조변수로 객체의 속성이나 기능을 사용할 수 없다.
		// null값이 대입되어 있는 참조변수로 객체의 속성이나 기능을 하용하려고 하면 NullPointException 오류가 발생한다.
		//System.out.println("보유차량: " + p1.car.name);  		// 실행 오류가 발생함.
		//System.out.println("보유차량: " + p1.car.maker);
		//System.out.println("보유차량: " + p1.car.year);
		//System.out.println("보유차량: " + p1.car.price);
		
		Person p2 = new Person();
		p2.no = 20;
		p2.name = "강감찬";
		p2.email = "kang@naver.com";
		p2.tel = "010-1233-1233";
		p2.point = 30000;
		
		Car genesis = new Car();
		genesis.name = "GV80";
		genesis.maker = "현대자동차";
		genesis.year = 2022;
		genesis.price = 50_000_000;
		
		// p2가 참조하는 Person 객체의 car 변수에 Car객체를 조립시켰다.
		p2.car = genesis;		//p2가 참조하는 Person 객체의 car변수에 genesis가 저장하고 있는 Car객체의 주소값을 대입한다.
								//p2.car 변수와 genesis 변수는 같은 주소값을 가지고 있다
								//p2.car 변수와 genesis 변수는 같은 객체를 참조하고 있다
		
		System.out.println("p2 참조변수가 참조하는 Person객체의 속성값 출력하기");
		System.out.println("번호: " + p2.no);
		System.out.println("이름: " + p2.name);
		System.out.println("이메일: " + p2.email);
		System.out.println("전화번호: " + p2.tel);
		System.out.println("포인트: " + p2.point);
		System.out.println("보유차량: " + p2.car);
		System.out.println("보유차량의 모델명: " + p2.car.name);
		System.out.println("보유차량의 제조회사: " + p2.car.maker);
		System.out.println("보유차량의 제작연도: " + p2.car.year);
		System.out.println("보유차량의 판매가격: " + p2.car.price);
		
		Person p3 = new Person();
		p3.no = 30;
		p3.name = "김유신";
		p3.email = "kim@naver.com";
		p3.tel = "010-3333-3333";
		p3.point = 350000;
		p3.car = new Car();  	// Car객체를 생성하고 그 객체의 주소값(객체의 속성에 기본값이 설정된 객체)을 p3.car 변수에 대입함
		System.out.println("p3가 참조하는 고객정보의 보유차량정보 출력하기");
		System.out.println("보유차량의 모델명: " + p3.car.name);
		System.out.println("보유차량의 제조회사: " + p3.car.maker);
		System.out.println("보유차량의 제작연도: " + p3.car.year);
		System.out.println("보유차량의 판매가격: " + p3.car.price);
		
		p3.car.name = "그랜져";
		p3.car.maker = "현대자동차";
		p3.car.year = 2021;
		p3.car.price = 40_000_000;
		
		System.out.println("p3가 참조하는 고객정보의 보유차량정보 출력하기");
		System.out.println("보유차량의 모델명: " + p3.car.name);
		System.out.println("보유차량의 제조회사: " + p3.car.maker);
		System.out.println("보유차량의 제작연도: " + p3.car.year);
		System.out.println("보유차량의 판매가격: " + p3.car.price);
		
		
	}

}
