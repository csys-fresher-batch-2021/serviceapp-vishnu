package in.vishnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BillingPageAction
 */
@WebServlet("/BillingPageAction")
public class BillingPageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serviceCenterList = request.getParameter("center");
		HttpSession session = request.getSession();
		session.setAttribute("stationName", serviceCenterList);

		response.sendRedirect("billing.jsp?msg=" + "redirected");

	}

}
