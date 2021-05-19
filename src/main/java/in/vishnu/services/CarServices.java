package in.vishnu.services;

import java.util.ArrayList;
import java.util.List;

import in.vishnu.validation.ServiceValidation;

public class CarServices {

	private CarServices() {
		// default constructor
	}

	private static List<String> carServicesList = new ArrayList<>();

	static {
		carServicesList.add("TIRE REPLACEMENT");
		carServicesList.add("BATTERY REPLACEMENT");
		carServicesList.add("BRAKE REPLACEMENT");
		carServicesList.add("SPARK PLUG REPLACEMENT");
		carServicesList.add("WHEEL ALIGNMENT");
		carServicesList.add("AIR FILTER REPLACEMENT");
		carServicesList.add("OIL CHANGE");
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
	 * @param serviceName
	 * @return boolean 
	 */
	public static boolean addService(String serviceName) {
		boolean isAdded = false;

		if(ServiceValidation.stringValidation(serviceName)) {
			
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
	 * @param serviceName
	 * @return boolean
	 */
	public static boolean deleteService(String serviceName) {
		boolean isDeleted =false;
		if(ServiceValidation.stringValidation(serviceName)) {
			String service = serviceName.toUpperCase();
			if(carServicesList.contains(service)) {
				carServicesList.remove(service);
				isDeleted=true;
			}
			else {
				isDeleted=false;
			}
		}
		return isDeleted;
	}

}
