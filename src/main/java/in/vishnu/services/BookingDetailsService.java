package in.vishnu.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import in.vishnu.dao.BookingDetailsDAO;
import in.vishnu.exception.ServiceException;
import in.vishnu.model.BookingDetails;
import in.vishnu.model.UserBooking;
import in.vishnu.validation.EmailValidation;
import in.vishnu.validation.StringValidation;

public class BookingDetailsService {

	private BookingDetailsService() {

	}

	/**
	 * This method is used to get all booking details
	 * 
	 * @return
	 */
	public static List<ArrayList<String>> showAllUserBookings() {
		BookingDetailsDAO dao1 = new BookingDetailsDAO();
		return dao1.getAllBookingDetail();
	}

	/**
	 * This method is used to confirm booking
	 * 
	 * @param booking
	 * @return
	 */
	public static boolean confirmBooking(BookingDetails booking) {
		boolean isDone = false;
		try {
			if (StringValidation.isCarNameValid(booking.getCarName())
					&& EmailValidation.isEmailValid(booking.getEmailId())
					&& StringValidation.isRegistrationNumberValid(booking.getRegistrationNumber())
					&& StringValidation.isServiceCenterNameValid(booking.getServiceCenter())
					&& StringValidation.serviceNameValidation(booking.getServiceType())) {
				BookingDetailsDAO dao = new BookingDetailsDAO();
				dao.addBookingDetails(booking);
				isDone = true;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to book");
		}
		return isDone;
	}

	/**
	 * This method is used to get all user booking details
	 * 
	 * @param sessionEmail
	 * @return
	 */
	public static List<UserBooking> getUserBookings(String sessionEmail) {
		List<UserBooking> bookingList = new ArrayList<>();
		try {
			if (EmailValidation.isEmailValid(sessionEmail)) {
				BookingDetailsDAO dao1 = new BookingDetailsDAO();
				bookingList = dao1.getBookingDetails(sessionEmail);

			}
		} catch (ServiceException e) {
			throw new ServiceException("Unable to get details");
		}
		return bookingList;
	}

	/**
	 * This method is to return users recent (today and yesterday) bookings
	 * 
	 * @param sessionEmail
	 * @return
	 */
	public static List<UserBooking> getRecentBooking(String sessionEmail) {
		List<UserBooking> finalList = new ArrayList<>();
		BookingDetailsDAO dao2 = new BookingDetailsDAO();
		List<UserBooking> newList = dao2.getBookingDetails(sessionEmail);
		LocalDate todaysDate = LocalDate.now();
		try {
			if (EmailValidation.isEmailValid(sessionEmail)) {
				for (UserBooking userBooking : newList) {
					if (userBooking.getDate().compareTo(todaysDate) == 0
							|| ChronoUnit.DAYS.between(userBooking.getDate(), todaysDate) <= 2) {
						finalList.add(userBooking);
					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("No bookings today");
		}
		return finalList;
	}

	/**
	 * This method is used to update booking status
	 * 
	 * @param status
	 * @param carName
	 * @param service
	 * @param regNo
	 * @return
	 */
	public static boolean updateBookingStatusService(String status, String carName, String service, String regNo) {
		boolean isDone = false;
		try {
			if (StringValidation.isCarNameValid(carName) && StringValidation.isRegistrationNumberValid(regNo)
					&& StringValidation.serviceNameValidation(service)) {
				BookingDetailsDAO dao = new BookingDetailsDAO();
				dao.updateBookingStatus(carName, service, status, regNo);
				isDone = true;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("unable to update");
		}

		return isDone;
	}

	/**
	 * This method is used to get all completed services
	 * 
	 * @param sessionEmail
	 * @return
	 */
	public static List<UserBooking> getCompletedServices(String sessionEmail) {
		List<UserBooking> lastList = new ArrayList<>();
		BookingDetailsDAO dao4 = new BookingDetailsDAO();
		List<UserBooking> newList = dao4.getBookingDetails(sessionEmail);
		try {
			if (EmailValidation.isEmailValid(sessionEmail)) {
				for (UserBooking userBooking : newList) {
					if (userBooking.getBookingStatus().equals("COMPLETED")) {
						lastList.add(userBooking);
					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to display details");
		}
		return lastList;
	}

	/**
	 * This method is used to get all cancelled services booking
	 * 
	 * @param sessionEmail
	 * @return
	 */
	public static List<UserBooking> getCancelledServices(String sessionEmail) {
		List<UserBooking> cancelledList = new ArrayList<>();
		BookingDetailsDAO dao4 = new BookingDetailsDAO();
		List<UserBooking> newList = dao4.getBookingDetails(sessionEmail);
		try {
			if (EmailValidation.isEmailValid(sessionEmail)) {
				for (UserBooking userBooking : newList) {
					if (userBooking.getBookingStatus().equals("CANCELLED")) {
						cancelledList.add(userBooking);
					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to display details");
		}
		return cancelledList;
	}
}
