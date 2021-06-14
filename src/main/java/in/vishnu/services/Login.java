package in.vishnu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.vishnu.dao.LoginDao;
import in.vishnu.exception.DbException;
import in.vishnu.util.Util;

public class Login {
	private Login() {
		// default constructor
	}

	private static final HashMap<String, String> adminCredential = new HashMap<>();
	static {
		adminCredential.put("admin123@gmail.com", "admin1234");
	}

	/**
	 * returns true if admin login credentials are valid
	 * 
	 * @param adminUserName
	 * @param password
	 * @return boolean
	 */
	public static boolean isAdminLoginValid(String adminUserName, String password) {
		boolean validLogin = false;
		if (Util.isEmailValid(adminUserName) && Util.isPasswordStrong(password)
				&& adminCredential.containsKey(adminUserName)) {
			String adminPassword = adminCredential.get(adminUserName);
			if (adminPassword.equals(password)) {
				validLogin = true;
			}
		}
		return validLogin;
	}

	/**
	 * This method is used to verify if the user login credentials are valid
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public static boolean isUserLoginValid(String email, String password) {
		boolean isValid;
		try {
			LoginDao dao = new LoginDao();
			isValid = dao.loginDao(email, password);

		} catch (DbException e) {
			e.printStackTrace();
			throw new DbException("Invalid Credentials");
		}
		return isValid;
	}

	/**
	 * This method is used to get user details
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public static List<String> getuserDetails(String email, String password) {
		List<String> userList = new ArrayList<>();
		try {
			LoginDao dao = new LoginDao();
			userList = dao.getUserDetails(email, password);

		} catch (DbException e) {
			e.printStackTrace();
			throw new DbException("Invalid Credentials");
		}
		return userList;
	}

}
