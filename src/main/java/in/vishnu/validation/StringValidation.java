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

	public static boolean serviceChargeValidation(int charge) {
		boolean isValid = false;
		if (charge >= 0 && charge <= 100000) {
			isValid = true;
		}
		return isValid;
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
		if (isValid) {
			for (int index = 0; index < name.length(); index++) {
				if ((name.charAt(index) >= 65 && name.charAt(index) <= 90)
						|| (name.charAt(index) >= 97 && name.charAt(index) <= 122)) {
					isValid = true;
				} else {
					isValid = false;
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
		if (isValid) {
			for (int index = 0; index < name.length(); index++) {
				if ((name.charAt(index) >= 65 && name.charAt(index) <= 90)
						|| (name.charAt(index) >= 97 && name.charAt(index) <= 122)
						|| (name.charAt(index) >= 48 && name.charAt(index) <= 57)) {
					isValid = true;
				} else {
					isValid = false;
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

	/**
	 * returns true if the registration number id valid
	 * 
	 * @param registrationNumber
	 * @return boolean
	 */
	public static boolean isRegistrationNumberValid(String registrationNumber) {
		boolean isValid = true;
		int length = registrationNumber.length();

		char[] charArray = registrationNumber.trim().toCharArray();

		String lastFourCharacters = new StringBuilder().append(charArray[length - 1]).append(charArray[length - 2])
				.append(charArray[length - 3]).append(charArray[length - 4]).toString();
		StringBuilder lastFourDigits = new StringBuilder();
		for (int i = 0; i < lastFourCharacters.length(); i++) {
			if (lastFourCharacters.charAt(i) >= '0' && lastFourCharacters.charAt(i) <= '9') {
				String string = Character.toString(lastFourCharacters.charAt(i));
				lastFourDigits.append(string);
			} else {
				isValid = false;
			}
		}
		if (lastFourDigits.length() == 4) {
			int lastFourDigitInt = Integer.parseInt(lastFourDigits.toString());
			if (length == 0 || charArray[0] < 65 || charArray[0] > 90 || charArray[1] < 65 || charArray[1] > 90
					|| charArray[3] < 48 || charArray[3] > 57 || charArray[4] < 48 || charArray[4] > 57
					|| lastFourDigitInt <= 0 || lastFourDigitInt >= 10000) {
				isValid = false;
			}
		} else {
			isValid = false;
		}

		return isValid;
	}

}