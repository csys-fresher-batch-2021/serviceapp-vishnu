<!DOCTYPE>
<html lang="en">
<head>
<title>Car Services App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>ADD TO DATABASE HERE</h3>
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
		String existingServiceMsg = request.getParameter("existingServiceMsg");
		if (existingServiceMsg != null) {
			out.println("<font color='red'>" + infoMessage + "</font>");
		}
		%>

		<form action="AddServices" method="post">

			<label for="add Service">Add Services</label> <input type="text"
				name="services" placeholder="Enter New Service here" required>
			<input type="number" name="servicecharge"
				placeholder="Enter the service charge" min=0 max=100000 required>
			<button type="submit">Add Service</button>

		</form>
		<br> <br>
		<%
		String carAddedMessage = request.getParameter("carAddedMessage");
		if (carAddedMessage != null) {
			out.println("<font color='green'>" + carAddedMessage + "</font>");
		}
		%>
		<%
		String carNotAddedMessage = request.getParameter("carNotAddedMsg");
		if (carNotAddedMessage != null) {
			out.println("<font color='red'>" + carNotAddedMessage + "</font>");
		}
		%>
		<form action="AddCarServlet" method="post">

			<label for="carname">Add New Car</label> <input type="text"
				name="carname" placeholder="Enter New Car here" required>
			<button type="submit">Add Car</button>

		</form>
		<br> <br>
		<%
		String serviceCenterAdded = request.getParameter("successMessage");
		if (serviceCenterAdded != null) {
			out.println("<font color='green'>" + serviceCenterAdded + "</font>");
		}
		String StationNotAddedMessage = request.getParameter("errorMsg");
		if (StationNotAddedMessage != null) {
			out.println("<font color='green'>" + StationNotAddedMessage + "</font>");
		}
		%>

		<form action="AddServiceCenter" method="post">
			<label for="servicecenter">Add New Service Center</label> <input
				type="text" name="servicecenter" required> <label
				for="location">Enter center location</label> <input type="text"
				name="location" required>
			<button type="submit">Add Station</button>
		</form>

	</main>
</body>
</html>
