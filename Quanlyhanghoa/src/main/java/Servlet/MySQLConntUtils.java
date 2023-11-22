package Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConntUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String hostname = "localhost";
		String dbName = "quanlybanhang";
		String username = "root";
		String password = "";
		return getConnection(hostname, dbName, username, password);
	}
	
	private static Connection getConnection(String hostname, String dbName,
	        String username, String password) throws ClassNotFoundException, SQLException {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://" + hostname + ":3306/" + dbName;
	        Connection conn = DriverManager.getConnection(url, username, password);
	        System.out.println("OK");
	        return conn;
	    } catch (ClassNotFoundException | SQLException ex) {
	        System.err.println("Connection failed: " + ex.getMessage());
	        throw ex; // Re-throw the exception to propagate it to the caller
	    }
	}
}
