package App;

import java.sql.*;


import Database.*;

public class Auth {
	
	Connection conn;
	PreparedStatement ps;
	public boolean auth_user(String username, String password) {
		conn = DbConnection.connectDb();
		
		try {
			String query  = "SELECT * FROM users WHERE user_name=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(password.equals(rs.getString(3))) {
					System.out.println("match");
					DbConnection.closeConnection();
					return true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
}
