package day26.app.controller;

import java.util.List;

import day26.app.exception.SchoolException;
import day26.app.service.CourseRequestService;
import day26.app.vo.Course;
import utils.KeyboardReader;

public class CourseRequestController {
	
	KeyboardReader keybaord = new KeyboardReader();
	private CourseRequestService service = new CourseRequestService();
	
	public void 실행() {
		메뉴();
	}
	
	private void 메뉴() {
		while(true) {
			try {
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				System.out.println("1.강좌등록 2.학생등록 3.모든강좌출력 4.강좌상세정보출력 5.수강신청목록출력 ");
				System.out.println("6.수강신청 7.수강취소 8.나의수강목록 출력 9.강좌별수강신청현황출력 10.교수별 수강신청현황출력 0.종료");
				System.out.println("---------------------------------------------------------------------------------------------------------------");
			
				System.out.println("## 메뉴선택: ");
				int menuNo = keybaord.getInt();
				
				switch(menuNo) {
				case 1 : 강좌등록(); break;
				case 2 : 학생등록(); break;
				case 3 : 모든강좌출력(); break;
				case 4 : 강좌상세정보출력(); break;
				case 5 : 수강신청목록출력(); break;
				case 6 : 수강신청(); break;
				case 7 : 수강취소(); break;
				case 8 : 나의수강목록출력(); break;
				case 9 : 강좌별수강신청현황출력(); break;
				case 10 : 교수별수강신청현황출력(); break;
				case 0 : System.exit(0); break;
				}
		} catch (SchoolException ex) {
			System.out.println("### [오류] " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("### [오류] 알 수없는 오류가 발생하였습니다.");
		}
		System.out.println();
		System.out.println();
		System.out.println();
			
		}
	}
	
	private void 강좌등록() {
		System.out.println("<< 강좌 등록 >> ");
		
		System.out.print("## 강좌코드 입력: ");
		String code = keybaord.getString();
		System.out.print("## 강좌제목 입력: ");
		String title = keybaord.getString();
		System.out.print("## 담당학과 입력: ");
		String dept = keybaord.getString();
		System.out.print("## 해당학년 입력: ");
		int grade = keybaord.getInt();
		System.out.print("## 담당교수 입력: ");
		String professor = keybaord.getString();
		System.out.print("## 모집정원 입력: ");
		int quota = keybaord.getInt();
		
		Course course = new Course(code, title, dept, grade, professor, quota);
		service.addCourse(course);
		
		System.out.println("### [완료] 강좌가 등록되었씁니다.");
	}
	
	private void 학생등록() {
		
	}
	
	private void 모든강좌출력() {
		System.out.println(" << 모든 강좌 정보 출력 >>");
		
		List<Course> courses = service.getAllCourse();
		
		System.out.println("코드\t제목\t\t담당교수\t정원\t신청자");
		for(Course course : courses) {
			System.out.print(course.getCode() + "\t");
			System.out.print(course.getTitle() + "\t");
			System.out.print(course.getProfessor() + "\t");
			System.out.print(course.getQuota() + "\t");
			System.out.println(course.getReqCount() + "\t");
		}
	}
	
	// 강좌번호를 잘못 입력할 수 있음 - 강좌정보 조회불가 (오류)
	private void 강좌상세정보출력() {
		System.out.println("<< 강좌 상제 정보 출력 >>");
		
		System.out.print("## 강좌코드 입력");
		String code = keybaord.getString();
		
		Course course =  service.getCourseDetail(code);
		System.out.println("강좌코드 : " + course.getCode());
		System.out.println("강좌제목 : " + course.getTitle());
		System.out.println("담당학과 : " + course.getDept());
		System.out.println("해당학년 : " + course.getGrade());
		System.out.println("담당교수 : " + course.getProfessor());
		System.out.println("모집정원 : " + course.getQuota() + "명");
		System.out.println("신청자수 : " + course.getReqCount() + "명");
	}
	
	private void 수강신청목록출력() {
		
	}
	
	// 아이디 혹은 강좌코드를 잘못입력 - 오류
	private void 수강신청() {
		
	}
	
	// 순번을 잘못입력 - 오류
	private void 수강취소() {
		
	}
	
	// 아이디를 잘못입력 - 오류
	private void 나의수강목록출력() {
		
	}
	
	// 강좌코드를 잘못입력 - 오류
	private void 강좌별수강신청현황출력() {
		
	}
	
	// 교수이름 잘못입력 - 오류
	private void 교수별수강신청현황출력() {}
	
	
}
