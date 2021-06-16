package in.vishnu.validation;

import in.vishnu.model.User;

public class RegistrationValidation {
	private RegistrationValidation() {

	}

	/**
	 * This method is to validate registration 
	 * @param user
	 * @return
	 */
	public static boolean isRegistrationValid(User user) {
		boolean isValidRegistration = false;
		if (StringValidation.isNameValid(user.getFirstName()) 
				&& StringValidation.isNameValid(user.getLastName())
				&& ContactValidation.isValidContact(user.getContact()) 
				&& EmailValidation.isEmailValid(user.getEmail())
				&& PasswordValidation.isPasswordStrong(user.getPassword())) {
			isValidRegistration = true;
		}
		return isValidRegistration;
	}
}
