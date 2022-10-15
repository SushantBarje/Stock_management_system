package Database;

import java.sql.*;

public class DbConnection {
	
	public static Connection conn;
	
	public static Connection connectDb() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			//Statement stmt = conn.createStatement();
//			int result = stmt.executeUpdate("SELECT * FROM users");
//			System.out.println(result);
//			ResultSet result2 = stmt.executeQuery("SELECT * from stock");
//			while(result2.next()) {
//				System.out.println(result2.getInt(1)+ '\n');
//			}
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
