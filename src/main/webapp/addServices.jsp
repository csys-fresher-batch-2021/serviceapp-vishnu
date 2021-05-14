<!DOCTYPE>
<html lang="en">
<head>
<title>Car Services App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>ADD PACKAGES</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<%
		String infoMessage = request.getParameter("message");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
		<form action="AddServices" method="post">

			<label for="add Service">Add Services</label> <input type="text"
				name="services">
			<button type="submit">Add Service</button>

		</form>

	</main>
</body>
</html>
