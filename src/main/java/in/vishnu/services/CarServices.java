package in.vishnu.services;

import java.util.ArrayList;
import java.util.List;

import in.vishnu.validation.Validation;

public class CarServices {

	private CarServices() {
		// default constructor
	}

	private static List<String> carServicesList = new ArrayList<>();

	static {
		carServicesList.add("TIRE REPLACEMENT");
		carServicesList.add("OIL CHANGE");
		carServicesList.add("BATTERY REPLACEMENT");
		carServicesList.add("OTHER SERVICES");
	}

	/**
	 * returns car services list
	 * 
	 * @return
	 */
	public static List<String> getServices() {
		return carServicesList;
	}

	/**
	 * this method adds new service
	 * 
	 * @param serviceName
	 * @return boolean
	 */
	public static boolean addService(String serviceName) {
		boolean isAdded = false;

		if (Validation.stringValidation(serviceName)) {

			String service = serviceName.toUpperCase();
			if (carServicesList.contains(service)) {
				isAdded = false;
			} else {
				carServicesList.add(carServicesList.size() - 1, service);
				isAdded = true;
			}
		}

		return isAdded;
	}

	/**
	 * this method deletes existing service
	 * 
	 * @param serviceName
	 * @return boolean
	 */
	public static boolean deleteService(String serviceName) {
		boolean isDeleted = false;
		if (carServicesList.contains(serviceName)) {
			carServicesList.remove(serviceName);
			isDeleted = true;
		}
		return isDeleted;
	}
}
