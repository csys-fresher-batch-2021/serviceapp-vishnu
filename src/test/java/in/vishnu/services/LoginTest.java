package in.vishnu.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginTest {

	@Test
	public void loginTest1() {
		boolean isValid = Login.isAdminLoginValid("admin123@gmail.com", "admin1234");
		assertTrue(isValid);
	}
	@Test
	public void loginTest2() {
		boolean isValid = Login.isAdminLoginValid("", "");
		assertFalse(isValid);
	}

}
