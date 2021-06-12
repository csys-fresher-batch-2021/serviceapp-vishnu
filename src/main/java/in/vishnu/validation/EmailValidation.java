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
		boolean isValid = true;
		int indexOfAt = email.indexOf("@");
		int emailLength = email.trim().length();
		int frequencyOfAt = 0;
		for (int index = 0; index < emailLength; index++) {
			if (email.charAt(index) == '@') {
				frequencyOfAt++;
			}
		}
		if (emailLength == 0 || indexOfAt == 0 || indexOfAt == emailLength - 1 || frequencyOfAt > 1 || emailLength > 65
				|| email.charAt(indexOfAt + 1) == '.') {
			isValid = false;
		}
		return isValid;
	}

}
