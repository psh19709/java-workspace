package day19.school;

import utils.KeyboardReader;

public class SchoolController {
	
	private KeyboardReader keyboard = new KeyboardReader();
	private SchoolService service = new SchoolService();
			
	
	// 실행기능
	public void run() {
		메뉴();
		
	}
	
	// 메뉴 출력 기능 - 메뉴를 표시한다.
	private void 메뉴() {
		while(true) {
		System.out.println("-------------------------------------");
		System.out.println("1. 학생등록  2.성적등록  3.전체조회  4.상세조회  5.성적변경 6.삭제 0.종료");
		System.out.println("-------------------------------------");
		System.out.println();
		
		System.out.print("메뉴선택: ");
		int menuNo = keyboard.getInt();
		System.out.println();
		
		if(menuNo == 1) {
			학생등록();
		} else if (menuNo == 2) {
			성적등록();
		} else if (menuNo == 3) {
			전체학생정보출력();
		} else if (menuNo == 4) {
			학생상세정보출력();
		} else if (menuNo == 5) {
			성적변경();
		} else if (menuNo == 6) {
			학생정보삭제();
		} else if (menuNo == 0) {
			System.out.println("### 프로그램을 종료합니다.");
			System.exit(0);
		}
		System.out.println();
		System.out.println();
		
		메뉴();							// 재기호출 덕분에 while문을 쓰지 않아도 된다.			
		}
	}
	
	//학생 정보 등록 기능 - 학생 정보를 입력받는다.
	// 				- 학생정보를 등록시킨다.
	
	private void 학생등록() {
		/*
		 *  1 화면에 "<< 신규 학생 등록 >>" 메세지를 출력한다.
		 *  2. 화면에 "학교정보 입력(이름, 학년 전화번호, 이메일)" 메세지를 출력한다.
		 *  				[홍길동, 3, 010-1111-1111,hong@naver.com] 한번에 입력받기
		 *  3. 입력내용을 Split(구문문자) 메소드를 이용해서 잘라서 String[] 배열을 획득한다.
		 *  		{"홍길동", "3", "010-1111-1111", "hong@naver.com"} 
		 *  4. Student객체를 생성한다.
		 *  5. Student 객체의 setter메소드를 이용해서 배열의 값은 Student 객체의 각 멤버변수에 저장시킨다.
		 *  	단, 학년은 현재 "3"이기 때문에 Integer.parasrInt(문자열) 메소드를 실행해서 "3"을 3으로 변환시킨 다음
		 *  6.Student객체에 저장시킨다.
		 *  7. 위에서 생성한 StudentService객체의 insertStudent(student)를 실행해서 학생정보를 등록시킨다.
		 *  8. insertStudent(student) 메소드가 true 를 반환하면 "### 학생정보가 등록되었습니다." 메세지를 출력하고,
		 *  	false를 반환하면 "### 학생정보 등록에 실패하였습니다" 메세지를 출력한다.
		 */
		
		System.out.println("<< 신규 학생 등록 >>");
		System.out.println("학교정보 입력(이름, 학년, 전화번호, 이메일)");
		String text = keyboard.getString();
		String[] items = text.split(",");
		
		Student student = new Student();
		student.setName(items[0]);
		student.setGrade(Integer.parseInt(items[1]));
		student.setTel(items[2]);
		student.setEmail(items[3]);
		System.out.println(student);
		
		boolean isSuccess = service.insertStudent(student);
		if (isSuccess) {
			System.out.println("### 학생정보가 등록되었습니다.");
		} else {
			System.out.println("### 학생정보 등록에 실패하였습니다.");
		}
		
		
	}
	
