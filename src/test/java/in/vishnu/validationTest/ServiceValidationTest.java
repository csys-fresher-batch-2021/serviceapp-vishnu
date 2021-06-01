package in.vishnu.validationTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vishnu.validation.StringValidation;

 class ServiceValidationTest {

	/**
	 * This method checks the if service name is valid string
	 */
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"'', 1234, car1234"
	})
	void test1(String serviceName) {
		boolean isValid = StringValidation.isServiceCenterNameValid(serviceName);
		assertFalse(isValid);
		
	}

	@Test
	public void stringValidationTest3() {
		String string = "painting";
		boolean valid = StringValidation.serviceNameValidation(string);
		assertTrue(valid);

	}

	@Test
	public void stringValidationTest4() {
		String string = "PAINTING";
		boolean valid = StringValidation.serviceNameValidation(string);
		assertTrue(valid);

	}

}
