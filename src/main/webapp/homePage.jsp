<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.vishnu.services.Cars"%>
<%@page import="in.vishnu.services.CarServices"%>
<%@page import="in.vishnu.model.Service"%>

<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book now</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<h3>Quick Book</h3>
	<%
	String successMessage = request.getParameter("successMessage");
	if (successMessage != null) {
		out.println("<font color='green'>" + successMessage + "</font>");
	}

	String message = request.getParameter("registrationNumberMessage");
	if (message != null) {
		out.println("<font color='red'>" + message + "</font>");
	}
	%>
	<form action="SelectServiceCenter" method="post">


		<label>Select your car:</label> <select name="cars" required>
			<option value="">Not selected</option>
			<%
			List<String> carList = Cars.showCars();

			for (String car : carList) {
			%>
			<option value="<%=car%>"><%=car%></option>
			<%
			}
			%>
		</select> <br> <label>Select your service:</label> <select name="services"
			required>
			<option value="">Not selected</option>
			<%
			List<Service> serviceList = CarServices.showAllServices();

			for (Service service : serviceList) {
			%>
			<option value="<%=service.getServiceName()%>"><%=service.getServiceName()%></option>
			<%
			}
			%>
		</select> <br> <label>Enter vehicle Registration number:</label> <input
			type="text" name="regno" placeholder="TN-03-AP-3333" required>
		<br>
		<button type="submit">Book Now</button>

	</form>

</body>
</html>