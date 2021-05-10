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
		List<String> numberOFServices = DisplayServices.getServices();
		System.out.println(numberOFServices);
		assertEquals(7, numberOFServices.size());
	}

}
