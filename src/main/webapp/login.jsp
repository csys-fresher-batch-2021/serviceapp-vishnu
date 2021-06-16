<!DOCTYPE>
<html lang="en">
<head>
<title>Car Service App</title>

</head>

<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1 class="text-center">Admin</h1>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>

		<div>
			<form action="AdminLogin" method="post">
				<label for="username">Admin:</label> <input type="text"
					name="userName" placeholder="Enter your email" autofocus required>
				<br> <label for="password">Password:</label> <input
					type="password" name="password" placeholder="Password" required>
				<br>
				<button type="submit">LOG IN</button>

				<p>
					<em>Admin: admin123@gmail.com<br>Password: admin1234
					</em>
				</p>
			</form>
		</div>

	</main>
</body>
</html>
