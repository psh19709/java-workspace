package day19.school;

//import java.util.Arrays;

public class SchoolService {

	private Student[] students = new Student[5];
	private int position = 0;
	private int limit = students.length;
	private final int size = 5;
	
	
	// 학생정보 등록 서비스
	//			학생정보를 전달받아서 같은 이름의 학생이 있으면 false를 반환한다.
	//			같은 이름의 학생이 존재하지 않으면 배열에 학생정보를 저장하고, true를 반환한다.
	/*
	 *  1. 반환타입에 해당하는 변수를 정의하고, 변수에 해당 타입의 기본값을 대입한다.		// 이게 무슨 말인지 모르겠음
	 *  1-1. 매개변수 인자로 전달받은 객체와 같은 이름의 Student 객체가 배열에 저장되어 있는지 검사한다.
	 *  	검사하기
	 *  			존재하는지 여부를 저장하는 불리나입의 변수를 정의하고, false을 기본값으로 대입한다.
	 *  			향상된 for문으로 배열에의 각 칸에 저장된 Student객체를 하나씩 가져온다.
	 *  				반복문내에서 매개변수로 전달받은 학생의 이름과  , 배열에서 순서대로 꺼낸 Student객체의 학생이름이 일치하는지 검사한다.
	 *  				일치하는 경우가 발생하면 존재하는지 여부를 저장하는 변수에 true를 대입한다.
	 *  1-2. 존재하는지 여부를 저장하는 변수의 값이 참(true)이면 아래 수행문을 실행한다.
	 *  2. 매개변수 인자로 전달받은 Student 객체를 students배열에 저장한다.
	 *  	배열의 저장위치는 position값이다.
	 *  3. position의 값을 1 증가시킨다.
	 *  4. 1번에서 정의한 변수의 값을 반환한다.
	 */
	public boolean insertStudent(Student student) {
		//Student student = new Student();
		boolean isSuccess = false;				// 1번에 해당
		
		if(!isExist(student.getName())) {
			students[position] = student;
			position++;
			isSuccess = true;
			
			resize();
		} 
		//System.out.println(Arrays.toString(students));		// 단순 값이 잘 들어갔는지 확인 코드
		return isSuccess;
	}
	
	/*
	 *  1. 전달받은 이름의 학생이 존재하는지 확인하기
	 *  		존재하지 않으면 false를 실행
	 *  2. 배열에서 전달받은 이름과 일치하는 학생정보를 찾아온다.
	 *  		검색된 학생정보를 저장하는 변수를 선언한다.
	 *  		향상된 for문안에서 전달받은 이름과 같은 이름의 학생정보를 가져와서 위에서 선언한 변수에 대입한다.
	 *  3. 조회된 Student객체의 score변수에 전달받은 Score객체를 저장한다.
	 *  4. true를 반환한다.
	 */
	public boolean insertScore(String name, Score score) {
		if(!isExist(name)) {
			return false;
		} 
		Student student = findStudentByName(name);
		student.setScore(score);
		
		//System.out.println(Arrays.toString(students));		// 단순 값이 잘 들어갔는지 확인 코드
		return true;
	}

	
	public Student[] getAllStudent() {
		if(position == 0) {
			return new Student[0];
		}
		return students;
	}
	
	
	/*
	 *  1. 검색된 학생정보를 저장할 변수에 생성한다.
	 *  2. 향상된 for문을 사용해서 배열에 저장된 Student객체를 반복 처리한다.
	 *  	매개변수로 전달받은 이름과 배열에서 조회한 Student 객체의 이름이 일치하면 1번에서 선언한 변수에 Student객체를 저장한다.
	 *  3. 발견된 학생정보를 반환한다. 이름과 일치하는 학생정보가 없으면 null값을 반환한다.
	 */
	public Student findStudentByName(String name) {
		Student foundStudent = null;
			for(Student item : students) {
				if(item == null) {
					break;
				} 
				if(item.getName().equals(name)) {
					foundStudent = item;
					break;
				}
				
			}
			return foundStudent;
	}
	
	
	/*
	 * 1. 매개변수로 전달받은 이름에 해당하는 학생정보가 배열에 존재하는지 체크한다.
	 * 		학생정보가 존재하지 않으면 false를 반환한다.
	 * 2. 이름으로 학생정보를 조회한다.
	 * 3. 2번에서 조회한 학생정보에서 성적정보를 조회한다.
	 * 4. 3번에서 조회한 성적정보가 null이면 false를 반환한다.
	 * 5. 2번에서 조회한 학생의 성적정보를, 매개변수로 전달받은 성적정보로 변경한다.
	 * 6. true값을 반환한다.
	 */
	public boolean updateScore(String name, Score score) {
		if(!isExist(name)) {
			return false;			//학생정보가 존재하지 않음
		}
		Student student = findStudentByName(name);		// 여기부터는 혼자 하지 못함
		if(student.getScore() == null) {
			return false;			// 성적정보가 등록되지 않은 학생
		}
		
		student.setScore(score);
		
		return true;
	}
	
	/*
	 *  1. 전달받은 이름과 일치하는 학생정보가 없으면 false를 반환한다.
	 *  2. 이름과 일치하는 학생정보가 몇번째 위치하는지 알아낸다.
	 *  3. 해당 위치 다음부터 한칸씩 앞으로 이동시켜서 학생정보를 삭제시킨다.
	 *  4. true를 반환한다.
	 */
	public boolean deleteStudent(String name) {
		if(!isExist(name)) {
			return false;
		}
		int foundIndex = findIndexByName(name);		//2번
		moveToLeft(foundIndex + 1); 				//3번
		return true;
	}
	
	private void resize() {				// 크기 늘리기
		if(position == limit) {
			limit += size;
			Student[] dest = new Student[limit];
			System.arraycopy(students, 0, dest, 0, students.length);
			students = dest;
		}
	}

	private boolean isExist(String name) {
		boolean isStudentExist = false;
		for(Student item : students) {
			if(item == null) {
				break;
			} 
			if(name.equals(item.getName())) {
				isStudentExist = true;
				break;
			}
		}
		return isStudentExist;
	}
	
	/**
	 * 이름을 전달받아서 이름과 일치하는 학생정보가 저장된 배열의 인덱스를 반환한다.
	 * @param name	학생이름
	 * @return	배열의 인덱스, 일치하는 학생정보가 없으면 -1를 반환한다.
	 */
	private int findIndexByName(String name) {
		for (int index = 0; index < position; index++) {
			Student student = students[index];
			if(student.getName().equals(name)) {
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 지정된 시작위치부터 마지막 데이터까지 한 칸씩 왼쪽으로 이동시킨다.
	 * <p>맨 마지막번째 객체가 저장된 곳을 null로 변경하고, position값도 1 감소시킨다. 
	 * @param beginindex	이동 시작위치
	 */
		
	private void moveToLeft(int beginindex) {
		for(int index = beginindex; index < position; index++) {
			students[index -1] = students[index];
		}
		students[position -1] = null;
		position--;
	}

	// 성적정보 등록 서비스
	//			학생이름과 성적정보를 전달받아서 같은 이름의 학생이 없으면 false를 반환한다.
	//			같은 이름의 학생이 존재하면 그 학생의 성적 정보를 추가한다.
	
	
	
	// 학생정보 조회 서비스
	
	// 학생정보 상세 조회 서비스
	
	// 학생정보 변경 서비스
	
	// 성적 정보 변경 서비스
}
