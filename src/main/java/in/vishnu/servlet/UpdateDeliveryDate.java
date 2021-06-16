package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.services.BookingDetailsService;

/**
 * Servlet implementation class UpdateDeliveryDate
 */
@WebServlet("/UpdateDeliveryDate")
public class UpdateDeliveryDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		String deliveryDate = request.getParameter("deliveryDate");
		boolean isDone = BookingDetailsService.updateDeliveryDate(deliveryDate, bookingId);
		if (isDone) {
			response.sendRedirect("adminDeliveredServices.jsp");
		}
	}

}
