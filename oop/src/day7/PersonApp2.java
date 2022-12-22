package day7;

public class PersonApp2 {
	
	public static void main(String[] args) {
		// 고객정보를 표현(저장)하는 Person 객체를 생성하고, 고객정보를 저장하기
		
		// 김유신 고객 정보를 저장하는 Person객체 생성하기
		 Person person1 = new Person();
		 // 이순신 고객 정보를 저장하는 Person 객체 생성하기
		 Person person2 = new Person();
		 // 류관순 고객 정보를 저장하는 Person객체 생성하기
		 Person person3 = new Person();
		 
		 person1.no = 1000;          //person1 . (name, no, email, etc)<- 참조변수 이용해서 변수에 값 저장하기
		 person1.name = "김유신";
		 person1.email = "kimyousin@gmail.com";
		 person1.tel = "010-1234-1234";
		 person1.point = 23000;
		 
		 
		 person2.no = 2000;
		 person2.name = "이순신";
		 person2.email = "leess@naver.com";
		 person2.tel = "010-1111-1111";
		 person2.point = 12000;
		 
		 person3.no = 3000;
		 person3.name = "류관순";
		 person3.email = "RyeKs@gmail.com";
		 person3.tel = "010-2222-2222";
		 person3.point = 43957;
	}

}
