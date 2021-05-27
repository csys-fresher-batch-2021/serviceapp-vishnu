package in.vishnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
