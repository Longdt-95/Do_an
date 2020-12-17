
package com.leduyanh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection(){
		final String user = "sa";
		final String password = "saker0905971230";
		final String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;user="+user+";password="+password;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			return DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
