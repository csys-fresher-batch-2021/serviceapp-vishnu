package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vishnu.services.CarServices;

/**
 * Servlet implementation class GetBillServlet
 */
@WebServlet("/GetBillServlet")
public class GetBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String serviceType = (String) session.getAttribute("selectedService");
		int serviceChargeFinal = CarServices.getServiceCharge(serviceType);
		if (serviceChargeFinal >= 0) {
			session.setAttribute("finalFare", serviceChargeFinal);
			response.sendRedirect("billing.jsp?msg=" + "success");
		} else {
			response.sendRedirect("billing.jsp?msg=" + "bill genration failed");
		}

	}

}
