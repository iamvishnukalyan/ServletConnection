package demo.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DbConnect {
	static Connection con = null;



	public int dbRetreive(String uid, String password) {
		String id = null, pwd = null;
		Statement stmt;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");

			stmt = con.createStatement();
			String url = "select userid, password from login where userid=";
			ResultSet rs = stmt.executeQuery(url + uid);

			while (rs.next()) {
				id = rs.getString("userid");
				pwd = rs.getString("password");
			}
			if (uid.equals(id) && password.equals(pwd)) {
				return 1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;

	}

}
