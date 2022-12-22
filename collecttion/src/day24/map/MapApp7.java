package day24.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * ArrayList<E>
 * 		-객체를 여러개 저장할 떄 가장 많이 사용되는 자료구조 구현 클래스다.
 * 		- 같은 타입의 객체를 여러 개 저장한다.
 *		- 내부적으로 index(순번)가 있어서 저장한 순서대로 다시 꺼낼 수 있다.
 *		- 순서가 보장되는 자료구조 구현 클래스다.
 *	HashSet<E>
 *		- 같은 타입의 객체를 여러 개 저장한다.
 *		- 중복을 허용하지 않는다.(동일한 객체 혹은 동등한 객체를 중복해서 저장할 수 없다.)
 *			* 동등성 비교를 위해서는 hashCode와 equals메소드를 재정의해야 한다.
 *	TreeSet<E>
 *		- 같은 타입의 객체를 여러 개 저장한다.
 *		- 중복을 허용하지 않는다
 *		-  객체를 저장하면 내부 정렬된다.(TreeSet에 저장하는 객체는 반드시 Comparable<E> 인터페이스의 compareTo(E o)메소드를 재정의해야한다.)
 *
 *	HashMap<E>
 *		- key, value의 쌍으로 저장한다.
 *		- key는 중복을 허용하지 않는다.
 *		- value는 같은 타입일 수도 있고, 서로 다른 타입의 객체일 수도 있다.
 *		- 항상 key를 사용해서 key, value 쌍의 정보를 다룬다.
 *		- 정보가 가변적일 때 사용되는 자료구조 구현 클래스다.
 */

public class MapApp7 {

	public static void main(String[] args) {
		//Employee emp = new Employee("홍보부", "이재원", 300);
		List<Employee> employeeList = Arrays.asList(new Employee("홍보부", "이재원", 300), 
				new Employee("총무부", "이승엽", 450),
				new Employee("홍보부", "박성한", 400),
				new Employee("총무부", "한유섬", 200),
				new Employee("인사부", "황성빈", 200),
				new Employee("연구소", "전준우", 700),
				new Employee("인사부", "안치용", 350),
				new Employee("총무부", "최지훈", 550),
				new Employee("연구소", "이정후", 800),
				new Employee("총무부", "윤영철", 600),
				new Employee("인사부", "이대호", 500),
				new Employee("연구소", "김혜성", 650));
		
		// 부서별로 사원정보를 분류하기
		Map<String, List<Employee>> map1 = new HashMap<>();
		
		for (Employee emp : employeeList) {
			// 사원의 소속부서를 조회한다.
			String dept = emp.getDept();
			// Map객체에 해당 소속부서로 저장된 Key가 있는지 확인한다.
			if(map1.containsKey(dept)) {
				List<Employee> list = map1.get(dept);
				list.add(emp);
				
			} else {
				// Map객체에 해당 소속부서의 key가 존재하지 않으면
				// 사원정보를 여러 개 저장할 수 있는 List객체를 생성한다.
				// List객체에 지금 조회된 사원정보를 저장한다.
				// Map객체에 해당 소속부서를 key로 List객체를 저장한다.
				List<Employee> list = new ArrayList<>();
				list.add(emp);
				map1.put(dept, list);
			}
		}
		
		// Map<String, List<Employee>> 객체의 key를 전부 조회하기
		Set<String> keys = map1.keySet();

		// 부서별 인원 수 출력하기
		for(String key : keys) {
			List<Employee> employees = map1.get(key);
			int count = employees.size();
			System.out.println("["+key+"] " + count + " 명");
		}
		System.out.println();
		
		// 부서별 총 급여와 평균급여를 출력하기
		System.out.println("### 부서별 총 급여와 평균 급여 출력하기");
		for(String key : keys) {
			List<Employee> employees = map1.get(key);
			int totalSalary = 0;
			int averageSalary = 0;
			
			for(Employee emp : employees) {
				totalSalary += emp.getSalary();
			}
			averageSalary = totalSalary/employees.size();
			
			System.out.println("부서명: " + key);
			System.out.println("총급여: " + totalSalary);
			System.out.println("평균 급여: " +averageSalary);
			System.out.println();
		}
	}
	
	// 정적 내부 클래스(클래스 안에 클래스를 만들 수 있다.)
	// static을 붙이면 정적 클래스
	static class Employee {
		private String dept;
		private String name;
		private int salary;
		
		public Employee(String dept, String name, int salary) {
			this.dept = dept;
			this.name = name;
			this.salary = salary;
		}

		public String getDept() {
			return dept;
		}

		public String getName() {
			return name;
		}

		public int getSalary() {
			return salary;
		}
		
		
	}
}
