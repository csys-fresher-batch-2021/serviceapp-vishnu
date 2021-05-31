package in.vishnu.services;

import java.util.List;

import in.vishnu.dao.ServiceCenterDao;
import in.vishnu.exception.DbException;
import in.vishnu.model.ServiceCenter;
import in.vishnu.validation.StringValidation;

public class ServiceCenters {
	private ServiceCenters() {
		
	}
	/**
	 * lists all service centers
	 * @return list
	 */
	public static List<ServiceCenter> showServiceCenters(){
		ServiceCenterDao dao = new ServiceCenterDao();
		return dao.displayServiceCenter();
	}
	
	/**
	 * add new service center
	 * @param serviceCenter
	 * @return boolean
	 */
	public static boolean addServiceCenter(ServiceCenter serviceCenter) {
		boolean isDone = false;
		try {
			if(StringValidation.isServiceCenterNameValid(serviceCenter.getCenterName()) 
					&& StringValidation.isNameValid(serviceCenter.getLocation())) {
				ServiceCenterDao dao = new ServiceCenterDao();
				dao.addServiceCenter(serviceCenter);
				isDone=true;
			}
		} catch (DbException e) {
			e.printStackTrace();
			throw new DbException("Unable to add");
		}
		return isDone;
	}
	
	/**
	 *   remove the service center details
	 * @param serviceCenter
	 * @return
	 */
	public static boolean removeServiceCenter(ServiceCenter serviceCenter) {
		boolean isProcessDone = false;
		try {
			ServiceCenterDao dao = new ServiceCenterDao();
			List<ServiceCenter> newList = dao.getAllServiceCenters();
			for (ServiceCenter serviceCenterItem : newList) {
				if(serviceCenterItem.getCenterName().equals(serviceCenter.getCenterName()) &&
						serviceCenterItem.getLocation().equals(serviceCenter.getLocation())) {
					isProcessDone=true;
				}
			}
			if(isProcessDone) {
				dao.removeServiceCenter(serviceCenter);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException("unable to remove");
		}
		return isProcessDone;
		
	}

}
