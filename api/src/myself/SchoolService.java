package myself;

public class SchoolService {
	
	private Student[] students = new Student[5];
	private int position = 0;
	private int limit = students.length;
	private final int size = 5;
	
	// insertStudent 학생등록서비스
	public boolean insertStudent(Student student) {
		boolean isSuccess = false;
		
		if(!isExist(student.getName())) {
			students[position] = student;
			position++;
			isSuccess = true;
			
			resize();
		}
		return isSuccess;
	}


	private void resize() {			//length의 길이 늘이기
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
	
	// 이름과 학생 성적정보를 매치해서 저장하는 것
	
	public boolean insertScore(String name, Score score) {
		if(!isExist(name)) {
			return false;
		}
		Student student = findStudentByName(name);
		student.setScore(score);
		
		return true;
	}
	
	public Student[] getAllStudent() {
		if(position == 0) {
			return new Student[0];
		}
		return students;
	}


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
	
	public boolean updateScore(String name, Score score) {
		if(!isExist(name)) {
			return false;
		}
		Student student = findStudentByName(name);
		if(student.getName() == null) {
			return false;
		}
		student.setScore(score);
		return true;
	}
	
	public boolean deleteStudent(String name) {
		if(!isExist(name)) {
			return false;
		}
		int foundIndex = findIndexByName(name);
		moveToLeft(foundIndex + 1);
		return true;
	}

	// 배열의 위치에 저장이 되어있는 것들 중 하나를 지우면 비는 공간에 뒤에 배열에 있던 것들은 앞으로 밀어서 넣어서 저장하기
	// 밀어서 저장하기.
	private void moveToLeft(int beginindex) {
		for(int index = beginindex; index < position; index++) {
			students[index -1] = students[index];
		}
		students[position -1] = null;
		position--;
	}


	private int findIndexByName(String name) {
		for(int index = 0; index < position; index++) {
			Student student = students[index];
			if(student.getName().equals(name)) {
				return index;
			}
		}
		return -1;
	}

}
