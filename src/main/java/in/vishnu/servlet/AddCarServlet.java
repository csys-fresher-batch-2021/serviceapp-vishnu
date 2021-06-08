package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.services.Cars;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newCar = request.getParameter("carname");
		boolean isAdded = Cars.addCar(newCar);
		if (isAdded) {
			String carAddedMessage = "New car added successfully";
			response.sendRedirect("addServices.jsp?carAddedMessage=" + carAddedMessage);
		} else {
			String carNotAddedMsg = "Unable to add new car";
			response.sendRedirect("addServices.jsp?carNotAddedMsg=" + carNotAddedMsg);
		}
	}

}
