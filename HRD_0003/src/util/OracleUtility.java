package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleUtility {
	public static Connection getcConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String id = "practice1";
		String pw = "1234";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,id,pw);
		
		return conn;
	}
}
