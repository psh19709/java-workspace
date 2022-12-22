package day18;

import java.util.Objects;

public class Contact implements Cloneable {

	private String name;
	private String email;
	private String phone;
	
	public Contact() {}
	public Contact(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public String getEmil() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	
	// Contact객체의 복제본을 반환하는 메소드다.
	public Contact copy() throws CloneNotSupportedException {
		Contact contact = (Contact) clone();
		return contact;
	}
	
	// Contact 객체를 동등성 비교하도록 hash() equals 
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)			// 주소값이 서로 같으면 같은 객체다.
			return true;			// true 반환
		if (obj == null)			// 비교 대상이 되는 객체가 null이면 
			return false;			// false 반환
		if (getClass() != obj.getClass())		// getClass()는 현재 객체의 설계도 정보, 
			return false;						// obj.getClass()는 비교대상객체의 설계도 정보를 비교해서 서로 다르면 설계도로 만들어진 객체다.
		Contact other = (Contact) obj;			// 같은 설계도로 만들어진 객체임으로 Contact 타입으로 형변환 가능
		return Objects.equals(name, other.name);	// 이 객체의 name과 비교대상 객체의 name을 비교한 값을 반환한다.
	}
	
	// Object의 toString() 메소드를 재정의하기
	// Contact
//	@Override
//	public String toString() {
//		return "name= " + name + ", email= " + email + ", phone= " + phone;
//}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
