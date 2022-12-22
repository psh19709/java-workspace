package day22.generic.phone;

public class GenericPhoneBoxApp {

	public static void main(String[] args) {
		
		// String은 Phone의 하위타입이 아니기 때문에 String객체를 담는 Box객체는 생성할 수 없다.
//		GenericPhoneBox<String> box1 = new GenericPhoneBox<>();
//		box1.setItem("홍길동");
//		box1.setItem("홍길동");
//		box1.setItem("홍길동");
//		box1.setItem("홍길동");
//		box1.setItem("홍길동");
//		box1.setItem("홍길동");
//		box1.setItem("홍길동");
		
		// box1이 참조하는 객체는 Phone 종류의 객체를 저장할 수 있다.
		GenericPhoneBox<Phone> box1 = new GenericPhoneBox<>();
		box1.setItem(new Phone());
		box1.setItem(new FeaturePhone());
		box1.setItem(new SmartPhone());
		// box2이 참조하는 객체는 FeaturePhone 종류의 객체를 저장할 수 있다.
		GenericPhoneBox<FeaturePhone> box2 = new GenericPhoneBox<>();
		//box2.setItem(new Phone());
		box2.setItem(new FeaturePhone());
		box2.setItem(new FeaturePhone());
		box2.setItem(new FeaturePhone());
		box2.setItem(new FeaturePhone());
		//box2.setItem(new SmartPhone());
		// box3이 참조하는 객체는 SmartPhone 종류의 객체를 저장할 수 있다.
		GenericPhoneBox<SmartPhone> box3 = new GenericPhoneBox<>();
		//box3.setItem(new Phone());
		//box3.setItem(new FeaturePhone());
		box3.setItem(new SmartPhone());
		box3.setItem(new SmartPhone());
		box3.setItem(new SmartPhone());
		box3.setItem(new SmartPhone());
		box3.setItem(new SmartPhone());
		box3.setItem(new SmartPhone());
	}
}
