package in.vishnu.services;

import java.util.List;


import in.vishnu.dao.ServicesDAO;
import in.vishnu.exception.ServiceException;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.Service;
import in.vishnu.validation.StringValidation;

public class CarServices {

	private CarServices() {
		// default constructor
	}

	/**
	 * returns car services list
	 * 
	 * @return
	 */
	public static List<Service> showAllServices() {
		ServicesDAO dao = new ServicesDAO();
		return dao.getAllServices();
	}

	/**
	 * this method adds new service
	 * 
	 * @param serviceName
	 * @return boolean
	 */
	public static boolean addService(Service service) {
		boolean isAdded = false;

		try {
			if (StringValidation.serviceNameValidation(service.getServiceName())
					&& StringValidation.serviceChargeValidation(service.getServiceCharge())) {
				String newService = service.getServiceName().toUpperCase();
				service.setServiceName(newService);
				ServicesDAO dao = new ServicesDAO();
				dao.addService(service);
				isAdded = true;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("unable to add");
		}
		return isAdded;
	}

	/**
	 * return true if service already exists
	 * 
	 * @param service
	 * @return
	 */
	public static boolean isServiceExist(Service service) {
		boolean isExist = false;
		try {
			ServicesDAO dao = new ServicesDAO();
			List<Service> newList = dao.getAllServices();
			for (Service serviceItem : newList) {
				if (serviceItem.getServiceName().equals(service.getServiceName())) {
					isExist = true;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new ValidationException("Service already exists");
		}
		return isExist;
	}

	/**
	 * this method deletes existing service
	 * 
	 * @param serviceName
	 * @return boolean
	 */
	public static boolean deleteService(Service service) {
		boolean isProcessTrue = false;

		try {
			ServicesDAO dao = new ServicesDAO();
			List<Service> newList = dao.getAllServices();
			for (Service serviceItem : newList) {
				if (serviceItem.getServiceName().equals(service.getServiceName())
						&& serviceItem.getServiceCharge() == service.getServiceCharge()) {
					isProcessTrue = true;
				}
			}
			if (isProcessTrue) {
				dao.removeService(service);
			}

		} catch (ServiceException e) {
			e.printStackTrace();
			String message = e.getMessage();
			throw new ServiceException(message);
		}

		return isProcessTrue;
	}
	
	/**
	 * return service amount
	 * @return
	 */
	public static int getServiceCharge(String serviceName) {
		int charge=0;
		try {
			if(StringValidation.serviceNameValidation(serviceName)) {
				ServicesDAO dao = new ServicesDAO();
				charge += dao.getServiceCharge(serviceName);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("unable to get charge");
		}
		
		return charge;
	}
}
