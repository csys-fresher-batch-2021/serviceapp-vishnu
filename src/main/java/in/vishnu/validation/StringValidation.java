package in.vishnu.validation;

public class StringValidation {

	private StringValidation() {
		// Default Constructor
	}

	/**
	 * validates the service name
	 * 
	 * @param serviceName
	 * @return
	 */
	public static boolean serviceNameValidation(String serviceName) {

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
	 * 
	 * @param name
	 * @return boolean
	 */
	public static boolean isNameValid(String name) {
		boolean isValid = false;
		if (name.length() > 3 && name.length() < 20) {
			isValid = true;
		}
		if(isValid) {
		for (int index = 0; index < name.length(); index++) {
			if ((name.charAt(index) >= 65 && name.charAt(index) <= 90)
					|| (name.charAt(index) >= 97 && name.charAt(index) <= 122)) {
				isValid = true;
			}
			else {
				isValid=false;
			}
		}
		}

		return isValid;
	}
	/**
	 * returns true if name is valid
	 * 
	 * @param name
	 * @return boolean
	 */
	public static boolean isCarNameValid(String name) {
		boolean isValid = false;
		if (name.length() > 3 && name.length() < 20) {
			isValid = true;
		}
		if(isValid) {
			for (int index = 0; index < name.length(); index++) {
				if ((name.charAt(index) >= 65 && name.charAt(index) <= 90)
						|| (name.charAt(index) >= 97 && name.charAt(index) <= 122)
						|| (name.charAt(index) >= 48 && name.charAt(index) <= 57 )) {
					isValid = true;
				}
				else {
					isValid=false;
				}
			}
		}
		
		return isValid;
	}

	/**
	 * returns true if service center name is valid
	 * 
	 * @param serviceCenterName
	 * @return boolean
	 */
	public static boolean isServiceCenterNameValid(String serviceCenterName) {
		boolean isValid = true;
		if (serviceCenterName.trim().equals("") || serviceCenterName.length() < 3 || serviceCenterName.length() > 100) {
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean isRegistrationValid(String registrationNumber) {
		boolean isValid = true;
		if(registrationNumber.trim().length()==0) {
			isValid=false;
		}
		return isValid;
	}

}