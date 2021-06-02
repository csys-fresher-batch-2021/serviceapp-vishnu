package in.vishnu.validationTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vishnu.validation.StringValidation;

class RegistrationNumberTest {

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"TN-09-AD-6754, AP-34-AS-4563"
	})
	void test1(String regNo) {
		boolean isValid = StringValidation.isRegistrationNumberValid(regNo);
		assertTrue(isValid);
	}
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"12-09-AC-7685, AP-34-AS-abcd, '', kl-ui-ac-2324"
	})
	void test2(String regNo) {
		boolean isValid = StringValidation.isRegistrationNumberValid(regNo);
		assertFalse(isValid);
	}

}
