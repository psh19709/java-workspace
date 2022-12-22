package day26.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import day26.app.exception.SchoolException;
import day26.app.vo.Course;
import day26.app.vo.CourseRequest;
import day26.app.vo.Student;

public class CourseRequestService {

	
	private List<Course> coursrList = new ArrayList<>();
	private List<Student> studentList = new ArrayList<>();
	private List<CourseRequest> courseRequestList = new ArrayList<>();
	
	private AtomicInteger atom = new AtomicInteger(1001);
	
	
	public CourseRequestService() {
		addCourse(new Course("C_001", "컴퓨터일반", "컴공", 1, "김교수", 10));
		addCourse(new Course("C_002", "프로그램기초", "컴공", 2, "이교수", 10));
		addCourse(new Course("C_003", "프로그램응용", "컴공", 3, "박교수", 10));
		addCourse(new Course("C_004", "데이터베이스", "컴공", 4, "김교수", 10));
		addCourse(new Course("C_005", "동역학 기초", "기계", 1, "최교수", 10));
		addCourse(new Course("C_006", "정역학 기초", "기계", 2, "홍교수", 10));
		addCourse(new Course("C_007", "열역학 기초", "기계", 3, "정교수", 10));
	
		addStudent(new Student("hong", "홍길동", "컴공", 1));
		addStudent(new Student("kim", "김유신", "컴공", 1));
		addStudent(new Student("kang", "강감찬", "기계", 1));
	}
	
	public void addCourse(Course course) {
		// 등록된 강좌중ㅇ에서 새 강좌와 같은 강좌코드가 있는지 확인하고, 같은 강좌코드를 가진 강좌가 등록되지 않게 한다.
		for(Course savedCorse : coursrList) {
			String savedCourseCode = savedCorse.getCode();
			String code = course.getCode();
			
			if(savedCourseCode.equals(code)) {
				throw new SchoolException("강좌코드 증복: " + code + ", 동일한 강좌코드가 이미 등록되어 있습니다.");
			}
			
		}
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public List<Course> getAllCourse(){
		return coursrList;
	}
	
	public Course getCourseDetail(String code) {
		for(Course course : coursrList) {
			if(course.getCode().equals(code)) {
				return course;
			}
		}
		throw new SchoolException("강좌코드: " + code + ", 강좌정보가 존재하지 않습니다.");
	}
}
