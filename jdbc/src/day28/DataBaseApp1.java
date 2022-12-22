package day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseApp1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 값이 들어갈 자리가 ?로 표시된 SQL을 정의한다.
		String sql = "insert into sample_users "
				+ "(user_id, user_password, user_email, user_name, user_tel, user_point) "
				+"values "
				+"(?, ?, ?, ?, ?, ?)";			// "?"는 바인딩 변수 변수의 값을 담는 표시
		
		// 1. oracle.jdbc.OracleDriver를 자바 가상머신의 드라이버 레지스트리에 jdbc:oracle:thin"이라는 이름으로 등록시키기
		// Class.forName(클래스의 전체 경로)는 지정된 클래스를 메모리의 영역에 로딩시킨다.
		// OracleDriver는 메모리에 로딩이 완료되면 자바가상머신의 드라이버 레지스트리에 오라클 드라이버를 등록시킨다.
		Class.forName("oracle.jdbc.OracleDriver");
		
		// 2. 데이터베이스와 연결을 담당하는 Connection 인터페이스 구현객체를 획득하기
		// 드라이버 레지스트리에 등록된 OracleDriver는 url, username, password를 전달받아서 
		// 데이터베이스와 연결을 담당하는 Connection 인터페이스 구현객체를 제공한다.
		// url의 "jdbc:oracle:thin"은 드라이버 레지스트리에 등록된 이름이다.
		// url의 "@localhost:1521:xe"에서 @localhost는 데이터베이스 설치된 컴퓨터 이름이다.
		// 								1521은 데이터베이스가 사용하는 포트번호다.
		//								xe는 데이터베이스를 식별하는 고유한 이름이다.
		// username과 password는 데이터베이스 계정명과 비밀번호다.
		// DriverManager는 자바 가상머신의 드라이버 레지스트리를 관리하는 클래스다.
		// DriverManager의 getConnection(url, username, password)는 지정된 url의 데이터베이스와 연결을 유지하는
		// java.sql.Connection 인터페이스의 구현객체를 반환한다.(구현객체는 ojdbc11.jar에서 제공한다.)
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		Connection connection = DriverManager.getConnection(url, username, password);
		
		// 3. SQL을 데이터베이스로 전송/실행시키는 PrepareStatement 인터페이스 구현객체 획득하기
		// pstmt에는 oracle.jdbc.driver.OraclePreparedStatementWrapper객체의 PreparedStatement 참조한다.
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 4. SQL의 ? 자리에 실제 값을 바인딩하기
		pstmt.setString(1, "hong-gd");					//user_id(VARCHAR2) 컬럼의 값
		pstmt.setString(2, "hong-gd@naver.com");		//user_email(VARCHAR2)
		pstmt.setString(3, "zxcv1234");					//user_password(VARCHAR2)
		pstmt.setString(4, "홍길동");						//user_name(VARCHAR2)
		pstmt.setString(5, "010-1111-1111");			//user_tel(VARCHAR2)
		pstmt.setInt(6, 100);							//user_point(NUMBER)
		
		// 5. SQL을 데이터베이스로 전송하고, 실행시킨다.
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 추가되었습니다.");
		
		// 6. 데이터베이스 액세스 작업에 사용했던 모든 리소스 연결해제 하기
		pstmt.close();
		connection.close();
		
	}
	
	
}
