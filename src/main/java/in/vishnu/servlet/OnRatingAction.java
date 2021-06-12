package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.services.Ratings;

/**
 * Servlet implementation class OnRatingAction
 */
@WebServlet("/OnRatingAction")
public class OnRatingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rating = Integer.valueOf(request.getParameter("rate"));

		String centerName = request.getParameter("center");

		boolean rated = Ratings.updateRating(rating, centerName);
		if (rated) {
			String ratedMessage = "Thank you for rating";
			response.sendRedirect("completedServices.jsp?ratedMessage=" + ratedMessage);
		} else {
			String ratedMessage = "Couldnt rate now";
			response.sendRedirect("completedServices.jsp?ratedMessage=" + ratedMessage);
		}

	}

}
