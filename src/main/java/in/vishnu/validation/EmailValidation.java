package in.vishnu.validation;

public class EmailValidation {
	private EmailValidation() {
		
	}
	/**
	 * returns true if email is valid
	 * 
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmailValid(String email) {
		boolean isValid = false;
		int indexOfAt = email.indexOf("@");
		int emailLength = email.trim().length();
		if (emailLength != 0 && indexOfAt != -1 && indexOfAt < emailLength - 9) {
			isValid = true;
		}
		return isValid;
	}


}
