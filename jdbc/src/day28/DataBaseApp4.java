package day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Date;

public class DataBaseApp4 {

	public static void main(String[] args) throws Exception {
		
		String sql = "select * "
				+ "from sample_users "
				+ "order by user_id asc ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("user_id");
			String password = rs.getString("user_password");
			String email = rs.getString("user_email");
			String name = rs.getString("user_name");
			String tel = rs.getString("user_tel");
			int point = rs.getInt("user_point");
			String disabled = rs.getString("user_disabled");
			Date createdDate = rs.getDate("user_created_date");
			Date updatedDate = rs.getDate("user_updated_date");
			
			String text = MessageFormat.format("{0} {1} {2} {3} {4} {5} {6} {7} {8}", 
					id, password, email, name, tel, point, disabled, createdDate, updatedDate);
			System.out.println(text);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
	}
}
