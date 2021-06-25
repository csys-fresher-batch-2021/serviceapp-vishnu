package in.vishnu.model;

import java.time.LocalDate;

public class UserBooking {

	private int bookingId;
	private String carName;
	private String registrationNumber;
	private String serviceType;
	private int serviceCharge;
	private int serviceCenterId;
	private String serviceCenter;
	private String bookingStatus;
	private LocalDate date;
	private String deliveryDate;

	public UserBooking() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public int getServiceCenterId() {
		return serviceCenterId;
	}

	public void setServiceCenterId(int serviceCenterId) {
		this.serviceCenterId = serviceCenterId;
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

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "UserBooking [carName=" + carName + ", registrationNumber=" + registrationNumber + ", serviceType="
				+ serviceType + ", serviceCharge=" + serviceCharge + ", serviceCenter=" + serviceCenter
				+ ", bookingStatus=" + bookingStatus + ", date=" + date + ", deliveryDate=" + deliveryDate + "]";
	}

}
