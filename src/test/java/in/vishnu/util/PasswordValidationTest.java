package in.vishnu.util;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vishnu.validation.PasswordValidation;

class PasswordValidationTest {

	/**
	 * This method checks if password is valid
	 */
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"adm, adm min,''"
	})
	void invalidPasswordCase(String password) {
		boolean isValid = PasswordValidation.isPasswordStrong(password);
		assertFalse(isValid);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"admin1234, anirudh1, aashikahamed"
	})
	void ValidPasswordCase(String password) {
		boolean isValid = PasswordValidation.isPasswordStrong(password);
		assertTrue(isValid);
	}
	
 

	

}
