package in.vishnu.validation;

public class PasswordValidation {
	private PasswordValidation(){
		
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
}
