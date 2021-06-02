package in.vishnu.services;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vishnu.model.Service;

public class AddServicesTest {

	/**
	 * This method checks if new service is added or not
	 */
	@Test
	public void addServiceTest1() {
		Service services = new Service();
		String name = "PAINTING";
		int fare = 8999;
		services.setServiceName(name);
		services.setServiceCharge(fare);
		boolean isAdded = CarServices.addService(services);
		assertTrue(isAdded);
	}

	@Test
	public void addServiceTest2() {
		Service services = new Service();
		String serviceName = "1234";
		int fare = -1;
		services.setServiceName(serviceName);
		services.setServiceCharge(fare);
		boolean isAdded = CarServices.addService(services);
		assertFalse(isAdded);

	}

	@Test
	public void addServiceTest3() {
		Service services = new Service();
		String serviceName = "123wed";
		int fare = 1000000;
		services.setServiceName(serviceName);
		services.setServiceCharge(fare);
		boolean isAdded = CarServices.addService(services);
		assertFalse(isAdded);

	}

}
