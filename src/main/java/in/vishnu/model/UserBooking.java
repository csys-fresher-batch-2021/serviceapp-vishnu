package in.vishnu.model;

import java.time.LocalDate;

public class UserBooking {
	private String carName;
	private String registrationNumber;
	private String serviceType;
	private int serviceCharge;
	private String serviceCenter;
	private String bookingStatus;
	private LocalDate date;

	public UserBooking() {
		super();
	}

	public UserBooking(String carName, String registrationNumber, String serviceType, int serviceCharge,
			String serviceCenter, String bookingStatus, LocalDate date) {
		super();
		this.carName = carName;
		this.registrationNumber = registrationNumber;
		this.serviceType = serviceType;
		this.serviceCharge = serviceCharge;
		this.serviceCenter = serviceCenter;
		this.bookingStatus = bookingStatus;
		this.date = date;
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

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(String serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MyBooking [carName=" + carName + ", registrationNumber=" + registrationNumber + ", serviceType="
				+ serviceType + ", serviceCharge=" + serviceCharge + ", serviceCenter=" + serviceCenter
				+ ", bookingStatus=" + bookingStatus + ", date=" + date + "]";
	}

}
