package in.vishnu.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddServicesTest {

	/**
	 * This method checks if new service is added or not
	 */
	@Test
	public void addServiceTest1() {
		String serviceName = "painting";
		boolean isAdded = CarServices.addService(serviceName);
		assertTrue(isAdded);

	}

	@Test
	public void addServiceTest2() {
		String serviceName = "";
		boolean isAdded = CarServices.addService(serviceName);
		assertFalse(isAdded);

	}

	@Test
	public void addServiceTest3() {
		String serviceName = "123";
		boolean isAdded = CarServices.addService(serviceName);
		assertFalse(isAdded);

	}

}
