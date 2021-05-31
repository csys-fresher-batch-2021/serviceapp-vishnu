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
	 * tests if data didn't exist
	 */
	@Test
	public void test2() {
		User user = new User();
		user.setFirstName("kelly");
		user.setLastName("vedha");
		user.setContact(8978235409L);
		user.setEmail("kellyvedha@gmail.com");
		user.setPassword("kellyvedha123");
		boolean isValid = UserRegistration.isUserExist(user);
		assertFalse(isValid);
	}
	
	/**
	 * existing contact number 
	 */
	@Test
	public void test3() {
		User user = new User();
		user.setFirstName("bipin");
		user.setLastName("roy");
		user.setContact(9978235409L);
		user.setEmail("bipinroy@gmail.com");
		user.setPassword("kellyvedha123");
		boolean isValid = UserRegistration.isUserExist(user);
		assertTrue(isValid);
	}
	/**
	 * existing email address
	 */
	@Test
	public void test4() {
		User user = new User();
		user.setFirstName("rahul");
		user.setLastName("raj");
		user.setContact(9932425374L);
		user.setEmail("arunvedha@gmail.com");
		user.setPassword("kellyvedha123");
		boolean isValid = UserRegistration.isUserExist(user);
		assertTrue(isValid);
	}


}
