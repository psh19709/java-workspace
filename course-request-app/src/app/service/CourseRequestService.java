package app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import app.exception.SchoolException;
import app.vo.Course;
import app.vo.CourseRequest;
import app.vo.Student;

public class CourseRequestService {

	private List<Course> courseList = new ArrayList<>();
	private List<Student> studentList = new ArrayList<>();
	private List<CourseRequest> courseRequestList = new ArrayList<>();
	
	private AtomicInteger atom = new AtomicInteger(1001);
	
	public CourseRequestService() {
		addCourse(new Course("C_001", "컴퓨터 일반", "컴공", 1, "김교수", 10));
		addCourse(new Course("C_002", "프로그램 기초", "컴공", 1, "이교수", 10));
		addCourse(new Course("C_003", "프로그램 응용", "컴공", 1, "박교수", 10));
		addCourse(new Course("C_004", "데이터베이스", "컴공", 1, "김교수", 10));
		addCourse(new Course("C_005", "동역학 기초", "기계", 1, "최교수", 10));
		addCourse(new Course("C_006", "정역학 기초", "기계", 1, "홍교수", 10));
		addCourse(new Course("C_007", "열역학 기초", "기계", 1, "정교수", 10));
		
		addStudent(new Student("hong", "홍길동", "컴공", 1));
		addStudent(new Student("kim", "김유신", "컴공", 1));
		addStudent(new Student("lee", "이재원", "체공", 1));
	}
	
	/*
	 *  과정 등록 시나리오
	 *  1. 신규 강좌정보(Course 객처)를 전달받는다.
	 *  2. 신규 강좌정보코드와 같은 코드로 등록된 강좌가 존재하면 예외를 발생시킨다.
	 *  3. 같은 코드가 존재하지 않으면 신규 강좌정보를 ArrayList에 추가한다.
	 */
	public void addCourse(Course course) {
		for (Course savedCourse : courseList) {
			String savedCourseCode = savedCourse.getCode();
			String code = course.getCode();
			
			// 같은 코드가 존재하면 예외를 발생시킨다.
			if (savedCourseCode.equals(code)) {
				throw new SchoolException("강좌코드 중복: " + code + ", 동일한 강좌코드가 이미 등록되어 있습니다.");
			}
		}
		
		courseList.add(course);
	}
	
	/*
	 *  학생 등록 시나리오
	 *  1. 신규 학생정보(Student 객체)를 전달받는다.
	 *  2. 신규 학생의 아이디와 같은 아이디로 등록된 학생정보가 존재하면 예외를 발생시킨다.
	 *  3. 같은 아이디가 존재하지 않으면 신규 학생정보를 ArrayList에 추가한다.
	 */
	public void addStudent(Student student) {
		for (Student savedStudent : studentList) {
			String savedId = savedStudent.getId();
			String id = student.getId();
			
			// 동일한 아이디가 존재하면 예외를 발생시킨다.
			if (savedId.equals(id)) {
				throw new SchoolException("학생 아이디 중보: " + id + ", 동일한 아이디의 학생정보가 이미 등록되어 있습니다.");
			}
		}
		
		studentList.add(student);
	}
	
	/*
	 *  모든 개설 강좌정보를 제공하는 시나리오
	 *  1. 강좌정보가 저장된 ArrayList객체를 참조하는 참조변수의 주소값을 반환한다.
	 */
	public List<Course> getAllCourse() {
		return courseList;
	}
	
	/*
	 * 강좌상세정보를 제공하는 시나리오
	 * 1. 조회할 강좌코드를 전달받는다.
	 * 2. 개설 강좌정보가 저장된 ArrayList의 모든 강좌정보의 코드와 전달받은 코드를 비교한다.
	 * 3. 같은 코드가 존재하면 , 해당 강좌정보를 반환한다.
	 * 4. ArrayList에 저장된 모든 강좌정보를 조사했는데, 동일한 코드의 강좌정보가 존재하지 않으면 예외를 발생시킨다.
	 */
	public Course getCourseDetail(String code) {
		for (Course savedCourse : courseList) {
			// 조회할 강좌코드와 저장된 강좌의 코드가 일치하면 해당 강좌정보를 반환하고, 메소드를 종료한다.
			if (savedCourse.getCode().equals(code)) {
				return savedCourse;
			}
		}
		
		// 같은 코드를 가진 강좌정보가 존재하지 않으므로 예외를 발생시킨다.
		throw new SchoolException("강좌코드: " + code + ", 강좌정보가 존재하지 않습니다.");
	}

