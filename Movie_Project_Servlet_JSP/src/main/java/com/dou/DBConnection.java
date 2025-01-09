package com.dou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_servlet","root","root");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return conn;
		}
	}
}
