package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.services.Cars;

/**
 * Servlet implementation class DeleteCarServlet
 */
@WebServlet("/DeleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carName = request.getParameter("carName");
		boolean isDeleted = Cars.removeCar(carName);
		if(isDeleted) {
			String carDeletedMsg = "Car successfully deleted";
			response.sendRedirect("carsTable.jsp?carDeletedMsg="+carDeletedMsg);
		}
		else {
			String carNotDeletedMsg = "Unable to delete";
			response.sendRedirect("carsTable.jsp?carNotDeletedMsg="+carNotDeletedMsg);
		}
	}

	

}
