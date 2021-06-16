
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register Now!</title>
</head>
<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Registration</h3>
		<%
		String successMessage = request.getParameter("successMessage");
		if (successMessage != null) {
			out.println("<font color='green'>" + successMessage + "</font>");
		}
		%>
		<%
		String userMessage = request.getParameter("userMessage");
		if (userMessage != null) {
			out.println("<font color='red'>" + userMessage + "</font>");
		}
		%>
		<%
		String invalidMessage = request.getParameter("invalidMessage");
		if (invalidMessage != null) {
			out.println("<font color='red'>" + invalidMessage + "</font>");
		}
		%>
		<form action="RegistrationServlet" method="post">

			<label for="firstname">FirstName:</label> <input type="text"
				name="firstname" id="firstname" placeholder="firstName" autofocus
				required> <br> <label for="lastname">LastName:</label>
			<input type="text" name="lastname" id="lastname"
				placeholder="lastName" required> <br> <label
				for="contact">Contact Number:</label> <input type="tel"
				name="contact" id="contact" placeholder="9999999999" required>
			<br> <label for="email">Email:</label> <input type="email"
				name="email" id="email" placeholder="demoperson@example.com"
				required> <br> <label for="password">Password:</label>
			<input type="password" name="password"
				placeholder="Min 9 letters required" required> <br>
			<button type="submit">Register</button>
		</form>
	</main>
</body>
</html>