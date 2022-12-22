package day22.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetApp3 {
	
	public static void main(String[] args) {
		
		Set<Employee> employeeSet = new HashSet<>();		
		// 사원번호를 기준으로 사원번호가 같으면 같은 값이라고 판단해서 한번만 출력되게 만들었다. HashCode를 재정의한 이유다.
		employeeSet.add(new Employee(10, "영업1팀", "이순신", 350));
		employeeSet.add(new Employee(11, "영업1팀", "이재원", 60));
		employeeSet.add(new Employee(90, "영업1팀", "김원형", 300));
		employeeSet.add(new Employee(44, "영업1팀", "이대호", 500));
		employeeSet.add(new Employee(66, "영업1팀", "안치홍", 450));
		employeeSet.add(new Employee(34, "영업1팀", "이정후", 410));
		employeeSet.add(new Employee(87, "영업1팀", "한유섬", 470));
		

		// HashSet객체에 저장된 Employee객체를 향상된 for문을 이용해서 반복처리하기
		for(Employee emp : employeeSet) {
			System.out.println("사원번호: " + emp.getNo());
			System.out.println("소속부서: " + emp.getDept());
			System.out.println("이름: " + emp.getName());
			System.out.println("급여: " + emp.getSalary());
			System.out.println();
		}
		
		// HashSet객체에 저장된 사원들의 총 급여 계산하기
		System.out.println(" ###사원들의 총 급여 계산하기");
		int totalSalary = 0;
		for(Employee emp : employeeSet) {
			totalSalary += emp.getSalary();
		}
		System.out.println("총 급여: " + totalSalary);
	}

}
