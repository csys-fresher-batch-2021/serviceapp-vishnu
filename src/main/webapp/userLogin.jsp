<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Log-in</title>
</head>
<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Login</h1>
		<%
		String successMessage = request.getParameter("successMessage");
		if (successMessage != null) {
			out.println("<font color='green'>" + successMessage + "</font>");
		}
		%>
		<%
		String invalidMessage = request.getParameter("invalidMessage");
		if (invalidMessage != null) {
			out.println("<font color='red'>" + invalidMessage + "</font>");
		}
		%>

		<form action="UserLoginServlet" method="post">
			<label for="username">Email:</label> <input type="email" name="email"
				placeholder="Enter your email" autofocus required> <br>
			<label for="password">Password:</label> <input type="password"
				name="password" placeholder="Password" required> <br>
			<button type="submit">LOG IN</button>
		</form>
		<br><br>
		<h5>Do not have an Axles Account? <a href="userRegistration.jsp">Register</a> Now!</h5>
	</main>
</body>
</html>