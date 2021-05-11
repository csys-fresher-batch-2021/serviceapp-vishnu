package in.vishnu.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DisplayServicesTest {

	/**
	 * This checks the if it displays all car services
	 */
	@Test
	public void displayServicesTest() {
		List<String> numberOfServices = DisplayServices.getServices();
		System.out.println(numberOfServices);
		assertEquals(7, numberOfServices.size());
	}

}
