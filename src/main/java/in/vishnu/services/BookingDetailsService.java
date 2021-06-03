package in.vishnu.services;

import in.vishnu.dao.BookingDetailsDAO;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.BookingDetails;
import in.vishnu.validation.EmailValidation;
import in.vishnu.validation.StringValidation;

public class BookingDetailsService {
	
	private BookingDetailsService() {
		
	}
	
	public static boolean confirmBooking(BookingDetails booking) {
		boolean isDone = false;
		try {
			if(StringValidation.isCarNameValid(booking.getCarName()) 
					&& EmailValidation.isEmailValid(booking.getEmailId())
					&& StringValidation.isRegistrationNumberValid(booking.getRegistrationNumber())
					&& StringValidation.isServiceCenterNameValid(booking.getServiceCenter())
					&& StringValidation.serviceNameValidation(booking.getServiceType())) {
				BookingDetailsDAO dao = new BookingDetailsDAO();
				dao.addBookingDetails(booking);
				isDone=true;
			}
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new ValidationException("unable to book");
		}
		return isDone;
	}

}
