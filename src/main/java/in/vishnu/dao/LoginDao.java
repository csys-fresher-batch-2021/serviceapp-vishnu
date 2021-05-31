package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vishnu.exception.DbException;
import in.vishnu.util.ConnectionUtil;

public class LoginDao {
	
	public boolean loginDao(String email, String password) {
		boolean isProcessDone = false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from user_details where email=? AND password=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				isProcessDone = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("unable to connect to database");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isProcessDone;
	}

	public List<String> getUserDetails(String email, String password) {
		List<String> userList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select first_name, last_name, contact from user_details where first_name like '%' and last_name like '%' and contact > 1 and email =? and password=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Long contact = rs.getLong("contact");
				String phoneNumber = String.valueOf(contact);
				userList.add(firstName);
				userList.add(lastName);
				userList.add(phoneNumber);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException(e.getMessage());
		}finally {
			ConnectionUtil.close(pst, connection);
		}

		return userList;
	}
}
