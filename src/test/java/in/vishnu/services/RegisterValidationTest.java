package in.vishnu.services;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vishnu.model.User;

import in.vishnu.validation.ContactValidation;
import in.vishnu.validation.EmailValidation;
import in.vishnu.validation.PasswordValidation;
import in.vishnu.validation.RegistrationValidation;
import in.vishnu.validation.Validation;

public class RegisterValidationTest {

	@Test
	public void test() {
		User user =new User();
		user.setFirstName("jacob");
		user.setLastName("james");
		user.setContact(9909897876L);
		user.setEmail("jacobjames.123@gmail.com");
		user.setPassword("qwerty1234");
		boolean isRegistrationValid = RegistrationValidation.isRegistrationValid(user);
		assertTrue(isRegistrationValid);
		}
	@Test
	public void test1() {
		String email = "jacobjames.123@gmail.com";
		boolean isValid = EmailValidation.isEmailValid(email);
		assertTrue(isValid);
		}
	@Test
	public void test2() {
		long contact = 9909897876L;
		boolean isValid = ContactValidation.isValidContact(contact);
		assertTrue(isValid);
		}
	@Test
	public void test3() {
		String password = "qwerty1234";
		boolean isValid = PasswordValidation.isPasswordStrong(password);
		assertTrue(isValid);
	}
	@Test
	public void test4() {
		String firstname = "jacob";
		boolean isValid = Validation.isNameValid(firstname);
		assertTrue(isValid);
	}
	

}