	//성적 정보 등록 기능 - 학생이름, 국어/영어/수학점수를 입력받는다.
	//				- 학생이름에 해당하는 학생정보를 조회한다.
	//				- 조회된 학생정보에 성적정보를 저장시킨다.
	/*
	 *  1. 화면에 "<< 학생 성적 정보 등록 >>" 메세지를 출력한다.
	 *  2. 화면에 "학생이름 입력 " 메세지를 출력한다.
	 *  3. 입력된 학생이름을 읽어서 변수에 대입한다.
	 *  4. 화면에 "정적정보입력(국어,영어,수학 점수 순으로 입력)" 메서지를 출력한다.
	 *  5. 입력된 성적정보를 읽어서 변수에 대입한다.
	 *  	입력값 = "70,80,90"
	 *  6. 입력된 성적정보를 split(구분자) 메소드를 이용해서 자르고, 배열을 획득한다.
	 *  	배열 = {"70", "80", "90"} 
	 *  7. 성적정보를 저장하는 Score객체를 생성한다.
	 *  8. Score객체의 setter 메소드를 이용해서 국어, 영어, 수학점수를 생성된 Score객체에 대입한다.
	 *  9. SchoolService객체의 insertScore(String name, Score score) 메소드를 실행해서 지정된
	 *  	학생의 성적정보를 추가한다.
	 *  10. insertScore(student) 메소드가 true 를 반환하면 "### 성적정보가 등록되었습니다." 메세지를 출력하고,
	 *  	false를 반환하면 "### 성적정보 등록에 실패하였습니다" 메세지를 출력한다.
	 */
	private void 성적등록() {
		System.out.println("<< 학생 성적정보 등록 >>");
		
		System.out.print("학생이름 입력: ");
		String name = keyboard.getString();
		System.out.print("성적정보 입력(국어, 영어, 수학 점수 순으로 입력)");
		String text = keyboard.getString();		// text -> "80,70,90"
		String[] items = text.split(",");		// items -> {"80", "70", "90"}
		
		Score score = new Score();				// 이부분 난 생각을 못함
		score.setKor(Integer.parseInt(items[0]));
		score.setEng(Integer.parseInt(items[1]));
		score.setMath(Integer.parseInt(items[2]));
		
		boolean isSeccess = service.insertScore(name, score);
		if(isSeccess) {
			System.out.println("### 성적정보가 등록되었습니다.");
		} else {
			System.out.println("### 성적정보 등록에 실패하였습니다");
		}
	}
	
	
	// 학생 목록 출력 기능
	/*
	 * 1. 화면에 " << 전체 학생리스트 출력 >>" 메세지를 출력한다.
	 * 2. SchoolService객체의 getAllStudent()실행해서 Student[] 배열객체를 반환받는다.
	 * 3. 화면에 "이름		학년		전화번호		이메일"을 출력한다.
	 * 4. 향상된 for문을 사용해서 배열객체에 저장된 학생정보를 반복해서 화면에 출력한다.
	 */
	private void 전체학생정보출력() {
		System.out.println("<< 전체 학생리스트 출력 >>");
		
		Student[] students = service.getAllStudent();
		if(students.length == 0) {
			System.out.println("### 등록된 학생정보가 존재하지 않습니다.");
		} else {
			System.out.println("이름\t학년\t전화번호\t\t이메일");
			for (Student item : students) {
				if(item == null) {
					break;
				}
				System.out.print(item.getName() + "\t");
				System.out.print(item.getGrade() + "\t");
				System.out.print(item.getTel() + "\t");
				System.out.print(item.getEmail() + "\t");
			}
		}
	}
	
	
	// 학생 상세정보 출력 기능
	/*
	 * 1. 화면에 "<< 학생 상세정보 출력>>" 메세지를 출력한다.
	 * 2. 화면에 "학생 이름 입력 " 메세지를 출력한다.
	 * 3. 입력된 학생이름을 읽어서 변수에 대입하려고 한다.
	 * 4. SchoolService객체의 findStudentByName(String name) 메소드를 실행해서 학생정보를 반환받는다.
	 * 5. 반환된 학생정보가 null이면 화면에 "### 학생정보가 존재하지 않습니다."fmf cnffurgksek.
	 * 6. 반환된 학생정보가 null이 아니면 화면에 학생정보와 성적정보를 아래와 같이 출력한다.
	 * 		이름:
	 * 		학년:
	 * 		전화번호:
	 * 		이메일:
	 * 		국어점수:
	 * 		영어점수:
	 * 		수학점수:
	 * 		총점:
	 * 		평균:
	 */
	private void 학생상세정보출력() {
		System.out.println("<< 학생 상세정보 출력 >>");
		
		System.out.print("학생이름 입력: ");
		String name = keyboard.getString();
		
		Student student = service.findStudentByName(name);
		System.out.println();
		
		if(student == null) {
			System.out.println("### 학생정보가 존재하지 않습니다.");
			return;
		} 
		
		System.out.println(" ### 학생 상세 정보 ### ");
		System.out.println("이름: " + student.getName());
		System.out.println("학년: " + student.getGrade());
		System.out.println("전화번호: " + student.getTel());
		System.out.println("이메일: " + student.getEmail());
		System.out.println();
		
		Score score = student.getScore();
		
		if(score != null) {
			System.out.println(" ### 성적 상세 정보 ### ");
			System.out.println("국어점수: " + score.getKor());
			System.out.println("영어점수: " + score.getEng());
			System.out.println("수학점수: " + score.getMath());
			System.out.println("총 점수: " + score.getTotal());
			System.out.println("평균점수: " + score.getAverage());
		}
			else {
				System.out.println("### 성적정보가 존재하지 않습니다.");
				return;
			
		}
		
	}
	

