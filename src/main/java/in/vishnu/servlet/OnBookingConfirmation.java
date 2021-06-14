package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vishnu.model.BookingDetails;
import in.vishnu.services.BookingDetailsService;

/**
 * Servlet implementation class OnBookingComfirmation
 */
@WebServlet("/OnBookingConfirmation")
public class OnBookingConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionEmail = (String) session.getAttribute("sessionEmail");
		String carType = (String) session.getAttribute("carModel");
		String registerNum = (String) session.getAttribute("registrationNumber");
		String typeOfService = (String) session.getAttribute("selectedService");
		String stationName = (String) session.getAttribute("stationName");
		BookingDetails details = new BookingDetails(sessionEmail, carType, registerNum, typeOfService, stationName);
		if (BookingDetailsService.confirmBooking(details)) {
			session.removeAttribute("carModel");
			session.removeAttribute("registrationNumber");
			session.removeAttribute("selectedService");
			session.removeAttribute("finalFare");
			String message = "Booking Confirmed";
			response.sendRedirect("confirmationPage.jsp?message=" + message);
		} else {
			String processFailed = "Unable to Book now";
			response.sendRedirect("billing.jsp?processFailed=" + processFailed);
		}
	}

}
