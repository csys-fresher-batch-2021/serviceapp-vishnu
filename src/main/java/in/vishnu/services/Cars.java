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
	 * @return List of cars
	 */
	public static List<String> showCars(){
		CarDao dao = new CarDao();
		return dao.displayCars();
	}
	
	/**
	 * adds car to db if it doesnt exists
	 * @param carName
	 * @return boolean
	 */
	public static boolean addCar(String carName) {
		boolean isAdded = false;
		if(StringValidation.isCarNameValid(carName)) {
			String car = carName.toUpperCase();
			CarDao dao = new CarDao();
			List<String> carList = dao.getAllCars();
			if(carList.contains(car)) {
				isAdded = false;
			}else {
				dao.addCar(car);
				isAdded = true;
			}
		}
		return isAdded;
	}
	
	/**
	 * removes the car from db if it is present
	 * @param carName
	 * @return boolean
	 */
	public static boolean removeCar(String carName) {
		boolean isRemoved = false;
		CarDao dao = new CarDao();
		List<String> carList = dao.getAllCars();
		if(carList.contains(carName)) {
			dao.removeCar(carName);
			isRemoved=true;
		}
		else {
			throw new ServiceException("Unable to delete");
		}
		return isRemoved;
	}
}
