package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vishnu.validation.StringValidation;

/**
 * Servlet implementation class SelectServiceCenter
 */
@WebServlet("/SelectServiceCenter")
public class ServiceCenterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carModel = request.getParameter("cars");
		String selectedService = request.getParameter("services");
		String registrationNumber = request.getParameter("regno");
		if(StringValidation.isRegistrationValid(registrationNumber)) {
			HttpSession session = request.getSession();
			session.setAttribute("registrationNumber", registrationNumber);
			session.setAttribute("carModel", carModel);
			session.setAttribute("selectedService", selectedService);
			response.sendRedirect("serviceCenters.jsp");
		}else {
			String message = "Invalid Registration Number";
			response.sendRedirect("index.jsp?Invalid="+message);
		}
	}

}
