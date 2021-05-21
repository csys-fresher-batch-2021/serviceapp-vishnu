package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.services.CarServices;

/**
 * Servlet implementation class DeleteServices
 */
@WebServlet("/DeleteServices")
public class DeleteServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newService = request.getParameter("serviceName");

		boolean isDeleted = CarServices.deleteService(newService);
		if (isDeleted) {
			String message = "Deleted successfully";
			response.sendRedirect("services.jsp?message=" + message);
		}
	}

}
