package in.vishnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.services.CarServices;

/**
 * Servlet implementation class AddServices
 */
@WebServlet("/AddServices")
public class AddServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    /**
//     * @see HttpServlet#HttpServlet()
//     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newService = request.getParameter("services");

		boolean isAdded = CarServices.addService(newService);
		if (isAdded) {
			String message = "New Service Added successsfully";
			response.sendRedirect("addServices.jsp?message=" + message);
		} else {
			String errorMessage = "Unable to add new service. Check again";
			response.sendRedirect("addServices.jsp?errorMessage=" + errorMessage);
		}
	}

}
