package in.vishnu.services;

import java.util.List;

import in.vishnu.dao.CarDao;
import in.vishnu.exception.ServiceException;
import in.vishnu.validation.StringValidation;

public class Cars {
	private Cars() {

	}

	/**
	 * displays all available cars
	 * 
	 * @return List of cars
	 */
	public static List<String> showCars() {
		CarDao dao = new CarDao();
		return dao.getAllCars();
	}

	/**
	 * adds car to database if it does not exists
	 * 
	 * @param carName
	 * @return boolean
	 */
	public static boolean addCar(String carName) {
		boolean isAdded = false;
		try {
			if (StringValidation.isCarNameValid(carName)) {
				String car = carName.toUpperCase();
				CarDao dao = new CarDao();
				List<String> carList = dao.getAllCars();
				if (carList.contains(car)) {
					isAdded = false;
				} else {
					dao.addCar(car);
					isAdded = true;
				}
			}
		} catch (ServiceException e) {
			throw new ServiceException("Unable to add car");
		}
		return isAdded;
	}

	/**
	 * This method removes the car from database if it is present
	 * 
	 * @param carName
	 * @return boolean
	 */
	public static boolean removeCar(String carName) {
		boolean isRemoved = false;
		try {
			CarDao dao = new CarDao();
			List<String> carList = dao.getAllCars();
			if (carList.contains(carName)) {
				dao.removeCar(carName);
				isRemoved = true;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to remove car");
		}
		return isRemoved;
	}
}
