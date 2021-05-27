package in.vishnu.validation;

import in.vishnu.model.User;

public class RegistrationValidation {
	private RegistrationValidation() {
		
	}
	public static boolean isRegistrationValid(User user) {
		boolean isValidRegistration = false;
		if(Validation.isNameValid(user.getFirstName()) && Validation.isNameValid(user.getLastName()) && ContactValidation.isValidContact(user.getContact()) 
				&& EmailValidation.isEmailValid(user.getEmail()) && PasswordValidation.isPasswordStrong(user.getPassword()) ) {		
			isValidRegistration=true;
		}
		return isValidRegistration;
	}
}
