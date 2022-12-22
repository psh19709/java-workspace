package day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseApp2 {

	public static void main(String[] args) throws Exception{
		
		String sql = "delete from sample_users "		// 끝에 공백을 하나 포함시키세요.
				+ "where user_id = ? ";
		
		//Oracle JDBC 드라이브 클래스 로딩
		Class.forName("oracle.jdbc.OracleDriver");
		
		//COnnection(데이터 베이스와 연결을 유지하는 객체) 구현객체 획득
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
	
		// PreparedStatement(SQL의 전송을 담당하는 객체) 구현객체 획득
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// ? 값 바이딩하기
		pstmt.setString(1, "hong");				// ?에는 삭제할 사용자 아이디 값이 지정되어야 한다.
		
		//SQL를 데이테베이스로 전송하고 결과값 받기
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + " 개의 행이 삭제되었습니다.");
		
		// 자원 반납하기
		pstmt.close();
		connection.close();
	}
}
