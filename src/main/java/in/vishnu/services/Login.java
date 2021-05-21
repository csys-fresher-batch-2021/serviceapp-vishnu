package in.vishnu.services;

import java.util.HashMap;

import in.vishnu.util.Util;


public class Login {
	private Login(){
		//default constructor
	}
	
	private static final HashMap<String, String> adminCredential = new HashMap<>();
	static {
		adminCredential.put("admin123@gmail.com", "admin1234");
	}

	/**
	 * returns true if admin login credentials are valid
	 * @param adminUserName
	 * @param password
	 * @return boolean
	 */
	public static boolean isAdminLoginValid(String adminUserName, String password) {
		boolean validLogin = false;
		if (Util.isEmailValid(adminUserName) && Util.isPasswordStrong(password) && adminCredential.containsKey(adminUserName)) {
			String adminPassword = adminCredential.get(adminUserName);
			if (adminPassword.equals(password)) {
				validLogin = true;
			}
		}
		return validLogin;
	}

}