	/*
	 *  수강 신청 시나리오
	 *  1. 강좌코드와 학생아이디를 전달받는다.
	 *  2. 강좌코드로 강좌정보를 조회한다.
	 *  3. 학생아이디로 학생정보를 조회한다.
	 *  4. 해당 강좌의 모집 정원과 신청자수가 동일하면 예외를 발생시킨다.
	 *  5. 해당 강좌를 이미 수강신청했으면 예외를 발생시킨다.
	 *  6. 수강신청정보를 저장하는 CourseRequest객체를 생성한다.
	 *  7. 2번과, 3번에서 획득한 강좌정보와 학생정보에서 필요한 정보를 가져와서 생성된 CourseRequest객체에 저장한다.
	 *  8. 수강신청정보가 저장된 CourseRequest객체를 ArrayList에 저장한다.
	 *  9. 2번에서 획득한 강좌정보의 신청자수를 1증가시킨다.
	 */
	public void addCourseRequest(String code, String id) {		// 수강 신청
		// 강좌 정보와 학생 정보를 조회한다.
		Course course = getCourseDetail(code);
		Student student = getStudentDetail(id);
		
		// 조횐된 강좌정보의 모집정원과 신청자수가 일치하면 예외를 발생시킨다.
		if (course.getQuota() == course.getReqCount()) {
			throw new SchoolException("정원 초과: " + code + ", 이 강좌는 모집이 완료되었습니다.");
		}

		// 전달받은 강좌코드와 학생 아이디를 이미 등록된 수강신청정보와 비교해서 수강신청정보가 존재하는지 확인하고, 존재하면 예외를 발생시킨다.
		if (isAlreadyCourseRequest(code, id)) {
			throw new SchoolException("수강신청 중복: " + code + ", " + id + ", 이미 신청한 강좌입니다.");
		}
		 
		// 신규 수강신청정보를 저장할 CourseRequest 객체를 생성하고, 위에서 조회된 강좌정보와 학생정보에서 필요한 정보를 가져와서 저장한다.
		CourseRequest courseRequest = new CourseRequest();
		courseRequest.setNo(atom.getAndIncrement());
		courseRequest.setCode(course.getCode());
		courseRequest.setTitle(course.getTitle());
		courseRequest.setDept(course.getDept());
		courseRequest.setGrade(course.getGrade());
		courseRequest.setProfessor(course.getProfessor());
		courseRequest.setId(student.getId());
		courseRequest.setName(student.getName());
		
		// 신규 수강신청정보를 ArrayList에 저장한다.
		courseRequestList.add(courseRequest);		
		
		// 해당 강좌의 신청자수를 1증가시킨다.
		course.setReqCount(course.getReqCount() + 1);
	}
	
	private Student getStudentDetail(String id) {
		for (Student student : studentList) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		throw new SchoolException("학생아이디: " + id + ", 학생정보가 존재하지 않습니다.");
	}
	
