package in.vishnu.services;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vishnu.model.User;

public class UserRegistrationTest {

	@Test
	public void test1() {
		User user = new User();
		user.setFirstName("arun");
		user.setLastName("vedha");
		user.setContact(9978235409L);
		user.setEmail("arunvedha@gmail.com");
		user.setPassword("arunvedha123");
		boolean isValid = UserRegistration.userRegistration(user);
		assertTrue(isValid);
	}
	
	/*
	 * tests if data already exist
	 */
	@Test
	public void test2() {
		User user = new User();
		user.setFirstName("arun");
		user.setLastName("vedha");
		user.setContact(9978235409L);
		user.setEmail("arunvedha@gmail.com");
		user.setPassword("arunvedha123");
		boolean isValid = UserRegistration.isUserExist(user);
		assertTrue(isValid);
	}


}
