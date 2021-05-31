package in.vishnu.validationTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vishnu.validation.StringValidation;


class NameValidationTest {

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"'', as, 1234, qwertyuioplkjh6543221, ash123"
	})
	void invalidNameCase(String name) {
		boolean isValid = StringValidation.isNameValid(name);
		assertFalse(isValid);
	}
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"vishnu, aashik"
	})
	void validNameCase(String name) {
		boolean isValid = StringValidation.isNameValid(name);
		assertTrue(isValid);
	}
	
}
