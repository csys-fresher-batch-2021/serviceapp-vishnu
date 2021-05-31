package in.vishnu.util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vishnu.validation.ContactValidation;

public class ContactValidationTest {

	@Test
	public void test1() {
		long number = 1234567890L;
		boolean isValid = ContactValidation.isValidContact(number);
		assertFalse(isValid);
	}
	@Test
	public void test2() {
		long number = 7234567890L;
		boolean isValid = ContactValidation.isValidContact(number);
		assertTrue(isValid);
	}
	@Test
	public void test3() {
		long number = 9234567890L;
		boolean isValid = ContactValidation.isValidContact(number);
		assertTrue(isValid);
	}

}
