package day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseApp3 {

	public static void main(String[] args) throws Exception {		// 항상 throws Exception 던지기!
		
		String sql = "update employees "
				+ "set "
				+ " salary = salary + 500"
				+ "where department_id = ? ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, 60);
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 변경되었습니다.");
		
		pstmt.close();
		connection.close();
		
	}
}
