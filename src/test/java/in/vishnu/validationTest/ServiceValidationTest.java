package in.vishnu.validationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vishnu.validation.Validation;

public class ServiceValidationTest {

	/**
	 * This method checks the if service name is valid string
	 */
	@Test
	public void stringValidationTest() {
		String string = "";
		boolean valid = Validation.stringValidation(string);
		assertFalse(valid);

	}

	@Test
	public void stringValidationTest1() {
		String string = "1234";
		boolean valid = Validation.stringValidation(string);
		assertFalse(valid);

	}

	@Test
	public void stringValidationTest2() {
		String string = "car1234";
		boolean valid = Validation.stringValidation(string);
		assertFalse(valid);

	}

	@Test
	public void stringValidationTest3() {
		String string = "painting";
		boolean valid = Validation.stringValidation(string);
		assertTrue(valid);

	}

	@Test
	public void stringValidationTest4() {
		String string = "PAINTING";
		boolean valid = Validation.stringValidation(string);
		assertTrue(valid);

	}

}
