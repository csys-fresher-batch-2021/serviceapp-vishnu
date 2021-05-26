package in.vishnu.services;

import java.util.List;

import in.vishnu.dao.ServiceDao;

import in.vishnu.exception.ServiceException;
import in.vishnu.validation.Validation;

public class CarServices {

	private CarServices() {
		// default constructor
	}

	/**
	 * returns car services list
	 * 
	 * @return
	 */
	public static List<String> getServices() {
		ServiceDao dao = new ServiceDao();
		return dao.displayService();
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
			ServiceDao dao1 = new ServiceDao();
			List<String> newList = dao1.getAllServices();

			if (newList.contains(service)) {
				isAdded = false;
			} else {

				dao1.addService(service);

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

		ServiceDao dao1 = new ServiceDao();
		List<String> newList = dao1.getAllServices();

		if (newList.contains(serviceName)) {
			dao1.removeService(serviceName);
			isDeleted = true;
		} else {
			throw new ServiceException("Unable to delete");
		}

		return isDeleted;
	}
}
