package in.vishnu.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteServicesTest {

	@Test
	public void test1() {
		boolean isValid = CarServices.deleteService("TIRE REPLACEMENT");
		assertTrue(isValid);
		
	}
	@Test
	public void test2() {
		boolean isValid = CarServices.deleteService("Random");
		assertFalse(isValid);
	}
	@Test
	public void test3() {
		boolean isValid = CarServices.deleteService("");
		assertFalse(isValid);
	}
	@Test
	public void test4() {
		boolean isValid = CarServices.deleteService("123");
		assertFalse(isValid);
	}

}
