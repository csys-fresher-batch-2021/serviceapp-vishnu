package in.vishnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vishnu.services.Login;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean isValid = Login.isAdminLoginValid(userName, password);
		if(isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("ROLE",userName);
			response.sendRedirect("services.jsp");
		}
		else {
			String errorMessage = "Invalid Login Credentials";
			response.sendRedirect("login.jsp?errorMessage="+errorMessage);
		}
		
		
	}

}
