package in.vishnu.model;

public class BookingDetails {
	private String emailId;
	private String carName;
	private String registrationNumber;
	private String serviceType;
	private String serviceCenter;

	public BookingDetails() {
		super();

	}

	public BookingDetails(String emailId, String carName, String registrationNumber, String serviceType,
			String serviceCenter) {
		super();
		this.emailId = emailId;
		this.carName = carName;
		this.registrationNumber = registrationNumber;
		this.serviceType = serviceType;
		this.serviceCenter = serviceCenter;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(String serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	@Override
	public String toString() {
		return "BookingDetails [emailId=" + emailId + ", carName=" + carName + ", registrationNumber="
				+ registrationNumber + ", serviceType=" + serviceType + ", serviceCenter=" + serviceCenter + "]";
	}

}