	// 학생 성적 정보 변경 기능
	/*
	 *  1. 화면에 "<< 학생 성적 정보 변경 >>" 메세지를 출력한다.
	 *  2. 화면에 "학생이름 입력 " 메세지를 출력한다.
	 *  3. 입력된 학생이름을 읽어서 변수에 대입한다.
	 *  4. 화면에 "정적정보입력(국어,영어,수학 점수 순으로 입력)" 메서지를 출력한다.
	 *  5. 입력된 성적정보를 읽어서 변수에 대입한다.
	 *  	입력값 = "70,80,90"
	 *  6. 입력된 성적정보를 split(구분자) 메소드를 이용해서 자르고, 배열을 획득한다.
	 *  	배열 = {"70", "80", "90"} 
	 *  7. 성적정보를 저장하는 Score객체를 생성한다.
	 *  8. Score객체의 setter 메소드를 이용해서 국어, 영어, 수학점수를 생성된 Score객체에 대입한다.
	 *  9. SchoolService객체의 updateScore(String name, Score score) 메소드를 실행해서 지정된
	 *  	학생의 성적정보를 추가한다.
	 *  10. updateScore(name, score) 메소드가 true 를 반환하면 "### 성적정보가 변경되었습니다." 메세지를 출력하고,
	 *  	false를 반환하면 "### 성적정보 변경에 실패하였습니다" 메세지를 출력한다.
	 */
	private void 성적변경() {
		System.out.println("<< 학생 성적정보 변경 >>");
		
		System.out.print("학생이름 입력: ");
		String name = keyboard.getString();
		System.out.print("성적정보 입력(국어, 영어, 수학 점수 순으로 입력)");
		String text = keyboard.getString();		// text -> "80,70,90"
		String[] items = text.split(",");		// items -> {"80", "70", "90"}
		
		Score score = new Score();				// 이부분 난 생각을 못함
		score.setKor(Integer.parseInt(items[0]));
		score.setEng(Integer.parseInt(items[1]));
		score.setMath(Integer.parseInt(items[2]));
		
		boolean isSeccess = service.updateScore(name, score);
		if(isSeccess) {
			System.out.println("### 성적정보가 변경되었습니다.");
		} else {
			System.out.println("### 성적정보 변경에 실패하였습니다");
		}
	}
	
	/*
	 *  1. 화면에 "<< 학생 정보 삭제 >>" 메세지를 출력한다.
	 *  2. 화면에 "학생이름 입력 " 메세지를 출력한다.
	 *  3. 입력된 학생이름을 읽어서 변수에 대입한다.
	 *  4. SchoolService객체의 deleteStudent(String name)메소드를 실행해서 학생정보를 삭제시킨다.
	 *  5. deleteStudent(name)메소드가 true를 반환하면 "### 학생정보가 삭제되었습니다" 메세지를 출력하고,
	 *  false를 반환하면 "### 학생정보 삭제가 실패하였습니다."
	 */
	private void 학생정보삭제() {
		System.out.println("<< 학생정보 삭제 >>");
		System.out.println("학생이름 입력: ");
		String name = keyboard.getString();
		
		boolean isSuccess = service.deleteStudent(name);
		if(isSuccess) {
			System.out.println(" ### 학생 정보가 삭제되었습니다.");
		} else {
			System.out.println(" ### 학생 정보 삭제가 실패하였습니다.");
		}
				
	}

}
