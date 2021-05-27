package in.vishnu.services;

import java.util.List;

import in.vishnu.dao.RegistrationDao;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.User;
import in.vishnu.validation.RegistrationValidation;

public class UserRegistration {
	private UserRegistration() {

	}

	public static boolean userRegistration(User user) {
		boolean isProcessDone = false;
		try {

			if (RegistrationValidation.isRegistrationValid(user)) {
				RegistrationDao dao = new RegistrationDao();
				dao.addUser(user);
				isProcessDone = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidationException("Unable to add");
		}
		return isProcessDone;
	}

	public static boolean isUserExist(User user) {
		boolean isExist = false;
		try {
			RegistrationDao dao = new RegistrationDao();
			List<User> newList = dao.getAllUsers();
			for (User useritem : newList) {
				if (useritem.getContact() == user.getContact() && useritem.getEmail().equals(user.getEmail())) {
					isExist = true;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new ValidationException("Unable to add");
		}
		return isExist;
	}

}