	private boolean isAlreadyCourseRequest(String code, String id) {
		for (CourseRequest courseRequest : courseRequestList) {
			if (courseRequest.getCode().equals(code) && courseRequest.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * 수강취소 시나리오 
	 * 1. 수강신청 순번을 전달받는다.
	 * 2. 해당 수강신청 순번으로 수강신청정보가 존재하는지 확인하고, 존재하지 않으면 예외를 발생시킨다.
	 * 3. 수강신청 순번에 해당하는 수강신청정보를 조회한다.
	 * 4. 수강신청정보의 취소여부가 이미 true로 설정되어 있으면 예외를 발생시킨다.
	 * 5. 수강신청정보의 취소여부를 true로 변경한다.
	 * 6. 수강신청정보의 강좌코드로 강좌정보를 조회한다.
	 * 7. 강좌정보의 신청자수를 1감소시킨다. 
	 */
	public void cancelCourseRequest(int no) {		// 수강취소
		// 수강신청 순번에 해당하는 수강신청정보가 존재하지 않으면 예외를 발생시킨다.
		if (!isExistCourseRequest(no)) {
			throw new SchoolException("수강신청 순번: " + no + ", 수강신청 정보가 존재하지 않습니다.");
		}
		// 수강신청 순번에 해당하는 수강신청정보를 조회하고, 수강취소여부가 true로 설정되어 있으면 예외를 발생시킨다.
		CourseRequest courseRequest = getCourseRequest(no);
		if (courseRequest.isCanceled()) {
			throw new SchoolException("수강신청 순번: " + no + ", 이미 수강취소 처리된 강좌입니다.");
		}
		// 수강신청정보의 취소여부를 true로 설정한다.
		courseRequest.setCanceled(true);
		
		// 수강신청정보의 강좌코드로 강좌정보를 조회하고, 해당 강좌의 신청자수를 1감소시킨다.
		Course course = getCourseDetail(courseRequest.getCode());
		course.setReqCount(course.getReqCount() - 1);
	}

	/*
	 * 내가 수강신청한 강좌 조회하기 시나리오
	 * 1. 학생 아이디를 전달받는다.
	 * 2. 수강신청정보를 저장한 ArrayList객체를 생성한다.
	 * 3. 수강신청리스트에 수강신청정보 중에서 학생아이디가 일치하는 정보를 찾아서 2번에서 생성한 ArrayList객체에 저장한다.
	 * 4. 조회된 수강신청 정보를 반환한다.
	 */
	public List<CourseRequest> getMyCourseRequestList(String id) {		// 내 수강리스트 조회
		// 내가 신청한 수강신청정보를 저장하는 ArrayList객체를 생성한다.
		List<CourseRequest> myCourseRequestList = new ArrayList<>();
		
		// 수강신청정보 목록에서 동일한 학생아이디를 가진 수강신청정보를 위에서 생성한 ArrayList에 저장한다.
		for (CourseRequest courseRequest : courseRequestList) {
			if (courseRequest.getId().equals(id)) {
				myCourseRequestList.add(courseRequest);
			}
		}
		
		// 조회된 수강신청정보를 반환한다.
		return myCourseRequestList;
	}
	
	/*
	 *  강좌별 수강신청 정보 조회하기 시나리오
	 *  1. 강좌코드를 전달받는다.
	 *  2. 강좌정보와 수강신청학생정보를 저장할 Map객체를 생성한다.
	 *  3. 전달받은 강좌코드의 강좌정보를 조회하고, Map객체에 저장한다.
	 *  4. 해당 강좌에 수강신청한 학생정보를 여러 개 저장할 수 있는 ArrayList객체를 생성한다.
	 *  5. 수강신청정보 목록에서 수강신청정보를 하나씩 가져온다
	 *  	5-1. 저장된 수강신청정보의 강좌코드를 조회한다.
	 *  	5-2. 저장된 수강신청정보가 신청취소 상태가 아니고, 저장된 수강신청정보의 강좌코드와 전달받은 강좌코드가 일치하는지 확인한다.
	 *  	5-3. 학생 아이디로 학생정보를 조회한다.
	 *  	5-4. 조회된 학생정보를 4번에서 생성한 ArrayList객체에 저장한다.
	 *  6. 4번에서 생성한 ArrayList객체를 Map에 저장한다.
	 */
	public Map<String, Object> getCourseSummary(String code) {
		// 전달받은 강좌코드로 강좌정보 조회하기
	      Course course = getCourseDetail(code);

	      // 이 강좌를 신청한 학생정보를 저장하는 ArrayList객체 생성하기
	      List<Student> requestStudentList = new ArrayList<>();
	      // 수강신청정보 목록의 수강신청정보를 하나씩 조회한다.
	      for (CourseRequest cr : courseRequestList) {
	    	  // 전달받은 강좌코드와 일치하고, 취소처리되지 않은 수강신청정보를 조회한다.
	         String savedCourseCode = cr.getCode();
	         if (!cr.isCanceled() && savedCourseCode.equals(code)) {
	        	 // 해당 수강신청정보에서 학생아이디를 조회한다.
	            String studentId = cr.getId();
	            // 학생아이디로 학생정보를 조회한다.
	            Student student = getStudentDetail(studentId);
	            // 조회된 학생정보를 위에서 생성한 ArrayList객체에 저장한다.
	            requestStudentList.add(student);
	         }
	      }

	      // 전달받은 강조코드에 해당하는 강좌정보와 그 강좌를 수강신청한 학생정보 리스트를 저장하는 Map 객체를 생성한다.
	      Map<String, Object> map = new HashMap<>();
	      // Map 객체에 강좌정보를 저장한다.
	      map.put("course", course);
	      // Map 갭체에 이 강좌를 수강신청한 학생정보리스트를 저장한다.
	      map.put("students", requestStudentList);
	      
	      return map;
	   }
	
	/*
	 *  교수별 개설강좌에 대한 수강신청 정보 조회하기 시나리오
	 *  1. 교수이름을 전달받는다.
	 *  2. 강좌목록에서 해당 교수가 개설한 강좌를 검색한다.
	 *  3. 강좌의 강좌코드를 조회한다.
	 *  4. 강좌코드로 강좌별 수강신청정보 (Map<String, Object>)을 조회한다.
	 *  5. 조회된 강좌별 수강신청정보(Map<String, Object>) List<Map<String, Object>> 객체에 추가한다.
	 */
	public List<Map<String, Object>> getProfessorSummary(String professor) {
		List<Map<String, Object>> result = new ArrayList<>();
		
		for (Course course : courseList) {
			// 조회된 강좌의 담당교수 이름과 전달받은 교수의 이름이 같으면 해당 교수가 개설한 강좌다.
			if (course.getProfessor().equals(professor)) {
				// 개설한 강좌의 강좌코드를 조회한다.
				String code = course.getCode();
				// 위에서 구현한 강좌 코드를 전달해서 강좌별 수강신청 정보를 조회하는 메소드를 실행한다.
				// 강좌정보와, 해당 강좌를 신청한 학생리스크가 저장된 Map객체가 획득된다.
				Map<String, Object> courseSummary = getCourseSummary(code);
				// 조회된 Map객체를 위에서 정의한 ArrayList객체에 저장한다.
				result.add(courseSummary);
			}
		}
		
		return result;
	}
	
	private CourseRequest getCourseRequest(int no) {
		for (CourseRequest courseRequest : courseRequestList) {
			if (courseRequest.getNo() == no) {
				return courseRequest;
			}
		}
		return null;
	}
	
	private boolean isExistCourseRequest(int no) {
		for (CourseRequest courseRequest : courseRequestList) {
			if (courseRequest.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	
} 
