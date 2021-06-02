<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.vishnu.services.ServiceCenters"%>
<%@page import="in.vishnu.model.ServiceCenter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
String admin = (String) session.getAttribute("ADMIN");
%>
<%
String user = (String) session.getAttribute("USER");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>service centers</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<form action="BillingPageAction" method="post">
	<%
	String firstName = (String) session.getAttribute("firstName");
	String lastName = (String) session.getAttribute("lastName");
	String userName = (firstName + " " + lastName).toUpperCase();
	String contact = (String) session.getAttribute("contact");
	String carModel = (String) session.getAttribute("carModel");
	String selectedService = (String) session.getAttribute("selectedService");
	String registrationNumber = (String) session.getAttribute("registrationNumber");
	%>

	<%
	if (admin == null && user != null) {
	%>
	<label for="username"> User Name:</label>
	<input type="text" name="contact" value="<%=userName%>" readonly>
	<label for="contact">Contact: </label>
	<input type="text" name="contact" value="<%=contact%>" readonly>
	<label for="carmodel">Your Car: </label>
	<input type="text" name="carmodel" value="<%=carModel%>" readonly>
	<br>
	<label for="selectedservice">Service type: </label>
	<input type="text" name="selectedservice" value="<%=selectedService%>"
		readonly>
	<label for="registrationnumber">Registration Number: </label>
	<input type="text" name="registrationnumber"
		value="<%=registrationNumber%>" readonly>
	<%
	}
	%>
		<table class="table table-bordered">
			<caption>List Of Service Centers</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Name</th>
					<th scope="col">Location</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<%
				List<ServiceCenter> serviceCenterList = ServiceCenters.showServiceCenters();
				int i = 0;
				for (ServiceCenter serviceCenterItem : serviceCenterList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=serviceCenterItem.getCenterName()%></td>

					<td><%=serviceCenterItem.getLocation()%></td>
					<%
					if (admin == null && user != null) {
					%>

					<td><input type="radio" name="center" value="<%=serviceCenterItem.getCenterName()+", "+serviceCenterItem.getLocation()%>" required></td>
					<%
					}
					%>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
		<div class="text-center">
		<%
		if (admin == null && user != null) {
		%>
		<button type="submit" class="btn btn-danger">Submit</button>
		<%
		}
		%>
		</div>
	</form>
</body>
</html>