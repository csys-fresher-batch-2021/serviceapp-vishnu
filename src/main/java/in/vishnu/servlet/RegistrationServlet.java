package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vishnu.model.User;
import in.vishnu.services.UserRegistration;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		Long contact = Long.parseLong(request.getParameter("contact"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User newUser = new User(firstName, lastName, contact, email, password);
		
		if(!UserRegistration.isUserExist(newUser)) {
			
			if(UserRegistration.userRegistration(newUser)) {
				String successMessage = "You have registered successfully";
				response.sendRedirect("userLogin.jsp?successMessage="+successMessage);
			}else {
				String invalidMessage = "Invalid details";
				response.sendRedirect("userRegistration.jsp?invalidMessage="+invalidMessage);
			}
			
		}else {
			String userMessage = "You are already a user";
			response.sendRedirect("userRegistration.jsp?userMessage="+userMessage);
			
		}
		
		

	}

}
