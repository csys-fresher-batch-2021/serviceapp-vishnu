package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.model.ServiceCenter;
import in.vishnu.services.ServiceCenters;


/**
 * Servlet implementation class AddServiceCenter
 */
@WebServlet("/AddServiceCenter")
public class AddServiceCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String centerName = request.getParameter("servicecenter");
		String location = request.getParameter("location");
		ServiceCenter newServiceCenter = new ServiceCenter(centerName, location);
		boolean isStationNameValid = ServiceCenters.addServiceCenter(newServiceCenter);
		if(isStationNameValid) {
			String successMessage = "Successfully Added";
			response.sendRedirect("addServices.jsp?successMessage="+successMessage);
		}
		else {
			String errorMsg = "Unable to add";
			response.sendRedirect("addServices.jsp?errorMsg="+errorMsg);
		}
	}

}
