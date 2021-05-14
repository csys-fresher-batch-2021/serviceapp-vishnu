package in.vishnu.testStringValidation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.vishnu.services.CarServices;

public class ShowServicesTest {

	/**
	 * This checks the if it displays all car services
	 */
	@Test
	public void showServicesTest() {
		List<String> numberOfServices = CarServices.getServices();
		System.out.println(numberOfServices);
		assertEquals(8, numberOfServices.size());
	}

}
