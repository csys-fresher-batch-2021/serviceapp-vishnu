package in.vishnu.validation;

public class Validation {

	private Validation() {
		// Default Constructor
	}

	/**
	 * validates the service name
	 * 
	 * @param serviceName
	 * @return
	 */
	public static boolean stringValidation(String serviceName) {

		boolean isValidService = true;
		if (serviceName.length() == 0 || serviceName.trim().equals("")) {
			isValidService = false;
		}
		for (int index = 0; index < serviceName.length(); index++) {
			if (serviceName.charAt(index) >= '0' && serviceName.charAt(index) <= '9') {
				isValidService = false;

			}
		}
		return isValidService;
	}

	/**
	 * returns true if name is valid
	 * @param name
	 * @return boolean
	 */
	public static boolean isNameValid(String name) {
		boolean isValid = true;
		if (name.trim().equals("")) {
			isValid = false;
		}
		return isValid;
	}

}