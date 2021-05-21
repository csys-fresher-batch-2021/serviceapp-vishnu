package in.vishnu.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailValdationTest {

	/**
	 * this checks if the input is a valid email address
	 */
	@Test
	public void emailValidation1() {
		boolean isValid = Util.isEmailValid("Admin01@gmail.com");
		assertTrue(isValid);
	}

	@Test
	public void emailValidation2() {
		boolean isValid = Util.isEmailValid("Admin01gmail.com");
		assertFalse(isValid);
	}

	@Test
	public void emailValidation3() {
		boolean isValid = Util.isEmailValid("Admin01gmailcom");
		assertFalse(isValid);
	}

}
