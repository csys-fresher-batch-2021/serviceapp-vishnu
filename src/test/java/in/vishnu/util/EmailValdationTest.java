package in.vishnu.util;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vishnu.validation.EmailValidation;

class EmailValdationTest {

	/**
	 * this checks if the input is a valid email address
	 */
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"arunachalam@gmail.com, admin123@gmail.com, aashikahamed@gmail.com"
	})
	void validPasswordCase(String email) {
		boolean isValid = EmailValidation.isEmailValid(email);
		assertTrue(isValid);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"Admin01gmail.com, @Admin01gmailcom, Admin01gmailcom@, @Admin01gmail@com@"
	})
	void invalidPasswordCase(String email) {
		boolean isValid = EmailValidation.isEmailValid(email);
		assertFalse(isValid);
	}

}
