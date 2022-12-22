package day23.collection.app2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import day23.collection.app2.vo.CourseRequest;
import day23.collection.app2.vo.Student;
import day23.collection.app2.vo.Subject;

public class SystemService {
	
	private static AtomicInteger atom = new AtomicInteger(1000);
	private List<Subject> subjectList = new ArrayList<>();
	private List<Student> studentList = new ArrayList<>();
	private List<CourseRequest> courseRequests = new ArrayList<>();
	
	public SystemService() {
		
		// 과목 생성(코드, 제목, 학과, 학년, 담당교수, 모집정원)
		subjectList.add(new Subject(atom.getAndIncrement(), "경영학입문", "경영학과", "1학년", "이순신", 45));
		subjectList.add(new Subject(atom.getAndIncrement(), "경영학응용", "경영학과", "2학년", "김민재", 30));
		subjectList.add(new Subject(atom.getAndIncrement(), "마케팅입문", "경영학과", "3학년", "이순신", 25));
		subjectList.add(new Subject(atom.getAndIncrement(), "마케팅응용", "경영학과", "4학년", "유희관", 15));
		subjectList.add(new Subject(atom.getAndIncrement(), "자바처음", "전자공학과", "1학년", "강감찬", 30));
		subjectList.add(new Subject(atom.getAndIncrement(), "자바입문", "전자공학과", "2학년", "강감찬", 30));
		subjectList.add(new Subject(atom.getAndIncrement(), "자바응용", "전자공학과", "3학년", "홍길동", 15));
		subjectList.add(new Subject(atom.getAndIncrement(), "AWS입문", "전자공학과", "4학년", "이재원", 20));
		subjectList.add(new Subject(atom.getAndIncrement(), "C++", "컴퓨터공학과", "1학년", "이정재", 10));
		subjectList.add(new Subject(atom.getAndIncrement(), "오라클입문", "컴퓨터공학과", "2학년", "정우성", 12));
		subjectList.add(new Subject(atom.getAndIncrement(), "오라클응용", "컴퓨터공학과", "3학년", "이우성", 10));
		subjectList.add(new Subject(atom.getAndIncrement(), "스프링부트", "컴퓨터공학과", "4학년", "정현호", 10));
		
		// 학생 생성(아이디, 학생이름, 학생학과, 학생 학년)
		studentList.add(new Student(1111, "이영빈", "경영학과", "1학년"));
		studentList.add(new Student(2222, "이승엽", "전자공학과", "2학년"));
		studentList.add(new Student(3333, "이대호", "컴퓨터공학과", "3학년"));
		studentList.add(new Student(4444, "전준우", "경영학과", "1학년"));
		studentList.add(new Student(5555, "박성한", "전자공학과", "1학년"));
		studentList.add(new Student(6666, "한유섬", "컴퓨터공학과", "1학년"));
		studentList.add(new Student(7777, "최정", "경영학과", "4학년"));
		
	}
	
		// 신규 학생 등록하기
		public boolean addStudent(Student student) {
		Student saveStudent = getStudentId(student.getId());
			if(saveStudent != null) {
				return false;
			}
			studentList.add(student);
			
			return true;
	}

		public Student getStudentId(int id) {
			for(Student student : studentList) {
				if(student.getId() == id) {
					return student;
				}
			}
			return null;
		}
		
		// 모든강좌전체 목록 제공하기
		
		public List<Subject>getAllSubjects(){
			return subjectList;
		}
		
		// 강좌 상세 정보 제공하기
		
		public Subject getSubjectDetail(int code) {
			for(Subject subject : subjectList) {
				if(subject.getCode() == code) {
					return subject;
				}
			}
			return null;
		}
		
		// 학생별 수강신청 내역
		
		public List<Student> getCourseRequestByDeptGrade(String studentDept, String studentGrade){
			List<Student> studentCourseRequestList = new ArrayList<>();
			
			for(Student student : studentList) {
				if(student.getDept().equals(studentDept)) {
					studentCourseRequestList.add(student);
				}
			}
			
			return studentCourseRequestList;
		}

}
