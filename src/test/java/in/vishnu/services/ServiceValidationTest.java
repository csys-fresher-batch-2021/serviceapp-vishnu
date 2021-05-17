package in.vishnu.services;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vishnu.validation.ServiceValidation;

public class ServiceValidationTest {

	/**
	 * This checks the if it displays all car services
	 */
	@Test
	public void stringValidationTest() {
		String string = "";
		boolean valid = ServiceValidation.stringValidation(string);
		assertFalse(valid);

	}

	@Test
	public void stringValidationTest1() {
		String string = "1234";
		boolean valid = ServiceValidation.stringValidation(string);
		assertFalse(valid);

	}

	@Test
	public void stringValidationTest2() {
		String string = "car1234";
		boolean valid = ServiceValidation.stringValidation(string);
		assertFalse(valid);

	}

	@Test
	public void stringValidationTest3() {
		String string = "painting";
		boolean valid = ServiceValidation.stringValidation(string);
		assertTrue(valid);

	}

	@Test
	public void stringValidationTest4() {
		String string = "PAINTING";
		boolean valid = ServiceValidation.stringValidation(string);
		assertTrue(valid);

	}

}
