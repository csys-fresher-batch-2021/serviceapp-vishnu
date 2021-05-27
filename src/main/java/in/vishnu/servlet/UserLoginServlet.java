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
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userLogin = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(Login.isUserLoginValid(userLogin, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("USER", "user");
			String successMessage = "Login Success";
			response.sendRedirect("index.jsp?successMessage="+successMessage);
		}else {
			String invalidMessage = "Invalid Login Credentials";
			response.sendRedirect("UserLogin.jsp?invalidMessage="+invalidMessage);
		}
	}

}
