package day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

public class DataBaseApp5 {

	public static void main(String[] args) throws Exception {
		
		String sql = "select employee_id, first_name, job_id, salary, salary*12 as annual "
				+ "from employees "
				+ "where department_id = ? "
				+ "order by employee_id asc ";
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, 60);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("employee_id");
			String name = rs.getString("first_name");
			String job = rs.getString("job_id");
			double salary = rs.getDouble("salary");
			double annaulSalary = rs.getDouble("annual");
			
			String text = MessageFormat.format("{0} {1} {2} {3} {4}", id, name, job, salary, annaulSalary);
			System.out.println(text);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
	}
}
