package in.vishnu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	private ConnectionUtil() {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/CarService_db";
		String username = "postgres";
		String password = "postgres123";
		Class.forName(driverClass);
		return DriverManager.getConnection(url, username, password);
	}

	public static void close(Statement st, Connection con) {
		try {
			if (con != null && st != null) {
				con.close();
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
