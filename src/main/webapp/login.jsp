<!DOCTYPE>
<html lang="en">
<head>
<title>Car Service App</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Login</h1>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>

		<form action="AdminLogin" method="post">
			<label for="username">User-Name:</label> <input type="email"
				name="userName" placeholder="Enter your email" autofocus required>
			<br> <label for="password">Password:</label> <input
				type="password" name="password" placeholder="Password" required> <br>
			<button type="submit">LOG IN</button>
		</form>

	</main>
</body>
</html>
