package in.vishnu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	private Util(){
		
	}
	/**
	 * returns true if password is valid
	 * 
	 * @param password
	 * @return boolean
	 */
	public static boolean isPasswordStrong(String password) {
		boolean isStrong = false;
		int passwordLength = password.length();
		if (password.equals(password.replace(" ", "")) && passwordLength > 8 && passwordLength < 20) {
			isStrong = true;
		}

		return isStrong;
	}

	/**
	 * returns true if email is valid
	 * 
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmailValid(String email) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern userNamePattern = Pattern.compile(regex);
		Matcher matchUserName = userNamePattern.matcher(email);
		return matchUserName.matches();
	}

}
