package app.controller;

import java.util.List;
import java.util.Map;

import app.exception.SchoolException;
import app.service.CourseRequestService;
import app.vo.Course;
import app.vo.CourseRequest;
import app.vo.Student;
import utils.KeyboardReader;

public class CourseRequestController {
	
	private KeyboardReader keyboard = new KeyboardReader();
	private CourseRequestService service = new CourseRequestService();

	public void 실행() {
		메뉴();
	}
	
	private void 메뉴() {
		while(true) {
			try {
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("1.강좌등록 2.학생등록 3.모든강좌출력 4.강좌상세정보출력  ");
				System.out.println("5.수강신청 6.수강취소 7.나의수강목록출력 8.강좌별현황출력 9.교수별현황출력 0.종료");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println();
				
				System.out.print("## 메뉴선택: ");
				int menuNo = keyboard.getInt();
				System.out.println();
				
				switch(menuNo) {
					case 1: 강좌등록(); break;
					case 2: 학생등록(); break;
					case 3: 모든강좌출력(); break;
					case 4: 강좌상세정보출력(); break;
					case 5: 수강신청(); break;
					case 6: 수강취소(); break;
					case 7: 나의수강목록출력(); break;
					case 8: 강좌별수강신청현황출력(); break;
					case 9: 교수별수강신청현황출력(); break;
					case 0: System.exit(0);
				}
			} catch (SchoolException ex) {
				System.out.println("### [오류] " + ex.getMessage());
			} catch (Exception ex) {
				System.out.println("### [오류] 알 수 없는 오류가 발생하였습니다.");
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	
	private void 강좌등록() {
		System.out.println("<< 신규 강좌 등록 >>");
		System.out.println();
		
		System.out.print("## 강좌코드 입력: ");
		String code = keyboard.getString();
		System.out.print("## 강좌제목 입력: ");
		String title = keyboard.getString();
		System.out.print("## 담당학과 입력: ");
		String dept = keyboard.getString();
		System.out.print("## 해당학년 입력: ");
		int grade = keyboard.getInt();
		System.out.print("## 담당교수 입력: ");
		String professor = keyboard.getString();
		System.out.print("## 모집정원 입력: ");
		int quota = keyboard.getInt();
		System.out.println();
		
		Course course = new Course(code, title, dept, grade, professor, quota);
		service.addCourse(course);
		
		System.out.println("### [완료] 강좌가 등록되었습니다.");
	}
	
	private void 학생등록() {
		System.out.println("<< 신규 학생 등록 >>");
		System.out.println();
		
		System.out.print("## 아이디 입력: ");
		String id = keyboard.getString();
		System.out.print("## 이름 입력: ");
		String name = keyboard.getString();
		System.out.print("## 학과 입력: ");
		String dept = keyboard.getString();
		System.out.print("## 학년 입력: ");
		int grade = keyboard.getInt();
		System.out.println();
		
		Student student = new Student(id, name, dept, grade);
		service.addStudent(student);
		
		System.out.println("### [완료] 학생이 등록되었습니다.");
	}
	
	private void 모든강좌출력() {
		System.out.println("<< 모든 강좌정보 출력 >>");
		System.out.println();
		
		List<Course> courses = service.getAllCourse();
		System.out.println("코드\t제목\t\t담당교수\t정원\t신청자");
		for (Course course : courses) {
			System.out.print(course.getCode() + "\t");
			System.out.print(course.getTitle() + "\t");
			System.out.print(course.getProfessor() + "\t");
			System.out.print(course.getQuota() + "\t");
			System.out.println(course.getReqCount());
		}
	}
	
	private void 강좌상세정보출력() {
		System.out.println("<< 강좌 상세 정보 출력 >>");
		System.out.println();
		
		System.out.print("## 강좌코드 입력: ");
		String code = keyboard.getString();
		System.out.println();
		
		Course course = service.getCourseDetail(code);
		System.out.println("### 강좌 상세정보");
		System.out.println("강좌코드 : " + course.getCode());
		System.out.println("강좌제목 : " + course.getTitle());
		System.out.println("담당학과 : " + course.getDept());
		System.out.println("해당학년 : " + course.getGrade());
		System.out.println("담당교수 : " + course.getProfessor());
		System.out.println("모집정원 : " + course.getQuota() + "명");
		System.out.println("신청자수 : " + course.getReqCount() + "명");
	}
	
	private void 수강신청() {
		System.out.println("<< 수강 신청 >>");
		System.out.println();
		
		System.out.print("## 강좌코드 입력: ");
		String code = keyboard.getString();
		System.out.print("## 학생 아이디 입력: ");
		String id = keyboard.getString();
		
		service.addCourseRequest(code, id);
		
		System.out.println("### [완료] 수강신청이 완료되었습니다.");
	}
	
	private void 수강취소() {
		System.out.println("<< 수강 취소 >>");
		System.out.println();
		
		System.out.print("## 수강신청 순번 입력: ");
		int no = keyboard.getInt();
		
		service.cancelCourseRequest(no);
		
		System.out.println("### [완료] 수강취소가 완료되었습니다.");
	}
	
	private void 나의수강목록출력() {
		System.out.println("<< 나의 수강신청 목록 출력 >>");
		System.out.println();
		
		System.out.print("## 아이디 입력: ");
		String id = keyboard.getString();
		System.out.println();
		
		List<CourseRequest> courseRequestList = service.getMyCourseRequestList(id);
		if (courseRequestList.isEmpty()) {
			throw new SchoolException("학생 아이디: " + id + ", 해당 학생이 수강신청한 과목이 존재하지 않습니다.");
		}
		
		System.out.println("순번\t코드\t제목\t\t학과\t담당교수\t취소여부");
		for (CourseRequest courseRequest : courseRequestList) {
			System.out.print(courseRequest.getNo() + "\t");
			System.out.print(courseRequest.getCode() + "\t");
			System.out.print(courseRequest.getTitle() + "\t");
			System.out.print(courseRequest.getDept() + "\t");
			System.out.print(courseRequest.getProfessor() + "\t");
			System.out.println(courseRequest.isCanceled());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void 강좌별수강신청현황출력() {
		System.out.println("<< 강좌별 수강신청 현황 출력 >>");
		System.out.println();
		
		System.out.print("## 강좌코드 입력: ");
		String code = keyboard.getString();
		System.out.println();
		
		Map<String, Object> map = service.getCourseSummary(code);
		Course course = (Course) map.get("course");
		List<Student> requestStudentList = (List<Student>) map.get("students");
		
		System.out.println("### 강좌 상세정보");
		System.out.println("강좌코드 : " + course.getCode());
		System.out.println("강좌제목 : " + course.getTitle());
		System.out.println("담당학과 : " + course.getDept());
		System.out.println("해당학년 : " + course.getGrade());
		System.out.println("담당교수 : " + course.getProfessor());
		System.out.println("모집정원 : " + course.getQuota() + "명");
		System.out.println("신청자수 : " + course.getReqCount() + "명");
		System.out.println();
		
		if (!requestStudentList.isEmpty()) {
			System.out.println("### 수강 신청 학생 목록");
			System.out.println("아이디\t이름\t학과\t학년");
			for (Student student : requestStudentList) {
				System.out.print(student.getId() + "\t");
				System.out.print(student.getName() + "\t");
				System.out.print(student.getDept() + "\t");
				System.out.println(student.getGrade());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void 교수별수강신청현황출력() {
		System.out.println("<< 교수별 수강신청 현황 출력 >>");
		System.out.println();
		
		System.out.print("## 교수이름 입력: ");
		String professor = keyboard.getString();
		System.out.println();
		
		List<Map<String, Object>> result = service.getProfessorSummary(professor);
		for (Map<String, Object> map : result) {
			Course course = (Course) map.get("course");
			System.out.println("### 강좌 상세정보");
			System.out.println("강좌코드 : " + course.getCode());
			System.out.println("강좌제목 : " + course.getTitle());
			System.out.println("담당학과 : " + course.getDept());
			System.out.println("해당학년 : " + course.getGrade());
			System.out.println("담당교수 : " + course.getProfessor());
			System.out.println("모집정원 : " + course.getQuota() + "명");
			System.out.println("신청자수 : " + course.getReqCount() + "명");
			System.out.println();
			
			System.out.println("### 수강 신청 학생 목록");
			List<Student> requestStudentList = (List<Student>) map.get("students");
			if (!requestStudentList.isEmpty()) {
				System.out.println("아이디\t이름\t학과\t학년");
				for (Student student : requestStudentList) {
					System.out.print(student.getId() + "\t");
					System.out.print(student.getName() + "\t");
					System.out.print(student.getDept() + "\t");
					System.out.println(student.getGrade());
				}
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
	
}
