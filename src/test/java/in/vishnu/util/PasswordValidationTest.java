package in.vishnu.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordValidationTest {

	/**
	 * This method checks if password is valid
	 */
	@Test
	public void test1() {
		boolean isPasswordValid = Util.isPasswordStrong("admin1234");
		assertTrue(isPasswordValid);
	}

	@Test
	public void test2() {
		boolean isPasswordValid = Util.isPasswordStrong("adm");
		assertFalse(isPasswordValid);
	}

	@Test
	public void test3() {
		boolean isPasswordValid = Util.isPasswordStrong("adm min");
		assertFalse(isPasswordValid);
	}

	@Test
	public void test4() {
		boolean isPasswordValid = Util.isPasswordStrong("");
		assertFalse(isPasswordValid);
	}

}
