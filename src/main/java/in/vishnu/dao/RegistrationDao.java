package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vishnu.exception.DbException;
import in.vishnu.model.User;

import in.vishnu.util.ConnectionUtil;

public class RegistrationDao {

	/**
	 * This method is to add a new user to database
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO user_details(first_name, last_name, contact,"
					+ " email, password)VALUES(?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setLong(3, user.getContact());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to add data");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method gets all users from database
	 * 
	 * @return
	 */
	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM user_details";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Long contact = rs.getLong("contact");
				String email = rs.getString("email");
				String password = rs.getString("password");
				User user = new User(firstName, lastName, contact, email, password);
				userList.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to get all users");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userList;

	}
}
