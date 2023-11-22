package Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

	public static UserAccount findUser(Connection conn, String username, String password) throws SQLException {
		String sql = "SELECT username, password, gender FROM user_account WHERE username = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String gender = rs.getString("gender");
			UserAccount user = new UserAccount();
			user.setUsername(username);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String username) throws SQLException {
		String sql = "SELECT username, password, gender FROM user_account WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			UserAccount user = new UserAccount();
			user.setUsername(username);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "INSERT INTO user_account(username, password, gender) values (?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getGender());
			ps.executeUpdate();
		}
	}

	public static List<Product> selectAllProduct(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			ps = conn.prepareStatement("SELECT * FROM product");
			rs = ps.executeQuery();
			Product p;
			while (rs.next()) {
				p = new Product(rs.getString("id"), rs.getString("name"), rs.getString("type"), rs.getInt("price"),
						rs.getString("image"));
				productList.add(p);
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
			return productList;
		}
	}
}
