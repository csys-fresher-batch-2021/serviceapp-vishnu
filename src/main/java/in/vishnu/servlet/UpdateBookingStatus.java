package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.services.BookingDetailsService;

/**
 * Servlet implementation class UpdateBookingStatus
 */
@WebServlet("/UpdateBookingStatus")
public class UpdateBookingStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String service = request.getParameter("serviceType");
		String regNum = request.getParameter("regNum");
		String carName = request.getParameter("carName");
		String status = request.getParameter("status");

		boolean isDone = BookingDetailsService.updateBookingStatusService(status, carName, service, regNum);
		if (isDone && status.equals("CANCELLED")) {
			response.sendRedirect("recentBookings.jsp");
		} else if (isDone && status.equals("COMPLETED")) {
			response.sendRedirect("bookings.jsp");
		}
	}

}
