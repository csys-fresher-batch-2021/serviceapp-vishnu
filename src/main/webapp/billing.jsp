<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Billing</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<%
	String station = (String) session.getAttribute("stationName");
	String serviceStation = station.toUpperCase();
	String firstName = (String) session.getAttribute("firstName");
	String lastName = (String) session.getAttribute("lastName");
	String userName = (firstName + " " + lastName).toUpperCase();
	String contact = (String) session.getAttribute("contact");
	String carModel = (String) session.getAttribute("carModel");
	String selectedService = (String) session.getAttribute("selectedService");
	String registrationNumber = (String) session.getAttribute("registrationNumber");
	Integer fare = (Integer) session.getAttribute("finalFare");

	String notConfirmMessage = request.getParameter("processFailed");
	if (notConfirmMessage != null) {
		out.println("<font color='red'>" + notConfirmMessage + "</font>");
	}
	%>
	<h3>Billing</h3>
	<form action="GetBillServlet" method="post">
		<table class="table table-hover">
			<caption>Billing</caption>
			<thead>
				<tr>
					<th scope="col">Get your bill here</th>
				</tr>

			</thead>
			<tbody>
				<tr>
					<td>User Name</td>
					<td><%=userName%></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><%=contact%></td>
				</tr>
				<tr>
					<td>Your Car</td>
					<td><%=carModel%></td>
				</tr>
				<tr>
					<td>Registration Number</td>
					<td><%=registrationNumber%></td>
				</tr>
				<tr>
					<td>Service Type</td>
					<td><%=selectedService%></td>
				</tr>
				<tr>
					<td>Service Center</td>
					<td><%=serviceStation%></td>
				</tr>
				<tr>
					<td>Your Estimated Price</td>
					<%
					if (fare != null) {
					%>
					<td><%=fare%> Rs</td>
				</tr>
				<tr>
					<td></td>
					<td><p class="text-muted">
							<em>NOTE: this is an estimated price.<br>The *price may
								vary at station
							</em>
						</p></td>
				</tr>
				<%
				}
				%>
			</tbody>

		</table>
		<div class="text-center">
			<button type="submit" class="btn btn-info">Get Service
				Charge</button>
		</div>
	</form>
	<form action="OnBookingConfirmation" method="post">
		<%
		if (fare != null) {
		%>
		<div class="text-right">
			<button type="submit" class="btn btn-success">Confirm
				Booking</button>
		</div>
	</form>
	<%
	}
	%>
</body>
</html>